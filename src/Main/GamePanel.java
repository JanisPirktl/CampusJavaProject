package Main;

import CollisionCheck.CollisionChecker;
import Entity.Entity;
import Entity.Zombie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;
import javax.swing.JPanel;

import Entity.Player;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

  //Screen Settings
  final int originalTileSize = 16;
  final int scale = 3;

  public final int tileSize = originalTileSize * scale;
  public final int maxScreenCol = 24;
  public final int maxScreenRow = 20;
  public final int screenWidth = tileSize * maxScreenCol;
  public final int screenHeight = tileSize * maxScreenRow;

  //World settings
  public final int maxWorldCol = 70;
  public final int maxWorldRow = 70;



  //FPS
  int fps = 60;

  private TileManager tileM = new TileManager(this);
  KeyHandler keyHandler = new KeyHandler();
  Thread gameThread;
  public MonsterSpawn monsterSpawn = new MonsterSpawn(this);
  public Player player = new Player(this, keyHandler);
  private ArrayList<Zombie> monsters = new ArrayList<>();



  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
  }

  public void addMonster(Zombie monster) {
    monsters.add(monster);
  }
  public void removeMonster(Zombie monster) {
    monsters.remove(monster);
  }

  public ArrayList<Zombie> getMonsters() {
    return monsters;
  }

  public void setupMonsters() {
    monsterSpawn.setMonster();
  }

  public void startGameThread() {

    gameThread = new Thread(this);
    gameThread.start();
  }


  public void run() {

    double drawInterval = 1000000000/fps;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;

    while(gameThread != null) {

      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      if(delta >= 1) {
        update(this);
        repaint();
        delta--;
        drawCount++;
      }

      if(timer >= 1000000000) {
        System.out.println("FPS:" + drawCount);
        drawCount = 0;
        timer = 0;
      }

    }
  }

  public void update(GamePanel gamePanel) {

    player.update();

    for (Zombie entity : monsters) {
      entity.update();
    }

  }

  @Override
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;

    tileM.draw(g2);

    for(Zombie monster : monsters) {
      monster.paint(g2, this);
    }

    player.paint(g2);



    g2.dispose();
  }

  public int getTileSize() {
    return tileSize;
  }
  public TileManager getTileM() {
    return tileM;
  }
}

