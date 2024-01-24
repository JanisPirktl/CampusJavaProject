package Tile;


import java.awt.image.BufferedImage;


//a tile represents a bufferedImage like a tree or water or grass. The world is set up with 48x48 Pixxel Tiles
public class Tile {
  private BufferedImage image;
  private boolean collision = false;

  public void setImage(BufferedImage image) {
    this.image = image;
  }
  public BufferedImage getImage() {
    return image;
  }
  public void setCollision(boolean collision) {
    this.collision = collision;
  }
  public boolean isCollision() {
    return collision;
  }
}
