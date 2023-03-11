package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ApplePickup implements CollisionListener {

    private final MainCharacter mc;

    public ApplePickup(MainCharacter mc) {
        this.mc = mc;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Apple){
            mc.addLife();
            // gets other body and sets it as type Apple then runs the appleCollected method
            ((Apple) e.getOtherBody()).appleCollected();
            e.getOtherBody().destroy();
        }

    }
}
