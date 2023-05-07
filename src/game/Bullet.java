package game;

import city.cs.engine.*;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Bullet extends StaticBody {

    private static final Shape bulletShape = new CircleShape(0.5f);
    private static BodyImage image = new BodyImage("data/apple.gif", 2.0f);

    public Bullet(GameLevel level) {
        super(level, bulletShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
