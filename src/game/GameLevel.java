package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public abstract class GameLevel extends World implements ActionListener {
    private Player player;
    public Random random = new Random();
    public Timer t;
    public Door door;

    private int coin_threshold;

    public int get_coin_threshold() {
        return coin_threshold;
    }

    public void set_coin_threshold(int threshold){
        this.coin_threshold = threshold;
    }

    public GameLevel(Game game) {
        player = new Player(this); // Player character
        t = new Timer(20000, this);
        t.setInitialDelay(0);
        t.start();
        player.addCollisionListener(new GenericCollisionListener(this, game));

        door = new Door(game, this);
    }

    public Player getPlayer() {
        return player;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Apple(this).setPosition(new Vec2(random.nextFloat() * 34 - 17, random.nextFloat() * 10));
        new Coin(this).setPosition(new Vec2(random.nextFloat() * 34 - 17, random.nextFloat() * 10));
    }

    public abstract boolean isComplete();


    public abstract String getLevelName();

}
