package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

/**
 * THe Control Panel class represents a panel containing control buttons and checkboxes for the game
 * @author Vedant Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class ControlPanel {
    /**
     * The main panel represents the main JPanel of the control panel
     */
    public JPanel mainPanel;

    /**
     * Quit button used to exit the game
     */
    private JButton quitButton;

    /**
     * Save button used to save current game state (i.e. current level and player coin count)
     */
    private JButton saveGameButton;

    /**
     * Load button used to load a previously saved game state
     */
    private JButton loadGameButton;

    /**
     * Sound check toggles game music on or off
     */
    private JCheckBox soundCheck;

    /**
     * Restart game button is used to restart the game, back to level 1
     */
    private JButton restartGameButton;

    /**
     * Mute sound fx button is used to mute all sound effects in the game
     */
    private JCheckBox muteSoundFXCheckBox;

    /**
     * Creates a Control Panel object with the specified Game and GameLevel
     * @param game The game object associated with the control panel
     * @param level the GameLevel object associated with the control panel
     */
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
