package game;

import city.cs.engine.*;

public class Coin extends DynamicBody {

    private static final Shape coinShape = new CircleShape(0.5f);
    private static final BodyImage image = new BodyImage("data/coin.gif", 1.0f);

    public Coin(GameWorld world) {
        super(world, coinShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
