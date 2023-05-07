package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A class representing a Slime enemy in a game
 * The slime is a subclass of the Walker class and implements a StepListener interface to move the SLime back and forth across the screen
 * It has a set number of lives and can be damaged by the player's attacks
 * The slime can change its appearance depending on the level that it appears in
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Slime extends Walker implements StepListener {
    /**
     * The shape of the slime
     */
    private static final Shape slimeShape = new PolygonShape(-1.23f, 1.12f, 1.27f, 1.06f, 2.53f, -1.85f, -2.5f, -1.78f, -1.35f, 0.99f);

    /**
     * Number of lives the slime has
     */
    private static int lives;

    /**
     * Speed of the slime's movement
     */
    private final int SPEED = 3;

    /**
     * Range of the slime's movement
     */
    private final int RANGE = 4;

    /**
     * Image of the slime
     */
    private BodyImage image = new BodyImage("data/slime.gif", 4.0f);

    /**
     * Left and right boundaries of the slime's movement
     */
    private float left, right;

    /**
     * The GameLevel in which the Slime appears in
     */
    private GameLevel level;

    /**
     * Constructs a new Slime object with a given GameLevel
     * @param level the GameLevel the Slime appears in
     */
    public Slime(GameLevel level) {
        super(level, slimeShape);
        addImage(image);
        lives = 3;
        level.addStepListener(this);
        this.setPosition(new Vec2(0f, -10f));
        startWalking(SPEED);
        this.setAlwaysOutline(true);
        this.level = level;
    }

    /**
     * Gets the number of lives the Slime has
     * @return slime's lives count
     */
    public static int getLives() {
        return lives;
    }

    /**
     * Sets the number of lives the Slime has
     * @param lives new number for slime's lives count
     */
    public static void setLives(int lives) {
        Slime.lives = lives;
    }

    /**
     * Changes the slime's image depending on the level and the direction it is facing
     * @param type slime image changed based on the type
     */
    public void setImage(String type) {
        if (level instanceof Level1) {
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
        } else if (level instanceof Level2) {
            removeAllImages();
            switch (type) {
                case "left" -> {
                    image = new BodyImage("data/mushroom/idle.gif", 4f);
                    addImage(image);
                }
                case "right" -> {
                    image = new BodyImage("data/mushroom/idle_right.gif", 4f);
                    addImage(image);
                }
            }
        } else if (level instanceof Level3) {
            removeAllImages();
            switch (type) {
                case "left" -> {
                    image = new BodyImage("data/pig/idle_left.gif", 4f);
                    addImage(image);
                }
                case "right" -> {
                    image = new BodyImage("data/pig/idle_right.gif", 4f);
                    addImage(image);
                }
            }
        } else if (level instanceof Level4) {
            removeAllImages();
            switch (type) {
                case "left" -> {
                    image = new BodyImage("data/pig/run_left.gif", 4f);
                    addImage(image);
                }
                case "right" -> {
                    image = new BodyImage("data/pig/run_right.gif", 4f);
                    addImage(image);
                }
            }
        }
    }

    /**
     * Sets the position of the slime and calculates the left and right range based on the range of movement
     * @param position a Vec2 representing the position of the Slime
     */
    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x - RANGE;
        right = position.x + RANGE;
    }

    /**
     * Moves the slime in a particular direction and changes the image of the Slime based on the direction of movement
     * @param stepEvent a StepEvent that occurs when the Slime object moves
     */
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

    /**
     * Empty implementation (as it is not needed) of the postStep method from the StepListener
     * @param stepEvent a StepEvent that occurs after the SLime object moves
     */
    @Override
    public void postStep(StepEvent stepEvent) {

    }
}