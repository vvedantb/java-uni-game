package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GenericCollisionListener implements CollisionListener {

    private final int counter = 0;

    public GenericCollisionListener(Player p) {
    }

    @Override
    public void collide(CollisionEvent e) {
//        counter++;
//        System.out.print("Collision " + counter + ":\n" +
//                "  rep. body:" + e.getReportingBody() + "\n" +
//                "  oth. body:" + e.getOtherBody() + "\n");

        if (e.getOtherBody() instanceof Apple){
            Player.setLives(Player.getLives()+1);
            // gets other body and sets it as type Apple then runs the appleCollected method
            ((Apple) e.getOtherBody()).appleCollected();
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Coin){
            Player.setCoins(Player.getCoins()+1);
            e.getOtherBody().destroy();
        }


        if (e.getOtherBody() instanceof Slime){
            System.out.println("Collision of Slime and Player");
            if (Player.getLives() > 0) {
                Player.setLives(Player.getLives()-1);
            } else if (Player.getLives() < 0) {
                e.getOtherBody().destroy();
                System.out.println("Game ends");
            }

        }
    }

}
