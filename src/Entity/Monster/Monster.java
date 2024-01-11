package Entity.Monster;


import Entity.Entity.Entity;
import Entity.Entity.SpriteCounter;

public abstract class Monster extends Entity implements Runnable {

  private boolean attackingPlayer = false;
  Thread thread;
  FacePlayer facePlayer = new FacePlayer();
  CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();
  SpriteCounter spriteCounter = new SpriteCounter();
  MonsterAttack monsterAttack = new MonsterAttack();


  protected Monster () {
    super(2);
  }


  public void run() {
    facePlayer.facePlayer(this);                //Make Monster face player
    getCheckFacedTile().checkFacedTile(this);                    //Check tile collision
    if (checkDistanceToPlayer.checkDistance(this)) {      //Check distance to player
      setCollisionOn(true);
      //setAttackingPlayer(true);
      //monsterAttack.monsterAttack(this);
    } else {
      move();
      spriteCounter.countSprite(this, 30);
    }
  }
  public void addThread(Thread thread)  {
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
}
