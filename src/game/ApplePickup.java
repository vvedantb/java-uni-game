package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ApplePickup implements CollisionListener {

    public ApplePickup(Player mc) {
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Apple){
            Player.addLife();
            // gets other body and sets it as type Apple then runs the appleCollected method
            ((Apple) e.getOtherBody()).appleCollected();
            e.getOtherBody().destroy();
        }

    }
}
