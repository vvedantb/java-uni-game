package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The PLayerController class is responsible for controlling the movement and actions of a Player object
 * It implements the KeyListner interface to listen for keyboard events and respond accordingly
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class PlayerController implements KeyListener {
    /**
     * The player object that this controller is controlling
     */
    Player player;

    /**
     * The speed at which the player moves
     */
    int speed = 5;

    /**
     * Constructor for creating a new PLayerController object
     * @param player the Player object to control
     */
    public PlayerController(Player player) {
        this.player = player;
    }

    /**
     * Updates the Player object that this controller is controlling
     * @param player the updated Player object
     */
    public void updatePlayer(Player player) {
        this.player = player;
    }

    /**
     * Responds to a key being typed
     * @param e the keyevent to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Responds to a key being pressed
     * @param e the keyevent to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            player.startWalking(-speed);
            player.setImage("run left");
        } else if (code == KeyEvent.VK_D) {
            player.startWalking(speed);
            player.setImage("run right");
        } else if (code == KeyEvent.VK_SPACE) {
            player.jump(10);
            player.setImage("jump");
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 5) {
                speed = 10;
            } else if (speed == -5) {
                speed = -10;
            }
        } else {
            player.setImage("default right");
        }
    }

    /**
     * Responds to a key being released
     * @param e the keyevent to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            player.startWalking(0);
            player.setImage("default left");
        } else if (code == KeyEvent.VK_D) {
            player.startWalking(0);
            player.setImage("default right");
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 10) {
                speed = 5;
            } else if (speed == -10) {
                speed = -5;
            }
        }

        if (code == KeyEvent.VK_SPACE) {
            player.jump(0);
        }
    }
}