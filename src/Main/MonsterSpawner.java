package Main;

import Entity.Monster.Zombie.Zombie;
import Entity.Player.Player;


public class MonsterSpawner {

  private final GamePanel gp;
  private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

  public MonsterSpawner(GamePanel gp) {
    this.gp = gp;
  }

  public void spawnNewMonster(Player player) {

    int playerX = player.getWorldX();
    int playerY = player.getWorldY();
    int playerScreenX = player.getScreenX();
    int playerScreenY = player.getScreenY();
    int tileSize = gp.getTileSize();

    int monsterX = 0;
    int monsterY = 0;

    boolean foundSpace = false;

    while (!foundSpace) {

      monsterX = randomNumberGenerator.generateRandomNumber();
      monsterY = randomNumberGenerator.generateRandomNumber();

      if (!
              //only valid if outside player screen
              (monsterX + tileSize > playerX - playerScreenX &&
              monsterX - tileSize < playerX + playerScreenX &&
              monsterY + tileSize > playerY - playerScreenY &&
              monsterY - tileSize < playerY + playerScreenY)) {

        int tileColumn = monsterX / tileSize;
        int tileRow = monsterY / tileSize;

        int tile1 = gp.getTileM().getMapTileNum()[tileColumn][tileRow];
        int tile2 = gp.getTileM().getMapTileNum()[tileColumn + 1][tileRow];
        int tile3 = gp.getTileM().getMapTileNum()[tileColumn][tileRow + 1];
        int tile4 = gp.getTileM().getMapTileNum()[tileColumn - 1][tileRow];
        int tile5 = gp.getTileM().getMapTileNum()[tileColumn][tileRow - 1];

        if (      //only valid if outside any unpassable terrain
                !gp.getTileM().getTile()[tile1].isCollision() &&
                !gp.getTileM().getTile()[tile2].isCollision() &&
                !gp.getTileM().getTile()[tile3].isCollision() &&
                !gp.getTileM().getTile()[tile4].isCollision() &&
                !gp.getTileM().getTile()[tile5].isCollision())


        {
          foundSpace = true;
        }


      }
    }
    //create new zombie as thread
    System.out.println("a new zombie has spawned");
    Zombie zombie = new Zombie(gp, monsterX, monsterY);
    Thread thread = new Thread(zombie);
    zombie.addThread(thread);
    thread.start();
    gp.addMonster(zombie);
  }
}



