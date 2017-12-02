package simulation;

import simulation.creature.Bone;
import simulation.creature.Creature;
import simulation.creature.Joint;
import util.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2017-11-29.
 */
public class World {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private List<TerrainSegment> terrain;
    private List<Creature> creatures;

    public World() {
        this.terrain = new ArrayList<>();
        this.creatures = new ArrayList<>();
        createGround();
        creatures.add(new Creature(new Point(100,100)));
    }

    public void update(double dTime) {
        for (Creature creature : creatures) {
            creature.update(dTime);
        }
        terrainCollision();
    }

    public List<TerrainSegment> getTerrain() {
        return terrain;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void terrainCollision() {
        for (TerrainSegment segment : terrain) {
            for (Creature c : creatures) {
                // TODO: Fix
                if (c.getHead().getPosition().getY() + c.getHead().getRadius() > HEIGHT - 100) {
                    // Kill
                    c.getHead().addForce(new Point(0, -c.getHead().getForce().getY() * 2));

                }

                for (Bone b : c.getBones()) {
                    if (b.getSnd().getPosition().getY() + b.getSnd().getRadius() > HEIGHT - 100) {
                        b.getSnd().addForce(new Point(0, -b.getSnd().getForce().getY() * 2));
                    }
                }
            }
        }
    }

    private void createGround() {
        terrain.add(new TerrainSegment(new Point(0, HEIGHT - 100), new Point(WIDTH, HEIGHT - 100)));
    }
}
