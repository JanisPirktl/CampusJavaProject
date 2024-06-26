package Entity.Monster;

public class FacePlayer {

  //used when a monster is close to the player, calculates its direction according to
  // its own and the players world coordinates
  public void facePlayer(Monster monster) {

    int playerX = monster.getGamePanel().getPlayer().getWorldX();
    int playerY = monster.getGamePanel().getPlayer().getWorldY();
    int monsterX = monster.getWorldX();
    int monsterY = monster.getWorldY();


    if (monsterX < playerX && monsterY > playerY){
      if (Math.abs(monsterX - playerX) < 24){
        monster.setDirection("up");
      } else if (Math.abs(monsterY - playerY) < 24) {
        monster.setDirection("right");
      }
      else {
        monster.setDirection("right_up");
      }
    } else if (monsterX > playerX && monsterY > playerY) {
      if (Math.abs(monsterX - playerX) < 24) {
        monster.setDirection("up");
      } else if (Math.abs(monsterY - playerY) < 24) {
        monster.setDirection("left");
      } else {
        monster.setDirection("left_up");
      }
    } else if (monsterX > playerX && monsterY < playerY) {
        if (Math.abs(monsterX - playerX) < 24){
          monster.setDirection("down");
        } else if (Math.abs(monsterY - playerY) < 24) {
          monster.setDirection("left");
        }
        else {
          monster.setDirection("left_down");
        }
    } else if (monsterX < playerX && monsterY < playerY) {
        if (Math.abs(monsterX - playerX) < 24){
          monster.setDirection("down");
        } else if (Math.abs(monsterY - playerY) < 24) {
          monster.setDirection("right");
        }
        else {
          monster.setDirection("right_down");
        }

    }
  }

}
