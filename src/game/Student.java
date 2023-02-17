package game;

import city.cs.engine.*;

public class Student extends DynamicBody {

    private static final Shape studentShape = new BoxShape(1, 2);
    private static final BodyImage image = new BodyImage("data/student.png", 4);

    private int credit;
    public Student(World world) {
        super(world);
        addImage(image);
        credit = 0;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
