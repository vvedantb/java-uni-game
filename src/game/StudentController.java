package game;

import city.cs.engine.Walker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentController implements KeyListener  {

    Student student;
    int speed = 5;

    public StudentController(Student student) {
        this.student = student;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed: " + e.getKeyChar());

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            student.startWalking(-speed);
        } else if (code == KeyEvent.VK_D) {
            student.startWalking(speed);
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 5) {
                speed = 10;
            } else if (speed == -5) {
                speed = -10;
            }
        }

        if (code == KeyEvent.VK_SPACE){
            student.jump(5);
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            student.startWalking(0);
        } else if (code == KeyEvent.VK_D) {
            student.startWalking(0);
        } else if (code == KeyEvent.VK_SHIFT) {
            if (speed == 10) {
                speed = 5;
            } else if (speed == -10) {
                speed = -5;
            }
        }

        if (code == KeyEvent.VK_SPACE){
            student.jump(0);
        }

    }

}