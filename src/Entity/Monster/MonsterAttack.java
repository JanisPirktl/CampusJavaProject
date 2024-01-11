package Entity.Monster;


public class MonsterAttack {

  public void monsterAttack(Monster monster) {

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
  }
}
