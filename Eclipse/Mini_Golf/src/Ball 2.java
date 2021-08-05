import processing.core.PApplet;
import processing.core.PVector;

public class Ball {

	public Ball(PApplet pap, float ang, float velMag) {
		p = pap;
		pos = new PVector(p.width / 2, p.height - 70);
		vel = new PVector(0, 0, 0);
		vel.set(velMag * PApplet.cos(PApplet.radians(ang)), velMag * -PApplet.sin(PApplet.radians(ang)));
		acc = new PVector(0, 0, 0);
		mass = 0.055F; // kg
		net = new PVector(0, 0, 0);
		this.ang= ang;
		this.velMag= velMag;

	}

	private PApplet p;
	private PVector pos;
	private PVector vel;
	private PVector acc;
	private float mass;
	PVector net;
	private float ang;
	private float velMag;

	public void render() {

		p.pushStyle();
		p.fill(255);
		p.noStroke();
		p.ellipse(pos.x, pos.y, 5, 5);
		p.popStyle();
	}

	public void update(float dt, Hill hill, Valley valley) {
		pos.add(PVector.mult(vel, dt));
		float friction = 0.01F;
		PVector fricForce = PVector.mult(vel, -friction);
	
		acc = PVector.div(fricForce, mass);

		vel.add(PVector.mult(acc, dt));

	}

	public void collide(Wall wall) {
		PVector bump = wall.wall().cross(new PVector(0, 0, 1));
		bump.normalize();
		bump.mult(PVector.dot(vel, bump) * 2);
		vel.sub(bump);
		vel.mult(0.99999F);
	}

	public PVector getPos() {
		return pos;
	}

	public float getVel() {
		return vel.mag();
	}
	public float getAng() {
		return ang;
	}
	public float getVelmag() {
		return velMag;
	}

}
