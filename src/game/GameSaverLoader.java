package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GameSaverLoader {

    private GameLevel level;

    public static void save(GameLevel level, String file_name) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(file_name, append);
            writer.write(level.getLevelName() + "," + level.getPlayer().getCoins() + "\n");
            System.out.println(level.getLevelName() + " ," + level.getPlayer().getCoins());
            System.out.println("Game data saved!");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static GameLevel load(GameLevel lvl, String file_name, Game game) throws IOException {

        FileReader fr = null;
        BufferedReader reader = null;

        try {
            System.out.println("Reading " + file_name + " ...");
            fr = new FileReader(file_name);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");
                System.out.println(Arrays.toString(tokens));
                String level_name = tokens[0];
                int coins = Integer.parseInt(tokens[1]);
                System.out.println(level_name + " , Coins: " + coins);
                line = reader.readLine();
                if (level_name == "Level 1"){
                    game.getLevel().stop();
                    game.setLevel(1, coins);
//                    lvl.stop();
//                    GameLevel level = new Level1(game);
//                    game.setLevel(1, coins);
//
//                    Player.setCoins(coins);
//                    level.getPlayer().setCoins(coins);
//                    return level;
                } else if (level_name == "Level 2") {
                    lvl.stop();
                    GameLevel level = new Level2(game);
//                    game.setLevel(level);

                    Player.setCoins(coins);
                    level.getPlayer().setCoins(coins);
                    return level;
                }
            }
            System.out.println("...done reading");

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

        return null;
    }
}
