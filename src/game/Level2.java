package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level2 extends GameLevel {
    public Level2(Game game) {
        super(game);

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
        new Platform(this).setPosition(new Vec2(-8, 0));
        new Lift(this).setPosition(new Vec2(0, -2));
        new Platform(this).setPosition(new Vec2(6, 0));

        // Grass blocks
        new Block(this, "grass").setPosition(new Vec2(-15f, 0f));
        new Block(this, "grass").setPosition(new Vec2(15f, 0f));

        // Bomb
//        new Bomb(game, this, new Vec2(0, 0), 5000);

        // Dirt blocks
        for (int i=-20; i<20; i++){
            new Block(this, "dirt").setPosition(new Vec2(5f*i, -15f));
        }

        // Water blocks
        new Block(this, "water1").setPosition(new Vec2(-15f, -10f));
        new Block(this, "water1").setPosition(new Vec2(15f, -10f));


    }

    @Override
    public boolean isComplete() {
        if (getPlayer().getCoins() > 1) {
            System.out.println("Level 2 is complete!");
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String getLevelName() {
        return "Level2";
    }

}
