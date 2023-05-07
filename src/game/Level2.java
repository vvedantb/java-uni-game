package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Random;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Level2 extends GameLevel {

    private Door door;

    public Level2(Game game) {
        super(game);

        door = new Door(game, this);

        Random rand = new Random();
        set_coin_threshold(rand.nextInt(4) + 4);

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
        new Platform(this, "brown").setPosition(new Vec2(-8, 0));
        new Lift(this, "brown").setPosition(new Vec2(0, -2));
        new Platform(this, "brown").setPosition(new Vec2(6, 0));

        // Grass blocks
        new Block(this, "grass").setPosition(new Vec2(-15f, 0f));
        new Block(this, "grass").setPosition(new Vec2(15f, 0f));

        // Bomb
//        new Bomb(game, this, new Vec2(0, 0), 5000);
//        new Block(this, "dirt").setPosition(new Vec2(5f*i, -15f));

        // Dirt blocks
        for (int i = -20; i < 20; i++) {
            if (i % 2 == 0) {
                new Block(this, "water1").setPosition(new Vec2(5f * i, -15f));
            } else {
                new Block(this, "water1").setPosition(new Vec2(5f * i, -15f));
            }
        }

        door.setPosition(new Vec2(15f, -10f));

        // Water blocks
    }

    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() > get_coin_threshold()) {
            System.out.println("Level 2 is complete!");
            door.setBodyImage("open");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changeDoor() {
        if (getPlayer().getCoins() > get_coin_threshold()) {
            door.setBodyImage("open");
        }
    }

    @Override
    public String getLevelName() {
        return "Level 2";
    }

}
