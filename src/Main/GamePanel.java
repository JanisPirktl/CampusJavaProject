package Main;

import Draw.IsMonsterOnScreen;
import Entity.Entity;
import Entity.Monster.Monster;
import Entity.Monster.Zombie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;
import javax.swing.JPanel;

import Entity.Player.Player;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

  //Screen Settings
  private final int originalTileSize = 16;
  private final int scale = 3;
  private final int tileSize = originalTileSize * scale;

  private final int maxScreenCol = 24;
  private final int maxScreenRow = 18;
  private final int screenWidth = tileSize * maxScreenCol;
  private final int screenHeight = tileSize * maxScreenRow;


  private final int maxWorldCol = 70;
  private final int maxWorldRow = 70;
  private final double fps = 60;

  private final TileManager tileM = new TileManager(this);
  private final KeyHandler keyHandler = new KeyHandler();
  private Thread gameThread;
  private final MonsterSpawn monsterSpawn = new MonsterSpawn(this);
  private final Player player = new Player(this, keyHandler);
  private final ArrayList<Monster> monsters = new ArrayList<>();
  private final IsMonsterOnScreen isMonsterOnScreen = new IsMonsterOnScreen();


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

    double drawInterval = 1000000000 / fps;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;
    int spawnTimer = 0;

    while (gameThread != null) {

      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      if (delta >= 1) {
        try {
          update();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        repaint();
        delta--;
        drawCount++;
      }

      if (timer >= 1000000000) {
        spawnTimer++;
        drawCount = 0;
        timer = 0;
      }

      if (spawnTimer == 5) {
        try {
          monsterSpawn.spawnNewMonster();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        spawnTimer = 0;
      }

    }
  }

  public void update() throws InterruptedException {
    player.update();
    for (Monster monster : monsters) {
      monster.run();


    }
  }

  @Override
  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    tileM.draw(g2);
    for (Entity monster : monsters) {
      isMonsterOnScreen.isMonsterOnScreen(this, monster, g2);
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

  public ArrayList<Monster> getMonsters() {
    return monsters;
  }


}

