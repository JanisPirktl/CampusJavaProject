package Entity.Entity;

public class CheckFacedTile {

  //this Method is used for every kind of entity, it checks if entity can walk given path
  //or if its facing solid obstacles like a tree or water
  public boolean checkFacedTile(Entity entity) {

    //Set all current variables with the Getters here for easier calculations after

    int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
    int entityRightWorldX =
        entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
    int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
    int entityBottomWorldY =
        entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

    int tileSize = entity.getGamePanel().getTileSize();

    int entityLeftCol = entityLeftWorldX / tileSize;
    int entityRightCol = entityRightWorldX / tileSize;

    int entityTopRow = entityTopWorldY / tileSize;
    int entityBottomRow = entityBottomWorldY / tileSize;

    int speed = entity.getSpeed();
    //speed for the diagonale axis
    int speedNormed = (int) (speed * speed / Math.sqrt(speed * speed * 2.0));

    int tileNum1;
    int tileNum2;

    //Returns true if path is blocked / tile is solid, according to given direction
    switch (entity.getDirection()) {
      case "up":
        entityTopRow = (entityTopWorldY - speed) / tileSize;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()
            || entity.getGamePanel().getTileM().getTile()[tileNum2].isCollision()) {
          return true;
        }
        break;
      case "down":
        entityBottomRow = (entityBottomWorldY + speed) / tileSize;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        tileNum2 = entity.getGamePanel().getTileM()
            .getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()
            || entity.getGamePanel().getTileM().getTile()[tileNum2].isCollision()) {
          return true;
        }
        break;
      case "left":
        entityLeftCol = (entityLeftWorldX - speed) / tileSize;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()
            || entity.getGamePanel().getTileM().getTile()[tileNum2].isCollision()) {
          return true;
        }
        break;
      case "right":
        entityRightCol = (entityRightWorldX + speed) / tileSize;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM()
            .getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()
            || entity.getGamePanel().getTileM().getTile()[tileNum2].isCollision()) {
          return true;
        }
        break;

      case "right_up":
        entityRightCol = ((entityRightWorldX + speedNormed) / tileSize);
        entityTopRow = ((entityTopWorldY - speedNormed) / tileSize);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()) {
          return true;
        }
        break;
      case "right_down":
        entityRightCol = ((entityRightWorldX + speedNormed) / tileSize);
        entityBottomRow = ((entityBottomWorldY + speedNormed) / tileSize);
        tileNum1 = entity.getGamePanel().getTileM()
            .getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()) {
          return true;
        }
        break;
      case "left_up":
        entityLeftCol = ((entityLeftWorldX - speedNormed) / tileSize);
        entityTopRow = ((entityTopWorldY - speedNormed) / tileSize);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()) {
          return true;
        }
        break;
      case "left_down":
        entityLeftCol = ((entityLeftWorldX - speedNormed) / tileSize);
        entityBottomRow = ((entityBottomWorldY + speedNormed) / tileSize);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].isCollision()) {
          return true;
        }
        break;
    }

    //Return false if tile is not solid
    return false;
  }
}
