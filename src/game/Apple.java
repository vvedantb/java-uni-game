package game;

import city.cs.engine.*;

public class Apple extends StaticBody {

    private static final Shape appleShape = new CircleShape(0.5f);
    private static BodyImage image = new BodyImage("data/apple.gif", 3.0f);

    public Apple(GameLevel level) {
        super(level, appleShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
