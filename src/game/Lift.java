package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Lift class represents a static body that moves up and down in a GameLevel
 * It implements the StepListener interface to update its position in the simulation
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Lift extends StaticBody implements StepListener {

    private static final Shape liftShape = new BoxShape(2, 0.5f);
    private static BodyImage image;
    private final Vec2 startPosition;
    private final float top, bottom;
    private float delta;

    /**
     * Creates a new Lift object with the given GameLevel as its parent
     * It also adds the object as a  step listener to the GameLevel so that its position can be updated in each simulation step
     * @param level The GameLevel object to which the Lift object belongs
     */
    public Lift(GameLevel level, String type) {
        super(level, liftShape);
        setLiftImage(type);
        startPosition = this.getPosition();
        bottom = startPosition.y;
        top = startPosition.y+5;
        delta = 0.04f;
        level.addStepListener(this);
    }

    private void setLiftImage(String type) {
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

    /**
     * This method is called before each simulation step
     * It updates the position of the Lift object
     * @param stepEvent The StepEvent object representing the current simulation step
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().y < bottom){
            this.setPosition(startPosition);
            delta*=-1;
        }
        if (getPosition().y > top){
            delta*=-1;
        }
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));
    }

    /**
     * This method is called after each simulation step, it is not used in the class
     * @param stepEvent the StepEvent object representing the current simulation step
     */
    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
