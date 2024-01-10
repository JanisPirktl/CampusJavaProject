package CollisionCheck;

import Entity.Entity;
import Entity.Zombie;

public class CheckMonsterIntersection {

  public void checkMonsterIntersection(Entity entity) {

    for (Entity monster : entity.getGamePanel().getMonsters()) {
      entity.solidArea.x = entity.getWorldX() + entity.solidArea.x;
      entity.solidArea.y = entity.getWorldY() + entity.solidArea.y;

      monster.solidArea.x = monster.getWorldX() + monster.solidArea.x;
      monster.solidArea.y = monster.getWorldY() + monster.solidArea.y;

      switch(entity.getDirection()) {
        case "up":
          entity.solidArea.y -= entity.getSPEED();
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "down":
          entity.solidArea.y += entity.getSPEED();
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left":
          entity.solidArea.x -= entity.getSPEED();
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right":
          entity.solidArea.x += entity.getSPEED();
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left_up":
          entity.solidArea.x -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.solidArea.y -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "left_down":
          entity.solidArea.x -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.solidArea.y += (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right_up":
          entity.solidArea.x += (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.solidArea.y -= (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
        case "right_down":
          entity.solidArea.x += (int) Math.sqrt(entity.getSPEED() * (double)2);
          entity.solidArea.y += (int) Math.sqrt(entity.getSPEED() * (double)2);
          if (entity.solidArea.intersects(monster.solidArea) && (monster.isCollisionOn())) {
            entity.setCollisionOn(true);

          }
          break;
      }
      entity.solidArea.x = entity.getSolidAreaDefaultX();
      entity.solidArea.y = entity.getSolidAreaDefaultY();
      monster.solidArea.x = monster.getSolidAreaDefaultX();
      monster.solidArea.y = monster.getSolidAreaDefaultY();
    }
  }
}
