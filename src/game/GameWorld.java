package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public Student student;
    public Professor professor;
    public Platform grassPlatform;

    public GameWorld() {

        //Make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11f));

        //Make grass
        grassPlatform = new Platform(this);



        //Make a character (with an overlaid image)
        student = new Student(this);
        professor = new Professor(this);

        Apple apple = new Apple(this);


        ApplePickup applePickup = new ApplePickup(this.getStudent());
        student.addCollisionListener(applePickup);

        ProfessorEncounter encounter = new ProfessorEncounter(student);
        student.addCollisionListener(encounter);

        GenericCollisionListener gcl = new GenericCollisionListener();
        student.addCollisionListener(gcl);
    }

    public Student getStudent(){
        return student;
    }

}
