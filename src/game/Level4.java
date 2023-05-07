package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Level4 extends GameLevel {

    private Door door;

    public Level4(Game game){
        super(game);

        door = new Door(game, this);

        Random rand = new Random();
        set_coin_threshold(rand.nextInt(5) + 11);

        System.out.println("This is level 3");

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


        // Dirt blocks
        for (int i=-20; i<20; i++){
            new Block(this, "block").setPosition(new Vec2(5f*i, -15f));
        }

        // Platforms
        new Platform(this, "metal").setPosition(new Vec2(-8, 0));
        new Lift(this, "metal").setPosition(new Vec2(0, -2));
        new Platform(this, "metal").setPosition(new Vec2(6, 0));


        door.setPosition(new Vec2(15f, -10f));
    }

    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() > get_coin_threshold()) {
            System.out.println("Level 4 is complete!");
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
        return "Level 4";
    }


}
