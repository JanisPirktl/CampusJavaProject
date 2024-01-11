package Entity.Monster;

import Entity.Entity;

public abstract class Monster extends Entity implements Runnable {
   Thread thread;
  protected Monster (int speed) {
    super(speed);
  }
  public abstract void run();
  public void addThread(Thread thread)  {
    this.thread = thread;
  }
  public Thread getThread() {
    return thread;
  }
}
