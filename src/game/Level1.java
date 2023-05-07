package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class represents Level 1 of the game
 * Its a sublass of the GameLevel class and provides specific implementations of the methods required for level completion, door change, and level name retrieval
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Level1 extends GameLevel {

    /**
     * Instance variable for the door
     */
    private Door door;

    /**
     * Creates a new Level1 object
     * @param game the Game object that the level belongs to
     */
    public Level1(Game game) {
        super(game);

        door = new Door(game, this);

        /**
         * Generates random coin threshold between 1 and 3
         */
        Random rand = new Random();
        set_coin_threshold(rand.nextInt(3) + 1);

        // Ground border
        Shape horizontalBar = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, horizontalBar);
        ground.setPosition(new Vec2(0f, -18f));

        // Side border shape
        Shape verticalBar = new BoxShape(0.5f, 30);

        // Left border
        StaticBody leftBar = new StaticBody(this, verticalBar);
        leftBar.setPosition(new Vec2(-18f, -Window.HEIGHT));

        // Right border
        StaticBody rightBar = new StaticBody(this, verticalBar);
        rightBar.setPosition(new Vec2(18f, Window.HEIGHT));

        // Tree
        new Tree(this).setPosition(new Vec2(-15f, 6f));

        // Platforms
        new Platform(this, "grass").setPosition(new Vec2(-8, 0));
        new Lift(this, "grass").setPosition(new Vec2(0, -2));
        new Platform(this, "grass").setPosition(new Vec2(6, 0));

        // Grass blocks
        new Block(this, "grass").setPosition(new Vec2(-15f, 0f));
        new Block(this, "grass").setPosition(new Vec2(15f, 0f));

        // Bomb
//        new Bomb(game, this, new Vec2(0, 0), 5000);

        door.setPosition(new Vec2(-15f, -10f));

        // Dirt blocks
        for (int i = -20; i < 20; i++) {
            new Block(this, "dirt").setPosition(new Vec2(5f * i, -15f));
        }

    }

    /**
     * Checks if the level is complete
     * @return true if player has collected enough coins to meet the threshold, false otherwise
     */
    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() > get_coin_threshold()) {
            System.out.println("Level 1 is complete!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Changes the appearance of the door if the player has collected enough coins
     */
    @Override
    public void changeDoor() {
        if (getPlayer().getCoins() > get_coin_threshold()) {
            door.setBodyImage("open");
        }
    }

    /**
     * Retrieves the name of the Level
     * @return a String containing the name of the level
     */
    @Override
    public String getLevelName() {
        return "Level 1";
    }


}
