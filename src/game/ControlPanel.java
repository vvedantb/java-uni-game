package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JButton startButton;
    private JButton settingsButton1;
    private JButton quitButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    public JPanel mainPanel;

    public ControlPanel() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game started!");
            }
        });
    }
}
