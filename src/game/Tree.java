package game;

import city.cs.engine.*;

public class Tree extends StaticBody {

    private static final Shape platformShape = new BoxShape(0.5f, 4f);
    private static final BodyImage image = new BodyImage("data/objects/tree.png", 8f);

    public Tree(GameLevel world) {
        super(world, platformShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

}
