package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class represents a game level by extending the World class and implementing a ActionListener interface
 * It contains a Player, a Slime enemy, and a door that leads to the next level
 * It also contains a random number generator, a timer that spawns Apples and Coins every 20 seconds, and a coin threshold variable
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public abstract class GameLevel extends World implements ActionListener {
    /**
     * Initialises the  player character in the game level
     */
    private Player player;
    /**
     * A random number generator used to determine the position of spawned items
     */
    public Random random = new Random();
    /**
     * A timer that spawns Apples and Coins every 20 seconds
     */
    public Timer t;
    /**
     * A door that leads to the next level
     */
    public Door door;
    /**
     * Initialises the slime enemy in the game level
     */
    private Slime slime;
    /**
     * Minimum numbers of coins required to obtain to progress to the next level
     */
    private int coin_threshold;

    /**
     * Gets the minimum number of coins required to progress to the next level
     * @return the minimum number of coins
     */
    public int get_coin_threshold() {
        return coin_threshold;
    }

    /**
     * Sets the minimum number of coins required to progress to the enxt level
     * @param threshold the minimum number of coins required to progress to the nxet level
     */
    public void set_coin_threshold(int threshold){
        this.coin_threshold = threshold;
    }

    /**
     * Creates a new game level with the specified Game object
     * @param game the Game object that this GameLevel object has been created within
     */
    public GameLevel(Game game) {
        player = new Player(this); // Player character
        player.addCollisionListener(new GenericCollisionListener(this, game));

        slime = new Slime(this); // Slime enemy

        t = new Timer(20000, this);
        t.setInitialDelay(0);
        t.start();
    }

    /**
     * Gets the player character for this game level
     * @return the player character for this game level
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the slime enemy for this game level
     * @return the slime enemy for this game level
     */
    public Slime getSlime(){
        return slime;
    }

    /**
     * Overrides the actionPerformed method of the ActionListener interface
     * This method is called every 20 seconds by the timer and spawns Apples and Coins at random positions
     * @param e the ActionEvent object which triggered this method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new Apple(this).setPosition(new Vec2(random.nextFloat() * 34 - 17, random.nextFloat() * 10));
        new Coin(this).setPosition(new Vec2(random.nextFloat() * 34 - 17, random.nextFloat() * 10));
    }

    /**
     * Checks if the level is complete (i.e. player has collected enough coins)
     * @return true if the level is complete, false otherwise
     */
    public abstract boolean isComplete();

    /**
     * Changes the state of the door (i.e. open or closed)
     */
    public abstract void changeDoor();

    /**
     * Gets the name of this level
     * @return the name of current level
     */
    public abstract String getLevelName();

}
