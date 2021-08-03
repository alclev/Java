
import processing.core.PApplet;
import processing.core.PVector;

public class Projectile {
	/**
	 * 
	 * range= 150
	 * 
	 */

	public Projectile(PApplet pap, float deg) {
		p = pap;
		diam = 0.04267F;
		origHeight = p.height - (diam / 2)-10;
		run = true;
		pos = new PVector(diam / 2, origHeight); // generalize
		vel = new PVector(0, 0, 0);
		velMag = 40F;
		this.deg = deg;
		vel.set(velMag * PApplet.cos(PApplet.radians(deg)), velMag * -PApplet.sin(PApplet.radians(deg)));
		g = new PVector(0, 9.8F);
		land = false;
		fog= new Force();
	}

	private PApplet p;
	private PVector pos;
	private PVector vel;
	private PVector g;
	private float diam;
	private float deg;
	private Boolean run;
	private float velMag;
	private Boolean land;
	private float origHeight;
	private PVector mg;
	private Force fog;

	public void render() {
		p.pushStyle();
		p.noStroke();
		p.fill(0, 73, 62);
		p.ellipse(pos.x, pos.y, 10, 10);
		p.popStyle();
	}

	public void update(float dt) {
		if (run) {

			pos.add(PVector.mult(vel, dt));

			float m = 0.0456F; // Kg
			mg = PVector.mult(g, m);
			PVector drag= fog.drag(diam, vel);
			
			PVector netF = fog.net(drag,mg);

			PVector ac = PVector.div(netF, m);
			vel.add(PVector.mult(ac, dt));
		}
	}

	public float getDeg() {
		return deg;
	}

	public PVector getPos() {
		return pos;
	}

	public void land() {
		if (pos.y > p.height - diam / 2) {
			run = false;
			pos.y = p.height - diam / 2;
		}
	}

	public boolean isLand() {
		if ((pos.y > p.height - diam / 2 || pos.y == p.height - diam / 2) && pos.x != diam / 2) {
			land = true;
		} else {
			land = false;
		}
		return land;
	}

	public void reset() {
		pos.set(diam / 2, origHeight);
		vel.set(velMag * PApplet.cos(PApplet.radians(deg)), velMag * -PApplet.sin(PApplet.radians(deg)));
		land = false;
		run = true;
	}

	public void runChng() {
		if (run) {
			run = false;
		} else {
			run = true;
		}
	}

	public void setDeg(float degChng) {
		deg = degChng;
	}

}
