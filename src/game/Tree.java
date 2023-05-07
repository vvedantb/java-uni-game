package game;

import city.cs.engine.*;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Tree extends StaticBody {

    private static final Shape platformShape = new BoxShape(0.5f, 4f);
    private static final BodyImage image = new BodyImage("data/objects/tree.png", 8f);

    public Tree(GameLevel level) {
        super(level, platformShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

}
