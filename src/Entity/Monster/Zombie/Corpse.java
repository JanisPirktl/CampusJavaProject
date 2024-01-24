package Entity.Monster.Zombie;

import Main.GamePanel;

//When a zombie dies it creates a new corpe object which is displayed on screen and then the zombie disappears
public class Corpse extends Zombie {

  public Corpse(GamePanel gamePanel, int worldX, int worldY) {
    super(gamePanel, worldX, worldY);
  }
}
