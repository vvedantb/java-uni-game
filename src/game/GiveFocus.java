package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Gives focus to the user playing
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class GiveFocus implements MouseListener {

    private final GameView view;

    public GiveFocus(GameView v){
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
