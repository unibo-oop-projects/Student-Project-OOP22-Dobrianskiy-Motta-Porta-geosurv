package it.unibo.geosurv.model.monsters;

import it.unibo.geosurv.model.Handler;
import it.unibo.geosurv.model.monsters.types.Triangle;

/**
 * class to generate Triangle monsters.
 */
public class GenerateMonsterT implements GenerateMonster {

    private static final float MIN_DISTANCE = 300.0f; // default monster creation min radius (distance from player)
    private static final float MAX_DISTANCE = 400.0f; // default monster creation min radius (distance from player)

    @Override
    public final MonsterImpl createMonster(final Handler h) {
        MonsterImpl m = new Triangle(h);
        m.setStartingPosition(MIN_DISTANCE, MAX_DISTANCE);
        return m;
    }

}
