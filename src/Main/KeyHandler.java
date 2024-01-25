package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//this is the keyHandler class which listens to KeyBoard Inputs and sets key booleans according to KeyBoard Inputs
public class KeyHandler implements KeyListener{

  private boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, togglePressed;

  @Override
  public void keyTyped(KeyEvent e) { }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();

    if(code == KeyEvent.VK_W){
      upPressed = true;
    }
    if(code == KeyEvent.VK_S){
      downPressed = true;
    }
    if(code == KeyEvent.VK_A){
      leftPressed = true;
    }
    if(code == KeyEvent.VK_D){
      rightPressed = true;
    }
    if(code == KeyEvent.VK_SPACE){
      spacePressed = true;
    }
    if(code == KeyEvent.VK_T) {
      togglePressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

    if(code == KeyEvent.VK_W){
      upPressed = false;
    }
    if(code == KeyEvent.VK_S){
      downPressed = false;
    }
    if(code == KeyEvent.VK_A){
      leftPressed = false;
    }
    if(code == KeyEvent.VK_D){
      rightPressed = false;
    }
    if(code == KeyEvent.VK_SPACE){
      spacePressed = false;
    }
    if(code == KeyEvent.VK_T){
      togglePressed = false;
    }
  }

  public boolean isUpPressed() {
    return upPressed;
  }

  public boolean isDownPressed() {
    return downPressed;
  }

  public boolean isLeftPressed() {
    return leftPressed;
  }

  public boolean isRightPressed() {
    return rightPressed;
  }
  public boolean isSpacePressed(){
    return spacePressed;
  }
  public boolean isTogglePressed() { return togglePressed;}
}