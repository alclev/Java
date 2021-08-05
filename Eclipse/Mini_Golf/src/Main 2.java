import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

	public void settings() {
		size(1000, 800);
	}

	public void setup() {
		cor = new Course(this);
		hill = new Hill(this);
		valley = new Valley(this);
		balls = new ArrayList<Ball>();
		genSize = 10000;
		for (int i = 0; i < genSize; i++) {
			balls.add(new Ball(this, (float) Math.random() * 180F, (float) Math.random() * 150F));
		} // Object, angle, velMag
		r = new PVector();
		success = new ArrayList<Ball>();
		accuracy = 20;
	}

	private Course cor;
	private Hill hill;
	private Valley valley;
	private List<Ball> balls;
	private List<Ball> success;
	private int genSize;
	private float c;
	private PVector r;
	private int t1;
	private float accuracy;

	/**
	 * 75 pixels = 1 meter
	 */

	public void draw() {
		background(255);
		imageMode(CENTER);
		rectMode(CENTER);

		/**
		 * initial parameters
		 */
		cor.course();
		hill.renderHill(75, 400, 300); // radius, x, y
		valley.renderValley(75, 550, 550);

		/**
		 * moving stuff
		 */

		if (millis() - t1 > 0) {
			for (Ball ball : balls) {
				ball.render();
				ball.update(0.1F, hill, valley);
			}
		}

		/**
		 * recreating generation
		 */

		if (balls.size() == 0) {

			success = sort(success);

			for (int m = 0; m < genSize; m++) {
				balls.add(new Ball(this,
						(float) (success.get(success.size() - 1).getAng() + (accuracy * Math.random() - accuracy / 2)),
						(float) (success.get(success.size() - 1).getVelmag()
								+ (accuracy * Math.random() - accuracy / 2))));
			}
			t1 = millis() + 500;
			if (accuracy > 0.07) {
				accuracy /= 2;
			}
			success.clear();
		}
		/**
		 * wall finder
		 */
		for (int j = 0; j < balls.size(); j++) {

			for (int i = 0; i < cor.wallsList().size(); i++) {

				if ((balls.get(j).getPos().dist(cor.wallsList().get(i).end1())
						+ balls.get(j).getPos().dist(cor.wallsList().get(i).end2())) <= (cor.wallsList().get(i).length()
								+ 1F)) {
					balls.get(j).collide(cor.wallsList().get(i));
				}

			}
			/**
			 * hills and valleys
			 */

			if (hill.inHill(balls.get(j).getPos()) && hill.distHill(balls.get(j).getPos()) > hill.getRad() / 2) {

			} // outer section

			if (hill.distHill(balls.get(j).getPos()) < hill.getRad() / 2) {

			} // inner section

			/**
			 * balls in the hole at a reasonable speed
			 */

			if (balls.get(j).getPos().dist(new PVector(500, 173, 0)) <= 10 && balls.get(j).getVel() < 5) {
				success.add(balls.get(j));
				balls.remove(j);
			}

			else if (balls.get(j) != null) {
				if (balls.get(j).getVel() < 1) { // remove balls that have slowed due to friction
					success.add(balls.get(j));
					balls.remove(j);

				}
			}
		}

	}

	public static void main(String[] args) {
		PApplet.main(new String[] { Main.class.getName() });
	}

	public List<Ball> sort(List<Ball> ball) {

		for (int i = 0; i < ball.size(); i++) {
			for (int k = 1; k < ball.size(); k++) {
				Ball temp = ball.get(k);
				if (ball.get(k).getPos().dist((new PVector(500, 173, 0))) < ball.get(i).getPos()
						.dist((new PVector(500, 173, 0)))) {
					ball.set(k, ball.get(i));
					ball.set(i, temp);
				}
			}
		}
		return ball;
	}

}
