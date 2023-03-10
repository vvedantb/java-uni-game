package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Slime extends DynamicBody {

    private static final Shape slimeShape = new PolygonShape(-1.23f,1.12f, 1.27f,1.06f, 2.53f,-1.85f, -2.5f,-1.78f, -1.35f,0.99f);
    private static final BodyImage image = new BodyImage("data/slime.gif", 4.0f);

    public Slime(GameWorld world) {
        super(world, slimeShape);
        addImage(image);
        this.setAlwaysOutline(true);
        this.setPosition(new Vec2(0f, -10f));
    }


}
