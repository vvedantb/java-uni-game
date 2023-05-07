package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * @author Vedant, Bhopatrao
 * @version 1.0
 * @since 2023
 */
public class Tracker implements StepListener {

    private GameView view;
    private Player player;

    public Tracker(GameView view, Player player){
        this.view = view;
        this.player = player;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        view.setCentre(new Vec2(player.getPosition()));
    }
}
