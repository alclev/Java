import java.util.ArrayList;

/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 22, 2021 
 * Last Date Modified: April 28, 2021
 * @param <E>
 * 
 * Class Heap to model a Heap
 */
public class Heap<E extends Comparable<E>> {
	// private data members
	private ArrayList<E> list;

//constructors
	public Heap() {
		list = new ArrayList<>(); // empty heap with capacity 10
	}

	public Heap(ArrayList<E> data) {
		list = new ArrayList<>();
		for (int i = 0; i < data.size(); i++)
			insert(data.get(i));
	}

	/**
	 * Method to insert element into the heap in the appropriate position
	 * 
	 * @param item
	 * @return int
	 * Time complexity: O(log n)
	 */
	public int insert(E item) { // modified for iterations
		int iterations = 0;
		list.add(item); // append item to end of the heap
		int currentIndex = list.size() - 1; // index of newly added node
		// index of the last element
		while (currentIndex > 0) { // not the root
			iterations++;
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
		return iterations;
	}

	/**
	 * Method to delete element of the heap
	 * 
	 * @param no parameters
	 * @return E
	 * Time complexity: O(log n)
	 */
	public E delete() {
		if (list.size() == 0)
			return null;
		E removedItem = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		int currentIndex = 0;
		while (currentIndex < list.size()) {
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
	 * 
	 * @param item
	 * @return int
	 * Time complexity: O(n)
	 */
	public int search(E item) {
		int iterations = 0;
		for (int i = 0; i < list.size(); i++) {
			iterations++;
			if (list.get(i).equals(item))
				return iterations;
		}
		return iterations;
	}

	/**
	 * Returns size of the heap
	 * 
	 * @param no parameters
	 * @return int
	 * Time complexity: O(1);
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Checks if heap is empty
	 * 
	 * @param no parameters
	 * @return boolean
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Clears the heap
	 * 
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(1)
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * Method to return the information in the heap as a formatted string
	 * 
	 * @param no parameters
	 * @return String
	 * Time complexity: O(n)
	 */

	public String toString() {
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i) + "\n";
		}
		return result;
	}
/**
 * Method to find the amount of leafNodes in a heap
 * @param no parameters
 * @return int 
 * Time complexity: O(log n)
 */
	public int leafNodes() {
		return leafNodes(0);
	}
//Recursive helper method for leafNodes()
	private int leafNodes(int i) {
		if (i < list.size() && (2 * i + 2) < list.size() && (2 * i + 1) < list.size()) {
			if (list.get(i) == null) {
				return 0;

			} else if (list.get(2 * i + 1) == null && list.get(2 * i + 2) == null) {

				return 1; //essentially same algorithm as BST on left = list.get(2 * i + 1) 
				//and right = list.get(2 * i + 2)

			} else {

				return leafNodes((2 * i + 1)) + leafNodes((2 * i + 2));
			}
		}
		return 1;
	}
	/**
	 * Method that returns the height of a heap
	 * @param no parameters
	 * @return int
	 * Time complexity O(log n)
	 */
	public int height() {
		return height(0) + 1; //adds one to convert the maximum depth into height 
	}
//recursive helper method for height()
	private int height(int i) {
		if (i < list.size() && (2 * i + 2) < list.size() && (2 * i + 1) < list.size()) {
			int left = 0;
			int right = 0;
			if (list.get(i) == null) {
				return 0;
			} else {
				left = height(2 * i + 1); //recursive portion
				right = height(2 * i + 2);
			}
			int max = Math.max(left, right);
			return 1 + max;
		}
		return 0;
	}
	/**
	 * Method that determines whether a heap is balanced or not
	 * @param no parameters 
	 * @return boolean
	 * Time complexity O(log n)
	 */
	public boolean isBalanced() {
		return isBalanced(0);
	}
//recursive helper method for isBalanced()
	private boolean isBalanced(int i) {
		if (i < list.size() && (2 * i + 2) < list.size() && (2 * i + 1) < list.size()) {
			if (Math.abs((height(2 * i + 1) + 1) - (height(2 * i + 2) + 1)) <= 1) {
				return isBalanced(2 * i + 1) && isBalanced(2 * i + 2);
			}
		}
		return true; //returns true on the outside here because of the outermost if statement
		//if this if statement is false, then the entire heap has been traversed without setting the 
		//insider return to false
	}

}