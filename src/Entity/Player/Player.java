package Entity.Player;


import Entity.Entity.CheckMonsterIntersection;
import Entity.Entity.Entity;
import Entity.Entity.SpriteCounter;
import java.awt.Rectangle;


import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

  private final GamePanel gamePanel;
  private final KeyHandler keyHandler;

  private final int screenX;
  private final int screenY;
  private final CheckMonsterIntersection checkMonsterIntersection = new CheckMonsterIntersection();
  private final SpriteCounter spriteCounter = new SpriteCounter();
  private int health = 5;
  private int maxHealth = 5;

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
  public void damage(int amount){
    this.health -= amount;
  }
  public int heal(int amount){
      return Math.min(health + amount, maxHealth);
  }

  public Player(GamePanel gamePanel, KeyHandler keyH) {
    super(5);
    this.gamePanel = gamePanel;
    this.keyHandler = keyH;

    screenX = gamePanel.getScreenWidth() / 2 - (gamePanel.getTileSize() / 2);
    screenY = gamePanel.getScreenHeight() / 2 - (gamePanel.getTileSize() / 2);

    setSolidArea(new Rectangle(15, 16, 18, 32));
    setSolidAreaDefaultX(getSolidArea().x);
    setSolidAreaDefaultY(getSolidArea().y);
    setDefaultValues();
    SetPlayerImages imageSetter = new SetPlayerImages();
    imageSetter.setPlayerImages(this);
  }

  private void setDefaultValues() {
    setWorldX(gamePanel.getTileSize() * 23);
    setWorldY(gamePanel.getTileSize() * 21);
    setDirection("down");
  }



  public void update() {

    if (keyHandler.isUpPressed() || keyHandler.isDownPressed() ||
        keyHandler.isLeftPressed() || keyHandler.isRightPressed() || (keyHandler.isLeftPressed() && keyHandler.isDownPressed()) || (
        keyHandler.isLeftPressed() && keyHandler.isUpPressed()) || (keyHandler.isRightPressed() && keyHandler.isDownPressed()) || (
        keyHandler.isRightPressed() && keyHandler.isUpPressed())) {

      if (keyHandler.isUpPressed() && !keyHandler.isLeftPressed() && !keyHandler.isRightPressed()) {
        setDirection("up");
      } else if (keyHandler.isDownPressed() && !keyHandler.isLeftPressed() && !keyHandler.isRightPressed()) {
        setDirection("down");
      } else if (keyHandler.isLeftPressed() && !keyHandler.isUpPressed() && !keyHandler.isDownPressed()) {
        setDirection("left");
      } else if (keyHandler.isRightPressed() && !keyHandler.isUpPressed() && !keyHandler.isDownPressed()) {
        setDirection("right");
      } else if (keyHandler.isUpPressed() && keyHandler.isRightPressed()) {
        setDirection("right_up");
      } else if (keyHandler.isUpPressed() && keyHandler.isLeftPressed()) {
        setDirection("left_up");
      } else if (keyHandler.isDownPressed() && keyHandler.isLeftPressed()) {
        setDirection("left_down");
      } else if (keyHandler.isDownPressed() && keyHandler.isRightPressed()) {
        setDirection("right_down");
      }

      setCollisionOn(false);

      //CHeck TILE COLLISION
      if (getCheckFacedTile().checkFacedTile(this)) {
        setCollisionOn(true);
      }

      //CHeck Monster COllision
      if (checkMonsterIntersection.checkMonsterIntersection(this)) {
        setCollisionOn(true);
      }


      //IF COLLISION IS FALSE, PLAYER CAN MOVE
      move();
      spriteCounter.countSprite(this, 10);
    }
  }

  public int getScreenX() {
    return screenX;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public void setMaxHealth(int maxHealth) {
    this.maxHealth = maxHealth;
  }

  public int getScreenY() {
    return screenY;
  }
  public GamePanel getGamePanel() {
    return gamePanel;
  }
}

