package Draw;

import Entity.Entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ChooseImage {

  public void draw(Entity entity, Graphics2D g2, int tileSize, int screenX, int screenY) {

    BufferedImage image = null;
    String direction = entity.getDirection();
    int spriteNum = entity.getSpriteNum();

    switch (direction) {
      case "up":
        if (spriteNum == 1) {
          image = entity.getUp1();
        } else {
          image = entity.getUp2();
        }
        break;
      case "down":
        if (spriteNum == 1) {
          image = entity.getDown1();
        } else {
          image = entity.getDown2();
        }
        break;
      case "left":
        if (spriteNum == 1) {
          image = entity.getLeft1();
        } else {
          image = entity.getLeft2();
        }
        break;
      case "right":
        if (spriteNum == 1) {
          image = entity.getRight1();
        } else {
          image = entity.getRight2();
        }
        break;
      case "right_up":
        if (spriteNum == 1) {
          image = entity.getRightUp1();
        } else {
          image = entity.getRightUp2();
        }
        break;
      case "right_down":
        if (spriteNum == 1) {
          image = entity.getRightDown1();
        } else {
          image = entity.getRightDown2();
        }
        break;
      case "left_up":
        if (spriteNum == 1) {
          image = entity.getLeftUp1();
        } else {
          image = entity.getLeftUp2();
        }
        break;
      case "left_down":
        if (spriteNum == 1) {
          image = entity.getLeftDown1();
        } else {
          image = entity.getLeftDown2();
        }
        break;
    }
    g2.drawImage(image, screenX, screenY, tileSize, tileSize, null);
  }
}
