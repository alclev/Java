package layer1;

import processing.core.PApplet;
import processing.core.PVector;

public class Ball {
	public Ball(PApplet papp) {
		p = papp;
		pos = new PVector(p.height / 2, p.width / 2);
		vel = new PVector(0, 0, 0);
		diam = 45;

	}

	private PVector pos;
	private PVector vel;
	private PVector acc;
	private PApplet p;
	private int diam;

	public void render() {
		p.fill(0);
		p.ellipse(pos.x, pos.y, diam, diam);
	}

	public void update(float dt) {
		PVector.add(pos, PVector.mult(vel, dt));
		PVector.add(vel, PVector.mult(acc, dt));
	}

	public PVector forceCompile(PVector a, PVector b, PVector c) {
		PVector ab = PVector.add(a, b);
		PVector net = PVector.add(ab, c);
		return net;
	}

	public float getPosX() {
		return pos.x;
	}

	public float getPosY() {
		return pos.y;
	}

}
