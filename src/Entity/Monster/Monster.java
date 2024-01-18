package Entity.Monster;


import Entity.Entity.CheckMonsterIntersection;
import Entity.Entity.Entity;
import Entity.Entity.SpriteCounter;
import Main.GamePanel;
import PathFinding.PathFinder;

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
    //facePlayer.facePlayer(this);    //Make Monster face player
    int goalCol = (gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getSolidArea().x) / 48;
    int goalRow = (gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getSolidArea().y) / 48;
    searchPath(goalCol, goalRow);

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
    }

    move();
    spriteCounter.countSprite(this, 30);

  }

  private void searchPath(int goalCol, int goalRow) {

    int startCol = (getWorldX() + getSolidArea().x) / 48;
    int startRow = (getWorldY() + getSolidArea().y) / 48;
    startCol++;

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

  @Override
  public GamePanel getGamePanel() {
    return gamePanel;
  }

  public PathFinder getPathFinder() {
    return pathFinder;
  }
}
