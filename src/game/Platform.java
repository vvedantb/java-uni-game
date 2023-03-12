package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

public class Platform extends StaticBody {
    private static final Shape grassBlockShape = new BoxShape(2, 0.5f);
    private static final BodyImage image = new BodyImage("data/objects/platform.gif", 1f);

    public Platform(GameWorld world){
        super(world, grassBlockShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
