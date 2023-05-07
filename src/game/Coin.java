package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The Coin class represents a dynamic coin object in a game
 * It extends the DynamicBody class
 * The Coin class allows for the creation of coins that can be collected by a player in the game
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Coin extends DynamicBody {

    /**
     * The shape of the coin object, which is a circle with radius 0.5f
     */
    private static final Shape coinShape = new CircleShape(0.5f);
    /**
     * The image of the coin object, which is a BodyImage loaded froma gif file
     */
    private static final BodyImage image = new BodyImage("data/coin.gif", 1.0f);
    /**
     * The sound clip played when a coin is collected
     */
    public static SoundClip coinSound;

    /**
     * Constructs a new Coin object within the mentioned GameLevel
     * @param world the GameLevel in which the coin object is created
     */
    public Coin(GameLevel world) {
        super(world, coinShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

    /**
     * Loads the sound clip for the coin object when the class is first loaded
     * The sound clip is loaded from a file and stored in the static variable coinSound
     */
    static {
        try {
            coinSound = new SoundClip("data/soundfx/letsgo.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Destroys the coin object and plays the coin sound clip when it is collected
     */
    @Override
    public void destroy(){
        coinSound.play();
        super.destroy();
    }

}
