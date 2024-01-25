package Entity.Entity;

public class EntityAttackHitbox {
  private int impactX;
  private int impactY;
  private final int range = 40;
  private final int rangeNormed =  (int) (range*range / Math.sqrt(range*range * 2.0));
  private boolean impacted = false;



  //checks if an Entity gets hit by an attack, returns true or false for Zombie Kill Counter
  public boolean entityAttackHitbox(Entity attacker, Entity target) {

      String direction = attacker.getDirection();
      int attackerPosX = attacker.getWorldX() + attacker.getSolidArea().x + 9;
      int attackerPosY = attacker.getWorldY() + attacker.getSolidArea().y + 16;
      int targetPosX = target.getWorldX() + target.getSolidArea().x + 9;
      int targetPosY = target.getWorldY() + target.getSolidArea().y + 16;

    //calculates point of impact based on direction

    switch (direction) {
      case "up":
        impactX = attackerPosX;
        impactY = attackerPosY - range;
        break;
      case "down":
        impactX = attackerPosX;
        impactY = attackerPosY + range;
        break;
      case "left":
        impactX = attackerPosX - range;
        impactY = attackerPosY;
        break;
      case "right":
        impactX = attackerPosX + range;
        impactY = attackerPosY;
        break;
      case "right_down":
        impactX = attackerPosX + rangeNormed;
        impactY = attackerPosY + rangeNormed;
        break;
      case "right_up":
        impactX = attackerPosX + rangeNormed;
        impactY = attackerPosY - rangeNormed;
        break;
      case "left_down":
        impactX = attackerPosX - rangeNormed;
        impactY = attackerPosY + rangeNormed;
        break;
      case "left_up":
        impactX = attackerPosX - rangeNormed;
        impactY = attackerPosY - rangeNormed;
        break;
    }
      int distanceX = Math.abs(targetPosX - impactX);
      int distanceY = Math.abs(targetPosY - impactY);
      double trueDistance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
    if(!impacted) {
      if (trueDistance <= 55) {
        target.damage(1);
        return true;
      }

    }return false;
  }

  public void setImpacted(boolean impacted) {
    this.impacted = impacted;
  }

}

