import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Ball {
//cannot extend PApplet because class Ball is not a PApplet
	public Ball(PApplet p) {
		papp = p;
		pos = new PVector(500, papp.height - 520, 0); // if 1 pixel = 1 meter then pos is in meters
		vel = new PVector(0, 0, 0); // vel is in m/s
		diam = 40;
		acc = new PVector(0, 9.8F, 0); // m/s^2
		pumpkin = papp.loadImage("pumpkin.jpg");
		pumpkin.resize(40,40); //fixes resolution
	}
	private PVector pos;
	private static PVector vel;
	private PVector acc; // acceleration doesn't change
	private PImage pumpkin;
	private PVector mg;
	
	private int diam; // diameter of ball
	private static float t; // keeps track of time

	private PApplet papp;
	public static Boolean run = false; // must be public so it can be modified from keyPressed
	public static Boolean help = false; // "

	public void render() { // displays ellipse on screen
		papp.fill(0);
		papp.imageMode(PApplet.CENTER);
		papp.image(pumpkin, pos.x, pos.y, diam, diam);

	}

	public void update(float dt) { // changes position of ellipse
		if (pos.y > papp.height - diam / 2) {
			run = false;
			pos.y = papp.height - diam / 2; // prevents bottom of ball from slipping below

		}

		if (run) { // actual motion when launched
			pos.add(PVector.mult(vel, dt));
			//vel.add(PVector.mult(acc, dt)); // vel is pixels per second
			//airdrag get the net force and divide by mass
			float m= 4.422F; //Kg
			float c= 0.2F; 
			float r= 0.125F;  //m
			float a= PApplet.sq(r)*PApplet.PI;
			float p= 1.15F; //kg/m^2
			
			PVector v= vel.copy().normalize();
			mg= PVector.mult(acc, m);
			PVector drag= PVector.mult(v,-0.5F*c*a*p*vel.magSq());
			PVector netF= PVector.add(drag,mg);
			PVector ac= PVector.div(netF, m);
			vel.add(PVector.mult(ac, dt));
		}
	}

	public void stats() {
		if (run) {
			t += (0.01F);
		} // position below is modified to account for the flipped coordinate system and
		papp.textSize(16); // measures height from bottom of ball instead of middle
		papp.text("Time: " + t + " s", 100, 200);
		papp.text("Position: " + new PVector(pos.x-500, papp.height - pos.y - 20, pos.z) + " m", 100, 250);
		papp.text("Velocity: " + vel + " m/s", 100, 300);
		papp.text("Press 'h' for keyboard interactions", 700, 50);
	}

	public void help() {
		if (help) { // boolean makes it only visible when h key has been pressed
			papp.fill(255, 255, 0);
			papp.rect(0, 0, papp.width, papp.height);
			papp.fill(0);
			papp.textSize(25);
			papp.text("UP ARROW: raise initial position", 200, 100);
			papp.text("DOWN ARROW: lower initial position", 200, 150);
			papp.text("v: insert initial parameters", 200, 200);
			papp.text("SPACE: launch ball", 200, 250);
			papp.text("r: reset", 200, 300);
		}
	}

	public void bounce() {
		if (pos.x < diam / 2 || pos.x > papp.width - diam / 2) {
			vel.x *= -1;
		}
		if (pos.y < diam / 2 || pos.y > papp.height - diam / 2) {
			vel.y *= -0.95;
		} // loses some energy on the bounce
	}// confines ball to the dimensions of window

	public void reset() {
		pos.set(500, papp.height - 520, 0);
		vel.set(0, 0, 0);
		t = 0;
		run = false;
		Graph.wipe();  //graph resets with simulation
	}

	public void getInput() { // allows user to input initial parameters
		String vi = javax.swing.JOptionPane.showInputDialog("Initial Velocity (m/s)");
		float rev = (float) Double.parseDouble(vi);
		String angle = javax.swing.JOptionPane.showInputDialog("Angle (Degrees from horizon)");
		float ang = (float) Double.parseDouble(angle);
		vel.set(PApplet.cos(PApplet.radians(ang)) * rev, PApplet.sin(PApplet.radians(ang)) * -rev);
		String hght= javax.swing.JOptionPane.showInputDialog("Initial Height");
		float h= (float) Double.parseDouble(hght);
		pos.set(500,papp.height-h-20,0);
	}

	public void adjY(int i) {
		pos.y += i; // adjusts the initial height of ball
	}

	public static PVector getVel() {
		return vel;  //accessor for Graph
	}
}
