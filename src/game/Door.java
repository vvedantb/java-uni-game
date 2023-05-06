package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Door extends StaticBody {
    private static Shape doorShape = new BoxShape(1.0f, 1.5f);
    private BodyImage image;
    private GameLevel level;

    public Door(Game game, GameLevel level){
        super(level, doorShape);
        image = new BodyImage("data/door/closed.png", 5f);
        addImage(image);
        addCollisionListener(new GenericCollisionListener(level, game));
        this.level = level;
    }

    public void changeBodyImage(){
        this.removeAllImages();
        image = new BodyImage("data/door/open.png", 5f);
        this.addImage(image);
    }

}
