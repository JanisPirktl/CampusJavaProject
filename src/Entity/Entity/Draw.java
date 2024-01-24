package Entity.Entity;

import java.awt.*;

public class Draw {


  //draws the entity, this Method is used for every kind of entity
  public void draw(Entity entity, Graphics2D graphics2D) {
    graphics2D.drawImage(entity.getImage(), entity.getScreenX(), entity.getScreenY(), 48, 48, null);
  }

  public void write(String string, Graphics2D graphics2D){
    graphics2D.setFont(new Font("SansSerif", Font.BOLD,20));
    graphics2D.setColor(Color.black);
    graphics2D.drawString(string,35,35);
  }
}
