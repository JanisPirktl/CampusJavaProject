package Entity;

public class ZombieCheckDistanceToPlayer {

  public static void checkDistance(Zombie zombie) {

    double distanceX = Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX());
    double distanceY = Math.abs(zombie.getWorldY() - zombie.getGamePanel().player.getWorldY());

    //absolute distance between zombie and player calculated with pytagoras
    double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);

    if (distance < 55) {
      zombie.setCollisionOn(true);
    }
  }
}
