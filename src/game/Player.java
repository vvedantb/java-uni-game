package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Player extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f, 1.38f, -0.77f, 0.94f, -0.64f, -1.81f, 0.13f, -1.78f, 0.71f, 0.43f, 0.65f, 1.33f, 0.12f, 1.4f);
    public static SoundClip damagedSound;
    private static int lives = 1;
    private static int coins = 0;
    private GameLevel level;

    static {
        try {
            damagedSound = new SoundClip("data/soundfx/slime_enemy_collide.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private BodyImage image = new BodyImage("data/maskdude.gif", 4f);

    public Player(GameLevel level) {
        super(level, studentShape);
        this.level = level;
        addImage(image);
        this.setAlwaysOutline(true);
        this.setPosition(new Vec2(0, 10));
    }

    public static int getCoins() {
        return coins;
    }

    public static void setCoins(int coins) {
        Player.coins = coins;
        System.out.println("Coins: " + coins);
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Player.lives = lives;
    }

    @Override
    public void destroy() {
        damagedSound.play();
        super.destroy();
    }

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
        } else if (level instanceof Level2){
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
        } else if (level instanceof Level3){
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
        }
    }

    public void shoot() {
        
    }
}
