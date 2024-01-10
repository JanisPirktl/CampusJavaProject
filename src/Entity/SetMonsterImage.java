package Entity;

public class SetMonsterImage {

  public static void setImage(Zombie zombie) {
    switch (zombie.getDirection()) {
      case "up":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getUp1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getUp2());
        }
        break;
      case "down":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getDown1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getDown2());
        }
        break;
      case "left":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getLeft1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getLeft2());
        }
        break;
      case "right":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getRight1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getRight2());
        }
        break;
      case "right_up":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getRightUp1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getRightUp2());
        }
        break;
      case "right_down":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getRightDown1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getRightDown2());
        }
        break;
      case "left_up":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getLeftUp1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getLeftUp2());
        }
        break;
      case "left_down":
        if (zombie.getSpriteNum() == 1) {
          zombie.setImage(zombie.getLeftDown1());
        }
        if (zombie.getSpriteNum() == 2) {
          zombie.setImage(zombie.getLeftDown2());
        }
        break;
    }
  }
}
