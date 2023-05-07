package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Your main game entry point
/**
 * The game class is the main entry point of the game
 * It initialises the world, creates the game view, and the player controller
 * It also handles sound effects and transitions between levels
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Game implements ActionListener {

    private GameLevel level = new Level1(this);
    private GameView view;
    private PlayerController controller;
    public static SoundClip objective_complete_sound;
    public static SoundClip game_over_sound;
    public static SoundClip gameMusic;

    /**
     * Initialises a new game instance
     */
    public Game() {

        view = new GameView(this, level, 700, 700); //3. make a view to look into the game world
//        view.setGridResolution(1); //optional: draw a 1-metre grid over the view

        controller = new PlayerController(level.getPlayer());
        view.addKeyListener(controller);

//        mouseHandler = new MouseHandler(level, view);
//        view.addMouseListener(mouseHandler);

        Tracker tracker = new Tracker(view, level.getPlayer());
//        level.addStepListener(tracker); // Focus camera to center of the player

        gameMusic.loop();
        gameMusic.setVolume(0.4);

        GiveFocus focus = new GiveFocus(view);
        view.addMouseListener(focus);

        final JFrame frame = new JFrame("City Game"); //4. create a Java window (frame) and add the game
        frame.add(view); //   view to it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // enable the frame to quit the application
        frame.setLocationByPlatform(true); // when the x button is pressed
        frame.setResizable(false); // don't let the frame be resized

        ControlPanel controlPanel = new ControlPanel(this, level);
        frame.add(controlPanel.mainPanel, BorderLayout.WEST);

        frame.pack(); // size the frame to fit the world view
        frame.setVisible(true); // finally, make the frame visible

//        JFrame debugView = new DebugViewer(world, 500, 500); //optional: uncomment this to make a debugging view

        level.start(); // start our game world simulation!
        view.requestFocus();
    }

    static {
        try {
            gameMusic = new SoundClip("data/music/gametheme2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            //code in here will deal with any errors
//            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    /**
     * Gets the current game level
     * @return the current game level
     */
    public GameLevel getLevel() {
        return level;
    }

    static {
        try {
            objective_complete_sound = new SoundClip("data/soundfx/objective_complete.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    static {
        try {
            game_over_sound = new SoundClip("data/soundfx/game_over.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    /**
     * Transitions to the next level. Stops old level and creates the new level for the player to enter
     */
    public void goToNextLevel() {
        if (level instanceof Level1) {
            System.out.println("Well done! Level 1 complete!");
            objective_complete_sound.play();
            level.stop();
            level = new Level2(this);
            System.out.println(level.getLevelName());
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level2) {
            System.out.println("Well done! Level 2 complete!");
            objective_complete_sound.play();
            level.stop();
            level = new Level3(this);
            System.out.println(level.getLevelName());
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level3) {
            System.out.println("Well done! Level 3 complete!");
            objective_complete_sound.play();
            level.stop();
            level = new Level4(this);
            System.out.println(level.getLevelName());
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level4) {
            System.out.println("Well done! Game complete.");
            game_over_sound.play();
            Timer timer = new Timer(3000, this);
            timer.setRepeats(false);
            timer.start();
        }
    }

    /**
     * Sets the game level and the players coins to the specified values
     * @param level level to set the gamelevel on
     */
    public void setLevel(GameLevel level) {
//        int lvl, int coins
//        if (lvl == 1){
//            System.out.println("Loading level 1...");
//            level = new Level1(this);
//            view.setWorld(level);
//            controller.updatePlayer(getLevel().getPlayer());
//            level.start();
//            level.getPlayer().setCoins(coins);
//            System.out.println(level.getPlayer().getCoins());
//        }
        if (level instanceof Level1) {
            System.out.println("Starting Level 1!");
            level.stop();
            level = new Level1(this);
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level2) {
            System.out.println("Starting Level 2!");
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level3) {
            System.out.println("Starting Level 3!");
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level4) {
            System.out.println("Starting Level 4!");
            view.setWorld(level);
            controller.updatePlayer(level.getPlayer());
            level.start();
        }
    }

    /**
     * Runs a game instance
     * @param args
     */
    public static void main(String[] args) {
        new Game();
    }

    /**
     * Quits the game after reaching the final level
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
