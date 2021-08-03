import java.util.ArrayList;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 7, 2021 
 * Last Date Modified: May 10, 2021
 * @param <E>
 * 
 * Class Heap to model a Heap
 */
public class Heap<E extends Comparable<E>> {
	//private data members
	private ArrayList<E> list;
//constructors
	public Heap() {
		list = new ArrayList<>(); // empty heap with capacity 10
	}

	public Heap(E[] data) {
		list = new ArrayList<>();
		for (int i = 0; i < data.length; i++)
			insert(data[i]);
	}
	public Heap(ArrayList<E> data) {
		list = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			Sort.iterations[5] ++;
			insert(data.get(i));
		}
	}
/**
 * Method to insert element into the heap in the appropriate position
 * @param item
 * @return int
 */
	public void insert(E item) { //modified for iterations
		list.add(item); // append item to end of the heap
		int currentIndex = list.size() - 1; // index of newly added node
		// index of the last element
		while (currentIndex > 0) { // not the root
			Sort.iterations[5] ++;
			int parentIndex = (currentIndex - 1) / 2;
			// swap if current is greater than its parent
			E current = list.get(currentIndex);
			E parent = list.get(parentIndex);
			if (current.compareTo(parent) > 0) {
				list.set(currentIndex, parent);
				list.set(parentIndex, current);
			} else
				break; // the tree is a heap
			currentIndex = parentIndex;
		}
	}
/**
 * Method to delete element of the heap
 * @param no parameters 
 * @return E
 */
	public E delete() {
		if (list.size() == 0)
			return null;
		E removedItem = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			Sort.iterations[5] ++;
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			// find the maximum of the two children
			if (left >= list.size())
				break;// reached the end
			int maxIndex = left;
			E max = list.get(maxIndex);
			if (right < list.size())
				if (max.compareTo(list.get(right)) < 0)
					maxIndex = right;
			E current = list.get(currentIndex);
			max = list.get(maxIndex);
			if (list.get(currentIndex).compareTo(max) < 0) {
				list.set(maxIndex, current);
				list.set(currentIndex, max);
				currentIndex = maxIndex;
			} else
				break; // the tree is a heap
		}
		return removedItem;
	}
/**
 * Method to search for an element in the heap 
 * @param item
 * @return int
 */
	public int search(E item) {
		int iterations = 0;
		for (int i = 0; i < list.size(); i++) {
			iterations ++;
			if (list.get(i).equals(item))
				return iterations;
		}
		return iterations;
	}
/**
 * Returns size of the heap
 * @param no parameters
 * @return int 
 */
	public int size() {
		return list.size();
	}
	/**
	 * Checks if heap is empty 
	 * @param no parameters
	 * @return boolean 
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	/**
	 * Clears the heap 
	 * @param no parameters
	 * @return no return value
	 */
	public void clear() {
		list.clear();
	}
/**
 * Method to return the information in the heap as a formatted string
 * @param no parameters
 * @return String 
 */
	public String toString() {
		return list.toString();
	}
}