import java.util.ArrayList;
import java.util.Iterator;

public class ShapeAL {

	private ArrayList<Pair<Integer, Integer>> points;

	public ShapeAL() {
		points = new ArrayList<Pair<Integer, Integer>>(10);
	}

	public void add(Pair<Integer, Integer> p) {
		points.add(p);
	}
/**
 * Note- the get(int index) method on an arrayList is O(1) 
 * 
 * 
 * Time complexity: O(1)
 */
	public boolean isClosed() {
		return points.get(0).equals(points.get(points.size() - 1));
	}
/**
 * 
 * Time complexity: O(n)
 * 
 * worst case the method iterates through the entire list recursively
 */
	public boolean containsPoint(Pair<Integer, Integer> p) {
		Iterator<Pair<Integer, Integer>> iter = points.iterator();
		return findElement(p, iter.next(), iter);
	}

	public boolean findElement(Pair<Integer, Integer> p, Pair<Integer, Integer> p2,
			Iterator<Pair<Integer, Integer>> iter) {

		if (p.equals(p2)) {
			return true;
		}
		if (!iter.hasNext()) {
			return false;
		} else {
			return findElement(p, iter.next(), iter);
		}
	}

	public String toString() {
		return points.toString();
	}

}
