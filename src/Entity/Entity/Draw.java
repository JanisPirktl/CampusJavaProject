package Entity.Entity;

import java.awt.Graphics2D;

public class Draw {


  //draws the entity, this Method is used for every kind of entity
  public void draw(Entity entity, Graphics2D graphics2D) {
    graphics2D.drawImage(entity.getImage(), entity.getScreenX(), entity.getScreenY(), 48, 48, null);
  }
}
