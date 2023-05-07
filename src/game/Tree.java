package game;

import city.cs.engine.*;

/**
 * The Tree class extends the StaticBody class and represents a tree object in the game
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Tree extends StaticBody {

    /**
     * platformShape represents the shape of the tree object as a BoxShape
     */
    private static final Shape platformShape = new BoxShape(0.5f, 4f);

    /**
     * image represents the image used for the tree object
     */
    private static final BodyImage image = new BodyImage("data/objects/tree.png", 8f);


    /**
     * Creates a new Tree object and adds it to the specified GameLevel
     * @param level the GameLevel the tree object is added to
     */
    public Tree(GameLevel level) {
        super(level, platformShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

}
