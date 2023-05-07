package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static game.Player.damagedSound;


/**
 * A collision listener that handles collisions between bodies in the game
 * This listener handles collisions between the players and coins, apples, doors, and slimes
 * If the player collides with a coin, coin count gets incremented and the coin body is destroyed
 * If the player collides with a apple, player lives gets incremented and the apple body is destroyed
 * If the player collides with a slime, player lives gets decremented by 1 and a sound is played to indicate damage
 * If player lives equals one, sound is played to indicate low health
 * If player lives equals zero, the game over sound is played and the game ends
 * If the player collides with a door and the level is complete, player is taken to the next level and the door body is destroyed
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class GenericCollisionListener implements CollisionListener {

    private GameLevel level;
    private Game game;

    public static SoundClip game_over_sound;
    public static SoundClip low_on_health_sound;
//    private int collision_counter;

    /**
     * Constructs a new GenericCollisionListener with the specified level and game
     * @param level the GaveLevel object for this listener to operate on
     * @param game the Game object for this listener to operate on
     */
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

    /**
     * Handles collisions between bodies in the game
     * @param e the CollisionEvent object that contains information about the collision
     */
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
