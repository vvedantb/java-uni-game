package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton startButton;
    private JButton quitButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    private JCheckBox soundCheck;

    public ControlPanel(Game game, GameLevel level) {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game started!");
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameSaverLoader.save(level, "src/game_data.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameSaverLoader.load("src/game_data.txt", game);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        soundCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // mute sound
                } else {
                    // Unmute sound
                }
            }
        });
    }
}
