package game;

import city.cs.engine.*;

public class Block extends StaticBody {

    private static final Shape groundBlockShape = new BoxShape(2.5f, 2.5f);

    public Block(GameLevel world, String block) {
        super(world, groundBlockShape);
        setBlock(block);
        this.setAlwaysOutline(true);
    }

    public void setBlock(String block) {
        BodyImage image;
        if (block.equals("dirt")) {
            removeAllImages();
            image = new BodyImage("data/blocks/ground blocks/dirt.png", 5f);
            addImage(image);
        } else if (block.equals("grass")){
            removeAllImages();
            image = new BodyImage("data/blocks/ground blocks/grass.png", 5f);
            addImage(image);
        }
    }

}
