package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Random;

public class GameWorld extends World {

    public Player player;

    public Tree grassTree;
    public Slime slime;

    public GameWorld() {
        Random random = new Random();


        // Ground border
        Shape horizontalBar = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, horizontalBar);
        ground.setPosition(new Vec2(0f, -18f));

        // Side borders
        Shape verticalBar = new BoxShape(0.5f, 30);

        // Left border
        StaticBody leftBar = new StaticBody(this, verticalBar);
        leftBar.setPosition(new Vec2(-18f, -Window.HEIGHT));

        // Right border
        StaticBody rightBar = new StaticBody(this, verticalBar);
        rightBar.setPosition(new Vec2(18f, Window.HEIGHT));


        // Apples
        new Apple(this).setPosition(new Vec2(random.nextFloat()*34-17, random.nextFloat()*10));
        new Apple(this).setPosition(new Vec2(random.nextFloat()*34-17, random.nextFloat()*10));
        new Apple(this).setPosition(new Vec2(random.nextFloat()*34-17, random.nextFloat()*10));


        // Tree
        new Tree(this).setPosition(new Vec2(-15f, 6f));


        // Platforms
        new Platform(this).setPosition(new Vec2(-8, 0));
        new Platform(this).setPosition(new Vec2(0, -2));
        new Platform(this).setPosition(new Vec2(6, 0));


        // Grass blocks
        new Block(this, "grass").setPosition(new Vec2(-15f, 0f));
        new Block(this, "grass").setPosition(new Vec2(15f, 0f));

        // Dirt blocks
        new Block(this, "dirt").setPosition(new Vec2(-15f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(-10f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(-5f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(0f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(5f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(10f, -15f));
        new Block(this, "dirt").setPosition(new Vec2(15f, -15f));


        // Player character
        player = new Player(this);

        // Slime enemy
        slime = new Slime(this);

        ApplePickup applePickup = new ApplePickup(player);
        player.addCollisionListener(applePickup);

        SlimeEncounter encounter = new SlimeEncounter(player);
        player.addCollisionListener(encounter);

//        GenericCollisionListener gcl = new GenericCollisionListener();
//        mainCharacter.addCollisionListener(gcl);
    }

    public Player getMainCharacter(){
        return player;
    }

}
