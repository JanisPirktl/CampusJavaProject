package Entity.Entity;

public class EntityImage {

  public void setImage(Entity entity) {


    String direction = entity.getDirection();
    int spriteNum = entity.getSpriteNum();


      switch (direction) {
        case "up":
          if (spriteNum == 1) {
            entity.setImage(entity.getUp1());
          } else {
            entity.setImage(entity.getUp2());
          }
          break;
        case "down":
          if (spriteNum == 1) {
            entity.setImage(entity.getDown1());
          } else {
            entity.setImage(entity.getDown2());
          }
          break;
        case "left":
          if (spriteNum == 1) {
            entity.setImage(entity.getLeft1());
          } else {
            entity.setImage(entity.getLeft2());
          }
          break;
        case "right":
          if (spriteNum == 1) {
            entity.setImage(entity.getRight1());
          } else {
            entity.setImage(entity.getRight2());
          }
          break;
        case "right_up":
          if (spriteNum == 1) {
            entity.setImage(entity.getRightUp1());
          } else {
            entity.setImage(entity.getRightUp2());
          }
          break;
        case "right_down":
          if (spriteNum == 1) {
            entity.setImage(entity.getRightDown1());
          } else {
            entity.setImage(entity.getRightDown2());
          }
          break;
        case "left_up":
          if (spriteNum == 1) {
            entity.setImage(entity.getLeftUp1());
          } else {
            entity.setImage(entity.getLeftUp2());
          }
          break;
        case "left_down":
          if (spriteNum == 1) {
            entity.setImage(entity.getLeftDown1());
          } else {
            entity.setImage(entity.getLeftDown2());
          }
          break;
      }
    }
  }

