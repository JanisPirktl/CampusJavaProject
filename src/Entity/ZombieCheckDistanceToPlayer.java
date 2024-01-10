package Entity;

public class ZombieCheckDistanceToPlayer {

  public static void checkDistance(Zombie zombie) {

    if (Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX()) < Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().player.getWorldY())) {
      if (Math.abs(zombie.getWorldY() - zombie.getGamePanel().player.getWorldY()) < 50) {
        zombie.setCollisionOn(true);
      }
    } else if (Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX()) > Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().player.getWorldY()) && (Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX()) < 50)) {
      zombie.setCollisionOn(true);
    }
  }
}
