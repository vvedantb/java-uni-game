//package game;
//
//import city.cs.engine.*;
//import org.jbox2d.common.Vec2;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Bomb extends Walker implements ActionListener {
//
//    private static final Shape bombShape = new CircleShape(1f);
//    private static final BodyImage bombImage = new BodyImage("data/Bomb/bomb_idle.gif", 3.0f);
//    private static final Shape explosionShape = new CircleShape(3f);
//    ;
//    private static final BodyImage explosionImage = new BodyImage("data/Bomb/bomb_explode.gif", 3.0f);
//    private static DynamicBody bombBody;
//    private static DynamicBody explosionBody;
//    private Game game;
//    private GameLevel level;
//    private Vec2 position;
//
//
//    public Bomb(Game game, GameLevel level, Vec2 position, int timerCount) {
//        super(level);
//        this.game = game;
//        this.level = level;
//        this.position = position;
//
//        bombBody = new DynamicBody(level, bombShape);
//        bombBody.addImage(bombImage);
//        bombBody.setPosition(position);
//
//        Timer timer = new Timer(timerCount, this);
//        timer.setRepeats(false);
//        timer.start();
//        this.setAlwaysOutline(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        bombBody.destroy();
//
//        Timer timer = new Timer(500, this);
//        timer.start();
//        explosionBody = new DynamicBody(level, explosionShape);
//        explosionBody.addImage(explosionImage);
//        explosionBody.setPosition(position);
//
//        explosionBody.addCollisionListener(new GenericCollisionListener(level, game));
//        explosionBody.destroy();
//
//    }
//}
//
//
