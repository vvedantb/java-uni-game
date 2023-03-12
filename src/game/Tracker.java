package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

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
        view.setCentre(player.getPosition());
    }
}
