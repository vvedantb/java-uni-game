package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class represents the view of the game, it extends UserView and implements ActionListener
 * The GameView class is responsible for painting the background, and foreground of the game, displaing information about the player, level, and coin count
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class GameView extends UserView implements ActionListener {

    private Image background;
    private GameLevel level;
    private Game game;

    /**
     * Constructs a GameView object
     * @param game the game to be displayed
     * @param level the level to be displayed
     * @param width the width of the view
     * @param height the height of the view
     */
    public GameView(Game game, GameLevel level, int width, int height) {
        super(level, width, height);
        this.level = level;
        this.game = game;
    }

    /**
     * Paints the background of each level
     * @param g the graphics2D object to paint
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        /**
         * Selects the background image based on the game level
         */
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

    /**
     * Paints the foreground of the game, including the player's lives, coins, and level name
     * @param g the graphics2D object to paint
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));

        /**
         * Displays players remaining lives
         */
        if (level.getPlayer().getLives() > 3){
            g.drawString("Lives: 3", 100, 100);
        } else {
            g.drawString("Lives: " + level.getPlayer().getLives(), 100, 100);
        }

        /**
         * Displays the level count
         */
        g.drawString(game.getLevel().getLevelName(), 100, 150);

        /**
         * Displays the coin count for the user
         */
        g.drawString("Coins: " + level.getPlayer().getCoins(), 100, 50);


        /**
         * Displays the heart health bar based on the player's remaining lives
         */
        if (level.getPlayer().getLives() >= 3) {
            g.drawImage(new ImageIcon("data/hearts/3 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 2) {
            g.drawImage(new ImageIcon("data/hearts/2 hearts.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 1) {
            g.drawImage(new ImageIcon("data/hearts/1 heart.png").getImage(), 317, 0, 66, 22, this);
        } else if (level.getPlayer().getLives() == 0) {
            g.drawImage(new ImageIcon("data/hearts/0 hearts.png").getImage(), 317, 0, 66, 22, this);
            g.drawImage(new ImageIcon("data/TheEnd.png").getImage(), 0, 0, 291, 79, this);
            Timer timer = new Timer(3000, this);
            timer.setRepeats(false);
            timer.start();
        }

        if (level instanceof Level3) {
            g.drawImage(new ImageIcon("data/TheEnd.png").getImage(), 0, 0, 291, 79, this);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}