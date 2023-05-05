package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bomb implements ActionListener {

    private static final Shape bombShape = new CircleShape(1f);
    private static final BodyImage bombImage = new BodyImage("data/Bomb/bomb_idle.gif", 3.0f);
    private static final BodyImage explosionImage = new BodyImage("data/Bomb/bomb_explode.gif", 3.0f);
    private int timerCount;
    private GameLevel level;

    public Bomb(GameLevel level, Vec2 position, int timerCount){
        DynamicBody bombBody = new DynamicBody(level, bombShape);
        bombBody.addImage(bombImage);
        bombBody.setPosition(new Vec2(0, 0));
        this.timerCount = timerCount;
        this.level = level;

        // Timer for the bomb
        Timer timer = new Timer(timerCount, level);
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        DynamicBody explosionBody;
//        if (timerCount == 0) {
//            bombShape.destroy(); // Detonate bomb, remove unexploded bomb body
//            explosionBody = new DynamicBody(level); // Set up new DynamicBody for explosion
//            explosionBody.setPosition(bombShape.getPosition()); // Set explosion body position
//            explosionBody.addCollisionListener(new ExplosionCollisionListener()); // Add CollisionListener to explosion body
//            Timer timer = new Timer(500, this); // Schedule timer for removing explosion
//            timer.setRepeats(false);
//            timer.start();
//        } else if (timerCount == 1) {
//            // Remove explosion
//            explosionBody.destroy();
//        }
//        timerCount++;
    }
}


