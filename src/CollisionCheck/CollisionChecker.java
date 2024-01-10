package CollisionCheck;

import Entity.Entity;
import Main.GamePanel;

public class CollisionChecker {

  CheckFacedTile tileChecker = new CheckFacedTile();

  private static GamePanel gp = null;

  public CollisionChecker(GamePanel gp) {
    CollisionChecker.gp = gp;
  }
  public void checkTile(Entity entity) {
    tileChecker.checkFacedTile(entity);
  }

  public void checkMonsterCollision(Entity entity) {
    CheckMonsterIntersection.checkMonsterIntersection(entity);
  }

  public static GamePanel getGp() {
    return gp;
  }
}
