import java.util.Iterator;
import java.util.LinkedList;

public class ShapeLL {

	private LinkedList<Pair<Integer, Integer>> points;

	public ShapeLL() {
		points = new LinkedList<Pair<Integer, Integer>>();
	}

	public void add(Pair<Integer, Integer> p) {
		points.addLast(p);
	}
/**
 * Note— both the time complexities of getFirst() and getLast() are O(1)
 * 
 * 
 * Time complexity: O(1)
 */
	public boolean isClosed() {
		return points.getFirst().equals(points.getLast());
	}
/**
 * 
 * Time complexity: O(n)
 * 
 * Worst case: containsPoint iterates through the entire list recursively
 */
	public boolean containsPoint(Pair<Integer, Integer> p) {
		Iterator<Pair<Integer, Integer>> iter = points.iterator();
		return findElement(p, points.get(0), iter);
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
