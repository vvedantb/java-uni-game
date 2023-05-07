package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

/**
 * The Door class represents a StaticBody that acts as a door gateway between levels for the game
 * When the player collides with a door, the level ends and the player is brought to the next level
 * The door has 2 states - open and closed
 * The door changes state depending on whether the player collides with it or not
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Door extends StaticBody {
    /**
     * The shape of the door, which is a box
     */
    private static final Shape doorShape = new BoxShape(1.0f, 1.5f);
    /**
     * The image of the door
     */
    private BodyImage image;

    /**
     * Initialises a new instance of the Door class
     * @param game The game object
     * @param level The GameLevel object
     */
    public Door(Game game, GameLevel level) {
        super(level, doorShape);
        setBodyImage("closed");
        addCollisionListener(new GenericCollisionListener(level, game));
    }

    /**
     * Sets the image of the door depending on its state (open or closed)
     * @param type The type of door state, which can be either "open" or "closed"
     */
    public void setBodyImage(String type) {
        removeAllImages();
        if (type.equals("open")) {
            System.out.println("Open door");
            image = new BodyImage("data/door/open.png", 5f);
            addImage(image);
        } else if (type.equals("closed")) {
            System.out.println("Closed door");
            image = new BodyImage("data/door/closed.png", 5f);
            addImage(image);
        }
    }

}
