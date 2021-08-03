package Main;

import processing.core.PApplet;

public class Main extends PApplet {

	private Projectile mass1;
	public void settings() {
		size(1000, 700);

	}

	public void setup() {
		mass1 = new Projectile(this); //takes a PApplet
		new Graph();
	}

	public void draw() {
		frameRate(40);
		background(255);
		mass1.render();
		mass1.update(0.01F);
		mass1.stats();
		mass1.help();
		// ball.bounce(); possible extension

	}

	public void keyPressed() {
		if (key == 'r') {
			mass1.reset(); // reset to center of screen with velocity = 0, 0, 0
		}
		if (key == CODED) {
			if (keyCode == UP) { // raise/lower initial position
				mass1.adjY(-10);
			}
			if (keyCode == DOWN) {
				mass1.adjY(10);
			}
		}
		if (key == ' ') {
			Projectile.run = true;  //launch
		}
		if (key == 'h') {  //only display the help menu when the h key has been pressed
			if (Projectile.help == false) {
				Projectile.help = true;
			} else
				Projectile.help = false;
		}

		if (key == 'v') {
			mass1.getInput();  //accepts user input
		}
		
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });
	}

}
