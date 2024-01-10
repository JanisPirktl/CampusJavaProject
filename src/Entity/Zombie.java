package Entity;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Zombie extends Entity {

  //TODO set private
  GamePanel gp;
  private BufferedImage image;
  private ZombieImages imageSetter = new ZombieImages();



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

  public void draw(Graphics2D g2, GamePanel gp) {
    int screenX = getWorldX() - gp.player.getWorldX() + gp.player.getScreenX();
    int screenY = getWorldY() - gp.player.getWorldY() + gp.player.getScreenY();
    SetMonsterImage.setImage(this);

    //only draws the zombie, if it's located inside screen area
    if (getWorldX() + gp.tileSize > gp.player.getWorldX() - gp.player.getScreenX() &&
        getWorldX() - gp.tileSize < gp.player.getWorldX() + gp.player.getScreenX() &&
        getWorldY() + gp.tileSize > gp.player.getWorldY() - gp.player.getScreenY() &&
        getWorldY() - gp.tileSize < gp.player.getWorldY() + gp.player.getScreenY()) {
      g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
  }



  public void setImage(BufferedImage image) {
    this.image = image;
  }
}




