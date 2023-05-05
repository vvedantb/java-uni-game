package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level3 extends GameLevel {

    public Level3(Game game){
        super(game);

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
            new Block(this, "dirt").setPosition(new Vec2(5f*i, -15f));
        }
    }

    @Override
    public boolean isComplete() {
        System.out.println("Level 2 isComplete is not implemented yet...");
        return false;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }
}
