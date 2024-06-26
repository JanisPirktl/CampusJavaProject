package Entity.Entity;

public class Move {


  //all Entities use this method move, it calculates the entities new World Coordinates with its speed according to its direction
  public void move(Entity entity) {

      int speed = entity.getSpeed();

      //speed for the diagonale axis
      int speedNormed = (int) (speed*speed / Math.sqrt(speed*speed * 2.0));

      String direction = entity.getDirection();

      int worldX = entity.getWorldX();
      int worldY = entity.getWorldY();

      switch (direction) {
        case "up":
          entity.setWorldY(worldY - speed);
          break;
        case "down":
          entity.setWorldY(worldY + speed);
          break;
        case "left":
          entity.setWorldX(worldX - speed);
          break;
        case "right":
          entity.setWorldX(worldX + speed);
          break;
        case "right_down":
          entity.setWorldX(worldX + speedNormed);
          entity.setWorldY(worldY + speedNormed);

          break;
        case "right_up":
          entity.setWorldX(worldX + speedNormed);
          entity.setWorldY(worldY - speedNormed);

          break;
        case "left_down":
          entity.setWorldX(worldX - speedNormed);
          entity.setWorldY(worldY + speedNormed);

          break;
        case "left_up":
          entity.setWorldX(worldX - speedNormed);
          entity.setWorldY(worldY - speedNormed);

          break;
      }
  }
}
