package Entity.Monster.Zombie;

import Entity.Monster.Monster;
import Main.GamePanel;
import java.awt.Rectangle;


public class Zombie extends Monster {

  private final GamePanel gamePanel;

  public Zombie(GamePanel gamePanel, int worldX, int worldY) {
    super();
    this.gamePanel = gamePanel;
    this.setWorldX(worldX);
    this.setWorldY(worldY);
    setSolidArea(new Rectangle(0, 0, 48, 48));
    setSolidAreaDefaultX(0);
    setSolidAreaDefaultY(0);
    setCollisionOn(true);
    setDirection("down");
    SetZombieImages imageSetter = new SetZombieImages();
    imageSetter.setZombieImages(this);
  }

  public void update() {
    //mach nix
  }
  public GamePanel getGamePanel() {
    return gamePanel;
  }
}




