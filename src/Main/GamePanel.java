package Main;

import Entity.Entity.Draw;
import Entity.Entity.EntityAttackImage1;
import Entity.Entity.EntityAttackImage2;
import Entity.Entity.EntityImage;
import Entity.Monster.IsMonsterOnScreen;
import Entity.Monster.Monster;
import Entity.Monster.Zombie.Zombie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;
import javax.swing.JPanel;

import Entity.Player.DrawHeart;
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

  private final IsMonsterOnScreen isMonsterOnScreen = new IsMonsterOnScreen();
  private final EntityImage entityImage = new EntityImage();

  private final Draw draw = new Draw();
  private final DrawHeart drawHeart = new DrawHeart();
  private final EntityAttackImage1 entityAttackImage1 = new EntityAttackImage1();
  private final EntityAttackImage2 entityAttackImage2 = new EntityAttackImage2();


  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
    Zombie zombie = new Zombie(this, 800, 800);
    monsters.add(zombie);
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

    if (player.getHealth() > 0) {
      player.update();
    }

    for (Monster monster : monsters) {
      if (!monster.isAttackingPlayer()) {
        monster.run();
      }
      if (isMonsterOnScreen.isMonsterOnScreen(this, monster)) {
        if (!monster.isAttackingPlayer()) {
          entityImage.setImage(monster);
          draw.draw(monster, g2);
        } else {



          if (monster.getCurrentTime() + 500000000 > System.nanoTime()) {
            entityAttackImage1.setAttackImage1(monster);
            draw.draw(monster, g2);
          } else if (monster.getCurrentTime() + 1000000000 > System.nanoTime()){
            entityAttackImage2.setAttackImage2(monster);
            draw.draw(monster, g2);
          } else {
            monster.setAttackingPlayer(false);
          }
        }
      }
    }
    if (player.getHealth() <= 0) {
      player.setImage(player.getDead());
      player.setCollisionOn(true);
    } else {
      entityImage.setImage(player);
    }
    draw.draw(player, g2);
    drawHeart.draw(player, g2);
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
  public int getGameCounter() {
    return gameCounter;
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

