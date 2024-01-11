package Entity.Monster;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MonsterAttack {

  public void monsterAttack(Monster monster, Graphics2D g2, int tileSize, int screenX, int screenY) {

    String direction = monster.getDirection();
    BufferedImage image = null;

    switch (direction) {
      case "up":
        image = monster.getAttackUp1();
        break;
      case "down":
        image = monster.getAttackDown1();
        break;
      case "left":
        image = monster.getAttackLeft1();
        break;
      case "right":
        image = monster.getAttackRight1();
        break;
      case "right_up":
        image = monster.getAttackUpRight1();
        break;
      case "right_down":
        image = monster.getAttackDownRight1();
        break;
      case "left_up":
        image = monster.getAttackUpLeft1();
        break;
      case "left_down":
        image = monster.getAttackDownLeft1();
        break;
    }
    g2.drawImage(image, screenX, screenY, tileSize, tileSize, null);
  }
}
