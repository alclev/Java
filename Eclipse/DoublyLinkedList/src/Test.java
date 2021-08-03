import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * 
 * Date of creation: April 15, 2021
 * Last Date Modified: April 17, 2021
 *
 * Testing class to test the implementations of the linked list and doubly linked list classes
 *         
 */
public class Test {

	public static void main(String[] args) {

//instantiation of the the linkedlist and doublylinkedlist
		LinkedList<String> countryLL = new LinkedList<String>(); 
		DoublyLinkedList<String> countryDLL = new DoublyLinkedList<String>();

		// reading from the file

		File file = new File("countries.txt");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		while (readFile.hasNextLine()) {

			String country = readFile.nextLine();

			countryLL.addLast(country);
			countryDLL.addLast(country);

		}
		readFile.close();
//printing the linked list forward
		System.out.println("Linked List (Forward): \n");
		printLLForward(countryLL);
//printing the linked list backwards
		System.out.println("Linked List (Backward): \n");
		printLLBackward(countryLL);
//printing the doubly linked list forward
		System.out.println("Doubly Linked List (Forward): \n");
		printDLLForward(countryDLL);
//printing the doubly linked list backwards
		System.out.println("Doubly Linked List (Backward): \n");
		printDLLBackward(countryDLL);

	}
/**
 * Prints linked list elements forward O(n)
 * @param list
 * 
 */
	public static <E> void printLLForward(LinkedList<E> list) {

		Iterator<E> iter = list.iterator(); //creates iteratior

		String output = "[";
		while (iter.hasNext()) {
			output += iter.next();
			if (iter.hasNext())
				output += ", "; //ensures that a comma and a space are not ended to the last element
		}
		output += "]";
		System.out.println(output + "\n");
	}
/**
 * Prints linked list elements backwards O(n^2)
 * @param list
 * 
 */
	public static <E> void printLLBackward(LinkedList<E> list) {

		int i = list.size() - 1;
		String output = "[";
		while (i >= 0) {
			output += list.get(i);
			if (i > 0) { //ensures that a comma and a space are not ended to the last element
				output += ", ";
			}
			i--;
		}
		output += "]";
		System.out.println(output + "\n");
	}
/**
 * Prints doubly linked list elements forward O(n)
 * @param list
 * 
 */
	public static <E> void printDLLForward(DoublyLinkedList<E> list) {

		ListIterator<E> iter = list.iterator(); //creates iterator
		String output = "[";
		while (iter.hasNext()) {
			output += iter.next();
			if (iter.hasNext()) //ensures that a comma and a space are not ended to the last element
				output += ", ";
		}
		output += "]";
		System.out.println(output + "\n");

	}
/**
 * Prints doubly linked list elements backwards O(n)
 * @param list
 * 
 */
	public static <E> void printDLLBackward(DoublyLinkedList<E> list) {
		ListIterator<E> iter = list.iterator(list.size()); //creates iterator that starts at the end of the list
		String output = "[";
		while (iter.hasPrevious()) {
			output += iter.previous();
			if(iter.hasPrevious()) //ensures that a comma and a space are not ended to the last element
				output += ", ";
		}
		output += "]";
		System.out.println(output + "\n");

	}
	/**
	 * Comparison of the four methods: all have time complexity of O(n) except printLLBackwards which is O(n^2)
	 * this means that printLLBackwards is the least efficient of the four- probably because it does not use an iterator
	 */
}
