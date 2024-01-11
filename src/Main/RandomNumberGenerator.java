package Main;

import java.util.Random;

public class RandomNumberGenerator {
  Random random = new Random();
  public int generateRandomNumber() {
    return random.nextInt(3000) + 300;
  }
}
