package Main;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * 
 * @author AlexClevenger
 * 
 *         Notes
 * 
 * 
 *         Incorporates air drag, gravity, and thrust the platforms speed up
 *         every 5 seconds for difficulty the man will run out of fuel if he is
 *         left in the air for too long
 * 
 */

public class Main extends PApplet {

	public void settings() {
		size(800, displayHeight, P3D);
	}

	public void setup() {
		man = new Rocket(this);
		run = false;
		controlsOn = true;
		new Fuel();

		prev = 0;
		thrustIsOn = false;
		speed = 1;
		startMenu = true;
		fail = false;
	}

	private Rocket man;
	private boolean run;
	private boolean controlsOn;
	private long prev;
	private long now;
	private static long moniter;
	private boolean thrustIsOn;
	private static float speed;
	private boolean startMenu;
	private boolean fail;

	public void draw() {
		background(255);
		pushStyle();
		fill(255, 90, 160);
		rect(0, height * 0.75F, width, height * 0.25F);
		popStyle(); // segment for the laser beam
		now = millis();
		man.render();
		/**
		 * below is the rate of PLATFORM CREATION every 3 seconds a platform will be
		 * created at random x within the width and a random y withing the top 150
		 * pixels
		 */

		this.testFail(); // checks to see if man is dead
		/**
		 * Below are the KEY CONTROLS
		 */
		if (controlsOn) {
			if (keyPressed) {
				if (key == 'w') {
					startMenu = false;
					run = true;
					man.thrust(new PVector(0, -100, 0));
					man.flames('B');
					man.onPlatform(false);
					thrustIsOn = true;
				}

				if (key == 'a') {
					run = true;
					man.thrust(new PVector(-50, -40, 0));
					man.flames('L');
					man.onPlatform(false);
					thrustIsOn = true;
				}

				if (key == 'd') {
					run = true;
					man.thrust(new PVector(50, -40, 0));
					man.flames('R');
					man.onPlatform(false);
					thrustIsOn = true;
				}

			}

		}
		if (startMenu) { // startMenu
			pushStyle();
			fill(200, 200, 234);
			rectMode(CORNERS);
			rect(100, 100, width - 100, height - 100);
			fill(50);
			rect(150, 150, width - 150, height - 150);
			popStyle();
			textSize(16);
			text("Welcome..." + System.lineSeparator() + "W for upwards thrust" + System.lineSeparator()
					+ "A and D for lateral movement" + System.lineSeparator() + "R for reset" + System.lineSeparator()
					+ "Hop from platform to platform without using too much fuel" + System.lineSeparator()
					+ "or hitting the laser" + System.lineSeparator() + "Press W to begin...", 175, 175);
		}

		if (fail) { // menu that comes up if you die
			pushStyle();
			fill(200, 0, 30);
			rectMode(CORNERS);
			rect(100, 100, width - 100, height - 100);
			fill(50);
			rect(150, 150, width - 150, height - 150);
			popStyle();
			textSize(16);
			text("You died!!!" + System.lineSeparator() + "Press R to restart", 175, 175);

		}

		/**
		 * starts only when user uses interaction
		 */
		if (run) {
			man.update(0.1F);
			man.boundary();
		}

		if (thrustIsOn) {
			moniter = (now - prev) / 1000;
			if (now - prev > 10000) {
				man.thrustOff();
				controlsOn = false;
			}
		}
		if (man.isOn())
			prev = now;

	}

	@Override
	public void keyPressed() {
		if (key == 'r') {
			run = false;
			controlsOn = true;
			man.reset();
			prev = now;
			speed = 1;
			fail = false;
		}
	}

	@Override
	public void keyReleased() {
		if (key == 'w') {
			man.thrustOff();
			thrustIsOn = false;
		}
		if (key == 'a') {
			man.thrustOff();
			thrustIsOn = false;
		}
		if (key == 'd') {
			man.thrustOff();
			thrustIsOn = false;
		}

	}

	public void testFail() {
		if (man.getPos().y > height * 0.8F) {
			controlsOn = false;
			man.thrustOff();
			man.onPlatform(false);
			prev = now;
			fail = true;
		}

	}

	public static long moniterFuel() {
		return moniter;
	}

	public static float getSpeed() {
		return speed;
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });

	}

}
