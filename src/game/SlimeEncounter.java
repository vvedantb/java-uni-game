package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SlimeEncounter implements CollisionListener {

    public SlimeEncounter(Player mc) {
    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Player){
            if (Player.getLives() > 0) {
                Player.removeLife();
            } else if (Player.getLives() < 0) {
                e.getOtherBody().destroy();
            }

        }
    }
}
