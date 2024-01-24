package Entity.Entity;

public class EntityAttackHitbox {
    private int impactX;
  private int impactY;
  private final int range = 40;
  private final int rangeNormed =  (int) (range*range / Math.sqrt(range*range * 2.0));
  private boolean impacted = false;
  private boolean hit = false;


  //checks if an Entity gets hit by an attack
  public void entityAttackHitbox(Entity attacker, Entity target) {

      String direction = attacker.getDirection();
      int attackerPosX = attacker.getWorldX() + attacker.getSolidArea().x;
      int attackerPosY = attacker.getWorldY() + attacker.getSolidArea().y;
      int targetPosX = target.getWorldX() + target.getSolidArea().x;
      int targetPosY = target.getWorldY() + target.getSolidArea().y;



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
      double trueDistance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    if(!impacted) {
      if (trueDistance <= 55) {
        target.damage(1);
        System.out.println("I hit");
        hit = true;
      } else {
        System.out.println("I miss");
      }

    }

  }

  public void setImpacted(boolean impacted) {
    this.impacted = impacted;
  }

}

