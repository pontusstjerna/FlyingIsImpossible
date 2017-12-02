package simulation.creature;

import util.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2017-11-29.
 */
public class Creature {
    private Joint head;
    private List<Bone> bones;

    public Creature(Point position) {
        bones = new ArrayList<>();
        head = new Joint(position, 20);
        Joint testFoot = new Joint(new Point(position.getX(), position.getY() + 100), 10);
        Bone spine = new Bone(head, testFoot);
        bones.add(spine);
    }

    public Joint getHead() {
        return head;
    }

    public List<Bone> getBones() {
        return bones;
    }

    public void update(double dTime) {
        for (Bone bone : bones) {
            bone.update(dTime);
        }
    }
}
