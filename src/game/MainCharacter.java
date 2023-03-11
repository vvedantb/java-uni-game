package game;

import city.cs.engine.*;

public class MainCharacter extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f,1.38f, -0.77f,0.94f, -0.64f,-1.81f, 0.13f,-1.78f, 0.71f,0.43f, 0.65f,1.33f, 0.12f,1.4f);
    private static final BodyImage image = new BodyImage("data/maskdude_idle.gif", 4f);
    private static int lives;

    public MainCharacter(GameWorld world) {
        super(world, studentShape);
        addImage(image);
        this.setAlwaysOutline(true);
        lives = 0;
    }

    public static int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        MainCharacter.lives = lives;
    }

    public void addLife(){
        setLives(getLives() + 1);
        System.out.println("Apple/Life count: " + getLives());
    }

    public void removeLife(){
        setLives(getLives() - 1);
    }
}
