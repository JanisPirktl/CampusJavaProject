package Entity.Entity;

public class EntityAttackImage2 {

  public void setAttackImage2(Entity entity) {

    String direction = entity.getDirection();

    switch (direction) {
      case "up":
        entity.setImage(entity.getAttackUp2());
        break;
      case "down":
        entity.setImage(entity.getAttackDown2());
        break;
      case "left":
        entity.setImage(entity.getAttackLeft2());
        break;
      case "right":
        entity.setImage(entity.getAttackRight2());
        break;
      case "right_up":
        entity.setImage(entity.getAttackUpRight2());
        break;
      case "right_down":
        entity.setImage(entity.getAttackDownRight2());
        break;
      case "left_up":
        entity.setImage(entity.getAttackUpLeft2());
        break;
      case "left_down":
        entity.setImage(entity.getAttackDownLeft2());
        break;
    }
  }

}
