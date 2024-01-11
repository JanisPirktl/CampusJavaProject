package Entity.Player;

import Entity.Monster.Monster;
public class CheckMonsterIntersection {

  public void checkMonsterIntersection(Player player) {

    for (Monster monster : player.getGamePanel().getMonsters()) {
      player.getSolidArea().x += player.getWorldX();
      player.getSolidArea().y += player.getWorldY();

      monster.getSolidArea().x = monster.getWorldX() + monster.getSolidArea().x;
      monster.getSolidArea().y = monster.getWorldY() + monster.getSolidArea().y;

      switch(player.getDirection()) {
        case "up":
          player.getSolidArea().y -= player.getSpeed();
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "down":
          player.getSolidArea().y += player.getSpeed();
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "left":
          player.getSolidArea().x -= player.getSpeed();
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "right":
          player.getSolidArea().x += player.getSpeed();
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "left_up":
          player.getSolidArea().x -= (int) Math.sqrt(player.getSpeed() * (double)2);
          player.getSolidArea().y -= (int) Math.sqrt(player.getSpeed() * (double)2);
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "left_down":
          player.getSolidArea().x -= (int) Math.sqrt(player.getSpeed() * (double)2);
          player.getSolidArea().y += (int) Math.sqrt(player.getSpeed() * (double)2);
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "right_up":
          player.getSolidArea().x += (int) Math.sqrt(player.getSpeed() * (double)2);
          player.getSolidArea().y -= (int) Math.sqrt(player.getSpeed() * (double)2);
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
        case "right_down":
          player.getSolidArea().x += (int) Math.sqrt(player.getSpeed() * (double)2);
          player.getSolidArea().y += (int) Math.sqrt(player.getSpeed() * (double)2);
          if (player.getSolidArea().intersects(monster.getSolidArea()) && (monster.isCollisionOn())) {
            player.setCollisionOn(true);

          }
          break;
      }
      player.getSolidArea().x = player.getSolidAreaDefaultX();
      player.getSolidArea().y = player.getSolidAreaDefaultY();
      monster.getSolidArea().x = monster.getSolidAreaDefaultX();
      monster.getSolidArea().y = monster.getSolidAreaDefaultY();
    }
  }
}
