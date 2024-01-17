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
  private int distanceX;
  private int distanceY;
  private double trueDistance;
  private boolean impacted = false;
  public void monsterAttackHitbox(Monster monster, Player player) {

    direction = monster.getDirection();
    monsterPosX = monster.getWorldX();
    monsterPosY = monster.getWorldY();
    playerPosX = player.getWorldX();
    playerPosY = player.getWorldY();
    distanceX = Math.abs(playerPosX - monsterPosX);
    distanceY = Math.abs(playerPosY - monsterPosY);
    trueDistance = Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2));


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
    if(!impacted) {
      if (trueDistance <= 55) {
        player.damage(1);
        System.out.println("I hit");
      } else {
        System.out.println("I miss");
      }
        this.impacted = true;
    }

    //TODO get something like pythagoras here...

  }

  public boolean isImpacted() {
    return impacted;
  }

  public void setImpacted(boolean impacted) {
    this.impacted = impacted;
  }
}
