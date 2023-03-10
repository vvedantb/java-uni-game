package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SlimeEncounter implements CollisionListener {

    private final MainCharacter mainCharacter;

    public SlimeEncounter(MainCharacter mc) {
        this.mainCharacter = mc;
    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof MainCharacter){
            if (mainCharacter.getLives() >0) {
                mainCharacter.removeLife();
            } else if (mainCharacter.getLives() <=0) {
                e.getOtherBody().destroy();
            }

        }
    }
}
