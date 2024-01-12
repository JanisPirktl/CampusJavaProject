package Entity.Monster;


import java.awt.Graphics2D;

public class MonsterAttack {

  public void monsterAttack(Monster monster, Graphics2D graphics2D) {

    String direction = monster.getDirection();

    switch (direction) {
      case "up":
        monster.setImage(monster.getAttackUp1());
        break;
      case "down":
        monster.setImage(monster.getAttackDown1());
        break;
      case "left":
        monster.setImage(monster.getAttackLeft1());
        break;
      case "right":
        monster.setImage(monster.getAttackRight1());
        break;
      case "right_up":
        monster.setImage(monster.getAttackUpRight1());
        break;
      case "right_down":
        monster.setImage(monster.getAttackDownRight1());
        break;
      case "left_up":
        monster.setImage(monster.getAttackUpLeft1());
        break;
      case "left_down":
        monster.setImage(monster.getAttackDownLeft1());
        break;
    }

    graphics2D.drawImage(monster.getImage(), monster.getScreenX(), monster.getScreenY(), 48, 48,
        null);

    long lastTime = System.nanoTime();

    while (true) {
      long currentTime = System.nanoTime();
      if (Math.abs(lastTime - currentTime) >= 500000000) {
        System.out.println("HALBE SEKUNDE IST VERGANGEN");
        break;
      }
    }

    switch (direction) {
      case "up":
        monster.setImage(monster.getAttackUp2());
        break;
      case "down":
        monster.setImage(monster.getAttackDown2());
        break;
      case "left":
        monster.setImage(monster.getAttackLeft2());
        break;
      case "right":
        monster.setImage(monster.getAttackRight2());
        break;
      case "right_up":
        monster.setImage(monster.getAttackUpRight2());
        break;
      case "right_down":
        monster.setImage(monster.getAttackDownRight2());
        break;
      case "left_up":
        monster.setImage(monster.getAttackUpLeft2());
        break;
      case "left_down":
        monster.setImage(monster.getAttackDownLeft2());
        break;
    }
    graphics2D.drawImage(monster.getImage(), monster.getScreenX(), monster.getScreenY(), 48, 48,
        null);

    lastTime = System.nanoTime();

    while (true) {
      long currentTime = System.nanoTime();
      if (Math.abs(lastTime - currentTime) >= 500000000) {
        System.out.println("HALBE SEKUNDE IST VERGANGEN");
        break;
      }
    }

    monster.setAttackingPlayer(false);


  }
}
