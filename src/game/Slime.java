package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Slime extends Walker implements StepListener {

    private static final Shape slimeShape = new PolygonShape(-1.23f, 1.12f, 1.27f, 1.06f, 2.53f, -1.85f, -2.5f, -1.78f, -1.35f, 0.99f);
    private BodyImage image = new BodyImage("data/slime.gif", 4.0f);
    private static int lives;
    private float left, right;
    private final int SPEED = 3;
    private final int RANGE = 4;

    public Slime(GameLevel level) {
        super(level, slimeShape);
        addImage(image);
        lives = 3;
        level.addStepListener(this);
        this.setPosition(new Vec2(0f, -10f));
        startWalking(SPEED);
        this.setAlwaysOutline(true);
    }

    public void shoot() {
        Goo goo = new Goo((GameLevel) getWorld());
        goo.setPosition(this.getPosition());
        goo.setLinearVelocity(new Vec2(0, -10));
    }


    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Slime.lives = lives;
    }


    public void setImage(String type) {
        removeAllImages();

        switch (type) {
            case "left" -> {
                image = new BodyImage("data/slime.gif", 4f);
                addImage(image);
            }
            case "right" -> {
                image = new BodyImage("data/slime_reverse.gif", 4f);
                addImage(image);
            }
        }
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x - RANGE;
        right = position.x + RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right) {
            setImage("left");
            startWalking(-SPEED);
        }
        if (getPosition().x < left) {
            setImage("right");
            startWalking(SPEED);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
