package Main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main(String[] args) {

    JFrame window = new JFrame();
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Treasure Hunter");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }
}
