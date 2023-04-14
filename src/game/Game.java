package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

//Your main game entry point
public class Game {

    private GameLevel level;
    private GameView view;
    private PlayerController controller;
    private MouseHandler mouseHandler;

    //Initialise a new Game
    public Game() {
        level = new Level1(this);
        view = new GameView(level, 700, 700); //3. make a view to look into the game world
//        view.setGridResolution(1); //optional: draw a 1-metre grid over the view

        controller = new PlayerController(level.getPlayer());
        view.addKeyListener(controller);

        mouseHandler = new MouseHandler(level, view);
        view.addMouseListener(mouseHandler);

        Tracker tracker = new Tracker(view, level.getPlayer());
//        world.addStepListener(tracker);

        try {
            SoundClip gameMusic = new SoundClip("data/music/gametheme2.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errorsdddd
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        GiveFocus focus = new GiveFocus(view);
        view.addMouseListener(focus);

        final JFrame frame = new JFrame("City Game"); //4. create a Java window (frame) and add the game
        frame.add(view); //   view to it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // enable the frame to quit the application
        frame.setLocationByPlatform(true); // when the x button is pressed
        frame.setResizable(false); // don't let the frame be resized
        frame.pack(); // size the frame to fit the world view
        frame.setVisible(true); // finally, make the frame visible

//        JFrame debugView = new DebugViewer(world, 500, 500); //optional: uncomment this to make a debugging view

        level.start(); // start our game world simulation!
        view.requestFocus();
    }

    public void goToNextLevel() {
        if (level instanceof Level1) {
            System.out.println("Well done! Level 1 complete!");
            level.stop();
            level = new Level2(this);
            view.setWorld(level);
//            level.setPlayer(level.getPlayer());
            controller.updatePlayer(level.getPlayer());
            level.start();
        } else if (level instanceof Level2) {
            System.out.println("Well done! Game complete!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
