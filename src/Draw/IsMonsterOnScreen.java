package Draw;

import Entity.Entity;
import Main.GamePanel;
import java.awt.Graphics2D;

public class IsMonsterOnScreen {

  private final ChooseImage chooseImage = new ChooseImage();
  public void isMonsterOnScreen (GamePanel gamePanel, Entity entity, Graphics2D g2) {

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
      int screenX = monsterX - playerX + playerScreenX;
      int screenY = monsterY - playerY + playerScreenY;

      chooseImage.draw(entity, g2, gamePanel.getTileSize(), screenX, screenY);
    }
  }
}
