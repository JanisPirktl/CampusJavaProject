package Entity.Monster;

import Entity.Player.Player;

public class MonsterAttackHitbox {
  private String direction;
  private int impactX;
  private int impactY;
  private int range = 40;
  private int rangeNormed =  (int) (range*range / Math.sqrt(range*range * 2.0));
  private int monsterPosX;
  private int monsterPosY;
  private int playerPosX;
  private int playerPosY;
  public void monsterAttackHitbox(Monster monster, Player player) {

    direction = monster.getDirection();
    monsterPosX = monster.getWorldX();
    monsterPosY = monster.getWorldY();
    playerPosX = player.getWorldX();
    playerPosY = player.getWorldY();

    switch (direction) {
      case "up":
        impactX = monsterPosX;
        impactY = monsterPosY - range;
        break;
      case "down":
        impactX = monsterPosX;
        impactY = monsterPosY + range;
        break;
      case "left":
        impactX = monsterPosX - range;
        impactY = monsterPosY;
        break;
      case "right":
        impactX = monsterPosX + range;
        impactY = monsterPosY;
        break;
      case "right_down":
        impactX = monsterPosX + rangeNormed;
        impactY = monsterPosY + rangeNormed;
        break;
      case "right_up":
        impactX = monsterPosX + rangeNormed;
        impactY = monsterPosY - rangeNormed;
        break;
      case "left_down":
        impactX = monsterPosX - rangeNormed;
        impactY = monsterPosY + rangeNormed;
        break;
      case "left_up":
        impactX = monsterPosX - rangeNormed;
        impactY = monsterPosY - rangeNormed;
        break;
    }

    //TODO get something like pythagoras here...

  }
}
