import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 * 
 * @author AlexClevenger use arrow keys to slow down and speed up program move
 *         mouse to change perspective (middle for normal) 
 *         use space to run
 */

public class Universe extends PApplet {
	private Planet sun;
	private Planet merc;
	private Planet venus;
	private Planet earth;
	private Planet mars;
	private Planet jupiter;
	private Planet saturn;
	private Planet uranus;
	private Planet neptune;
	private float dt;
	private float t;
	private PImage image;

	public void settings() {
		size(displayWidth, displayHeight, P3D);
	}

//this, mass (kg), pos vector, max velocity (m/s) vector, perihelion distance (m), pixel diameter

	public void setup() {
		sun = new Planet(this, 1.98e30, new PVector(0, 0, 0), 0, 40);
		merc = new Planet(this, 3.3011e23, new PVector(0, 58980, 0), 4.6e10, 10);
		venus = new Planet(this, 4.867e24, new PVector(0, 35260, 0), 1.075e11, 10);
		earth = new Planet(this, 5.972e24, new PVector(0, 30300, 0), 1.471e11, 10);
		mars = new Planet(this, 6.4185e23, new PVector(0, 26500, 0), 2.066e11, 10);
		jupiter = new Planet(this, 1.899e27, new PVector(0, 13720, 0), 7.405e11, 10);
		saturn = new Planet(this, 5.6846e26, new PVector(0, 10180, 0), 1.3526e12, 10);
		uranus = new Planet(this, 8.6832e25, new PVector(0, 7110, 0), 2.7413e12, 10);
		neptune = new Planet(this, 1.0243e26, new PVector(0, 5500, 0), 4.4445e12, 10);
		dt = 1000;
		image = loadImage("stars.png"); // if the image does not load then the background can just be set to black
		image.resize(displayWidth, displayHeight);
	}

	public void draw() {

		translate(width / 2, height / 2, 0);
		background(image);
		lights();
		this.stats();
		camera(mouseX, height / 2, (height / 2) / tan(PI / 6), width / 2, height / 2, 0, 0, 1, 0);
		translate(width / 2, height / 2, -100);
		sun.render(255, 255, 100); // takes rgb values
		merc.render(240, 0, 0);
		merc.update(dt);
		venus.render(147, 112, 0);
		venus.update(dt);
		earth.render(0, 0, 240);
		earth.update(dt);
		mars.render(147, 55, 0);
		mars.update(dt);
		jupiter.render(222, 253, 90);
		jupiter.update(dt);
		saturn.render(141, 73, 68);
		saturn.update(dt);
		uranus.render(203, 255, 248);
		uranus.update(dt);
		neptune.render(0, 0, 255);
		neptune.update(dt);

	}

	public void keyPressed() {
		if (key == ' ') {
			Planet.run = true; // launch
		}

		if (key == CODED) {
			if (keyCode == UP) { // raise/lower initial position
				dt *= 2;
			}
			if (keyCode == DOWN) {
				dt /= 2;
			}
		}

	}

	public void stats() {
		if (Planet.run == true) {
			t += dt;
		}
		textSize(32);
		text("Time: " + t / 1e5  + " days", -600, -300);

		println("Pos: " + earth.getPos());
		println("Time: " + t / 1e5);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Universe.class.getName() });

	}

}
