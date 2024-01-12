package Entity.Player;

import Entity.Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawHeart {
    private final BufferedImage heart;

    {
        try {
            heart = ImageIO.read(new File("res/player/Heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DrawHeart(){
    }

    public void draw(Player player, Graphics2D graphics2D) {
        int x = 970;
        for(int i = 0; i < player.getHealth();i++) {
            graphics2D.drawImage(heart, x, 20, 50,50,null);
            x += 30;
        }
    }
}
