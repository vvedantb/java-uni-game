package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Lift extends StaticBody implements StepListener {

    private static final Shape liftShape = new BoxShape(2, 0.5f);
    private static final BodyImage image = new BodyImage("data/objects/platform.gif", 1f);
    private final Vec2 startPosition;
    private final float top, bottom;
    private float delta;

    public Lift(GameWorld world) {
        super(world, liftShape);
        addImage(image);
        startPosition = this.getPosition();
        bottom = startPosition.y;
        top = startPosition.y+5;
        delta = 0.04f;
        world.addStepListener(this);
    }

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

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
