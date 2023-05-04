package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String file_name) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(file_name, append);
            writer.write(level.getLevelName() + "," + level.getPlayer().getCoins() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static GameLevel load(String file_name, Game game) throws IOException {

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
                String level = tokens[0];
                int coins = Integer.parseInt(tokens[1]);
                System.out.println("Level: " + level + ", Coins: " + coins);
                line = reader.readLine();
                if (level == "Level1"){
                    Level1 level1 = new Level1(game);
                    level1.getPlayer().setCoins(coins);
                    return level1;
                } else if (level == "Level2") {
                    Level2 level2 = new Level2(game);
                    level2.getPlayer().setCoins(coins);
                    return level2;
                }
            }
            System.out.println("...done.");

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
