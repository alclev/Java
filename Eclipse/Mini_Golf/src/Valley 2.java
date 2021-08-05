import processing.core.PApplet;
import processing.core.PVector;

public class Valley {
	public Valley(PApplet pap) {
		p = pap;
	}

	private PApplet p;
	private float radius;
	private PVector vPos;

	public void renderValley(float r, float x, float y) {
		radius = r;
		vPos= new PVector(x,y);
		p.pushStyle();
		p.noStroke();
		p.fill(57, 153, 52);
		p.ellipse(x, y, 2 * r, 2 * r);

		p.popStyle();

	}
	public boolean inValley(PVector pos) {
		return (distV(pos) <= radius);
	}

	public float distV(PVector pos) {
		return pos.dist(vPos);
	}
	public PVector vPos() {
		return vPos();
	}
}
