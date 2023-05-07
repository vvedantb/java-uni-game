package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

public class Door extends StaticBody {
    private static final Shape doorShape = new BoxShape(1.0f, 1.5f);
    private BodyImage image;

    public Door(Game game, GameLevel level) {
        super(level, doorShape);
        setBodyImage("closed");
        addCollisionListener(new GenericCollisionListener(level, game));
    }

    public void setBodyImage(String type) {
        removeAllImages();
        if (type.equals("open")) {
            System.out.println("Open door");
            image = new BodyImage("data/door/open.png", 5f);
            addImage(image);
        } else if (type.equals("closed")) {
            System.out.println("Closed door");
            image = new BodyImage("data/door/closed.png", 5f);
            addImage(image);
        }
    }

}
