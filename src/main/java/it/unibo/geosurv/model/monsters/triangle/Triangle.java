package it.unibo.geosurv.model.monsters.triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import it.unibo.geosurv.model.Game;
import it.unibo.geosurv.model.GameObject;
import it.unibo.geosurv.model.Handler;
import it.unibo.geosurv.model.ID;
import it.unibo.geosurv.model.MonstersObserver;
import it.unibo.geosurv.model.monsters.Monster;
import it.unibo.geosurv.model.player.MainPlayer;
import it.unibo.geosurv.model.utility.Func;
import it.unibo.geosurv.model.utility.Pair;

public class Triangle extends Monster {

    // private Handler handler;
    // private Game game;
    private float DEFAULT_SPEED = 1.2f; // default speed of triangle
    private float MAX_SPEED = 3.4f; // max speed of BIG triangle
    private float speed;
    private static int counter = 0;
    private int DEFAULT_HEALTH = 2; // default health of triangle
    private int MAX_HEALTH = 10; // default health of BIG triangle
    private String name = "Triangle-";
    private int DEFAULT_DIMENSION = 20; // default size of triangle
    private int MAX_DIMENSION = 50; // max size of (big) triangle
    private int dimension;
    private boolean isBig = false;

    /**
     * Triangle constructor
     */
    public Triangle(float x, float y, Handler handler, Game game, boolean isBig) { // TODO: handler & gamo
                                                                                   // not used! to
        // delete
        super(x, y);
        // this.speed = speed;
        // this.handler = handler;
        // this.game = game;
        Triangle.counter++;
        this.name = name + Triangle.counter;
        if (!isBig) {
            this.health = DEFAULT_HEALTH;
            this.dimension = DEFAULT_DIMENSION;
            this.speed = DEFAULT_SPEED;
            this.power = 1;
            this.height = DEFAULT_DIMENSION;
            this.width = DEFAULT_DIMENSION;
        } else {
            this.health = MAX_HEALTH;
            this.dimension = MAX_DIMENSION;
            this.speed = MAX_SPEED;
            this.power = 5;
            this.height = MAX_DIMENSION;
            this.width = MAX_DIMENSION;
        }

    };

    @Override
    public void tick() {

        reachTarget();

    }

    @Override
    public void render(Graphics g) {
        this.drawRect(g,  Color.DARK_GRAY);
        g.setColor(Color.white);
        g.drawString("" + this.health, (int) x + 3, (int) y + 8);
    }

    @Override
    public void reachTarget() {
        x += velX;
        y += velY;
        // evaluated only once at creation istead of each tick()
        // tempPlayer = Func.findPlayer(handler);

        // int mx = (int) this.tempPlayer.getX();
        // int my = (int) this.tempPlayer.getY();

        float angle = (float) Math.atan2(my - this.getY() + 8, mx - this.getX() + 4);

        this.velX = (float) ((this.speed) * Math.cos(angle));
        this.velY = (float) ((this.speed) * Math.sin(angle));
        // System.out.println("T trying to reach the target");
    }

    public boolean isBig() {
        return isBig;
    }

}
