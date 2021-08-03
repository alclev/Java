
public class Test {

	public static void main(String[] args) {

		ShapeAL crescent = new ShapeAL();
		crescent.add(new Pair(30, 50));
		crescent.add(new Pair(25, 40));
		crescent.add(new Pair(25, 30));
		crescent.add(new Pair(30, 20));
		crescent.add(new Pair(40, 10));

		ShapeLL hexagon = new ShapeLL();
		hexagon.add(new Pair(50, 60));
		hexagon.add(new Pair(40, 40));
		hexagon.add(new Pair(50, 20));
		hexagon.add(new Pair(70, 20));
		hexagon.add(new Pair(90, 40));
		hexagon.add(new Pair(70, 60));
		hexagon.add(new Pair(50, 60));

		

		Pair<Integer, Integer> p1 = new Pair(50, 60);
/**
 * Testing methods of CRESCENT
 */
		System.out.println("Shape crescent: " + crescent.toString());
		if (crescent.containsPoint(p1)) {
			System.out.println("Shape crescent contains the point " + p1.toString());
		} else {
			System.out.println("Shape crescent does NOT contain the point " + p1.toString());
		}

		if (crescent.isClosed()) {
			System.out.println("Shape crescent is closed");
		} else {
			System.out.println("Shape crescent is open");
		}
/**
 * Testing methods of HEXAGON
 */
		System.out.println("Shape hexagon: " + hexagon.toString());
		if (hexagon.containsPoint(p1)) {
			System.out.println("Shape hexagon contains the point " + p1.toString());
		} else {
			System.out.println("Shape hexagon does NOT contain the point " + p1.toString());
		}

		if (hexagon.isClosed()) {
			System.out.println("Shape hexagon is closed");
		} else {
			System.out.println("Shape hexagon is open");
		}

	}

}
