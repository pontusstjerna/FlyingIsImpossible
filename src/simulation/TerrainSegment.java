package simulation;


import util.Point;

/**
 * Created by Pontus on 2017-11-29.
 */
public class TerrainSegment {
    private Point start, end;

    public TerrainSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

}
