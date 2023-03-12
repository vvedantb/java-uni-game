package game;

import city.cs.engine.*;

public class Player extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f,1.38f, -0.77f,0.94f, -0.64f,-1.81f, 0.13f,-1.78f, 0.71f,0.43f, 0.65f,1.33f, 0.12f,1.4f);
    private BodyImage image = new BodyImage("data/maskdude.gif", 4f);
    private static int lives;

    public Player(GameWorld world) {
        super(world, studentShape);
        addImage(image);
        this.setAlwaysOutline(true);
        lives = 0;
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
            case "default" -> {
                image = new BodyImage("data/maskdude_idle.gif", 4f);
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

    public static void addLife(){
        setLives(getLives() + 1);
        System.out.println("Lives: " + getLives());
    }

    public static void removeLife(){
        setLives(getLives() - 1);
    }
}
