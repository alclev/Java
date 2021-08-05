import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {

	// Data members
	private Node head, tail;
	int size;

	// Inner class Node
	private class Node {
		E value;
		Node next;

		Node(E initialValue) {
			value = initialValue;
			next = null;
		}
	}

	// Constructor
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	/**
	 * Adding an item to the list
	 * 
	 * @param E item
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean addFirst(E item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return true;
	}
	/**
	 * Adding an item to the list
	 * 
	 * @param E item
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean addLast(E item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}
	/**
	 * Adding an item to the list
	 * 
	 * @param E item
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean add(E item) {
		return addFirst(item);
	}

	/**
	 * Retrieving an item from the list
	 * 
	 * @param no parameters
	 * @return E
	 * 
	 * Time complexity: O(1)
	 */
	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
	}
	/**
	 * Retrieving an item from the list
	 * 
	 * @param no parameters
	 * @return E
	 * 
	 * Time complexity: O(1)
	 */
	public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
	}

	/**
	 *  Removing an item from the list
	 * 
	 * @param no parameters
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean removeFirst() {
		if (head == null)
			throw new NoSuchElementException();
		head = head.next;
		if (head == null)
			tail = null;
		size--;
		return true;
	}
	/**
	 * Removing an item from the list
	 * 
	 * @param no parameters
	 * @return boolean
	 * 
	 * Time complexity: O(n)
	 */
	public boolean removeLast() {
		if (head == null)
			throw new NoSuchElementException();
		if (size == 1)
			return removeFirst();
		Node current = head;
		Node previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		tail = previous;
		size--;
		return true;
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
		Node current = head;
		while (current != null) {
			output += current.value + " ";
			current = current.next;
		}
		output += "]";
		return output;
	}

	/**
	 * clear, check if empty, and size of the list
	 * 
	 * @param no parameters
	 * @return no return value
	 * 
	 * Time complexity: O(1)
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Checking if the list is empty
	 * 
	 * @param no parameters
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Gets the size of the list
	 * 
	 * @param no parameters
	 * @return int
	 * 
	 * Time complexity: O(1)
	 */
	public int size() {
		return size;
	}

	/**
	 * Generating an iterator for the list
	 * 
	 * @param no parameters
	 * @return Iterator<E>
	 * 
	 * Time complexity: O(1)
	 */
	public Iterator<E> iterator() { //O(1)
		return new LinkedListIterator();
	}
//Inner class for the Iterator
	private class LinkedListIterator implements Iterator<E> {
		private Node current = head;

		public boolean hasNext() {
			return (current != null); //O(1)
		}

		public E next() { //O(1)
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next;
			return value;
		}

	}
	/**
	 * Adding an item to the list
	 * 
	 * @param E item, E item
	 * @return boolean
	 * 
	 * Time complexity: O(1)
	 */
	public boolean add(int index, E item) {
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();
		if (index == 0) {
			return addFirst(item);
		}
		if (index == size) {
			return addLast(item);
		}
		Node current = head;
		Node previous = null;
		int i = 0;
		while (i < index) {
			previous = current;
			current = current.next;
			i++;
		}
		Node newNode = new Node(item);
		previous.next = newNode;
		newNode.next = current;
		size++;
		return true;
	}
	/**
	 * Gets the number of iterations for the linear search for a given element
	 * 
	 * @param E item
	 * @return int
	 * 
	 * Time complexity: O(n)
	 */
	public int searchComparisons(E item) { 
		int iterations = 0;
		Iterator<E> iter = iterator();
		while (iter.hasNext()) {
			iterations++;
			if (iter.next().equals(item)) {
				return iterations;
			}
		}
		return iterations;
	}
}