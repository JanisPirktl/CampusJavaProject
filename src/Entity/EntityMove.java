package Entity;

public class EntityMove {

  public static void move(Entity entity, String direction) {
      int speed = entity.getSPEED();
      int speedNormed = (int) (speed*speed / Math.sqrt(speed*speed * 2.0));

      switch (direction) {
        case "up":
          entity.setWorldY(entity.getWorldY() - entity.getSPEED());
          break;
        case "down":
          entity.setWorldY(entity.getWorldY() + entity.getSPEED());
          break;
        case "left":
          entity.setWorldX(entity.getWorldX() - entity.getSPEED());
          break;
        case "right":
          entity.setWorldX(entity.getWorldX() + entity.getSPEED());
          break;
        case "right_down":
          entity.setWorldX((int) (entity.getWorldX() + speedNormed));
          entity.setWorldY((int) (entity.getWorldY() + speedNormed));
          break;
        case "right_up":
          entity.setWorldX((int) (entity.getWorldX() + speedNormed));
          entity.setWorldY((int) (entity.getWorldY() - speedNormed));
          break;
        case "left_down":
          entity.setWorldX((int) (entity.getWorldX() - speedNormed));
          entity.setWorldY((int) (entity.getWorldY() + speedNormed));
          break;
        case "left_up":
          entity.setWorldX((int) (entity.getWorldX() - speedNormed));
          entity.setWorldY((int) (entity.getWorldY() - speedNormed));
          break;
      }
  }
}
