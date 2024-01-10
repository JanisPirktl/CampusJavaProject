package Entity;


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
    getPlayerImage();
  }

  private void setDefaultValues() {

    setWorldX(gp.tileSize * 23);
    setWorldY(gp.tileSize * 21);
    setDirection("down");
  }

  private void getPlayerImage() {

    try {

      setUp1(ImageIO.read(new File("res/player/boy_up_1.png")));
      setUp2(ImageIO.read(new File("res/player/boy_up_2.png")));
      setDown1(ImageIO.read(new File("res/player/boy_down_1.png")));
      setDown2(ImageIO.read(new File("res/player/boy_down_2.png")));
      setLeft1(ImageIO.read(new File("res/player/boy_left_1.png")));
      setLeft2(ImageIO.read(new File("res/player/boy_left_2.png")));
      setRight1(ImageIO.read(new File("res/player/boy_right_1.png")));
      setRight2(ImageIO.read(new File("res/player/boy_right_2.png")));
      setLeftDown1(ImageIO.read(new File("res/player/boy_down_left1.png")));
      setLeftDown2(ImageIO.read(new File("res/player/boy_down_left2.png")));
      setLeftUp1(ImageIO.read(new File("res/player/boy_up_left1.png")));
      setLeftUp2(ImageIO.read(new File("res/player/boy_up_left2.png")));
      setRightDown1(ImageIO.read(new File("res/player/boy_down_right1.png")));
      setRightDown2(ImageIO.read(new File("res/player/boy_down_right2.png")));
      setRightUp1(ImageIO.read(new File("res/player/boy_up_right1.png")));
      setRightUp2(ImageIO.read(new File("res/player/boy_up_right2.png")));


    } catch (IOException e) {
      e.printStackTrace();
    }
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

  public void draw(Graphics2D g2) {

    BufferedImage image = null;

    switch (getDirection()) {
      case "up":
        if (getSpriteNum() == 1) {
          image = getUp1();
        }
        if (getSpriteNum() == 2) {
          image = getUp2();
        }
        break;
      case "down":
        if (getSpriteNum() == 1) {
          image = getDown1();
        }
        if (getSpriteNum() == 2) {
          image = getDown2();
        }
        break;
      case "left":
        if (getSpriteNum() == 1) {
          image = getLeft1();
        }
        if (getSpriteNum() == 2) {
          image = getLeft2();
        }
        break;
      case "right":
        if (getSpriteNum() == 1) {
          image = getRight1();
        }
        if (getSpriteNum() == 2) {
          image = getRight2();
        }
        break;
      case "right_up":
        if (getSpriteNum() == 1) {
          image = getRightUp1();
        }
        if (getSpriteNum() == 2) {
          image = getRightUp2();
        }
        break;
      case "right_down":
        if (getSpriteNum() == 1) {
          image = getRightDown1();
        }
        if (getSpriteNum() == 2) {
          image = getRightDown2();
        }
        break;
      case "left_up":
        if (getSpriteNum() == 1) {
          image = getLeftUp1();
        }
        if (getSpriteNum() == 2) {
          image = getLeftUp2();
        }
        break;
      case "left_down":
        if (getSpriteNum() == 1) {
          image = getLeftDown1();
        }
        if (getSpriteNum() == 2) {
          image = getLeftDown2();
        }
        break;
    }
    g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);


  }



  public int getScreenX() {
    return screenX;
  }

  public int getScreenY() {
    return screenY;
  }
}

