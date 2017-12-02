package simulation.creature;

import util.Point;

/**
 * Created by Pontus on 2017-11-29.
 */
public class Joint {
    private Point position;
    private double radius;
    private Muscle muscle;
    private Point force;

    public Joint(Point position, double radius) {
        this(position, radius, null);
    }

    public Joint(Point position, double radius, Muscle muscle) {
        this.position = position;
        this.radius = radius;
        this.muscle = muscle;
        force = new Point(0,0);
    }

    public Point getPosition() {
        return position;
    }

    public double getRadius() {
        return radius;
    }

    public void update(double dTime) {
        force.add(new Point(0, 9.81 * dTime));
        position.add(force);
    }

    public void addForce(Point force) {
        this.force.add(force);
    }

    public Point getForce() {
        return force;
    }
}
