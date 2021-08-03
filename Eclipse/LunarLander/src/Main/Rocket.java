package Main;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Rocket {

	public Rocket(PApplet papp) {
		p = papp;
		pos = new PVector(p.width / 2, 100, 0);
		acc = new PVector(0, 9.8F, 0);
		vel = new PVector(0, -10, 0);
		thrust = new PVector(0, 0, 0);
		onPlatform = true; // is man on or off platforms
		rocket= papp.loadImage("rocket.png");
	}

	private PImage rocket;
	private PApplet p;
	private PVector pos;
	private PVector acc;
	private PVector vel;
	private PVector mg;
	private PVector thrust;
	private Boolean onPlatform;

	public void render() {
		p.imageMode(PApplet.CENTER);  //measures from center of image
		p.image(rocket, pos.x, pos.y, 40, 40);
	}

	public void update(float dt) {

		pos.add(PVector.mult(vel, dt));

		float m = 150F; // Kg
		float c = 0.42F;
		float r = 0.5F; // m
		float a = PApplet.sq(r) * PApplet.PI;
		float p = 1.15F; // kg/m^2

		PVector v = vel.copy().normalize();
		mg = PVector.mult(acc, m);
		PVector drag = PVector.mult(v, -0.5F * c * a * p * vel.magSq());
		PVector comb = PVector.add(drag, mg);
		PVector netF = PVector.add(thrust, comb);
		PVector ac = PVector.div(netF, m);
		vel.add(PVector.mult(ac, dt));
	}

	public void thrust(PVector add) {
		thrust.add(add); // thrust method
	}

	public void thrustOff() {
		thrust = new PVector(0, 0, 0); // turns off thrust (obviously)
	}

	public PVector getPos() {
		return pos; // accessor method
	}

	public void flames(char test) {
		p.pushStyle();
		p.fill(255, 50, 50); // 88.6F, 34.5F, 13.3F
		switch (test) {
		case ('R'):
			p.triangle(pos.x - 10, pos.y + 30, pos.x - 5, pos.y + 10, pos.x - 15, pos.y + 10);
			p.triangle(pos.x + 10, pos.y + 20, pos.x + 5, pos.y + 10, pos.x + 15, pos.y + 10);
			break;
		case ('L'):
			p.triangle(pos.x + 10, pos.y + 30, pos.x + 5, pos.y + 10, pos.x + 15, pos.y + 10);
			p.triangle(pos.x - 10, pos.y + 20, pos.x - 5, pos.y + 10, pos.x - 15, pos.y + 10);
			break;
		case ('B'):
			p.triangle(pos.x - 10, pos.y + 30, pos.x - 5, pos.y + 10, pos.x - 15, pos.y + 10);
			p.triangle(pos.x + 10, pos.y + 30, pos.x + 5, pos.y + 10, pos.x + 15, pos.y + 10);
			break;
		}
		p.popStyle();
	}

	public void boundary() {
		if (pos.x > p.width - 20) {
			pos.x = p.width - 20;
			vel.x *= -0.4; // bounce off right edge of the screen
		}

		if (pos.x < 20) {
			pos.x = 20; // bounce off left side of screen
			vel.x *= -0.4;
		}

		if (pos.y < 20) {
			pos.y = 20; // bounce off the top side of the screen
			vel.y *= -0.5;
		}

	}

	public void reset() {
		pos.set(p.width / 2, p.height / 2, 0);
		vel.set(0, -10, 0); // part of the resetting process
	}

	public void landing(Rocket plat) {
		if (pos.y > p.displayHeight * 0.75) {
			vel.set(0,0,0);
			onPlatform = true; // flips boolean in update method for man
		}

		if (pos.x > plat.getPos().x - 5 && pos.x < plat.getPos().x + 60 && pos.y < plat.getPos().y + 40
				&& pos.y > plat.getPos().y) {
			pos.y = plat.getPos().y + 40;
			vel.y *= -1; // checks whether man is hitting BOTTOM of platform

		}

	}

	public void onPlatform(boolean swit) {
		onPlatform = swit; // allows user to change onPlatform boolean
	}

	public boolean isOn() {
		return onPlatform; // accessor method
	}

}
