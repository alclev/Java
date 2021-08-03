import java.util.Iterator;

public class ArrayList<E> {
	// data members
	private E[] elements;
	private int size;

	// Constructors
// O(1)
	public ArrayList() { 
		elements = (E[]) new Object[10];
		size = 0;
	}
// O(1)
	public ArrayList(int capacity) { 
		elements = (E[]) new Object[capacity];
		size = 0;
	}


	/**
	 * Adding an item to the list (2 methods)
	 * @param index
	 * @param item
	 * @return boolean
	 * 
	 * Time complexity: O(n)
	 */
	public boolean add(int index, E item) { 
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		ensureCapacity();
		for (int i = index; i < size - 1; i++)
			elements[i + 1] = elements[i];
		elements[index] = item;
		size++;
		return true;
	}
/**
 * Adds item to the list
 * @param item
 * @return boolean
 * 
 * Time complexity: O(n)
 */
	public boolean add(E item) { 
		return add(size, item);
	}

	// Getter and Setter
	
	/**
	 * Access to the data member stored in the list at a given index
	 * @param index
	 * @return E
	 * 
	 * time complexity: O(1)
	 */
	public E get(int index) { 
		checkIndex(index);
		return elements[index];
	}
/**
 * Sets the value at given index and E item
 * @param index
 * @param item
 * @return E
 * 
 * Time complexity: O(1)
 */
	public E set(int index, E item) { 
		checkIndex(index);
		E oldItem = elements[index];
		elements[index] = item;
		return oldItem;
	}

/**
 * Returns the size of the list
 * @return int
 * Time complexity: O(1)
 */
	public int size() { 
		return size;
	}

	
/**
 * Removing an item from the list
 * @param index
 * @return boolean
 * Time complexity: O(n)
 */
	public boolean remove(int index) { 
		checkIndex(index);
		for (int i = index; i < size - 1; i++)
			elements[i] = elements[i + 1];
		size--;
		return true;
	}
/**
 * Clears the list
 * @param no parameters
 * @return no return value
 * Time complexity: O(1)
 */
	
	public void clear() { 
		size = 0;
	}

	/**
	 * Checks if the list is empty
	 * @param no parameters
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() { 
		return (size == 0);
	}

	
	/**
	 * Shrink the list to size
	 * 
	 * @param no parameters
	 * @return no return value
	 * 
	 * Time complexity: O(n)
	 */
	public void trimToSize() { 
		if (size != elements.length) {
			E[] newElements = (E[]) new Object[size];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}

	
	/**
	 * Grow the list if needed
	 * 
	 * @param no parameters
	 * @return no return value
	 * 
	 * Time complexity: O(n)
	 */
	private void ensureCapacity() { 
		if (size >= elements.length) {
			int newSize = (int) (elements.length * 1.5);
			E[] newElements = (E[]) new Object[newSize];
			for (int i = 0; i < size; i++)
				newElements[i] = elements[i];
			elements = newElements;
		}
	}
	
	/**
	 * Check if the index is valid
	 * 
	 * @param index
	 * @return no return value
	 * 
	 * Time complexity: O(1)
	 */
	private void checkIndex(int index) { 
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds. Must be between 0 and " + (size - 1));
	}

	/**
	 * toString() method
	 * 
	 * @param no parameters
	 * @return String
	 * 
	 * Time complexity: O(n)
	 */
	public String toString() { 
		String output = "[";
		for (int i = 0; i < size - 1; i++)
			output += elements[i] + " ";
		output += elements[size - 1] + "]";
		return output;
	}

	/**
	 * Iterator for the list
	 * 
	 * @param no parameters
	 * @return Iterator<E>
	 * 
	 * Time complexity: O(1)
	 */
	public Iterator<E> iterator() { 
		return new ArrayIterator();
	}
	/**
	 * Inner class ArrayIterator
	 *
	 */

	private class ArrayIterator implements Iterator<E> {
		private int current = -1;
//O(1)
		public boolean hasNext() {
			return current < size - 1;
		}
//O(1)
		public E next() {
			return elements[++current];
		}
	}
	/**
	 * Number of iterations from the linear search algorithm 
	 * 
	 * @param E item
	 * @return item
	 * 
	 * Time complexity: O(n)
	 */
	public int searchComparisons(E item) {
		int iterations = 0; 
		Iterator<E> iter = iterator();
		while(iter.hasNext()) {
			iterations++;
			if(iter.next().equals(item)) {
				return iterations;
			}
		}
		return iterations;
	}
}