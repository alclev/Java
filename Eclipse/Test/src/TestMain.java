import processing.core.PApplet;

public class TestMain extends PApplet {

	public int add(int a, int b) {
		return a + b;
	}

	public void settings() {
		size(400,400);
	}

	public void setup() {

	}

	public void draw() {

	}

	public static void main(String[] args) {
		PApplet.main("Main");
		TestMain t = new TestMain();
		System.out.println(t.add(1, 2));
	}
}
