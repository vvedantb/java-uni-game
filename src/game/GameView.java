package game;

import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private final Image background;

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background/blue_background.gif").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 700, 700, this);
    }


    @Override
    protected void paintForeground(Graphics2D g){

        if (MainCharacter.getLives() == 3){
            g.drawImage(new ImageIcon("data/hearts/3 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (MainCharacter.getLives() == 2){
            g.drawImage(new ImageIcon("data/hearts/2 hearts.png").getImage(), 317, 0,  66, 22,this);
        } else if (MainCharacter.getLives() == 1){
            g.drawImage(new ImageIcon("data/hearts/1 heart.png").getImage(), 317, 0, 66, 22, this);
        } else if (MainCharacter.getLives() == 0){
            g.drawImage(new ImageIcon("data/hearts/0 hearts.png").getImage(), 317, 0,  66, 22,this);
        }
    }

}