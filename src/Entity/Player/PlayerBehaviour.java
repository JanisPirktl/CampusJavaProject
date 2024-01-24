package Entity.Player;

import Entity.Entity.*;
import Entity.Monster.Monster;

import Main.GamePanel;
import java.awt.Graphics2D;


//This class draws the player, calls the players update() method and checks if the player is still alive and if they are attacking

public class PlayerBehaviour {
  private final Draw draw = new Draw();
  private final DrawHeart drawHeart = new DrawHeart();
  private final EntityImage entityImage = new EntityImage();
  private final EntityAttackHitbox playerAttackHitbox = new EntityAttackHitbox();
  private EntityAttackImage1 entityAttackImage1 = new EntityAttackImage1();
  private EntityAttackImage2 entityAttackImage2 = new EntityAttackImage2();
  private int killCounter = 0;


  public void playerBehaviour(Graphics2D g2, GamePanel gp, Player player) {

    if (player.getHealth() > 0) {
      player.update();
    }
    if (player.getHealth() <= 0) {
      player.setImage(player.getDead());
      player.setCollisionOn(true);
      draw.draw(player, g2);
      draw.write("Kill-Counter: " + killCounter, g2);
    } else {
        if (!player.isAttacking()){
            entityImage.setImage(player);
            draw.draw(player,g2);
            drawHeart.draw(player,g2);
            draw.write("Kill-Counter: " + killCounter, g2);
            g2.dispose();
        }
        else {
            //gives the player an attack delay
            if (player.getCurrentTime() + 333333333 > System.nanoTime()) {
                entityAttackImage1.setAttackImage1(player);
                draw.draw(player, g2);
                drawHeart.draw(player, g2);
                draw.write("Kill-Counter: " + killCounter, g2);
            } else if (player.getCurrentTime() + 666666666 > System.nanoTime()) {
                entityAttackImage2.setAttackImage2(player);
                draw.draw(player, g2);
                drawHeart.draw(player, g2);
                draw.write("Kill-Counter: " + killCounter, g2);
                //checks which monsters that are currently spawned are hit by the players attack and counts up the kills
                for (Monster monster : gp.getMonsters()) {
                    if(playerAttackHitbox.entityAttackHitbox(player, monster)){
                        killCounter ++;
                    }
                    //after the last monster is checked, the attack ends
                    if (monster.equals(gp.getMonsters().get(gp.getMonsters().size() - 1))) {
                        playerAttackHitbox.setImpacted(true);
                    }

                }
            } else {
                player.setAttacking(false);
                playerAttackHitbox.setImpacted(false);
            }
        }
    }

  }


}
