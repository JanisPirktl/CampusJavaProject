package Entity.Monster;

import Entity.Entity.CheckFacedTile;
import Main.GamePanel;
import Entity.Entity.Entity;

public class Pathfinder {

  private final CheckFacedTile checkFacedTile = new CheckFacedTile();

  public void determineTile(Entity entity) {

    int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
    int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
    int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
    int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

    int tileSize = entity.getGamePanel().getTileSize();

    int currentColumn = (entityLeftWorldX + Math.abs(entityLeftWorldX - entityRightWorldX)) / tileSize;
    int currentRow = (entityTopWorldY + Math.abs(entityTopWorldY - entityBottomWorldY)) / tileSize;

    entity.setTileCol(currentColumn);
    entity.setTileRow(currentRow);

   // int currentTile = monster.getGamePanel().getTileM().getMapTileNum()[entityLeftCol][entityTopRow];
  }
}
