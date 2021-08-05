import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

public class Course {
	public Course(PApplet pap) {
		p = pap;
		flag = p.loadImage("flag.jpg");
		flag.resize(30, 90);
		cour = p.createShape();
		cour.beginShape();
		// window size is 1000, 800
		cour.fill(162, 194, 118);

		vertex1 = new PVector(200, 50);
		vertex2 = new PVector(p.width - 200, 50);
		vertex3 = new PVector(p.width - 200, p.height - 50);
		vertex4 = new PVector(200, p.height - 50);
		//
		cour.vertex(vertex1.x, vertex1.y);
		cour.vertex(vertex2.x, vertex2.y);
		cour.vertex(vertex3.x, vertex3.y);
		cour.vertex(vertex4.x, vertex4.y);
		cour.vertex(vertex1.x, vertex1.y);
		//
		cour.endShape();
		walls = new ArrayList<Wall>();
		walls.add(new Wall(vertex1, vertex2));
		walls.add(new Wall(vertex2, vertex3));
		walls.add(new Wall(vertex3, vertex4));
		walls.add(new Wall(vertex4, vertex1));
	}

	private PApplet p;
	private PImage flag;
	private PShape cour;
	private ArrayList<Wall> walls;

	private PVector vertex1;
	private PVector vertex2;
	private PVector vertex3;
	private PVector vertex4;

	public void course() {
		p.pushStyle();
		p.shape(cour, 0, 0);
		p.popStyle();

		p.image(flag, p.width / 2, p.displayHeight * 0.15F);
	}

	public ArrayList<Wall> wallsList() {
		return walls;
	}

}
