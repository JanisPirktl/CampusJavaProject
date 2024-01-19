package Entity.Monster;

import Entity.Entity.*;

import Entity.Monster.Zombie.Corpse;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MonsterBehaviour {

  private final IsMonsterOnScreen isMonsterOnScreen = new IsMonsterOnScreen();
  private final EntityAttackImage1 entityAttackImage1 = new EntityAttackImage1();
  private final EntityAttackImage2 entityAttackImage2 = new EntityAttackImage2();
  private final EntityImage entityImage = new EntityImage();
  private final Draw draw = new Draw();
  private final EntityAttackHitbox entityAttackHitbox = new EntityAttackHitbox();

  public void monsterBehaviour(Graphics2D g2, ArrayList<Monster> monsters, ArrayList<Corpse> corpses, Main.GamePanel gamePanel) {

    for (Corpse corpse : corpses) {
      corpse.setScreenX(corpse.getWorldX() - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX());
      corpse.setScreenY(corpse.getWorldY() - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY());
      draw.draw(corpse, g2);
    }
    for (Monster monster : monsters) {
      if(monster.getHealth()<=0){
        Corpse corpse = new Corpse(gamePanel, monster.getWorldX(), monster.getWorldY());
        corpse.setImage(monster.getDead());
        corpse.setCollisionOn(false);
        monsters.remove(monster);
        corpses.add(corpse);
        draw.draw(monster, g2);
      }

      else if (!monster.isAttackingPlayer()) {
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
            entityAttackHitbox.entityAttackHitbox(monster, gamePanel.getPlayer());
          } else {
            monster.setAttackingPlayer(false);
            entityAttackHitbox.setImpacted(false);
          }
        }
      }
    }
  }
}
