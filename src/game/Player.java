package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The PLayer class extends the Walker class and represents the main character of the game
 * It initialises the Player object with an image, a sound effect, number of lives, and number of coins
 * The class also allows the Player to set their image to different types of images depending on the level
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Player extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f, 1.38f, -0.77f, 0.94f, -0.64f, -1.81f, 0.13f, -1.78f, 0.71f, 0.43f, 0.65f, 1.33f, 0.12f, 1.4f);
    protected static SoundClip damagedSound;
    private static SoundClip low_on_health_sound;
    private static int lives = 3;
    private static int coins = 0;

    static {
        try {
            damagedSound = new SoundClip("data/soundfx/slime_enemy_collide.wav");
            System.out.println("Loading collide sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    static {
        try {
            low_on_health_sound = new SoundClip("data/soundfx/low_on_health.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    //    private BodyImage image = new BodyImage("data/maskdude.gif", 4f);
    private final GameLevel level;
    private BodyImage image;

    /**
     * The player constructor creates a new Player object for a GameLevel
     * It sets the PLayer object's image to the default left image and initialises its position
     * @param level the GameLevel that the PLayer object belongs to
     */
    public Player(GameLevel level) {
        // Initialises the player as a walker object and adds it to GameLevel
        super(level, studentShape);
        this.level = level;
        setImage("default left");
//        addImage(image);
        this.setAlwaysOutline(true);
        this.setPosition(new Vec2(0, 10));
    }

    /**
     * Returns the number of coins the player has
     * @return player coin count
     */
    public static int getCoins() {
        return coins;
    }

    /**
     * Sets the number of coins the player has to a specified value
     * @param coins the new number of coins the player has
     */
    public static void setCoins(int coins) {
        Player.coins = coins;
        System.out.println("Coins: " + coins);
    }

    /**
     * Returns the number of lives the player has
     * @return player lives count
     */
    public static int getLives() {
        return lives;
    }

    /**
     * Sets the number of lives the player has
     * @param lives new number of player lives count
     */
    public static void setLives(int lives) {
        Player.lives = lives;
    }

    /**
     * Overrides the destroy() method of the superclass, and plays the sound of the player getting damaged
     */
    @Override
    public void destroy() {
        damagedSound.play();
        super.destroy();
    }

    /**
     * Sets the image of the player according to the specific type based on the key stroke pressed by the user
     * @param type A string that represents the type of image to set on the Player character
     */
    public void setImage(String type) {
        removeAllImages();
        if (level instanceof Level1) {
            switch (type) {
                case "run right" -> {
                    image = new BodyImage("data/maskdude_run.gif", 4f);
                    addImage(image);
                }
                case "run left" -> {
                    image = new BodyImage("data/maskdude_run_mirror.gif", 4f);
                    addImage(image);
                }
                case "jump" -> {
                    image = new BodyImage("data/maskdude_jump.png", 4f);
                    addImage(image);
                }
                case "default right" -> {
                    image = new BodyImage("data/maskdude_idle.gif", 4f);
                    addImage(image);
                }
                case "default left" -> {
                    image = new BodyImage("data/maskdude_idle_mirror.gif", 4f);
                    addImage(image);
                }
            }
        } else if (level instanceof Level2) {
            switch (type) {
                case "run right" -> {
                    image = new BodyImage("data/pink_man/pink_man_run.gif", 4f);
                    addImage(image);
                }
                case "run left" -> {
                    image = new BodyImage("data/pink_man/pink_man_run_left.gif", 4f);
                    addImage(image);
                }
                case "jump" -> {
                    image = new BodyImage("data/pink_man/pink_man_jump.png", 4f);
                    addImage(image);
                }
                case "default right" -> {
                    image = new BodyImage("data/pink_man/pink_man_idle.gif", 4f);
                    addImage(image);
                }
                case "default left" -> {
                    image = new BodyImage("data/pink_man/pink_man_idle_left.gif", 4f);
                    addImage(image);
                }
            }
        } else if (level instanceof Level3) {
            switch (type) {
                case "run right" -> {
                    image = new BodyImage("data/virtual_guy/run.gif", 4f);
                    addImage(image);
                }
                case "run left" -> {
                    image = new BodyImage("data/virtual_guy/run_left.gif", 4f);
                    addImage(image);
                }
                case "jump" -> {
                    image = new BodyImage("data/virtual_guy/jump.png", 4f);
                    addImage(image);
                }
                case "default right" -> {
                    image = new BodyImage("data/virtual_guy/idle.gif", 4f);
                    addImage(image);
                }
                case "default left" -> {
                    image = new BodyImage("data/virtual_guy/idle_left.gif", 4f);
                    addImage(image);
                }
            }
        } else if (level instanceof Level4) {
            switch (type) {
                case "run right" -> {
                    image = new BodyImage("data/ninja_frog/run_right.gif", 4f);
                    addImage(image);
                }
                case "run left" -> {
                    image = new BodyImage("data/ninja_frog/run_left.gif", 4f);
                    addImage(image);
                }
                case "jump" -> {
                    image = new BodyImage("data/ninja_frog/jump.png", 4f);
                    addImage(image);
                }
                case "default right" -> {
                    image = new BodyImage("data/ninja_frog/idle_right.gif", 4f);
                    addImage(image);
                }
                case "default left" -> {
                    image = new BodyImage("data/ninja_frog/idle_left.gif", 4f);
                    addImage(image);
                }
            }
        }
    }
}
