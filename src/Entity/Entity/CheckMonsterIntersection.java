package Entity.Entity;


import Entity.Monster.Monster;
public class CheckMonsterIntersection {

  public boolean checkMonsterIntersection(Entity target) {

    for (Monster monster : target.getGamePanel().getMonsters()) {

      if (target.equals(monster)) {
        break;
      }
      target.getSolidArea().x += target.getWorldX();
      target.getSolidArea().y += target.getWorldY();

      monster.getSolidArea().x += monster.getWorldX();
      monster.getSolidArea().y += monster.getWorldY();

      int speed = target.getSpeed();

      //speed for the diagonale axis
      int speedNormed = (int) (speed*speed / Math.sqrt(speed*speed * 2.0));

      switch(target.getDirection()) {
        case "up":
          target.getSolidArea().y -= speed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "down":
          target.getSolidArea().y += speed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left":
          target.getSolidArea().x -= speed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right":
          target.getSolidArea().x += speed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left_up":
          target.getSolidArea().x -= speedNormed;
          target.getSolidArea().y -= speedNormed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "left_down":
          target.getSolidArea().x -= speedNormed;
          target.getSolidArea().y += speedNormed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right_up":
          target.getSolidArea().x += speedNormed;
          target.getSolidArea().y -= speedNormed;
          if (target.getSolidArea().intersects(monster.getSolidArea())) {
            resetSolidAreaValues(target, monster);
            return true;

          }
          break;
        case "right_down":
          target.getSolidArea().x += speedNormed;
          target.getSolidArea().y += speedNormed;
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
