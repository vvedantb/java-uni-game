package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Player extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f,1.38f, -0.77f,0.94f, -0.64f,-1.81f, 0.13f,-1.78f, 0.71f,0.43f, 0.65f,1.33f, 0.12f,1.4f);
    private BodyImage image = new BodyImage("data/maskdude.gif", 4f);
    private static int lives = 1;
    private static int coins = 0;
    public static SoundClip damagedSound;

    public Player(GameLevel level) {
        super(level, studentShape);
        addImage(image);
        this.setAlwaysOutline(true);
        this.setPosition(new Vec2(0, 10));
    }

    static {
        try {
            damagedSound = new SoundClip("data/soundfx/slime_enemy_collide.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy(){
        damagedSound.play();
        super.destroy();
    }


    public static int getCoins() {
        return coins;
    }

    public static void setCoins(int coins) {
        Player.coins = coins;
        System.out.println("Coins: " + coins);
    }


    public void setImage(String type){
        removeAllImages();

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
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Player.lives = lives;
    }

}
