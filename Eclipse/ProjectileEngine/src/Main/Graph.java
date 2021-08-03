package Main;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Graph extends PApplet {

	public Graph() {
		PApplet.runSketch(new String[] { this.getClass().getSimpleName() }, this);
		wipe = false;
		events = new ArrayList<PVector>();
		times = new ArrayList<>();

		xscale = 10F;
		yscale = 1F;

	}

	private static Boolean wipe; // clean graph
	private ArrayList<PVector> events;
	private ArrayList<Float> times;
	private float xscale;
	private float yscale;
	private static float t;
	private int i;

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		background(255);
	}

	public void draw() {
		strokeWeight(2);
		stroke(0);
		line(0, height / 2, width, height / 2); // x-axis s
		line(40, height, 40, 0); // y-axis m/s

		if (Projectile.run) {
			events.add(Projectile.getVel()); // continuously feed information into two arraylists
			times.add(t);
			t += 0.01;

			textSize(32);
			strokeWeight(2);
			translate(40, height / 2); // set origin
			strokeWeight(1);

			if (events.size() >= 2 && times.size() >= 2 && Projectile.run == true) {
				stroke(0, 255, 90); // iterates through list for current and previous data
				line(times.get(i) * xscale, -(events.get(i).mag() * yscale), times.get(i + 1) * xscale,
						-(events.get(i + 1).mag() * yscale));
				i++;

				/*
				 * if (events.get(i).y * yscale < 0) { yscale /= 10F; } if (times.get(i) *
				 * xscale > width) { xscale /= 10F; }
				 */

			}
		}

		if (wipe) { // refresh background when reset
			background(255);
			wipe = false;
		}
	}

	public static void wipe() {
		wipe = true;
		t = 0;
	}
}
