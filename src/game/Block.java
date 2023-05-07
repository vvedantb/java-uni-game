package game;

import city.cs.engine.*;

/**
 * The Block class represents a Static block object in the game
 * It extends the StaticBody class
 * The Block class allows the creation of different types of block objects, which can be used to build the game
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Block extends StaticBody {

    /**
     * Shape of the ground block object, which is a box with dimensions 2.5f x 2.5f
     */
    private static final Shape groundBlockShape = new BoxShape(2.5f, 2.5f);

    /**
     * Constructs a new Block object with the specified GameLevel and block type
     * @param level the GameLevel in which the block object gets created
     * @param block the type of Block object to be created
     */
    public Block(GameLevel level, String block) {
        super(level, groundBlockShape);
        setBlock(block);
        this.setAlwaysOutline(true);
    }

    /**
     * Sets the image of the block object based on the specified block type
     * @param block the type of block object to be created
     */
    public void setBlock(String block) {
        BodyImage image;
        removeAllImages();
        if (block.equals("dirt")) {
            image = new BodyImage("data/blocks/ground blocks/dirt.png", 5f);
            addImage(image);
        } else if (block.equals("grass")){
            image = new BodyImage("data/blocks/ground blocks/grass.png", 7f);
            addImage(image);
        } else if (block.equals("water1")){
            image = new BodyImage("data/blocks/water/1.png", 5f);
            addImage(image);
        } else if (block.equals("water2")){
            image = new BodyImage("data/blocks/water/2.png", 5f);
            addImage(image);
        } else if (block.equals("water3")){
            image = new BodyImage("data/blocks/water/3.png", 5f);
            addImage(image);
        } else if (block.equals("cave")) {
            image = new BodyImage("data/blocks/cave/block.png", 5f);
            addImage(image);
        } else if (block.equals("block")){
            image = new BodyImage("data/blocks/block.png", 7f);
            addImage(image);
        }
    }

}
