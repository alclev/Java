
import java.util.ArrayList;
import java.util.List;

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

public class JumpMan extends PApplet {

	public void settings() {
		size(800, displayHeight, P3D);
	}

	public void setup() {
		man = new JetMan(this);
		run = false;
		controlsOn = true;
		new Fuel();
		plats = new ArrayList<Platform>();
		plats.add(new Platform(this, new PVector(width / 2, height / 2 - 200, 0)));
		prev = 0;
		thrustIsOn = false;
		speed = 1;
		startMenu = true;
		fail = false;

	}

	private JetMan man;
	private boolean run;
	private boolean controlsOn;
	private List<Platform> plats;
	private long t1;
	private long prev;
	private long now;
	private static long moniter;
	private boolean thrustIsOn;
	private static float speed;
	private boolean startMenu;
	private boolean fail;
	private boolean spin;
	
	private long score;
	private long reset;
	
	
	

	public void draw() {
		background(245, 246, 246);
		pushStyle();
		stroke(255, 0, 20);
		line(0, height * 0.8F, width, height * 0.8F);
		popStyle(); // segment for the laser beam
		now = millis();
		
		pushStyle();
		fill(0);
		textSize(32);
		text((score-reset)/1000.0F,width * 0.75F, 50);
		popStyle();
		
		man.render();
		/**
		 * below is the rate of PLATFORM CREATION every 3 seconds a platform will be
		 * created at random x within the width and a random y withing the top 150
		 * pixels
		 */
		if (millis() - t1 >= 3000) {
			t1 = millis();
			plats.add(new Platform(this,
					new PVector((float) (Math.random() * width - 55), (float) (Math.random() * 150))));
			speed += 0.05F;  
		}

		for (Platform plat : plats) {
			plat.render(); //iterates through each platform to render, update, and formulate landing
			plat.update(speed);
			if (run)
				man.landing(plat);
		}

		for (int i = 0; i < plats.size(); i++) {
			if (plats.get(i).getPos().y > height * 0.8) {
				plats.remove(i);
			}
		} //if plat gets too low then laser kills it

		this.testFail();  //checks to see if man is dead
		
		if(!startMenu) {
			score=millis();
		}
		
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
		if (startMenu) { //startMenu
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

		if (fail) {  //menu that comes up if you die
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
				spin = true;
			}
		}
		if(spin) {
			man.rotate(5);
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
			reset=score;
			man.rotFix(0);
			spin=false;
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
			man.rotate(5);
		}

	}

	public static long moniterFuel() {
		return moniter;
	}

	public static float getSpeed() {
		return speed;
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { JumpMan.class.getName() });

	}

}
