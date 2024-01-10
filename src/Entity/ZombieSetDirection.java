package Entity;

public class ZombieSetDirection {

  public void zombieSetDirection(Zombie zombie) {

    if (Math.abs(Math.abs(zombie.getWorldX() - zombie.getGamePanel().getPlayer().getWorldX()) - Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().getPlayer().getWorldY())) < 50) {
      if (zombie.getWorldY() < zombie.getGamePanel().getPlayer().getWorldY() && zombie.getWorldX() < zombie.getGamePanel().getPlayer().getWorldX()) {
        zombie.setDirection("right_down");
      } else if (zombie.getWorldY() < zombie.getGamePanel().getPlayer().getWorldY() && zombie.getWorldX() > zombie.getGamePanel().getPlayer().getWorldX()) {
        zombie.setDirection("left_down");
      } else if (zombie.getWorldY() > zombie.getGamePanel().getPlayer().getWorldY() && zombie.getWorldX() < zombie.getGamePanel().getPlayer().getWorldX()) {
        zombie.setDirection("right_up");
      } else if (zombie.getWorldY() > zombie.getGamePanel().getPlayer().getWorldY() && zombie.getWorldX() > zombie.getGamePanel().getPlayer().getWorldX()) {
        zombie.setDirection("left_up");
      }
    } else if (Math.abs(zombie.getWorldX() - zombie.getGamePanel().getPlayer().getWorldX()) < Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().getPlayer().getWorldY())) {
      if (zombie.getWorldY() < zombie.getGamePanel().getPlayer().getWorldY()) {
        zombie.setDirection("down");
      } else {
        zombie.setDirection("up");
      }
    } else {
      if (zombie.getWorldX() < zombie.getGamePanel().getPlayer().getWorldX()) {
        zombie.setDirection("right");
      } else {
        zombie.setDirection("left");
      }
    }
  }

}
