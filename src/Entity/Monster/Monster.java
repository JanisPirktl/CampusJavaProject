package Entity.Monster;


import Entity.Entity.CheckMonsterIntersection;
import Entity.Entity.Entity;
import Entity.Entity.SpriteCounter;
import Main.GamePanel;
import PathFinding.PathFinder;


//abstract class Monster contains instances of all methods only used by Monsters and not the
//Player like checkDistanceToPlayer() or facePlayer(). It also contains the run() Method, which
//is executed 60 times per second. This run() Method contains the monster logic for some parts of
//its behaviour. It also has the searchPath() Method to calculate the optimal path and make
//the monster walk around obstacles
public abstract class Monster extends Entity implements Runnable {

  private boolean attackingPlayer = false;

  private final PathFinder pathFinder;
  private final GamePanel gamePanel;

  private Thread thread;
  private final FacePlayer facePlayer = new FacePlayer();
  private final CheckDistanceToPlayer checkDistanceToPlayer = new CheckDistanceToPlayer();
  private final SpriteCounter spriteCounter = new SpriteCounter();
  private final CheckMonsterIntersection checkMonsterIntersection = new CheckMonsterIntersection();

  private long currentTime;


  protected Monster(GamePanel gamePanel) {
    super(2);
    pathFinder = new PathFinder(gamePanel);
    this.gamePanel = gamePanel;
  }


  public void run() {

    setCollisionOn(false);


    if (!attackingPlayer) {
      int goalCol = (gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getSolidArea().x) / 48;
      int goalRow = (gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getSolidArea().y) / 48;

      if (gamePanel.getPlayer().isToggle()) {
        searchPath(goalCol, goalRow);
      } else {
        facePlayer.facePlayer(this);
      }
    }


    //Check tile collision
    if (getCheckFacedTile().checkFacedTile(this)) {
      setCollisionOn(true);
    }

    //check monster collision
    if (checkMonsterIntersection.checkMonsterIntersection(this)) {
      setCollisionOn(true);
    }

    if (checkDistanceToPlayer.checkDistance(this)) {
      setCollisionOn(true);//Check distance to player
      setAttackingPlayer(true);
      currentTime = System.nanoTime();
      facePlayer.facePlayer(this);
    }

    move();
    spriteCounter.countSprite(this, 30);

  }

  private void searchPath(int goalCol, int goalRow) {

    int startCol = (getWorldX() + 24) / 48;
    int startRow = (getWorldY() + 24) / 48;




    pathFinder.setNodes(startCol, startRow, goalCol, goalRow);

    if (pathFinder.search()) {
      int nextX = pathFinder.getPathList().get(0).getCol() * 48;
      int nextY = pathFinder.getPathList().get(0).getRow() * 48;

      int entityLeftX = getWorldX() + getSolidArea().x;
      int entityRightX = getWorldX() + getSolidArea().x + getSolidArea().width;
      int entityTopY = getWorldY() + getSolidArea().y;
      int entityBottomY = getWorldY() + getSolidArea().y + getSolidArea().height;



      if (entityTopY > nextY && entityLeftX >= nextX && entityRightX < nextX + 48) {
        setDirection("up");
      } else if (entityTopY < nextY && entityLeftX >= nextX && entityRightX < nextX + 48) {
        setDirection("down");
      } else if (entityTopY >= nextY && entityBottomY < nextY + 48) {
        if (entityLeftX > nextX) {
          setDirection("left");
        }
        if (entityLeftX < nextX) {
          setDirection("right");
        }
      } else if (entityTopY > nextY && entityLeftX > nextX) {
        setDirection("up");
        if (getCheckFacedTile().checkFacedTile(this)) {
          setDirection("left");
        }
      } else if (entityTopY > nextY && entityLeftX < nextX) {
        setDirection("up");
        if (getCheckFacedTile().checkFacedTile(this)) {
          setDirection("right");
        }
      } else if (entityTopY < nextY && entityLeftX > nextX) {
        setDirection("down");
        if (getCheckFacedTile().checkFacedTile(this)) {
          setDirection("left");
        }
      } else if (entityTopY < nextY && entityLeftX < nextX) {
        setDirection("down");
        if (getCheckFacedTile().checkFacedTile(this)) {
          setDirection("right");
        }
      }



    }
  }


  public void addThread(Thread thread) {
    this.thread = thread;
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

  @Override
  public GamePanel getGamePanel() {
    return gamePanel;
  }

  public PathFinder getPathFinder() {
    return pathFinder;
  }
}
