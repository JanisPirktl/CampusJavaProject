package Entity.Entity;

import Main.GamePanel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {

  //this abstract class entity is parent for all monsters and also the player, it contains all the images,
  //the coordinates, its variables and has over 150 getters and setters. Almost every Method like move() or draw()
  //is designed for all kind of entities.

  private int worldX, worldY;
  private final int speed;
  private int tileCol;
  private int tileRow;

  private final CheckFacedTile checkFacedTile = new CheckFacedTile();
  private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, leftUp1, leftUp2, rightUp1, rightUp2, leftDown1, leftDown2, rightDown1, rightDown2, attackLeft1, attackLeft2, attackRight1, attackRight2, attackUp1, attackUp2, attackDown1, attackDown2, attackDownLeft1, attackDownLeft2, attackDownRight1, attackDownRight2, attackUpLeft1, attackUpLeft2, attackUpRight1, attackUpRight2, dead;
  private String direction;

  private int spriteCounter = 0;
  private int spriteNum = 1;

  private Rectangle solidArea;
  private int solidAreaDefaultX;
  private int solidAreaDefaultY;
  private boolean collisionOn;
  private final Move move = new Move();
  private BufferedImage image;
  private int screenX;
  private int screenY;
  private int health = 1;

  private int range;



  //protected constructor because class is abstract
  protected Entity(int speed) {
    this.speed = speed;
  }


  //From here on only Getters and Setters
  public void damage(int amount) {
    this.health -= amount;
  }

  public CheckFacedTile getCheckFacedTile() {
    return checkFacedTile;
  }
  public boolean isCollisionOn() {
    return collisionOn;
  }

  public void setCollisionOn(boolean collisionOn) {
    this.collisionOn = collisionOn;
  }

  public int getSolidAreaDefaultX() {
    return solidAreaDefaultX;
  }

  public void setSolidAreaDefaultX(int solidAreaDefaultX) {
    this.solidAreaDefaultX = solidAreaDefaultX;
  }

  public int getSolidAreaDefaultY() {
    return solidAreaDefaultY;
  }

  public void setSolidAreaDefaultY(int solidAreaDefaultY) {
    this.solidAreaDefaultY = solidAreaDefaultY;
  }

  public BufferedImage getImage() {
    return image;
  }
  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public int getScreenX() {
    return screenX;
  }

  public void setScreenX(int screenX) {
    this.screenX = screenX;
  }

  public int getScreenY() {
    return screenY;
  }

  public void setScreenY(int screenY) {
    this.screenY = screenY;
  }

  public int getSpriteNum() {
    return spriteNum;
  }

  public void setSpriteNum(int spriteNum) {
    this.spriteNum = spriteNum;
  }

  public int getSpriteCounter() {
    return spriteCounter;
  }

  public void setSpriteCounter(int spriteCounter) {
    this.spriteCounter = spriteCounter;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public BufferedImage getUp1() {
    return up1;
  }

  public int getRange() {
    return range;
  }

  public void setRange(int range) {
    this.range = range;
  }

  public void setUp1(BufferedImage up1) {
    this.up1 = up1;
  }

  public BufferedImage getUp2() {
    return up2;
  }

  public void setRightDown1(BufferedImage rightDown1) {
    this.rightDown1 = rightDown1;
  }

  public int getSpeed() {
    return speed;
  }

  public void setUp2(BufferedImage up2) {
    this.up2 = up2;
  }

  public BufferedImage getDown1() {
    return down1;
  }

  public void setDown1(BufferedImage down1) {
    this.down1 = down1;
  }

  public BufferedImage getDown2() {
    return down2;
  }

  public void setDown2(BufferedImage down2) {
    this.down2 = down2;
  }

  public BufferedImage getLeft1() {
    return left1;
  }

  public void setLeft1(BufferedImage left1) {
    this.left1 = left1;
  }

  public BufferedImage getLeft2() {
    return left2;
  }

  public void setLeft2(BufferedImage left2) {
    this.left2 = left2;
  }

  public BufferedImage getRight1() {
    return right1;
  }

  public BufferedImage getLeftUp1() {
    return leftUp1;
  }

  public void setLeftUp1(BufferedImage leftUp1) {
    this.leftUp1 = leftUp1;
  }

  public BufferedImage getLeftUp2() {
    return leftUp2;
  }

  public void setLeftUp2(BufferedImage leftUp2) {
    this.leftUp2 = leftUp2;
  }

  public BufferedImage getRightUp1() {
    return rightUp1;
  }

  public void setRightUp1(BufferedImage rightUp1) {
    this.rightUp1 = rightUp1;
  }

  public BufferedImage getRightUp2() {
    return rightUp2;
  }

  public void setRightUp2(BufferedImage rightUp2) {
    this.rightUp2 = rightUp2;
  }

  public BufferedImage getLeftDown1() {
    return leftDown1;
  }

  public void setLeftDown1(BufferedImage leftDown1) {
    this.leftDown1 = leftDown1;
  }

  public BufferedImage getLeftDown2() {
    return leftDown2;
  }

  public void setLeftDown2(BufferedImage leftDown2) {
    this.leftDown2 = leftDown2;
  }

  public BufferedImage getRightDown1() {
    return rightDown1;
  }


  public BufferedImage getRightDown2() {
    return rightDown2;
  }


  public void setRightDown2(BufferedImage rightDown2) {
    this.rightDown2 = rightDown2;
  }

  public void setRight1(BufferedImage right1) {
    this.right1 = right1;
  }

  public BufferedImage getRight2() {
    return right2;
  }

  public void setRight2(BufferedImage right2) {
    this.right2 = right2;
  }

  public int getWorldX() {
    return worldX;
  }

  public void setWorldX(int worldX) {
    this.worldX = worldX;
  }

  public int getWorldY() {
    return worldY;
  }

  public void setWorldY(int worldY) {
    this.worldY = worldY;
  }

  public BufferedImage getAttackLeft1() {
    return attackLeft1;
  }

  public void setAttackLeft1(BufferedImage attackLeft1) {
    this.attackLeft1 = attackLeft1;
  }

  public BufferedImage getAttackLeft2() {
    return attackLeft2;
  }

  public void setAttackLeft2(BufferedImage attackLeft2) {
    this.attackLeft2 = attackLeft2;
  }

  public BufferedImage getAttackRight1() {
    return attackRight1;
  }

  public void setAttackRight1(BufferedImage attackRight1) {
    this.attackRight1 = attackRight1;
  }

  public BufferedImage getAttackRight2() {
    return attackRight2;
  }

  public void setAttackRight2(BufferedImage attackRight2) {
    this.attackRight2 = attackRight2;
  }

  public BufferedImage getAttackUp1() {
    return attackUp1;
  }

  public void setAttackUp1(BufferedImage attackUp1) {
    this.attackUp1 = attackUp1;
  }

  public BufferedImage getAttackUp2() {
    return attackUp2;
  }

  public void setAttackUp2(BufferedImage attackUp2) {
    this.attackUp2 = attackUp2;
  }

  public BufferedImage getAttackDown1() {
    return attackDown1;
  }

  public void setAttackDown1(BufferedImage attackDown1) {
    this.attackDown1 = attackDown1;
  }

  public BufferedImage getAttackDown2() {
    return attackDown2;
  }

  public void setAttackDown2(BufferedImage attackDown2) {
    this.attackDown2 = attackDown2;
  }

  public BufferedImage getAttackDownLeft1() {
    return attackDownLeft1;
  }

  public void setAttackDownLeft1(BufferedImage attackDownLeft1) {
    this.attackDownLeft1 = attackDownLeft1;
  }

  public BufferedImage getAttackDownLeft2() {
    return attackDownLeft2;
  }

  public void setAttackDownLeft2(BufferedImage attackDownLeft2) {
    this.attackDownLeft2 = attackDownLeft2;
  }

  public BufferedImage getAttackDownRight1() {
    return attackDownRight1;
  }

  public void setAttackDownRight1(BufferedImage attackDownRight1) {
    this.attackDownRight1 = attackDownRight1;
  }

  public BufferedImage getAttackDownRight2() {
    return attackDownRight2;
  }

  public void setAttackDownRight2(BufferedImage attackDownRight2) {
    this.attackDownRight2 = attackDownRight2;
  }

  public BufferedImage getAttackUpLeft1() {
    return attackUpLeft1;
  }

  public void setAttackUpLeft1(BufferedImage attackUpLeft1) {
    this.attackUpLeft1 = attackUpLeft1;
  }

  public BufferedImage getAttackUpLeft2() {
    return attackUpLeft2;
  }

  public void setAttackUpLeft2(BufferedImage attackUpLeft2) {
    this.attackUpLeft2 = attackUpLeft2;
  }

  public BufferedImage getAttackUpRight1() {
    return attackUpRight1;
  }

  public void setAttackUpRight1(BufferedImage attackUpRight1) {
    this.attackUpRight1 = attackUpRight1;
  }

  public BufferedImage getAttackUpRight2() {
    return attackUpRight2;
  }

  public void setAttackUpRight2(BufferedImage attackUpRight2) {
    this.attackUpRight2 = attackUpRight2;
  }

  public BufferedImage getDead() {
    return dead;
  }

  public void setDead(BufferedImage dead) {
    this.dead = dead;
  }

  public Rectangle getSolidArea() {
    return solidArea;
  }
  public void setSolidArea(Rectangle solidArea) {
    this.solidArea = solidArea;
  }

  public abstract void update();

  public abstract GamePanel getGamePanel();
  public void move(){
    if (!isCollisionOn()) {
      move.move(this);
    }
  }

  public int getTileCol() {
    return tileCol;
  }

  public void setTileCol(int tileCol) {
    this.tileCol = tileCol;
  }

  public int getTileRow() {
    return tileRow;
  }

  public void setTileRow(int tileRow) {
    this.tileRow = tileRow;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
