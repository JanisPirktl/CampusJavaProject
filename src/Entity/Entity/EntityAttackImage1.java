package Entity.Entity;

public class EntityAttackImage1 {

  public void setAttackImage1(Entity entity) {

    String direction = entity.getDirection();

    switch (direction) {
      case "up":
        entity.setImage(entity.getAttackUp1());
        break;
      case "down":
        entity.setImage(entity.getAttackDown1());
        break;
      case "left":
        entity.setImage(entity.getAttackLeft1());
        break;
      case "right":
        entity.setImage(entity.getAttackRight1());
        break;
      case "right_up":
        entity.setImage(entity.getAttackUpRight1());
        break;
      case "right_down":
        entity.setImage(entity.getAttackDownRight1());
        break;
      case "left_up":
        entity.setImage(entity.getAttackUpLeft1());
        break;
      case "left_down":
        entity.setImage(entity.getAttackDownLeft1());
        break;
    }
  }

}
