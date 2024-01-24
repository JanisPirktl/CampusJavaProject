package Entity.Player;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


//this class contains all the BufferedImagePaths and sets the Images accordingly

public class SetPlayerImages {

  public void setPlayerImages(Player player) {
    try {

      player.setUp1(ImageIO.read(new File("res/player/boy_up_1.png")));
      player.setUp2(ImageIO.read(new File("res/player/boy_up_2.png")));
      player.setDown1(ImageIO.read(new File("res/player/boy_down_1.png")));
      player.setDown2(ImageIO.read(new File("res/player/boy_down_2.png")));
      player.setLeft1(ImageIO.read(new File("res/player/boy_left_1.png")));
      player.setLeft2(ImageIO.read(new File("res/player/boy_left_2.png")));
      player.setRight1(ImageIO.read(new File("res/player/boy_right_1.png")));
      player.setRight2(ImageIO.read(new File("res/player/boy_right_2.png")));
      player.setLeftDown1(ImageIO.read(new File("res/player/boy_down_left1.png")));
      player.setLeftDown2(ImageIO.read(new File("res/player/boy_down_left2.png")));
      player.setLeftUp1(ImageIO.read(new File("res/player/boy_up_left1.png")));
      player.setLeftUp2(ImageIO.read(new File("res/player/boy_up_left2.png")));
      player.setRightDown1(ImageIO.read(new File("res/player/boy_down_right1.png")));
      player.setRightDown2(ImageIO.read(new File("res/player/boy_down_right2.png")));
      player.setRightUp1(ImageIO.read(new File("res/player/boy_up_right1.png")));
      player.setRightUp2(ImageIO.read(new File("res/player/boy_up_right2.png")));
      player.setDead(ImageIO.read(new File("res/player/dead.png")));

      player.setAttackUp1(ImageIO.read(new File("res/player_attacking/boy_attack_up_1.png")));
      player.setAttackUp2(ImageIO.read(new File("res/player_attacking/boy_attack_up_2.png")));
      player.setAttackDown1(ImageIO.read(new File("res/player_attacking/boy_attack_down_1.png")));
      player.setAttackDown2(ImageIO.read(new File("res/player_attacking/boy_attack_down_2.png")));
      player.setAttackLeft1(ImageIO.read(new File("res/player_attacking/boy_attack_left_1.png")));
      player.setAttackLeft2(ImageIO.read(new File("res/player_attacking/boy_attack_left_2.png")));
      player.setAttackRight1(ImageIO.read(new File("res/player_attacking/boy_attack_right_1.png")));
      player.setAttackRight2(ImageIO.read(new File("res/player_attacking/boy_attack_right_2.png")));
      player.setAttackUpRight1(ImageIO.read(new File("res/player_attacking/boy_attack_up_right_1.png")));
      player.setAttackUpRight2(ImageIO.read(new File("res/player_attacking/boy_attack_up_right_2.png")));
      player.setAttackUpLeft1(ImageIO.read(new File("res/player_attacking/boy_attack_up_left_1.png")));
      player.setAttackUpLeft2(ImageIO.read(new File("res/player_attacking/boy_attack_up_left_2.png")));
      player.setAttackDownLeft1(ImageIO.read(new File("res/player_attacking/boy_attack_down_left_1.png")));
      player.setAttackDownLeft2(ImageIO.read(new File("res/player_attacking/boy_attack_down_left_2.png")));
      player.setAttackDownRight1(ImageIO.read(new File("res/player_attacking/boy_attack_down_right_1.png")));
      player.setAttackDownRight2(ImageIO.read(new File("res/player_attacking/boy_attack_down_right_2.png")));
















    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
