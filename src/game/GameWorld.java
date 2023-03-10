package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public MainCharacter mainCharacter;

    public Platform grassPlatform;
    public Slime slime;

    public GameWorld() {

        //Make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -17f));

        //Make grass
        Platform grassPlatform = new Platform(this);

        //Make a character (with an overlaid image)
        mainCharacter = new MainCharacter(this);

        slime = new Slime(this);

        Apple apple = new Apple(this);


        ApplePickup applePickup = new ApplePickup(mainCharacter);
        mainCharacter.addCollisionListener(applePickup);

        SlimeEncounter encounter = new SlimeEncounter(mainCharacter, mainCharacter1);
        mainCharacter.addCollisionListener(encounter);

        GenericCollisionListener gcl = new GenericCollisionListener();
        mainCharacter.addCollisionListener(gcl);
    }

    public MainCharacter getMainCharacter(){
        return mainCharacter;
    }

}
