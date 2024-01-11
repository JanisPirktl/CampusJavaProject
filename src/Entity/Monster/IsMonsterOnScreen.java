package Entity.Monster;

import Entity.Entity.Entity;
import Main.GamePanel;

public class IsMonsterOnScreen {


  public boolean isMonsterOnScreen (GamePanel gamePanel, Entity entity) {

    int tileSize = gamePanel.getTileSize();
    int monsterX = entity.getWorldX();
    int monsterY = entity.getWorldY();
    int playerX = gamePanel.getPlayer().getWorldX();
    int playerY = gamePanel.getPlayer().getWorldY();
    int playerScreenX = gamePanel.getPlayer().getScreenX();
    int playerScreenY = gamePanel.getPlayer().getScreenY();


    //only draws the zombie, if it's located inside screen area
    if (monsterX + tileSize > playerX - playerScreenX &&
        monsterX - tileSize < playerX + playerScreenX &&
        monsterY + tileSize > playerY - playerScreenY &&
        monsterY - tileSize < playerY + playerScreenY) {

      //calculate zombie's position on the screen
      entity.setScreenX(monsterX - playerX + playerScreenX);
      entity.setScreenY(monsterY - playerY + playerScreenY);

      return true;
    } else {
      return false;
    }
  }
}
