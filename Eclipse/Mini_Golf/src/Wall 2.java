import processing.core.PVector;

public class Wall {
	public Wall(PVector end1, PVector end2) {
		this.end1 = end1;
		this.end2 = end2;
	}

	private PVector end1;
	private PVector end2;

	public float length() {
		return end1.dist(end2);
	}

	public PVector end1() {
		return end1;
	}

	public PVector end2() {
		return end2;
	}

	public PVector wall() {
		return PVector.sub(end1, end2);
	}

}
