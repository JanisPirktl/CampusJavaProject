package CollisionCheck;

import Entity.Entity;

public class CheckFacedTile {

  private static int entityLeftWorldX;
  private static int entityRightWorldX;
  private static int entityTopWorldY;
  private static int entityBottomWorldY;
  private static int entityLeftCol;
  private static int entityRightCol;
  private static int entityTopRow;
  private static int entityBottomRow;
  private static int tileNum1;
  private static int tileNum2;

  public static void checkFacedTile(Entity entity) {

    entityLeftWorldX = entity.getWorldX() + entity.solidArea.x;
    entityRightWorldX = entity.getWorldX() + entity.solidArea.x + entity.solidArea.width;
    entityTopWorldY = entity.getWorldY() + entity.solidArea.y;
    entityBottomWorldY = entity.getWorldY() + entity.solidArea.y + entity.solidArea.height;

    entityLeftCol = entityLeftWorldX/CollisionChecker.getGp().tileSize;
    entityRightCol = entityRightWorldX/CollisionChecker.getGp().tileSize;
    entityTopRow = entityTopWorldY/CollisionChecker.getGp().tileSize;
    entityBottomRow = entityBottomWorldY/CollisionChecker.getGp().tileSize;

    switch(entity.getDirection()) {
      case "up":
        entityTopRow = (entityTopWorldY - entity.getSPEED())/CollisionChecker.getGp().tileSize;
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision || CollisionChecker.getGp().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "down":
        entityBottomRow = (entityBottomWorldY + entity.getSPEED())/CollisionChecker.getGp().tileSize;
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        tileNum2 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision || CollisionChecker.getGp().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left":
        entityLeftCol = (entityLeftWorldX - entity.getSPEED())/CollisionChecker.getGp().tileSize;
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision || CollisionChecker.getGp().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "right":
        entityRightCol = (entityRightWorldX + entity.getSPEED())/CollisionChecker.getGp().tileSize;
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        tileNum2 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision || CollisionChecker.getGp().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;

      case "right_up":
        entityRightCol = (int) ((entityRightWorldX + Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        entityTopRow = (int) ((entityTopWorldY - Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "right_down":
        entityRightCol = (int) ((entityRightWorldX + Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        entityBottomRow = (int) ((entityBottomWorldY + Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left_up":
        entityLeftCol = (int) ((entityLeftWorldX - Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        entityTopRow = (int) ((entityTopWorldY - Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left_down":
        entityLeftCol = (int) ((entityLeftWorldX - Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        entityBottomRow = (int) ((entityBottomWorldY + Math.sqrt(entity.getSPEED() * 2))/CollisionChecker.getGp().tileSize);
        tileNum1 = CollisionChecker.getGp().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (CollisionChecker.getGp().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
    }
  }

}
