package Entity;


import ImageSetter.SetPlayerImages;
import Draw.Draw;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  private final int screenX;
  private final int screenY;
  private Draw draw = new Draw();


  public Player(GamePanel gp, KeyHandler keyH) {
    super(5);
    this.gp = gp;
    this.keyH = keyH;

    screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
    screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

    solidArea = new Rectangle();
    solidArea.x = 15;
    solidArea.y = 16;
    setSolidAreaDefaultX(solidArea.x);
    setSolidAreaDefaultY(solidArea.y);
    solidArea.width = 18;
    solidArea.height = 32;

    setDefaultValues();
    SetPlayerImages imageSetter = new SetPlayerImages();
    imageSetter.setPlayerImages(this);
  }

  private void setDefaultValues() {

    setWorldX(gp.tileSize * 23);
    setWorldY(gp.tileSize * 21);
    setDirection("down");
  }



  public void update() {

    if (keyH.upPressed || keyH.downPressed ||
        keyH.leftPressed || keyH.rightPressed || (keyH.leftPressed && keyH.downPressed) || (
        keyH.leftPressed && keyH.upPressed) || (keyH.rightPressed && keyH.downPressed) || (
        keyH.rightPressed && keyH.upPressed)) {

      if (keyH.upPressed && !keyH.leftPressed && !keyH.rightPressed) {
        setDirection("up");
      } else if (keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
        setDirection("down");
      } else if (keyH.leftPressed && !keyH.upPressed && !keyH.downPressed) {
        setDirection("left");
      } else if (keyH.rightPressed && !keyH.upPressed && !keyH.downPressed) {
        setDirection("right");
      } else if (keyH.upPressed && keyH.rightPressed) {
        setDirection("right_up");
      } else if (keyH.upPressed && keyH.leftPressed) {
        setDirection("left_up");
      } else if (keyH.downPressed && keyH.leftPressed) {
        setDirection("left_down");
      } else if (keyH.downPressed && keyH.rightPressed) {
        setDirection("right_down");
      }

      //CHeck TILE COLLISION
      setCollisionOn(false);
      gp.cChecker.checkTile(this);

      //CHeck Monster COllision
      gp.cChecker.checkMonsterCollision(this);

      //IF COLLISION IS FALSE, PLAYER CAN MOVE
      if (!isCollisionOn()) {
        EntityMove.move(this);
      }
      EntitySpriteCounter.countSprite(this, 10);
    }
  }

  public void paint(Graphics2D g2) {
    draw.draw(this, g2, gp.tileSize, screenX, screenY);
  }



  public int getScreenX() {
    return screenX;
  }

  public int getScreenY() {
    return screenY;
  }
}

