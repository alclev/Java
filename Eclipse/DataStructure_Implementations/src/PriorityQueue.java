import java.util.Iterator;
/**
 * 
 * @author alexclevenger
 *
 * All methods are O(1) except offer() and toString() which are O(n)
 */
public class PriorityQueue<E extends Comparable<E>> {
	private LinkedList<E> list;

	public PriorityQueue() {
		list = new LinkedList<>();
	}

	public void offer(E item) {
		Iterator<E> queueIterator = list.iterator();
		int index = 0;
		while (queueIterator.hasNext()) {
			E current = queueIterator.next();
			if (item.compareTo(current) < 0) {
				break;
			}
			index++;
		}
		list.add(index, item);// method in LinkedList
	}

	public E poll() {
		E value = list.getFirst();
		list.removeFirst();
		return value;
	}

	public E peek() {
		return list.getFirst();
	}

	public String toString() {
		return "Priority Queue: " + list.toString();
	}

	public int size() {
		return list.size();
	}

	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

}