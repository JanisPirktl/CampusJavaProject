import Entity.Entity.CheckMonsterIntersection;
import Entity.Monster.CheckDistanceToPlayer;
import Entity.Monster.Zombie.Zombie;
import Entity.Player.Player;
import Main.GamePanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {

  private static Zombie zombie;
  private static Player player;
  private static GamePanel gamePanel;
  private static int playerX;
  private static int playerY;
  private static CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();
  private static CheckMonsterIntersection checkMonsterIntersection = new CheckMonsterIntersection();


  @BeforeAll
  static void beforeAll() {
    gamePanel = new GamePanel();
    zombie = new Zombie(gamePanel, 1000, 1000);
    player = gamePanel.getPlayer();
    playerX = player.getWorldX();
    playerY = player.getWorldY();
    System.out.println("Befor all test methods");
  }

  @AfterEach
  void afterEach() {
    player.setWorldX(playerX);
    player.setWorldY(playerY);
    System.out.println("After each test method");
  }


  @Test
  public void checkDistanceToPlayerTest() {
    System.out.println("First test method");
    Assertions.assertEquals(false, checkDistanceToPlayer.checkDistance(zombie));
    player.setWorldX(1001);
    player.setWorldY(1001);
    Assertions.assertEquals(true, checkDistanceToPlayer.checkDistance(zombie));
  }

  @Test
  public void checkMonsterIntersection() {
    System.out.println("Second test method");
    gamePanel.addMonster(zombie);
    player.setWorldX(996);
    player.setWorldY(1000);
    player.setDirection("right");
    Assertions.assertEquals(true, checkMonsterIntersection.checkMonsterIntersection(player));
  }


}
