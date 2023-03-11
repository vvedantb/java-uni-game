package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Apple extends DynamicBody {

    private static final Shape appleShape = new CircleShape(0.5f, 0, 0);
    private static BodyImage image = new BodyImage("data/apple.gif", 3.0f);

    public Apple(GameWorld world) {
        super(world, appleShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

    public void appleCollected(){
        image = new BodyImage("data/collected_item.gif", 3.0f);
        addImage(image);
    }
}
