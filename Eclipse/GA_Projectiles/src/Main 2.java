import processing.core.PApplet;

public class Main extends PApplet {

	public void settings() {
		size(1000, 600);
	}

	public void setup() {
		ball = new Projectile(this);
		dt= 0.1F;

	}

	private Projectile ball;
	private float dt;

	public void draw() {
		background(255, 30, 90);
		pushStyle();
		strokeWeight(5);
		line(0, 415, width, 415);
		popStyle();
		
		
		ball.update(dt);
		ball.render();
		ball.land();
	}
	
	public void keyPressed() {
		if (key == 'r') {
			
		}
		if (key == CODED) {
			if (keyCode == UP) { // raise/lower initial position
				
			}
			if (keyCode == DOWN) {
				
			}
		}
		if (key == ' ') {
			ball.runCon(); //launch
		}

		if (key == 'v') {
			
		}
		
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });

	}
}
