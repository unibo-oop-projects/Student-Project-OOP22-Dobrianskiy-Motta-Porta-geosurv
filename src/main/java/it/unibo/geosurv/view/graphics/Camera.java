package it.unibo.geosurv.view.graphics;

import it.unibo.geosurv.model.Handler;
import it.unibo.geosurv.model.player.MainPlayer;

public class Camera {

    private float x, y;
    private MainPlayer tempPlayer;
//    private Handler handler;

    public Camera(float x, float y, Handler handler) {
        this.x = x;
        this.y = y;
        this.tempPlayer = handler.getPlayer();
    }

    public void tick() {
        x += ((this.tempPlayer.getX() - x) - 1000 /2) * 0.05f;
        y += ((this.tempPlayer.getY() - y) - 563 / 2) * 0.05f;

        if (x <= 0) {
            x = 0;
        }

        if (x >= 1045) {
            x = 1045;
        }

        if (y <= 0) {
            y = 0;
        }

        if (y >= 1500) {
            y = 1500;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
