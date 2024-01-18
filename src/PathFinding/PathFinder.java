package PathFinding;

import Entity.Entity.Entity;
import Main.GamePanel;
import java.util.ArrayList;

public class PathFinder {

  private GamePanel gamePanel;
  private Node[][] node;
  private ArrayList<Node> openList = new ArrayList<>();
  private ArrayList<Node> pathList = new ArrayList<>();
  private Node startNode;
  private Node goalNode;
  private Node currentNode;
  private boolean goalReached = false;
  private int step = 0;

  public PathFinder(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    instantiateNodes();
  }
  public void instantiateNodes() {

    int maxWorldCol = gamePanel.getMaxWorldCol();
    int maxWorldRow = gamePanel.getMaxWorldRow();

    node = new Node[maxWorldCol][maxWorldRow];

    int col = 0;
    int row = 0;

    while (col < maxWorldCol && row < maxWorldRow) {

      node[col][row] = new Node(col, row);

      col++;
      if (col == maxWorldCol) {
        col = 0;
        row++;
      }
    }
  }
  public void resetNodes() {
    int col = 0;
    int row = 0;

    int maxWorldCol = gamePanel.getMaxWorldCol();
    int maxWorldRow = gamePanel.getMaxWorldRow();

    while (col < maxWorldCol && row < maxWorldRow) {
      node[col][row].open = false;
      node[col][row].checked = false;
      node[col][row].solid = false;

      col++;
      if (col == maxWorldCol) {
        col = 0;
        row++;
      }
    }

    openList.clear();
    pathList.clear();
    goalReached = false;
    step = 0;
  }

  public void setNodes(int startCol, int startRow, int goalCol, int goalRow, Entity entity) {

    resetNodes();

    startNode = node[startCol][startRow];
    currentNode = startNode;
    goalNode = node[goalCol][goalRow];
    openList.add(currentNode);

    int maxWorldCol = gamePanel.getMaxWorldCol();
    int maxWorldRow = gamePanel.getMaxWorldRow();

    int col = 0;
    int row = 0;

    int [][] mapTileNum = gamePanel.getTileM().getMapTileNum();


    while (col < maxWorldCol && row < maxWorldRow) {

      int tileNum = mapTileNum[col][row];
      if (gamePanel.getTileM().getTile()[tileNum].isCollision()) {
        node[col][row].solid = true;
      }
      getCost(node[col][row]);

      col++;
      if (col == maxWorldCol) {
        col = 0;
        row++;
      }
    }



  }
  public void getCost(Node node) {
    int xDistance = Math.abs(node.col - startNode.col);
    int yDistance = Math.abs(node.row - startNode.row);
    node.gCost = xDistance + yDistance;
    xDistance = Math.abs(node.col - goalNode.col);
    yDistance = Math.abs(node.row - goalNode.row);
    node.hCost = xDistance + yDistance;
    node.fCost = node.gCost + node.hCost;
  }
  public boolean search() {
    while(!goalReached && step < 500) {

    }
    //remove return
    return false;
  }
}
