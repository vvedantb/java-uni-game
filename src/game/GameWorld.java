package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class GameWorld extends World {

    public MainCharacter mainCharacter;

    public Platform grassPlatform;
    public Slime slime;

    public GameWorld() {


        // Ground platform
        Shape horizontalBar = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, horizontalBar);
        ground.setPosition(new Vec2(0f, -17f));

        // Side bars
        Shape verticalBar = new BoxShape(0.5f, 30);
        new StaticBody(this, verticalBar).setPosition(new Vec2(-17f, -Window.HEIGHT));
        new StaticBody(this, verticalBar).setPosition(new Vec2(17f, Window.HEIGHT));

        // Apples
        new Apple(this).setPosition(new Vec2(-8, -4f));
        new Apple(this).setPosition(new Vec2(0, -4f));
        new Apple(this).setPosition(new Vec2(4, 0f));

        // Grass
        new Platform(this).setPosition(new Vec2(-10f, -2));


        //Make a character (with an overlaid image)
        mainCharacter = new MainCharacter(this);

        // Slime enemy
        slime = new Slime(this);

        ApplePickup applePickup = new ApplePickup(mainCharacter);
        mainCharacter.addCollisionListener(applePickup);

        SlimeEncounter encounter = new SlimeEncounter(mainCharacter);
        mainCharacter.addCollisionListener(encounter);

//        GenericCollisionListener gcl = new GenericCollisionListener();
//        mainCharacter.addCollisionListener(gcl);
    }

    public MainCharacter getMainCharacter(){
        return mainCharacter;
    }

}
