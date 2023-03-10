package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ApplePickup implements CollisionListener {

    private final Student student;

    public ApplePickup(Student s) {
        this.student = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Apple){
            student.setItemCount(student.getItemCount() + 1);
            e.getOtherBody().destroy();
        }

    }
}
