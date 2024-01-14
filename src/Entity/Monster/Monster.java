package Entity.Monster;


import Entity.Entity.CheckMonsterIntersection;
import Entity.Entity.Entity;
import Entity.Entity.SpriteCounter;

public abstract class Monster extends Entity implements Runnable {

  private boolean attackingPlayer = false;

  private Thread thread;
  private final FacePlayer facePlayer = new FacePlayer();
  private final CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();
  private final SpriteCounter spriteCounter = new SpriteCounter();
  private final CheckMonsterIntersection checkMonsterIntersection = new CheckMonsterIntersection();
  private long currentTime;


  protected Monster() {
    super(2);
  }


  public void run() {

    setCollisionOn(false);
    facePlayer.facePlayer(this);                //Make Monster face player

    //Check tile collision
    if (getCheckFacedTile().checkFacedTile(this)) {
      setCollisionOn(true);
    }

    //Check collision with other monsters
    if (checkMonsterIntersection.checkMonsterIntersection(this)) {
      setCollisionOn(true);
    }

    if (checkDistanceToPlayer.checkDistance(this)) {
      setCollisionOn(true);//Check distance to player
      setAttackingPlayer(true);
      currentTime = System.nanoTime();
    }

    move();
    spriteCounter.countSprite(this, 30);

  }


  public void addThread(Thread thread) {
    this.thread = thread;
  }

  public Thread getThread() {
    return thread;
  }

  public boolean isAttackingPlayer() {
    return attackingPlayer;
  }

  public void setAttackingPlayer(boolean attackingPlayer) {
    this.attackingPlayer = attackingPlayer;
  }


  public long getCurrentTime() {
    return currentTime;
  }

}
