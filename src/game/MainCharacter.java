package game;

import city.cs.engine.*;

public class MainCharacter extends Walker {

    private static final Shape studentShape = new PolygonShape(0.08f,1.38f, -0.77f,0.94f, -0.64f,-1.81f, 0.13f,-1.78f, 0.71f,0.43f, 0.65f,1.33f, 0.12f,1.4f);
    private static final BodyImage image = new BodyImage("data/maskdude_idle.gif", 4f);
    private int apples;
    private int lives;

    public MainCharacter(GameWorld world) {
        super(world, studentShape);
        addImage(image);
        this.setAlwaysOutline(true);
        apples = 0;
        lives = 3;
    }

    public int getApples() {
        return apples;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public void addApples(){
        addLife();
        setApples(getApples()+1);
        System.out.println("Apple count: " + getApples());
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void addLife(){
        setLives(getLives() + 1);
    }

    public void removeLife(){
        setLives(getLives() - 1);
    }
}
