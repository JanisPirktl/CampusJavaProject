package Entity.Monster.Zombie;

import Entity.Monster.Monster;
import Main.GamePanel;
import java.awt.Rectangle;


public class Zombie extends Monster {



  public Zombie(GamePanel gamePanel, int worldX, int worldY) {
    super(gamePanel);
    this.setWorldX(worldX);
    this.setWorldY(worldY);
    setSolidArea(new Rectangle(0, 0, 48, 48));
    setSolidAreaDefaultX(getSolidArea().x);
    setSolidAreaDefaultY(getSolidArea().y);
    setCollisionOn(true);
    setDirection("down");
    SetZombieImages imageSetter = new SetZombieImages();
    imageSetter.setZombieImages(this);
  }

  public void update() {
    //mach nix
  }

}




