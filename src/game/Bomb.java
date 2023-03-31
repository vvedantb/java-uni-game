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

    public Bomb(GameLevel level, Vec2 position, int time){
        DynamicBody bombBody = new DynamicBody(level, bombShape);
        bombBody.addImage(bombImage);
        bombBody.setPosition(new Vec2(0, 0));


        // Timer for the bomb
        Timer timeRemaining = new Timer(5000, level);
        timeRemaining.setRepeats(false);
        timeRemaining.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}