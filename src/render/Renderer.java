package render;

import simulation.TerrainSegment;
import simulation.World;
import simulation.creature.Bone;
import simulation.creature.Creature;
import simulation.creature.Joint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pontus on 2017-11-29.
 */
public class Renderer {

    private JPanel surface;
    private World world;

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public Renderer(World world) {
        this.world = world;
    }

    public void start() {
        JFrame frame = new JFrame("Flying is impossible");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        surface = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                render((Graphics2D) graphics);
            }
        };
        surface.setFocusable(true);
        surface.setBackground(Color.black);

        frame.add(surface);
        frame.setVisible(true);
    }

    public void update() {
        surface.repaint();
    }

    private void render(Graphics2D g) {
        configGraphics(g);
        g.setColor(new Color(16, 16, 16));
        g.fillRect(0,0,WIDTH, HEIGHT);
        renderTerrain(g);
        renderCreatures(g);
    }

    private void configGraphics(Graphics2D g) {
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(rh);
    }

    private void renderCreatures(Graphics2D g) {
        for (Creature creature : world.getCreatures()) {
            for (Bone bone : creature.getBones()) {
                g.setColor(Color.WHITE);
                g.drawLine(
                        (int)bone.getFirst().getPosition().getX(),
                        (int)bone.getFirst().getPosition().getY(),
                        (int)bone.getSnd().getPosition().getX(),
                        (int)bone.getSnd().getPosition().getY()
                );
                g.setColor(new Color(116, 178, 216));
                renderJoint(g, bone.getSnd());
            }
            g.setColor(Color.cyan);
            renderJoint(g, creature.getHead());
        }
    }

    private void renderJoint(Graphics2D g, Joint joint) {
        int radius = (int)joint.getRadius();
        g.fillRoundRect(
                (int) joint.getPosition().getX() - radius / 2,
                (int) joint.getPosition().getY() - radius / 2,
                radius, radius, radius, radius
        );
    }

    private void renderTerrain(Graphics2D g) {
        g.setColor(Color.WHITE);
        for (TerrainSegment segment : world.getTerrain()) {
            g.drawLine(
                    (int)segment.getStart().getX(),
                    (int)segment.getStart().getY(),
                    (int)segment.getEnd().getX(),
                    (int)segment.getEnd().getY()
            );
        }
    }
}
