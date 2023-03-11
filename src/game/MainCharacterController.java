package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainCharacterController implements KeyListener {

    MainCharacter mainCharacter;
    int speed = 5;


    public MainCharacterController(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            mainCharacter.startWalking(-speed);
            mainCharacter.setImage("run left");
        } else if (code == KeyEvent.VK_D) {
            mainCharacter.startWalking(speed);
            mainCharacter.setImage("run right");
        } else if (code == KeyEvent.VK_SPACE) {
            mainCharacter.jump(5);
            mainCharacter.setImage("jump");
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 5) {
                speed = 10;
            } else if (speed == -5) {
                speed = -10;
            }
        } else {
            mainCharacter.setImage("default");
        }



    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            mainCharacter.startWalking(0);
        } else if (code == KeyEvent.VK_D) {
            mainCharacter.startWalking(0);
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 10) {
                speed = 5;
            } else if (speed == -10) {
                speed = -5;
            }
        }

        if (code == KeyEvent.VK_SPACE) {
            mainCharacter.jump(0);
        }

    }

}