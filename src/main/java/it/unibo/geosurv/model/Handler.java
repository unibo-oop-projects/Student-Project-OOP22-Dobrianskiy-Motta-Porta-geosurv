package it.unibo.geosurv.model;

import java.awt.Graphics;
import java.util.ArrayList;
import it.unibo.geosurv.model.player.MainPlayer;


public class Handler {

	// TODO: provare Set?
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	private MainPlayer player;
	private boolean up = false, down = false, left = false, right = false;

	

	public void tick() {
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject tempObject = gameObjects.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < gameObjects.size(); i++) {
			GameObject tempObject = gameObjects.get(i);
			tempObject.render(g);
		}
	}

	public GameObject addObject(GameObject tempObject) {
		gameObjects.add(tempObject);
		return tempObject;
	}

	public GameObject addPlayer(MainPlayer player) {
		this.player = player;
		this.gameObjects.add(player);
		return player;
	}

	public void removeObject(GameObject tempObject) {
		gameObjects.remove(tempObject);
	}

	public MainPlayer getPlayer() {
		return this.player;
	}

	public int getObjectsSize() {
		return this.gameObjects.size();
	}
	public ArrayList<GameObject> getObjects() {
		return this.gameObjects;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}