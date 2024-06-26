package Entity.Entity;

public class SpriteCounter {

//used to make it look like the entity is walking (set image accourding to sprite counter)
  public void countSprite(Entity entity, int maxSpriteCounter) {

    entity.setSpriteCounter(entity.getSpriteCounter() + 1);
    if (entity.getSpriteCounter() > maxSpriteCounter) {
      if (entity.getSpriteNum() == 1) {
        entity.setSpriteNum(2);
      } else if (entity.getSpriteNum() == 2) {
        entity.setSpriteNum(1);
      }
      entity.setSpriteCounter(0);
    }
  }

}
