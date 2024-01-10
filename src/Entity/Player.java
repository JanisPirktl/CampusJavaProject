package Entity;


import CollisionCheck.CheckFacedTile;
import CollisionCheck.CheckMonsterIntersection;
import ImageSetter.SetPlayerImages;
import Draw.Draw;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

  private GamePanel gamePanel;
  KeyHandler keyHandler;

  private final int screenX;
  private final int screenY;
  private final Draw draw = new Draw();
  private CheckMonsterIntersection checkMonsterIntersection = new CheckMonsterIntersection();
  private CheckFacedTile checkFacedTile = new CheckFacedTile();


  public Player(GamePanel gamePanel, KeyHandler keyH) {
    super(5);
    this.gamePanel = gamePanel;
    this.keyHandler = keyH;

    screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
    screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

    setSolidArea(new Rectangle(15, 16, 18, 32));
    setSolidAreaDefaultX(getSolidArea().x);
    setSolidAreaDefaultY(getSolidArea().y);
    setDefaultValues();
    SetPlayerImages imageSetter = new SetPlayerImages();
    imageSetter.setPlayerImages(this);
  }

  private void setDefaultValues() {

    setWorldX(gamePanel.tileSize * 23);
    setWorldY(gamePanel.tileSize * 21);
    setDirection("down");
  }



  public void update() {

    if (keyHandler.upPressed || keyHandler.downPressed ||
        keyHandler.leftPressed || keyHandler.rightPressed || (keyHandler.leftPressed && keyHandler.downPressed) || (
        keyHandler.leftPressed && keyHandler.upPressed) || (keyHandler.rightPressed && keyHandler.downPressed) || (
        keyHandler.rightPressed && keyHandler.upPressed)) {

      if (keyHandler.upPressed && !keyHandler.leftPressed && !keyHandler.rightPressed) {
        setDirection("up");
      } else if (keyHandler.downPressed && !keyHandler.leftPressed && !keyHandler.rightPressed) {
        setDirection("down");
      } else if (keyHandler.leftPressed && !keyHandler.upPressed && !keyHandler.downPressed) {
        setDirection("left");
      } else if (keyHandler.rightPressed && !keyHandler.upPressed && !keyHandler.downPressed) {
        setDirection("right");
      } else if (keyHandler.upPressed && keyHandler.rightPressed) {
        setDirection("right_up");
      } else if (keyHandler.upPressed && keyHandler.leftPressed) {
        setDirection("left_up");
      } else if (keyHandler.downPressed && keyHandler.leftPressed) {
        setDirection("left_down");
      } else if (keyHandler.downPressed && keyHandler.rightPressed) {
        setDirection("right_down");
      }

      //CHeck TILE COLLISION

      checkFacedTile.checkFacedTile(this);

      //CHeck Monster COllision
      checkMonsterIntersection.checkMonsterIntersection(this);

      //IF COLLISION IS FALSE, PLAYER CAN MOVE
      if (!isCollisionOn()) {
        EntityMove.move(this);
      }
      EntitySpriteCounter.countSprite(this, 10);
    }
  }

  public void paint(Graphics2D g2) {
    draw.draw(this, g2, gamePanel.tileSize, screenX, screenY);
  }



  public int getScreenX() {
    return screenX;
  }

  public int getScreenY() {
    return screenY;
  }
  public GamePanel getGamePanel() {
    return gamePanel;
  }
}

