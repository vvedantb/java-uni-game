package game;

import city.cs.engine.*;

public class Apple extends DynamicBody {

    private static final Shape appleShape = new PolygonShape(-0.1f,0.98f, -0.85f,0.27f, -0.02f,-0.62f, 0.71f,0.09f, 0.01f,0.98f);
    private static final BodyImage image = new BodyImage("data/apple.gif", 2.0f);

    public Apple(GameWorld world) {
        super(world, appleShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
