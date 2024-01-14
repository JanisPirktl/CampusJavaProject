package Entity.Entity;

import Entity.Entity.Entity;
import Entity.Monster.Monster;
public class CheckMonsterIntersection {

  public boolean checkMonsterIntersection(Entity target) {

    for (Monster monster : target.getGamePanel().getMonsters()) {
      target.getSolidArea().x += target.getWorldX();
      target.getSolidArea().y += target.getWorldY();

      monster.getSolidArea().x = monster.getWorldX() + monster.getSolidArea().x;
      monster.getSolidArea().y = monster.getWorldY() + monster.getSolidArea().y;

      switch(target.getDirection()) {
        case "up":
          target.getSolidArea().y -= target.getSpeed();
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "down":
          target.getSolidArea().y += target.getSpeed();
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left":
          target.getSolidArea().x -= target.getSpeed();
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right":
          target.getSolidArea().x += target.getSpeed();
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left_up":
          target.getSolidArea().x -= (int) Math.sqrt(target.getSpeed() * (double)2);
          target.getSolidArea().y -= (int) Math.sqrt(target.getSpeed() * (double)2);
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left_down":
          target.getSolidArea().x -= (int) Math.sqrt(target.getSpeed() * (double)2);
          target.getSolidArea().y += (int) Math.sqrt(target.getSpeed() * (double)2);
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right_up":
          target.getSolidArea().x += (int) Math.sqrt(target.getSpeed() * (double)2);
          target.getSolidArea().y -= (int) Math.sqrt(target.getSpeed() * (double)2);
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right_down":
          target.getSolidArea().x += (int) Math.sqrt(target.getSpeed() * (double)2);
          target.getSolidArea().y += (int) Math.sqrt(target.getSpeed() * (double)2);
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
      }
      resetSolidAreaValues(target, monster);
    }
    return false;
  }

  private void resetSolidAreaValues(Entity target, Monster monster) {
    target.getSolidArea().x = target.getSolidAreaDefaultX();
    target.getSolidArea().y = target.getSolidAreaDefaultY();
    monster.getSolidArea().x = monster.getSolidAreaDefaultX();
    monster.getSolidArea().y = monster.getSolidAreaDefaultY();
  }
}
