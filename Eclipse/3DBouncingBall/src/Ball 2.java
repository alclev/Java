import processing.core.PApplet;
import processing.core.PVector;

public class Ball {

	public Ball(PApplet p, float diam) {
		papp = p;
		this.diam = diam;
		pos = new PVector(400, 250, 0);
		vel = new PVector(10, 1, 1);
		acc = new PVector(0, 9.8F, 0);
	}

	private PApplet papp;
	private PVector pos;
	private PVector vel;
	private PVector acc;
	float diam;
	public static Boolean run = false;

	public void update(float dt) { // changes position of ellipse

		if (run) { // actual motion when launched
			pos.add(PVector.mult(vel, dt));
			vel.add(PVector.mult(acc, dt));
		}
	}

	public void bounce() {
		papp.pushMatrix();
		papp.translate(pos.x, pos.y, pos.z);
		if (pos.x < 250 || pos.x > papp.width - 250) {
			vel.x *= -1;
		}
		if (pos.y < 200 || pos.y > 400) {
			vel.y *= -0.98;
		}
		if (pos.z < 150 || pos.z > 150) {
			vel.z *= -1;
		}
		papp.popMatrix();// loses some energy on the bounce
	}// confines ball to the dimensions of window

	public void render() {
		papp.pushMatrix();
		papp.translate(pos.x, pos.y, pos.z);
		papp.fill(255, 255, 0);
		papp.sphere(diam);
		papp.popMatrix();
	}

}
