package Entity.Monster.Zombie;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//this class contains all the paths for all the images for zombies and sets the bufferedImages accordingly
public class SetZombieImages {

  public void setZombieImages(Zombie zombie) {
    try {

      zombie.setUp1(ImageIO.read(new File("res/zombie/zombie_up1.png")));
      zombie.setUp2(ImageIO.read(new File("res/zombie/zombie_up2.png")));
      zombie.setDown1(ImageIO.read(new File("res/zombie/zombie_down1.png")));
      zombie.setDown2(ImageIO.read(new File("res/zombie/zombie_down2.png")));
      zombie.setLeft1(ImageIO.read(new File("res/zombie/zombie_left1.png")));
      zombie.setLeft2(ImageIO.read(new File("res/zombie/zombie_left2.png")));
      zombie.setRight1(ImageIO.read(new File("res/zombie/zombie_right1.png")));
      zombie.setRight2(ImageIO.read(new File("res/zombie/zombie_right2.png")));
      zombie.setLeftDown1(ImageIO.read(new File("res/zombie/zombie_down_left1.png")));
      zombie.setLeftDown2(ImageIO.read(new File("res/zombie/zombie_down_left2.png")));
      zombie.setLeftUp1(ImageIO.read(new File("res/zombie/zombie_up_left1.png")));
      zombie.setLeftUp2(ImageIO.read(new File("res/zombie/zombie_up_left2.png")));
      zombie.setRightDown1(ImageIO.read(new File("res/zombie/zombie_down_right1.png")));
      zombie.setRightDown2(ImageIO.read(new File("res/zombie/zombie_down_right2.png")));
      zombie.setRightUp1(ImageIO.read(new File("res/zombie/zombie_up_right1.png")));
      zombie.setRightUp2(ImageIO.read(new File("res/zombie/zombie_up_right2.png")));
      zombie.setDead(ImageIO.read(new File("res/zombie/dead.png")));

      zombie.setAttackLeft1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_left1.png")));
      zombie.setAttackLeft2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_left2.png")));
      zombie.setAttackRight1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_right1.png")));
      zombie.setAttackRight2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_right2.png")));
      zombie.setAttackUp1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up1.png")));
      zombie.setAttackUp2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up2.png")));
      zombie.setAttackDown1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down1.png")));
      zombie.setAttackDown2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down2.png")));
      zombie.setAttackDownLeft1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down_left1.png")));
      zombie.setAttackDownLeft2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down_left2.png")));
      zombie.setAttackDownRight1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down_right1.png")));
      zombie.setAttackDownRight2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_down_right2.png")));
      zombie.setAttackUpLeft1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up_left1.png")));
      zombie.setAttackUpLeft2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up_left2.png")));
      zombie.setAttackUpRight1(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up_right1.png")));
      zombie.setAttackUpRight2(ImageIO.read(new File("res/zombie_attacking/zombie_attack_up_right2.png")));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
