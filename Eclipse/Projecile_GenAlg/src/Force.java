import processing.core.PApplet;
import processing.core.PVector;

public class Force {

	public PVector net(PVector a, PVector b) {
		return PVector.add(a, b);
	}

	public PVector net(PVector a, PVector b, PVector c) {
		return PVector.add(PVector.add(a, b), c);
	}

	public PVector net(PVector a, PVector b, PVector c, PVector d) {
		return PVector.add(PVector.add(PVector.add(a, b), c), d);
	}
	public PVector drag(float diam, PVector vel) {
		float c = 0.24F;
		float r = diam / 2; // m
		float a = PApplet.sq(r) * PApplet.PI;
		float p = 1.2F; // kg/m^2
		
		PVector wind= new PVector (0,0,0);
		PVector windvel= PVector.sub(vel, wind);
		PVector v = windvel.copy().normalize();
	
		PVector drag = PVector.mult(v, -0.5F * c * a * p * windvel.magSq());
		
		
		float k = (float) (7*Math.pow(10, -5));
		float spinRate= 120; //radians per second
		
		PVector w= new PVector(0,0,-spinRate);
		PVector liftForce= PVector.mult(w.cross(windvel),k);
		return PVector.add(drag, liftForce);
	}
}
