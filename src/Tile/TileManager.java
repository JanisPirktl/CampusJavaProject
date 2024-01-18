package Tile;

import Entity.Monster.Monster;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;

import Main.GamePanel;
import java.io.BufferedReader;

public class TileManager {

  private final GamePanel gamePanel;
  private final Tile[] tile;
  private final int[][] mapTileNum;
  private final int[][] collisionMapTileNum;
  public TileManager(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    tile = new Tile[10];
    mapTileNum = new int[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldRow()];
    collisionMapTileNum = new int[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldRow()];
    getTileImage();
    loadMap("/maps/map.txt");
    //loadCollisionMap("/maps/collision_map.txt");
  }
  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png"))));
      tile[1] = new Tile();
      tile[1].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png"))));
      tile[1].setCollision(true);
      tile[2] = new Tile();
      tile[2].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png"))));
      tile[2].setCollision(true);
      tile[3] = new Tile();
      tile[3].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/earth.png"))));
      tile[4] = new Tile();
      tile[4].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree.png"))));
      tile[4].setCollision(true);
      tile[5] = new Tile();
      tile[5].setImage(ImageIO.read(
          Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sand.png"))));
    }catch(IOException e) {
      System.out.println(e.getMessage());
    }
  }
  public void loadMap(String filePath) {
    try {
      InputStream is = getClass().getResourceAsStream(filePath);
      assert is != null;
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col  = 0;
      int row = 0;
      while(col < gamePanel.getMaxWorldCol() && row < gamePanel.getMaxWorldRow()) {
        String line = br.readLine();
        while(col < gamePanel.getMaxWorldCol()) {
          String[] numbers = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          mapTileNum[col][row] = num;
          col++;
        }
        if(col == gamePanel.getMaxWorldCol()) {
          col = 0;
          row++;
        }
      }
      br.close();
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }

  }

  public void loadCollisionMap(String filePath) {
    try {
      InputStream is = getClass().getResourceAsStream(filePath);
      assert is != null;
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col  = 0;
      int row = 0;
      while(col < gamePanel.getMaxWorldCol() && row < gamePanel.getMaxWorldRow()) {
        String line = br.readLine();
        while(col < gamePanel.getMaxWorldCol()) {
          String[] numbers = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          collisionMapTileNum[col][row] = num;
          col++;
        }
        if(col == gamePanel.getMaxWorldCol()) {
          col = 0;
          row++;
        }
      }
      br.close();
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }

  }
  public void draw(Graphics2D g2) {
    int worldCol = 0;
    int worldRow = 0;
    while(worldCol < gamePanel.getMaxWorldCol() && worldRow < gamePanel.getMaxWorldRow()) {
      int tileNum = mapTileNum[worldCol][worldRow];
      int worldX = worldCol * gamePanel.getTileSize();
      int worldY = worldRow * gamePanel.getTileSize();
      int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX();
      int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY();
      if(worldX + gamePanel.getTileSize() > gamePanel.getPlayer().getWorldX() - gamePanel.getPlayer().getScreenX() &&
          worldX - gamePanel.getTileSize() < gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX() &&
          worldY + gamePanel.getTileSize() > gamePanel.getPlayer().getWorldY() - gamePanel.getPlayer().getScreenY() &&
          worldY - gamePanel.getTileSize() < gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY()) {
        g2.drawImage(tile[tileNum].getImage(), screenX, screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
      }
      worldCol++;
      if(worldCol == gamePanel.getMaxWorldCol()) {
        worldCol = 0;
        worldRow++;
      }
    }
    ArrayList<Monster> monsters = gamePanel.getMonsters();
    for (Monster monster : monsters) {
      g2.setColor(new Color(255, 0,0, 70));
      for (int i = 0; i < monster.getPathFinder().getPathList().size(); i++) {
        int worldX = monster.getPathFinder().getPathList().get(i).getCol() * 48;
        int worldY = monster.getPathFinder().getPathList().get(i).getRow() * 48;
        int screenX = worldX - gamePanel.getPlayer().getWorldX() + gamePanel.getPlayer().getScreenX();
        int screenY = worldY - gamePanel.getPlayer().getWorldY() + gamePanel.getPlayer().getScreenY();
        g2.fillRect(screenX, screenY, 48, 48);
      }
    }
  }

  public Tile[] getTile() {
    return tile;
  }


  public int[][] getMapTileNum() {
    return mapTileNum;
  }
}





