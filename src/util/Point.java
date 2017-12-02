package util;

/**
 * Created by Pontus on 2017-11-29.
 */
public class Point {
    private double x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getFloorX() {
        return (int)x;
    }

    public int getFloorY() {
        return (int)y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point add(Point term) {
        this.x += term.x;
        this.y += term.y;
        return this;
    }

    public Point sub(Point term) {
        this.x -= term.x;
        this.y -= term.y;
        return this;
    }

    public Point add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Point sub(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public double getDistance(Point other) {
        return Math.sqrt((other.x - x) * (other.x - x) + (other.y - y) * (other.y - y));
    }
}
