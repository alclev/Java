import processing.core.PApplet;
import processing.core.PVector;

public class Projectile {

	public Projectile(PApplet papp) {
		p = papp;
		pos = new PVector(50, 400, 0);
		vel = new PVector(10, -20, 0);
		acc = new PVector(0, 9.8F, 0);
		run = false;
		diam = 30;
	}

	private PApplet p;
	private PVector pos;
	private PVector vel;
	private PVector acc;
	private boolean run;
	private int diam;

	public void render() {
		p.pushStyle();
		p.fill(0, 225, 165);
		p.ellipse(pos.x, pos.y, diam, diam);
		p.popStyle();
	}

	public void runCon() {
		if (run == false) {
			run = true;
		}
		else {
			run = false;
		}
	}

	public void update(float dt) {
		if (run) {
			pos.add(PVector.mult(vel, dt));
			vel.add(PVector.mult(acc, dt));
		}
	}

	public void land() {
		if (pos.y >= 400 && pos.x != 50) {
			vel.set(0,0,0);
			//runCon();
		}
	}
}
