import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * 
 * Date of creation: April 15, 2021
 * Last Date Modified: April 17, 2021
 *
 * Class LinkedList<E> to implement the data structure linked list
 *         
 */
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

	// Adding an item to the list
	
/**
 * Adds element to the head of linked list
 * @param item
 * @return boolean
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
 * Adds element to the tail of linkedlist
 * @param item
 * @return boolean
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
 * Adds element using the addFirst(E item) method
 * @param item
 * @return boolean
 */
	public boolean add(E item) {
		return addFirst(item);
	}

/**
 * Gets the value of the head of the list
 * @param no parameters
 * @return E
 */
	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
	}
/**
 * Gets the value of the tail of the list
 * @param no parameters
 * @return E
 */
	public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
	}

/**
 * Removes the first element of the list
 * @param no parameters
 * @return boolean
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
 * Removes the last element of the list 
 * @param no parameters
 * @return boolean
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
 * Returns information of list as a formatted string
 * @param no parameters
 * @return String
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
 * Clears the list
 * @param no parameters
 * @return no return value
 */
	public void clear() {
		head = tail = null;
		size = 0;
	}
/**
 * Checks to see if the list is empty
 * @param no parameters
 * @return boolean
 */
	public boolean isEmpty() {
		return (size == 0);
	}
/**
 * Returns the size of the list as an integer
 * @param no parameters
 * @return int
 */
	public int size() {
		return size;
	}

/**
 * Generates an Iterator for a linkedlist
 * @param no parameters
 * @return Iterator<E>
 */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
/**
 * 
 * private inner class for LinkedListIterator
 *
 */
	private class LinkedListIterator implements Iterator<E> {
//private data members
		private Node current = head;
//checks to see if there is another element
		public boolean hasNext() {
			return (current != null);
		}
//returns the next value in the list
		public E next() {
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next;
			return value;
		}

	}

	/**
	 * Returns the value at a given index of the list
	 * @param index
	 * @return E
	 * 
	 * Time complexity: O(n)
	 */
	public E get(int index) {
		
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException();

		int count = 0;
		Node current = head;
		
		while(count < index) {
			current = current.next;
			count++;
		}
		return current.value;
	}
}
