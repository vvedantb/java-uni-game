package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

public class Trampoline extends StaticBody {

    private static final Shape jumperImage = null;
    private static final BodyImage image = new BodyImage("data/", 2.0f);

    public Trampoline(GameLevel world) {
        super(world, jumperImage);
        addImage(image);
        this.setAlwaysOutline(true);
    }
}
