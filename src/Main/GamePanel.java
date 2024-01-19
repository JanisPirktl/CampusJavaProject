package Main;

import Entity.Monster.Monster;
import Entity.Monster.MonsterBehaviour;
import Entity.Monster.Zombie.Corpse;
import Entity.Monster.Zombie.Zombie;
import Entity.Player.PlayerBehaviour;
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
  private int gameCounter = 0;

  private final TileManager tileM = new TileManager(this);
  private final KeyHandler keyHandler = new KeyHandler();
  private Thread gameThread;
  private final MonsterSpawner monsterSpawner = new MonsterSpawner(this);
  private final Player player = new Player(this, keyHandler);

  private final ArrayList<Monster> monsters = new ArrayList<>();
  private final ArrayList<Corpse> corpses = new ArrayList<Corpse>();


  private final MonsterBehaviour monsterBehaviour = new MonsterBehaviour();
  private final PlayerBehaviour playerBehaviour = new PlayerBehaviour();


  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
    Zombie zombie = new Zombie(this, 800, 800);
    monsters.add(zombie);
    player.setHealth(5);
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
    int spawnTimer = 0;

    while (gameThread != null) {

      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      if (delta >= 1) {
        repaint();
        delta--;
      }

      if (timer >= 500000000) {
        gameCounter++;
      }

      if (timer >= 1000000000) {
        spawnTimer++;
        timer = 0;
      }

      if (spawnTimer == 5) {
        monsterSpawner.spawnNewMonster(player);
        spawnTimer = 0;
      }
    }
  }


  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    tileM.draw(g2);
    monsterBehaviour.monsterBehaviour(g2, monsters, corpses, this);
    playerBehaviour.playerBehaviour(g2, this, player);
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

public void addCorpse(Corpse corpse) {
    corpses.add(corpse);
}

  public ArrayList<Monster> getMonsters() {
    return monsters;
  }


}

