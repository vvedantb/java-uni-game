package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.joints.PrismaticJointDef;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Platform extends StaticBody {

    private static final Shape grassBlockShape = new BoxShape(2, 0.5f);
    private static BodyImage image;
//    private final float left, right;
//    private final int SPEED = 2;
//    private final int RANGE = 1;
//    private final Vec2 startPosition;
//    private boolean goingLeft;

    public Platform(GameLevel level, String type) {
        super(level, grassBlockShape);
        setPlatform(type);
        this.setAlwaysOutline(true);
//
//        startPosition = this.getPosition();
//        left = startPosition.x - RANGE;
//        right = startPosition.x + RANGE;

//        world.addStepListener(this);
    }

    public void setPlatform(String type) {
        BodyImage image;
        removeAllImages();
        if (type.equals("grass")){
            image = new BodyImage("data/objects/platform.gif", 1f);
            addImage(image);
        } else if (type.equals("grey")) {
            image = new BodyImage("data/platforms/grey.png", 1f);
            addImage(image);
        } else if (type.equals("brown")){
            image = new BodyImage("data/platforms/brown.png", 1f);
            addImage(image);
        } else if (type.equals("metal")){
            image = new BodyImage("data/platforms/metal.png", 1f);
            addImage(image);
        }
    }

//
//    @Override
//    public void preStep(StepEvent stepEvent) {
//        if (getPosition().x > right && !goingLeft) {
//            goingLeft = true;
//            this.setPosition(new Vec2((this.getPosition().x-2), (this.getPosition().y)));
//
//        }
//        if (getPosition().x < left && goingLeft) {
//            goingLeft = false;
//            this.setPosition(new Vec2((this.getPosition().x+2), (this.getPosition().y)));
//        }
//
//    }
//
//    @Override
//    public void postStep(StepEvent stepEvent) {
//
//    }
}
