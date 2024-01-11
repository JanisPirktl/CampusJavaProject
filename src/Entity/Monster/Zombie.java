package Entity.Monster;

import CollisionCheck.CheckFacedTile;

import Entity.SpriteCounter;
import Main.GamePanel;
import java.awt.Rectangle;


public class Zombie extends Monster {
  private final GamePanel gamePanel;
  private final CheckFacedTile checkFacedTile = new CheckFacedTile();
  private final MonsterSetDirection monsterSetDirection = new MonsterSetDirection();
  private final CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();


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

    monsterSetDirection.monsterSetDirection(this); //Make Zombie face Player
    checkFacedTile.checkFacedTile(this); //Check Tile Collision
    checkDistanceToPlayer.checkDistance(this); //Make Zombie stand still if close to player

    if (isCollisionOn()) {
      //attack();
    } else {

      move();
      SpriteCounter.countSprite(this, 30);
    }

  }



  public GamePanel getGamePanel() {
    return gamePanel;
  }
}




