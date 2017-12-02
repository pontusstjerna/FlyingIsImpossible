package simulation.creature;

import util.Point;

/**
 * Created by Pontus on 2017-11-29.
 */
public class Bone {
    private Joint first, snd;
    private double length;

    public Bone(Joint first, Joint snd) {
        this.first = first;
        this.snd = snd;
        length = first.getPosition().getDistance(snd.getPosition());
    }

    public Joint getFirst() {
        return first;
    }

    public Joint getSnd() {
        return snd;
    }

    public void update(double dTime) {
        //Point diffForce = snd.getForce().sub(first.getForce());
        //first.addForce(diffForce);
        //snd.addForce(diffForce);

        // TODO: Torque!
        first.update(dTime);
        snd.update(dTime);
    }
}
