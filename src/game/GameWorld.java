package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public Student student;
    public Professor professor;

    public GameWorld() {

        //Make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        //Make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        //Make a character (with an overlaid image)
        student = new Student(this);
//        student.setPosition(new Vec2(4, -5));

        professor = new Professor(this);

        GenericCollisionListener gcl = new GenericCollisionListener();
        student.addCollisionListener(gcl);
    }

    public Student getStudent(){
        return student;
    }

}
