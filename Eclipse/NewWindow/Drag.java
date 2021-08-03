
import java.util.ArrayList;

import processing.core.PApplet;

public class Drag extends PApplet {

	public Drag() {
		PApplet.runSketch(new String[] { this.getClass().getSimpleName() }, this);
	}

	private static ArrayList<Double> xy;
	
	public void settings() {
		size(400, 400);
	}

	public void setup() {
		background(255);
		xy= new ArrayList<Double>();
	}

	public void draw() {
		fill(0);
		send(mouseX,mouseY);
	}
	public static void send(double x, double y) {
		xy.set(0, x);
		xy.set(1, y);
	}
	
	public static void main(String[] args) {
		Drag win = new Drag();
		Counter win2 = new Counter();
	}
}
