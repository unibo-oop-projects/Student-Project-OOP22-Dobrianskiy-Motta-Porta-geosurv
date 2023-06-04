package it.unibo.geosurv.model.drops;

import it.unibo.geosurv.model.GameObject;
import it.unibo.geosurv.model.Handler;
import it.unibo.geosurv.model.monsters.Monster;
import it.unibo.geosurv.model.monsters.types.Ball;

/**
 * Class which manages the logics of dropping objects (life and experience).
 * 
 * @param <T>
 */
public class Drop implements IDrop<GameObject> {

    private static final int LIFE_PILLS_PROB = 50; // probability to get a life pill: 1/50 at monster death
    private Monster m;
    private Handler h;

    public Drop(final Monster m, final Handler h) {
        this.m = m;
        this.h = h;
    }

    @Override
    public GameObject drop() {
        if (this.shouldDropLife()) {
            return dropLife();
        } else if (this.shouldDropMonsterBall()) {
            return dropBall();
        } else {
            return dropExperience();
        }

    }

    public boolean shouldDropLife() {
        // Generate a random number between 0 and 49
        double num = Math.random();
        int randomNumber = (int) (num * LIFE_PILLS_PROB);
        // Return true if the random number is 0 (probability of 1/50)
        // System.out.println("Math.random() + " + num + " random: " + randomNumber);
        return randomNumber == 0;
    }

    /**
     * @return life objet
     */
    public Life dropLife() {
        return new Life(this.m.getX(), this.m.getY(), this.h);
    }

    /**
     * @return experience object
     */
    public Experience dropExperience() {
        return new Experience(this.m.getX(), this.m.getY(), this.m.getDefaultExperience(), this.h);
    }

    public boolean shouldDropMonsterBall() {
        // Generate a random number between 0 and 49
        double num = Math.random();
        int randomNumber = (int) (num * 10);
        // Return true if the random number is 0 (probability of 1/50)
        // System.out.println("Math.random() + " + num + " random: " + randomNumber);
        return randomNumber == 0;
    }

    /**
     * @return a new Ball monster
     */
    public Ball dropBall() {
        Ball b = new Ball(this.h);
        b.setX(this.m.getX());
        b.setY(this.m.getY());
        return b;
    }

}
