import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * 
 * Date of creation: April 15, 2021
 * Last Date Modified: April 17, 2021
 *
 * Class DoublyLinkedList<E> to implement the data structure doubly linked list
 *         
 */
public class DoublyLinkedList<E> {
	// Data members
	private Node head, tail;
	int size;

	// Inner class Node
	private class Node {
		E value;
		Node next;
		Node previous;

		Node(E initialValue) {
			value = initialValue;
			next = null;
			previous = null;
		}
	}

	// Constructor

	public DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}

/**
 * Adds an element at the beginning of the list
 * @param item
 * @return boolean
 * Time complexity: O(1);
 */
	public boolean addFirst(E item) {
		Node newNode = new Node(item);

		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		size++;
		return true;
	}
/**
 * Adds an element at the end of the list
 * @param item
 * @return boolean
 * Time complexity: O(1)
 */
	public boolean addLast(E item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = tail = newNode;
		} else {

			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		size++;
		return true;
	}
/**
 * Adds an element to the list using the addFirst(E item) method
 * @param item
 * @return boolean
 * Time complexity: O(1)
 */
	public boolean add(E item) {
		return addFirst(item);
	}

/**
 * Returns the value of the first element of the list
 * @param no parameters
 * @return E
 * Time complexity: O(1)
 */
	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
	}
/**
 * Returns the value of the last element of the list
 * @param no parameters
 * @return E
 * Time complexity O(1)
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
	 * Removes the last element of the list
	 * @param no parameters
	 * @return boolean
	 * Time complexity: O(1)
	 */
	public boolean removeLast() {
		if (head == null)
			throw new NoSuchElementException();
		if (size == 1)
			return removeFirst();
		tail = tail.previous;
		size--;
		return true;
	}

	/**
	 * Returns information of list as a formatted string
	 * @param no parameters
	 * @return String
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
	 * Clears the list
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(1)
	 */
	public void clear() {
		head = tail = null;
		size = 0;
	}
	/**
	 * Checks to see if the list is empty
	 * @param no parameters
	 * @return boolean
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Returns the size of the list as an integer
	 * @param no parameters
	 * @return int
	 * Time complexity: O(1)
	 */
	public int size() {
		return size;
	}

/**
 * Generates an iterator for the doubly linked list
 * @param no parameters 
 * @return ListIterator<E>
 * Time complexity: O(1)
 */
	public ListIterator<E> iterator() { 
		return new DoublyLinkedListIterator();
	}
/**
 * Generates an iterator for the doubly linked list
 * @param int index 
 * @return ListIterator<E>
 * Time complexity: O(n)
 */
	public ListIterator<E> iterator(int index) {
		return new DoublyLinkedListIterator(index);
	}
	/**
	 * 
	 * private inner class for DoublyLinkedListIterator
	 *
	 */
	private class DoublyLinkedListIterator implements ListIterator<E> {
//private data member
		private Node current;
//default constructor O(1)
		public DoublyLinkedListIterator() {
			current = head;
		}
//constructor with parameter index O(n)
		public DoublyLinkedListIterator(int index) {
			if (index > size || index < 0)
				throw new ArrayIndexOutOfBoundsException();

			if (index == size) {
				current = tail;
			} else {
				current = head;
				int i = 0;
				while (i < index) {
					current = current.next; //goes until the given index 
					i++;
				}

			}
		}
/**
 * checks to see if there is another element in the list
 * @param no parameters
 * @return boolean
 * Time complexity: O(1)
 */
		public boolean hasNext() {
			return (current != null);
		}
/**
 * Returns value of the next element
 * @param no parameters
 * @return E
 * Time complexity: O(1)
 */
		public E next() {
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next;
			return value;
		}
/**
 * checks to see if there is another element in the list
 * @param no parameters
 * @return boolean
 * Time complexity: O(1)
 */
		public boolean hasPrevious() {
			return (current != null);
		}
/**
 * Returns value of the previous element
 * @param no parameters
 * @return E
 * Time complexity: O(1)
 */
		public E previous() {
			if (current == null)
				throw new NoSuchElementException();
			E value = current.value;
			current = current.previous;
			return value;

		}
//empty methods
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		public void add(E e) {
			throw new UnsupportedOperationException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
