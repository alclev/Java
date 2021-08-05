import processing.core.PApplet;

public class Environment extends PApplet {

	public void settings() {
		size(800, 500, P3D); // rendering engine
	}

	public void setup() {
		ball= new Ball(this, 40);
		ball2= new Ball(this,20);
	}

	private Ball ball;
	private Ball ball2;
	/**
	 * sphere(d) box(w,h,l) lights
	 */
	public void draw() {
		background(0);
		//ambientLight(255,0,0);
		camera(mouseX, height/2, (height/2) / tan(PI/6), width/2, height/2, 0, 0, 1, 0);
		lights();
		pushMatrix();
		translate(width / 2, height / 2, 0);
		noFill();
		stroke(255);
		box(300);
		popMatrix();
		
		ball.render();
		ball.update(0.1F);
		ball.bounce();
		
		ball2.render();
		ball2.update(0.1F);
		ball2.bounce();

	}

	public void keyPressed() {

		if (key == ' ') {
			Ball.run = true; // launch
		}
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Environment.class.getName() });

	}
}
