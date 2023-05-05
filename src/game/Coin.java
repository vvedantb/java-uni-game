package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Coin extends DynamicBody {

    private static final Shape coinShape = new CircleShape(0.5f);
    private static final BodyImage image = new BodyImage("data/coin.gif", 1.0f);
    private static SoundClip coinSound;

    public Coin(GameLevel world) {
        super(world, coinShape);
        addImage(image);
        this.setAlwaysOutline(true);
    }

    static {
        try {
            coinSound = new SoundClip("data/soundfx/letsgo.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy(){
        coinSound.play();
        super.destroy();
    }

}
