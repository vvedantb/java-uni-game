package game;

import javax.swing.*;

//Your main game entry point
public class Game {

    //Initialise a new Game
    public Game() {

        GameWorld world = new GameWorld(); //1. make an empty game world
        GameView view = new GameView(world, 700, 700); //3. make a view to look into the game world
//        view.setGridResolution(1); //optional: draw a 1-metre grid over the view


        PlayerController controller = new PlayerController(world.getPlayer());
        view.addKeyListener(controller);

        MouseHandler mouseHandler = new MouseHandler(world, view);
        view.addMouseListener(mouseHandler);


        Tracker tracker = new Tracker(view, world.getPlayer());
//        world.addStepListener(tracker);



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

        world.start(); // start our game world simulation!
        view.requestFocus();
    }

    // Run the game
    public static void main(String[] args) {
        new Game();
    }

}
