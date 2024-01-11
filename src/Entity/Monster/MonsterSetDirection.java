package Entity.Monster;

public class MonsterSetDirection {


  public void monsterSetDirection(Monster monster) {
    int playerX = monster.getGamePanel().getPlayer().getWorldX();
    int playerY = monster.getGamePanel().getPlayer().getWorldY();
    int monsterX = monster.getWorldX();
    int monsterY = monster.getWorldY();

    if (Math.abs(Math.abs(monsterX - playerX) - Math.abs(
        monsterY - playerY)) < 50) {
      if (monsterY < playerY && monsterX< playerX) {
        monster.setDirection("right_down");
      } else if (monsterY < playerY && monsterX> playerX) {
        monster.setDirection("left_down");
      } else if (monsterY > playerY && monsterX < playerX) {
        monster.setDirection("right_up");
      } else if (monsterY > playerY && monsterX > playerX) {
        monster.setDirection("left_up");
      }
    } else if (Math.abs(monsterX - playerX) < Math.abs(
        monsterY - playerY)) {
      if (monsterY < playerY) {
        monster.setDirection("down");
      } else {
        monster.setDirection("up");
      }
    } else {
      if (monsterX < playerX) {
        monster.setDirection("right");
      } else {
        monster.setDirection("left");
      }
    }
  }

}
