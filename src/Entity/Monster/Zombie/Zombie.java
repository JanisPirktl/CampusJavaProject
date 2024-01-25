package Entity.Monster.Zombie;

import Entity.Monster.Monster;
import Main.GamePanel;
import java.awt.Rectangle;


//this is the basic Zombie class, it contains only a few variables because most of them are
// in the Monster Class or even the Entity Class
public class Zombie extends Monster {



  public Zombie(GamePanel gamePanel, int worldX, int worldY) {
    super(gamePanel);
    this.setWorldX(worldX);
    this.setWorldY(worldY);
    setSolidArea(new Rectangle(15, 16, 18, 32));
    setSolidAreaDefaultX(getSolidArea().x);
    setSolidAreaDefaultY(getSolidArea().y);
    setCollisionOn(true);
    setDirection("down");
    SetZombieImages imageSetter = new SetZombieImages();
    imageSetter.setZombieImages(this);
  }



}




