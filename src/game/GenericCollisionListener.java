package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GenericCollisionListener implements CollisionListener {

    private int counter = 0;

    public GenericCollisionListener(Player p) {
    }

    @Override
    public void collide(CollisionEvent e) {
        counter++;
        System.out.print("Collision " + counter + ":\n" +
                "  rep. body:" + e.getReportingBody() + "\n" +
                "  oth. body:" + e.getOtherBody() + "\n");

        if (e.getOtherBody() instanceof Apple){
            Player.addLife();
            // gets other body and sets it as type Apple then runs the appleCollected method
            ((Apple) e.getOtherBody()).appleCollected();
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Slime){
            System.out.println("Collision of Slime and Player");
            if (Player.getLives() > 0) {
                Player.removeLife();
            } else if (Player.getLives() < 0) {
                e.getOtherBody().destroy();
                System.out.println("Game ends");
            }

        }
    }

}
