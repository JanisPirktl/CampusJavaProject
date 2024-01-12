package Main;

import Entity.Player.DrawHeart;
import java.awt.Graphics2D;
import Entity.Player.Player;
import Entity.Entity.EntityImage;
import Entity.Entity.Draw;

public class PlayerBehaviour {
  private final Draw draw = new Draw();
  private final DrawHeart drawHeart = new DrawHeart();
  private final EntityImage entityImage = new EntityImage();
  public void playerBehaviour(Graphics2D g2, GamePanel gp, Player player) {

    if (player.getHealth() > 0) {
      player.update();
    }
    if (player.getHealth() <= 0) {
      player.setImage(player.getDead());
      player.setCollisionOn(true);
    } else {
      entityImage.setImage(player);
    }
    draw.draw(player, g2);
    drawHeart.draw(player, g2);
    g2.dispose();
  }

}
