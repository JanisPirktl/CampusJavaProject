package Entity;

public class ZombieCheckDistanceToPlayer {

  public static void checkDistance(Zombie zombie) {

    if (Math.abs(zombie.getWorldX() - zombie.gp.player.getWorldX()) < Math.abs(
        zombie.getWorldY() - zombie.gp.player.getWorldY())) {
      if (Math.abs(zombie.getWorldY() - zombie.gp.player.getWorldY()) < 50) {
        zombie.setCollisionOn(true);
      }
    } else if (Math.abs(zombie.getWorldX() - zombie.gp.player.getWorldX()) > Math.abs(
        zombie.getWorldY() - zombie.gp.player.getWorldY()) && (Math.abs(zombie.getWorldX() - zombie.gp.player.getWorldX()) < 50)) {
      zombie.setCollisionOn(true);
    }
  }
}
