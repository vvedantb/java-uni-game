package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Apple extends DynamicBody {

    private static final Shape appleShape = new CircleShape(0.5f, 0, 0);
    private static final BodyImage image = new BodyImage("data/apple.gif", 3.0f);

    public Apple(GameWorld world) {
        super(world, appleShape);
        addImage(image);
        this.setAlwaysOutline(true);
        setPosition(new Vec2(-8, -4f));
    }
}
