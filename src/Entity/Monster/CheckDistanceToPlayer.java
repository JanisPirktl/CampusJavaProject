package Entity.Monster;

public class CheckDistanceToPlayer {

  public void checkDistance(Monster monster) {

    double distanceX = Math.abs(monster.getWorldX() - monster.getGamePanel().getPlayer().getWorldX());
    double distanceY = Math.abs(monster.getWorldY() - monster.getGamePanel().getPlayer().getWorldY());

    //absolute distance between monster and player calculated with pytagoras
    double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);

    if (distance < 55) {
      monster.setCollisionOn(true);
    }
  }
}
