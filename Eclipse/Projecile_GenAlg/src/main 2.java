import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author alexclevenger height= 4 speed= 40 rad= 0.2 mass= 5 p= 1.2 drag co=
 *         0.5 possible error in range
 */

public class Main extends PApplet {
	public void settings() {
		size(1200, 600);
	}

	public void setup() {
		frameRate(1000);
		balls = new ArrayList<Projectile>();
		genSize = 89;
		x = 1;
		count = 0;
		genCount = 1;
		minip = new Config(this);
		while (count < genSize) {
			balls.add(new Projectile(this, x)); // original generation
			x++;
			count++;

		}
		accuracy = 10;

	}

	private ArrayList<Projectile> balls;
	private int genSize;
	private float x;
	private int count;
	private float genCount;
	private long t1;
	private Config minip;
	private float accuracy;

	public void draw() {
		if (millis() - t1 > 0) {
			if (frameCount % 75 == 0) {
				background(255, 182, 193);
				pushStyle();
				fill(0);
				textSize(16);
				text("Generation #" + (int) genCount, 50, 75);
				text("Optimum Angle: " + minip.getOptAng() + " deg", 50, 125);
				text("Range: " + minip.getRange()+" m", 50, 150);
				popStyle();
				for (Projectile pro : balls) {
					pro.render();
				}
			}
			for( Projectile pro: balls) {
				pro.land();
				pro.update(0.01F);
			}
		}
		balls = minip.sortAng(balls);
		if (balls.get(balls.size() - 1).isLand()) {
			if (genCount % 5 == 0) {
				accuracy /= 4;
			}
			t1 = millis() + 500;
			balls = minip.mod(minip.sortRange(balls), accuracy);
			genCount++;
		}

	}

	public void keyPressed() {

		if (key == ' ') {
			noLoop();

		}

		if (key == 'r') {
			for (Projectile pro : balls) {
				pro.reset();
			}
		}
	}

	public void keyReleased() {
		if (key == ' ') {
			loop();
		}
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });
	}

}
