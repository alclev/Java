import processing.core.PApplet;
import processing.core.PVector;

public class Hill {
	public Hill(PApplet pap) {
		p = pap;
	}

	private PApplet p;
	private float radius;
	private PVector hillPos;

	public void renderHill(float r, float x, float y) {
		radius = r;
		hillPos = new PVector(x, y);
		p.pushStyle();
		p.noStroke();
		p.fill(80, 245, 71);
		p.ellipse(x, y, 2 * r, 2 * r);

		p.popStyle();

	}

	public boolean inHill(PVector pos) {
		return (distHill(pos) <= radius);
	}

	public float distHill(PVector pos) {
		return pos.dist(hillPos);
	}
	public float getRad() {
		return radius;
	}
	public PVector hillPos() {
		return hillPos;
	}
}
