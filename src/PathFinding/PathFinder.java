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

  public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {

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

      int col = currentNode.col;
      int row = currentNode.row;

      currentNode.checked = true;
      openList.remove(currentNode);

      if (row-1 >= 0) {
        openNode(node[col][row-1]);
      }
      if (col - 1 >= 0) {
        openNode(node[col-1][row]);
      }
      if (row + 1 < gamePanel.getMaxWorldRow()) {
        openNode(node[col][row+1]);
      }
      if (col + 1 < gamePanel.getMaxWorldCol()) {
        openNode(node[col+1][row]);
      }

      int bestNodeIndex = 0;
      int bestNodefCost = Integer.MAX_VALUE;

      for (int i = 0; i < openList.size(); i++) {
        if (openList.get(i).fCost < bestNodefCost) {
          bestNodeIndex = i;
          bestNodefCost = openList.get(i).fCost;
        } else if (openList.get(i).fCost == bestNodefCost) {
          if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
            bestNodeIndex = i;
          }
        }
      }

      if (openList.size() == 0) {
        break;
      }

      currentNode = openList.get(bestNodeIndex);

      if (currentNode == goalNode) {
        goalReached = true;
        trackThePath();
      }
      step++;
    }
    return goalReached;
  }
  public void openNode(Node node) {

    if(!node.open && !node.checked && !node.solid) {

      node.open = true;
      node.parent = currentNode;
      openList.add(node);
    }
  }
  public void trackThePath() {

    Node current = goalNode;

    while (current != startNode) {
      pathList.add(0, current);
      current = current.parent;
    }
  }

  public ArrayList<Node> getPathList() {
    return pathList;
  }
}
