package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static game.Player.damagedSound;



public class GenericCollisionListener implements CollisionListener {

    private GameLevel level;
    private Game game;

    private static SoundClip game_over_sound;
    private static SoundClip low_on_health_sound;
//    private int collision_counter;

    public GenericCollisionListener(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }


    static {
        try {
            game_over_sound = new SoundClip("data/soundfx/game_over.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    static {
        try {
            low_on_health_sound = new SoundClip("data/soundfx/low_on_health.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent e) {
//        collision_counter++;
//        System.out.print("Collision " + collision_counter + ":\n" +
//                "  rep. body:" + e.getReportingBody() + "\n" +
//                "  oth. body:" + e.getOtherBody() + "\n");

        if (e.getOtherBody() instanceof Apple){
            Player.setLives(Player.getLives()+1);
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Coin && e.getReportingBody() instanceof Player){
            Player.setCoins(Player.getCoins()+1);
            e.getOtherBody().destroy();
        }

        if (e.getOtherBody() instanceof Slime){
            System.out.println("Collision of Slime and Player");
            if (Player.getLives() > 0) {
                damagedSound.play();
                Player.setLives(Player.getLives()-1);
            } else if (Player.getLives() < 0) {
                game_over_sound.play();
                e.getOtherBody().destroy();
                System.out.println("Game ends");
            }

            if (Player.getLives() == 1){
                low_on_health_sound.play();
            }
        }

        if (e.getOtherBody() instanceof Door && e.getReportingBody() instanceof Player && level.isComplete()){
            game.goToNextLevel();
            e.getOtherBody().destroy();
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
