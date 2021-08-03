import processing.core.PApplet;

public class Counter extends PApplet {
	public Counter() {
		PApplet.runSketch(new String[] { this.getClass().getSimpleName() }, this);
	}

	private int num = 0;
	private float x, y;

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		background(255);

	}

	public void draw() {
		fill(0);
		if (mousePressed) {
		}
		
	}

	public int count() {
		num++;
		return num;
	}
	
}
