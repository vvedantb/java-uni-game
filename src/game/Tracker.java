package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * The Tracker class implements a StepListener to track the movement of the PLayer and update the GameView accordingly
 * It keeps the player in the centre of the view as it moves around the same world
 * It provides functionality to update the position of the camera in the GameView to follow the Player object
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Tracker implements StepListener {

    /**
     * The GameView object where the position of the camera will be updated
     */
    private GameView view;

    /**
     * The player object whose position the camera will follow
     */
    private Player player;

    /**
     * Creates a new tracker object with the specified GameView and Player objects
     * @param view the GameView object where the camera position will be updated
     * @param player the PLayer object whose position the camera will follow
     */
    public Tracker(GameView view, Player player){
        this.view = view;
        this.player = player;
    }


    @Override
    public void preStep(StepEvent stepEvent) {

    }

    /**
     * This method is called after the physics engine updates the simulation
     * It updates the camera position in the GameView to follow the PLayer object
     * @param stepEvent the StepEvent object that contains information about the step event
     */
    @Override
    public void postStep(StepEvent stepEvent) {
        view.setCentre(new Vec2(player.getPosition()));
    }
}
