package Main;

import Entity.Monster.Zombie;


public class MonsterSpawn {



  private final GamePanel gp;

  public MonsterSpawn(GamePanel gp) {
    this.gp = gp;
  }

  public void spawnNewMonster() throws InterruptedException {
    System.out.println("a new zombie has spawned");
    Zombie zombie = new Zombie(gp, 800, 800);
    Thread thread = new Thread(zombie);
    zombie.addThread(thread);
    thread.start();
    gp.addMonster(zombie);
  }


}
