import processing.core.PApplet;

public class Fuel extends PApplet {
	public Fuel() {
		PApplet.runSketch(new String[] { this.getClass().getSimpleName() }, this);
	}

	public void settings() {
		size(300, 600);
	}

	public void setup() {

	}

	public void draw() {
		background(255);
		fill(0);
		textSize(32);
		text("MAX FUEL", width / 4, 30);
		text("CRITICAL", width / 4, height - 5);

		pushStyle();
		fill(255);
		strokeWeight(5);
		rect(55, 50, 200, 500);
		popStyle();

		pushMatrix();
		pushStyle();
		noStroke();
		rectMode(CORNERS);
		translate(55, 550);
		fill(255 * JumpMan.moniterFuel(), 255 - (JumpMan.moniterFuel() * 25.5F), 0);
		//changes color according to current time of thrust (fuel)
		if (-500 + JumpMan.moniterFuel() * 50 <= 0) { //within bounds of rectangle
			rect(0, 0, 200, -500 + JumpMan.moniterFuel() * 50);
		} //fuel guage
		
		popStyle();
		popMatrix();

	}
}
