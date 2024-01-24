package Entity.Monster;

public class CheckDistanceToPlayer {

  //Only used by monsters, checks the absolute distance between monster and player calculated with pytagoras

  public boolean checkDistance(Monster monster) {

    double distanceX = Math.abs(monster.getWorldX() - monster.getGamePanel().getPlayer().getWorldX());
    double distanceY = Math.abs(monster.getWorldY() - monster.getGamePanel().getPlayer().getWorldY());


    double distance = Math.sqrt(distanceX*distanceX + distanceY*distanceY);

    return distance < 55;
  }
}
