package Main;

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
  private final int originalTileSize = 16;
  private final int scale = 3;
  private final int tileSize = originalTileSize * scale;

  private final int maxScreenCol = 24;
  private final int maxScreenRow = 20;
  private final int screenWidth = tileSize * maxScreenCol;
  private final int screenHeight = tileSize * maxScreenRow;


  private final int maxWorldCol = 70;
  private final int maxWorldRow = 70;
  private final int fps = 60;

  private final TileManager tileM = new TileManager(this);
  private final KeyHandler keyHandler = new KeyHandler();
  private Thread gameThread;
  private final MonsterSpawn monsterSpawn = new MonsterSpawn(this);
  private final Player player = new Player(this, keyHandler);
  private final ArrayList<Zombie> monsters = new ArrayList<>();



  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
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
        update();
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

  public void update() {

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
  public int getScreenWidth() {
    return screenWidth;
  }
  public int getScreenHeight() {
    return screenHeight;
  }
  public int getMaxWorldCol() {
    return maxWorldCol;
  }
  public int getMaxWorldRow() {
    return maxWorldRow;
  }
  public Player getPlayer() {
    return player;
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



}

