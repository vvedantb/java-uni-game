package game;

import city.cs.engine.*;

/**
 * The Apple class represents an apple collectible item in the game
 * It is a static body and extends the StaticBody class
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Apple extends StaticBody {

    /**
     * Shape of the apple object, which is a circle of radius 0.5f
     */
    private static final Shape appleShape = new CircleShape(0.5f);
    /**
     * Image of the apple object, which is a gif file and has a size of 3.0f
     */
    private static BodyImage image = new BodyImage("data/apple.gif", 3.0f);

    /**
     * Constructs a new Apple object in the level inputted
     * @param level the GameLevel in which the apple object is created
     */
    public Apple(GameLevel level) {
        super(level, appleShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
