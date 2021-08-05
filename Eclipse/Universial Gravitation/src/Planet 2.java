import processing.core.PApplet;
import processing.core.PVector;

public class Planet {

	public Planet(PApplet p, double mass, PVector vell, double realDist, int diam) {
		papp = p;
		pos = new PVector((float) realDist, 0, 0); 
		vel = vell; // vel is in m/s
		this.diam = diam; //m
		this.mass = mass; //kg
		vel.set(vell);
		scale = 1e9F; //1 pixel = 1e9 meters
	}

	private PVector pos;
	private PVector vel;
	private double mass;
	private int diam;
	private float scale;

	private PApplet papp;
	public static Boolean run = false; // must be public so it can be modified from keyPressed
	public static Boolean help = false; // "

	public void render(int r, int g, int b) { // displays ellipse on screen
		papp.pushMatrix();
		papp.pushStyle();
		papp.noStroke();
		papp.fill(r, g, b);
		papp.translate(pos.x / scale, pos.y / scale, pos.z / scale);
		papp.sphere(diam / 2); 
		papp.popStyle();
		papp.popMatrix();
	}

	public void update(float dt) {
		if (run) { // actual motion when launched
			pos.add(PVector.mult(vel, dt));
			vel.add(PVector.mult(getGforce(), dt));  
		}
	}

	public PVector getGforce() { 
		PVector direction = PVector.sub(new PVector(0, 0, 0), pos); //sun is always at center because of translation
		PVector gForce = PVector.mult(direction.copy().normalize(),
				(float) ((6.67e-11 * mass * 1.98e30F) / (Math.pow(direction.mag(), 2))));
		PVector acc = PVector.div(gForce, (float) mass);
		return acc;

	}

	public PVector getPos() {
		return PVector.div(pos, scale); //convenience
	}

}
