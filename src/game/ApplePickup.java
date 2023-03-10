package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ApplePickup implements CollisionListener {

    private final MainCharacter mainCharacter;

    public ApplePickup(MainCharacter s) {
        this.mainCharacter = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Apple){
            mainCharacter.addApples();
            e.getOtherBody().destroy();
        }

    }
}
