package Main;

import Entity.Entity.Draw;
import Entity.Entity.EntityAttackImage1;
import Entity.Entity.EntityAttackImage2;
import Entity.Entity.EntityImage;
import Entity.Monster.IsMonsterOnScreen;
import Entity.Monster.Monster;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MonsterBehaviour {

  private final IsMonsterOnScreen isMonsterOnScreen = new IsMonsterOnScreen();
  private final EntityAttackImage1 entityAttackImage1 = new EntityAttackImage1();
  private final EntityAttackImage2 entityAttackImage2 = new EntityAttackImage2();
  private final EntityImage entityImage = new EntityImage();
  private final Draw draw = new Draw();

  public void monsterBehaviour(Graphics2D g2, ArrayList<Monster> monsters, GamePanel gamePanel) {

    for (Monster monster : monsters) {
      if (!monster.isAttackingPlayer()) {
        monster.run();
      }
      if (isMonsterOnScreen.isMonsterOnScreen(gamePanel, monster)) {
        if (!monster.isAttackingPlayer()) {
          entityImage.setImage(monster);
          draw.draw(monster, g2);
        } else {

          if (monster.getCurrentTime() + 500000000 > System.nanoTime()) {
            entityAttackImage1.setAttackImage1(monster);
            draw.draw(monster, g2);
          } else if (monster.getCurrentTime() + 1000000000 > System.nanoTime()) {
            entityAttackImage2.setAttackImage2(monster);
            draw.draw(monster, g2);
          } else {
            monster.setAttackingPlayer(false);
          }
        }
      }
    }
  }
}
