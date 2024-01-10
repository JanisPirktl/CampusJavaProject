package Entity;

import CollisionCheck.CheckFacedTile;
import ImageSetter.SetZombieImages;
import Draw.Draw;
import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Zombie extends Entity {
  private final GamePanel gamePanel;
  private final Draw draw = new Draw();
  private final CheckFacedTile checkFacedTile = new CheckFacedTile();
  private final ZombieSetDirection zombieSetDirection = new ZombieSetDirection();
  private final CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();
  private final Move move = new Move();

  public Zombie(GamePanel gamePanel, int worldX, int worldY) {
    super(2);
    this.gamePanel = gamePanel;
    this.setWorldX(worldX);
    this.setWorldY(worldY);
    setSolidArea(new Rectangle(0,0,48,48));
    setSolidAreaDefaultX(0);
    setSolidAreaDefaultY(0);
    setCollisionOn(true);
    setDirection("down");
    SetZombieImages imageSetter = new SetZombieImages();
    imageSetter.setZombieImages(this);
  }

  public void update() {

    zombieSetDirection.zombieSetDirection(this); //Make Zombie face Player
    checkFacedTile.checkFacedTile(this); //Check Tile Collision
    checkDistanceToPlayer.checkDistance(this); //Make Zombie stand still if close to player

    if (isCollisionOn()) {
      //attack();
    } else {

      if (!isCollisionOn()) {
        move.move(this); //Make Zombie move
      }
      EntitySpriteCounter.countSprite(this, 30);
    }

  }

  public void paint(Graphics2D g2, GamePanel gamePanel) {

    //calculate zombie's position on the screen
    int screenX = getWorldX() - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX();
    int screenY = getWorldY() - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY();

    //only draws the zombie, if it's located inside screen area
    if (getWorldX() + gamePanel.getTileSize()
        > gamePanel.getPlayer().getWorldX() - gamePanel.getPlayer().getScreenX() &&
        getWorldX() - gamePanel.getTileSize()
            < gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX() &&
        getWorldY() + gamePanel.getTileSize()
            > gamePanel.getPlayer().getWorldY() - gamePanel.getPlayer().getScreenY() &&
        getWorldY() - gamePanel.getTileSize()
            < gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY()) {
      draw.draw(this, g2, gamePanel.getTileSize(), screenX, screenY);
    }
  }

  public GamePanel getGamePanel() {
    return gamePanel;
  }
}




