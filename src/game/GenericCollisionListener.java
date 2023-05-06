package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;

import static game.Player.damagedSound;

public class GenericCollisionListener implements CollisionListener {

    private GameLevel level;
    private Game game;
//    private int collision_counter;

    public GenericCollisionListener(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
//        collision_counter++;
//        System.out.print("Collision " + collision_counter + ":\n" +
//                "  rep. body:" + e.getReportingBody() + "\n" +
//                "  oth. body:" + e.getOtherBody() + "\n");

        if (e.getOtherBody() instanceof Coin && level.isComplete()){
            game.goToNextLevel();
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Apple){
            Player.setLives(Player.getLives()+1);
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Coin){
            Player.setCoins(Player.getCoins()+1);
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Slime){
            System.out.println("Collision of Slime and Player");
            if (Player.getLives() > 0) {
                damagedSound.play();
                Player.setLives(Player.getLives()-1);
            } else if (Player.getLives() < 0) {
                e.getOtherBody().destroy();
                System.out.println("Game ends");
            }
        }
//
//        if (e.getOtherBody() instanceof Bomb){
//            System.out.println("Bomb collision!");
//            e.getOtherBody().destroy();
//        }

//        if (e.getOtherBody() instanceof Slime){
//            e.getOtherBody().destroy();
//            Player.setCoins(Player.getCoins() + 10);
//        }


    }

}
