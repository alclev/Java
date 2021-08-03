import processing.core.PApplet;

public class BouncingBall extends PApplet {

	private Ball ball;
	public void settings() {
		size(1000, 700);

	}

	public void setup() {
		ball = new Ball(this); //takes a PApplet
		new Graph();
	}

	public void draw() {
		frameRate(40);
		background(255);
		ball.render();
		ball.update(0.01F);
		ball.stats();
		ball.help();
		// ball.bounce(); possible extension

	}

	public void keyPressed() {
		if (key == 'r') {
			ball.reset(); // reset to center of screen with velocity = 0, 0, 0
		}
		if (key == CODED) {
			if (keyCode == UP) { // raise/lower initial position
				ball.adjY(-10);
			}
			if (keyCode == DOWN) {
				ball.adjY(10);
			}
		}
		if (key == ' ') {
			Ball.run = true;  //launch
		}
		if (key == 'h') {  //only display the help menu when the h key has been pressed
			if (Ball.help == false) {
				Ball.help = true;
			} else
				Ball.help = false;
		}

		if (key == 'v') {
			ball.getInput();  //accepts user input
		}
		
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { BouncingBall.class.getName() });
	}

}
