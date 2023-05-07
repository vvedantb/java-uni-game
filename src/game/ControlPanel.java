package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton quitButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    private JCheckBox soundCheck;
    private JButton restartGameButton;
    private JCheckBox muteSoundFXCheckBox;

    public ControlPanel(Game game, GameLevel level) {

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
                    GameSaverLoader.save(game.getLevel(), "src/game_data.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameSaverLoader.load(game.getLevel(), "src/game_data.txt", game);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        soundCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Game.gameMusic.pause();
                } else {
                    Game.gameMusic.resume();
                    Game.gameMusic.loop();
                }
            }
        });
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game();
            }
        });
        muteSoundFXCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    Game.objective_complete_sound.setVolume(0.1);
                    Game.game_over_sound.setVolume(0.1);
                    Coin.coinSound.setVolume(0.1);
                    GenericCollisionListener.game_over_sound.setVolume(0.1);
                    GenericCollisionListener.low_on_health_sound.setVolume(0.1);
                } else {
                    Game.objective_complete_sound.setVolume(1.0);
                    Game.game_over_sound.setVolume(1.0);
                    Coin.coinSound.setVolume(1.0);
                    GenericCollisionListener.game_over_sound.setVolume(1.0);
                    GenericCollisionListener.low_on_health_sound.setVolume(1.0);
                }
            }
        });
    }
}
