package layer1;

import processing.core.PApplet;

public class Environment {

	public Environment(PApplet papp) {
		p = papp;
	}

	private PApplet p;
	
	public void ground() {
		p.line(0, p.height * 0.75F, p.width, p.height * 0.75F);
		p.pushStyle();
		p.fill(234, 20, 30);
		p.rect(0, p.height * 0.75F, p.width, p.height);
		p.popStyle();
	}
}
