package Entity;

import ImageSetter.SetZombieImages;
import Draw.Draw;
import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Zombie extends Entity {

  //TODO set private
  GamePanel gp;
  private BufferedImage image;
  private Draw draw = new Draw();


  public Zombie(GamePanel gp, int worldX, int worldY) {
    super(2);
    this.gp = gp;
    this.setWorldX(worldX);
    this.setWorldY(worldY);
    solidArea = new Rectangle(0, 0, 48, 48);
    setSolidAreaDefaultX(0);
    setSolidAreaDefaultY(0);
    setCollisionOn(true);
    setDirection("down");
    SetZombieImages imageSetter = new SetZombieImages();
    imageSetter.setZombieImages(this);
  }




  public void update() {

    setCollisionOn(false);
    ZombieCheckDistanceToPlayer.checkDistance(this); //Make Zombie stand still
    if (isCollisionOn()) {
      //facePlayer(this);
      //attack();
    } else {
      ZombieSetDirection.zombieSetDirection(this); //Make Zombie face Player
      gp.cChecker.checkTile(this); //Check Tile Collision
      if (!isCollisionOn()) {
        EntityMove.move(this); //Make Zombie move
      }
      EntitySpriteCounter.countSprite(this, 30);
    }

  }


  public void paint (Graphics2D g2, GamePanel gp) {

    //calculate zombie's position on the screen
    int screenX = getWorldX() - gp.player.getWorldX() + gp.player.getScreenX();
    int screenY = getWorldY() - gp.player.getWorldY() + gp.player.getScreenY();

    //only draws the zombie, if it's located inside screen area
    if (getWorldX() + gp.tileSize > gp.player.getWorldX() - gp.player.getScreenX() &&
        getWorldX() - gp.tileSize < gp.player.getWorldX() + gp.player.getScreenX() &&
        getWorldY() + gp.tileSize > gp.player.getWorldY() - gp.player.getScreenY() &&
        getWorldY() - gp.tileSize < gp.player.getWorldY() + gp.player.getScreenY()) {
      draw.draw(this,g2, gp.tileSize, screenX, screenY);
    }
  }



  public void setImage(BufferedImage image) {
    this.image = image;
  }
}




