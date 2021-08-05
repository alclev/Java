import java.util.ArrayList;

public class Generator {
	public Generator() {
		dist = new ArrayList<>();
	}

	private ArrayList<Float> dist;

	public ArrayList<Float> gen(float target, float standev, int num) {
		
		double random = 0.1F + Math.random() * (0.005);

		for (int i = 0; i < num; i++) {
			float x = (float) (target + (standev
					* Math.sqrt(Math.abs(Math.log(2 * Math.PI * Math.pow(standev, 2) * Math.pow(random, 2))))));
			float y = (float) (target - (standev
					* Math.sqrt(Math.abs(Math.log(2 * Math.PI * Math.pow(standev, 2) * Math.pow(random, 2))))));
			if (i % 2 == 0) {
				dist.add(x);
			} else {
				dist.add(y);
			}
		}

		return dist;
	}

	public ArrayList<Float> sort(ArrayList<Float> dist) {
		for (int k = 0; k < dist.size(); k++) {
			for (int i = 1; i < dist.size(); i++) {
				if (dist.get(i) < dist.get(k)) {
					float temp = dist.get(i);
					dist.set(i, dist.get(k));
					dist.set(k, temp);
				}
			}

		}
		
		return dist;
	}

	public static void main(String[] args) {
		Generator gen = new Generator();

		System.out.println((gen.gen(0, 5, 100)));
	}
}
