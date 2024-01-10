package CollisionCheck;

import Entity.Entity;
import Main.GamePanel;

public class CheckFacedTile {




  public void checkFacedTile(Entity entity) {

    int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
    int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
    int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
    int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

    int entityLeftCol = entityLeftWorldX/ 48;
    int entityRightCol = entityRightWorldX/ 48;
    
    int entityTopRow = entityTopWorldY/48;
    int entityBottomRow = entityBottomWorldY/48;

    int tileNum1;
    int tileNum2;

    entity.setCollisionOn(false);

    switch(entity.getDirection()) {
      case "up":
        entityTopRow = (entityTopWorldY - entity.getSPEED())/48;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision || entity.getGamePanel().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "down":
        entityBottomRow = (entityBottomWorldY + entity.getSPEED())/48;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision || entity.getGamePanel().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left":
        entityLeftCol = (entityLeftWorldX - entity.getSPEED())/48;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision || entity.getGamePanel().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "right":
        entityRightCol = (entityRightWorldX + entity.getSPEED())/48;
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        tileNum2 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision || entity.getGamePanel().getTileM().getTile()[tileNum2].collision) {
          entity.setCollisionOn(true);
        }
        break;

      case "right_up":
        entityRightCol = (int) ((entityRightWorldX + Math.sqrt(entity.getSPEED() * 2))/48);
        entityTopRow = (int) ((entityTopWorldY - Math.sqrt(entity.getSPEED() * 2))/48);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "right_down":
        entityRightCol = (int) ((entityRightWorldX + Math.sqrt(entity.getSPEED() * 2))/48);
        entityBottomRow = (int) ((entityBottomWorldY + Math.sqrt(entity.getSPEED() * 2))/48);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityRightCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left_up":
        entityLeftCol = (int) ((entityLeftWorldX - Math.sqrt(entity.getSPEED() * 2))/entity.getGamePanel().tileSize);
        entityTopRow = (int) ((entityTopWorldY - Math.sqrt(entity.getSPEED() * 2))/entity.getGamePanel().tileSize);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
      case "left_down":
        entityLeftCol = (int) ((entityLeftWorldX - Math.sqrt(entity.getSPEED() * 2))/entity.getGamePanel().tileSize);
        entityBottomRow = (int) ((entityBottomWorldY + Math.sqrt(entity.getSPEED() * 2))/entity.getGamePanel().tileSize);
        tileNum1 = entity.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityBottomRow];
        if (entity.getGamePanel().getTileM().getTile()[tileNum1].collision) {
          entity.setCollisionOn(true);
        }
        break;
    }
  }

}
