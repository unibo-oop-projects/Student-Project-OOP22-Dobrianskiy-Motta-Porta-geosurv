package it.unibo.geosurv.model.drops;

import java.awt.Rectangle;
import it.unibo.geosurv.model.GameObject;
import it.unibo.geosurv.model.ID;
import it.unibo.geosurv.view.graphics.Texture;

public class Experience extends GameObject {

    /** more experience make player go to new levels */
    private int experience;
    private static int experienceCounter = 0;
    protected final static int EXPERIENCE_HEIGHT = 25;
	protected final static int EXPERIENCE_WIDTH = 20;

    public Experience(float x, float y, int exp) {
        super(x, y, ID.Experience);
        this.experience = exp;
        experienceCounter++; // TODO: decrease the counter as Player gather experiences pills
        this.height = EXPERIENCE_HEIGHT;
        this.width = EXPERIENCE_WIDTH;
        this.texture = Texture.EXPERIENCE;
    }

    @Override
    public void tick() {
    }

    @Override
    public Rectangle getShape() {
        return new Rectangle((int) x, (int) y, 27, 33);
    }

    /**
     * @return int amount of experience in the pill
     */
    public int getExperience() {
        return experience;
    }

    public static int getExperienceCounter() {
        return experienceCounter;
    }
}
