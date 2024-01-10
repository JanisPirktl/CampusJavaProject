package Entity;

public class ZombieSetDirection {

  public void zombieSetDirection(Zombie zombie) {

    if (Math.abs(Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX()) - Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().player.getWorldY())) < 50) {
      if (zombie.getWorldY() < zombie.getGamePanel().player.getWorldY() && zombie.getWorldX() < zombie.getGamePanel().player.getWorldX()) {
        zombie.setDirection("right_down");
      } else if (zombie.getWorldY() < zombie.getGamePanel().player.getWorldY() && zombie.getWorldX() > zombie.getGamePanel().player.getWorldX()) {
        zombie.setDirection("left_down");
      } else if (zombie.getWorldY() > zombie.getGamePanel().player.getWorldY() && zombie.getWorldX() < zombie.getGamePanel().player.getWorldX()) {
        zombie.setDirection("right_up");
      } else if (zombie.getWorldY() > zombie.getGamePanel().player.getWorldY() && zombie.getWorldX() > zombie.getGamePanel().player.getWorldX()) {
        zombie.setDirection("left_up");
      }
    } else if (Math.abs(zombie.getWorldX() - zombie.getGamePanel().player.getWorldX()) < Math.abs(
        zombie.getWorldY() - zombie.getGamePanel().player.getWorldY())) {
      if (zombie.getWorldY() < zombie.getGamePanel().player.getWorldY()) {
        zombie.setDirection("down");
      } else {
        zombie.setDirection("up");
      }
    } else {
      if (zombie.getWorldX() < zombie.getGamePanel().player.getWorldX()) {
        zombie.setDirection("right");
      } else {
        zombie.setDirection("left");
      }
    }
  }

}
