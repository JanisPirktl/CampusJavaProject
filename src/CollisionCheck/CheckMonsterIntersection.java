package CollisionCheck;

import Entity.Entity;

public class CheckMonsterIntersection {

  public void checkMonsterIntersection(Entity entity) {

    for (Entity monster : entity.getGamePanel().getMonsters()) {
      entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
      entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;

      monster.getSolidArea().x = monster.getWorldX() + monster.getSolidArea().x;
      monster.getSolidArea().y = monster.getWorldY() + monster.getSolidArea().y;

      switch(entity.getDirection()) {
        case "up":
          entity.getSolidArea().y -= entity.getSPEED();
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "down":
          entity.getSolidArea().y += entity.getSPEED();
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left":
          entity.getSolidArea().x -= entity.getSPEED();
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right":
          entity.getSolidArea().x += entity.getSPEED();
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left_up":
          entity.getSolidArea().x -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.getSolidArea().y -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left_down":
          entity.getSolidArea().x -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.getSolidArea().y += (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right_up":
          entity.getSolidArea().x += (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.getSolidArea().y -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right_down":
          entity.getSolidArea().x += (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.getSolidArea().y += (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
      }
      entity.getSolidArea().x = entity.getSolidAreaDefaultX();
      entity.getSolidArea().y = entity.getSolidAreaDefaultY();
      monster.getSolidArea().x = monster.getSolidAreaDefaultX();
      monster.getSolidArea().y = monster.getSolidAreaDefaultY();
    }
  }
}
