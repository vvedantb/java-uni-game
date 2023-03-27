package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    Player player;
    int speed = 5;


    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

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