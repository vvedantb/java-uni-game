package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameView extends UserView {

    private Image background;
    private GameLevel level;
    private Game game;

    public GameView(Game game, GameLevel level, int width, int height) {
        super(level, width, height);
        this.level = level;
        this.game = game;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel() instanceof Level1) {
            removeAll();
            background = new ImageIcon("data/background/bg.png").getImage();
        } else if (game.getLevel() instanceof Level2) {
            removeAll();
            background = new ImageIcon("data/background/bg1.png").getImage();
        } else if (game.getLevel() instanceof Level3) {
            removeAll();
            background = new ImageIcon("data/background/bg2.png").getImage();
        } else if (game.getLevel() instanceof Level4){
            removeAll();
            background = new ImageIcon("data/background/bg3.png").getImage();
        }
        g.drawImage(background, 0, 0, 700, 700, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));

        if (level.getPlayer().getLives() > 3){
            g.drawString("Lives: 3", 100, 100);
        } else {
            g.drawString("Lives: " + level.getPlayer().getLives(), 100, 100);
        }

        if (level.isRunning()){
            g.drawString(game.getLevel().getLevelName(), 100, 150);
        }

        g.drawString("Coins: " + level.getPlayer().getCoins(), 100, 50);


        if (level.getPlayer().getLives() >= 3) {
            g.drawImage(new ImageIcon("data/hearts/3 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 2) {
            g.drawImage(new ImageIcon("data/hearts/2 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 1) {
            g.drawImage(new ImageIcon("data/hearts/1 heart.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 0) {
            g.drawImage(new ImageIcon("data/hearts/0 hearts.png").getImage(), 317, 0, 66, 22, this);
            g.drawImage(new ImageIcon("data/TheEnd.png").getImage(), 0, 0, 291, 79, this);
        }

        if (level instanceof Level3) {
            g.drawImage(new ImageIcon("data/TheEnd.png").getImage(), 0, 0, 291, 79, this);
        }

    }

}