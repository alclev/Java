
import processing.core.PApplet;
import processing.core.PVector;

public class Platform {

	public Platform(PApplet papp, PVector poss) {
		p = papp;
		pos = poss;
	}

	private PApplet p;
	private PVector pos;

	public void render() {
		p.pushStyle();
		p.fill(0);
		p.rect(pos.x, pos.y, 55, 20, 7); //simple rectangle for the platform
		p.popStyle();
	}

	public void update(float speed) {
		pos.y += speed;  //do not move with physical accuracy but they do not need to
	}

	public PVector getPos() {
		return pos;  //accessor method
	}
}
