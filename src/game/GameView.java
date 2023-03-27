package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private final Image background;

    public GameView(GameLevel world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background/bg.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, 700, 700, this);
    }


    @Override
    protected void paintForeground(Graphics2D g){

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Lives: " + Player.getLives(), 300, 0);
        g.drawString("Coins: " + Player.getCoins(), 280, 0);


        if (Player.getLives() >= 3){
            g.drawImage(new ImageIcon("data/hearts/3 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (Player.getLives() == 2){
            g.drawImage(new ImageIcon("data/hearts/2 hearts.png").getImage(), 317, 0,  66, 22,this);
        } else if (Player.getLives() == 1){
            g.drawImage(new ImageIcon("data/hearts/1 heart.png").getImage(), 317, 0, 66, 22, this);
        } else if (Player.getLives() == 0){
            g.drawImage(new ImageIcon("data/hearts/0 hearts.png").getImage(), 317, 0,  66, 22,this);
            g.drawImage(new ImageIcon("data/TheEnd.png").getImage(), 0, 0, 291, 79, this);
        }
    }

}