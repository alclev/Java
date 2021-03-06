package layer1;

import processing.core.PApplet;

import java.util.HashMap;


public class Main extends PApplet {

	public void settings() {
		size(1000, 700);
	}

	public void setup() {
		ball = new Ball(this);
		envo = new Environment(this);
		dt = 0.1F;
		capacity= 90;
		outputs = new HashMap<>(capacity);
	}

	private Ball ball;
	private Environment envo;
	private float dt;
	private int capacity;
	private HashMap<Integer, Float> outputs;

	public void draw() {

		ball.render();
		ball.update(dt);

		envo.ground();

	}

	public void keyPressed() {

	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });
	}
}
