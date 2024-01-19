package Entity.Entity;

public class EntityAttackHitbox {
  private String direction;
  private int impactX;
  private int impactY;
  private int range = 40;
  private int rangeNormed =  (int) (range*range / Math.sqrt(range*range * 2.0));
  private int attackerPosX;
  private int attackerPosY;
  private int targetPosX;
  private int targetPosY;
  private int distanceX;
  private int distanceY;
  private double trueDistance;
  private boolean impacted = false;


  //checks if an Entity gets hit by an attack
  public void entityAttackHitbox(Entity attacker, Entity target) {

    direction = attacker.getDirection();
    attackerPosX = attacker.getWorldX();
    attackerPosY = attacker.getWorldY();
    targetPosX = target.getWorldX();
    targetPosY = target.getWorldY();
    distanceX = Math.abs(targetPosX - attackerPosX);
    distanceY = Math.abs(targetPosY - attackerPosY);
    trueDistance = Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY,2));


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
    if(!impacted) {
      if (trueDistance <= 55) {
        target.damage(1);
        System.out.println("I hit");
      } else {
        System.out.println("I miss");
      }
        impacted = true;
    }

  }

  public void setImpacted(boolean impacted) {
    this.impacted = impacted;
  }
}
