package Main;

import Entity.Zombie;

public class MonsterSpawn {

  GamePanel gp;

  public MonsterSpawn(GamePanel gp) {
    this.gp = gp;
  }

  public void setMonster() {

    gp.addMonster(new Zombie(gp, 20 * gp.tileSize, 20 * gp.tileSize));

  }
}