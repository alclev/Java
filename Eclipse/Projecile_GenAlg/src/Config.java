import java.util.ArrayList;

import processing.core.PApplet;

public class Config {
	private float sum;
	private float optAng;
	private float koala;
	private float range;

	public Config(PApplet pap) {
		koala = 0;
	}

	public ArrayList<Projectile> sortRange(ArrayList<Projectile> a) {
		for (int j = 0; j < a.size(); j++) {
			for (int i = 1; i < a.size(); i++) {
				Projectile temp = a.get(i);
				if (a.get(i).getPos().x < a.get(i - 1).getPos().x) {
					a.set(i, a.get(i - 1));
					a.set(i - 1, temp);
				}
			}
		}
		return a;
	}

	public ArrayList<Projectile> sortAng(ArrayList<Projectile> a) {
		for (int j = 0; j < a.size(); j++) {
			for (int i = 1; i < a.size(); i++) {
				Projectile temp = a.get(i);
				if (a.get(i).getDeg() < a.get(i - 1).getDeg()) {
					a.set(i, a.get(i - 1));
					a.set(i - 1, temp);
				}
			}
		}
		return a;
	}

	public ArrayList<Projectile> mod(ArrayList<Projectile> a, float accuracy) {

		for (int i = 0; i < a.size(); i++) {
			System.out.println("Ball " + i + " Deg: " + a.get(i).getDeg() + " Range: " + a.get(i).getPos().x);

		}
		range = a.get(a.size() - 1).getPos().x;
		optAng = a.get(a.size() - 1).getDeg();

		for (int i = 0; i < a.size(); i++) {
			a.get(i).setDeg((float) (optAng + (accuracy * Math.random() - (accuracy / 2))));
			a.get(i).reset();

			System.out.println();
		}

		return a;
	}

	public float getOptAng() {
		return optAng;
	}

	public float getRange() {
		return range;
	}

	public float getAv(ArrayList<Projectile> a) {
		for (int k = (int) (0.95 * a.size()); k < a.size(); k++) {
			koala++;
			sum += a.get(k).getDeg(); // System.out.println(a.get(k).getDeg()); }
		}
		optAng = sum / koala;
		koala = 0;
		sum = 0;
		return optAng;

	}

}
