import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 22, 2021 
 * Last Date Modified: April 25, 2021
 * @param <E>
 * 
 * Testing class for heap and BST
 */
public class AnimalDB {

	public static void main(String[] args) {
//Instantiating a BST and Heap of stringds
		BST<String> animalBST = new BST<>();
		Heap<String> animalHeap = new Heap<>();
//Instantiating an ArrayList
		ArrayList<String> animalAL = new ArrayList<>();

		// reading from the file

		File file = new File("animals.txt");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		while (readFile.hasNextLine()) {

			String animal = readFile.nextLine();
			animalAL.add(animal);
		}
		readFile.close();

		// Unsorted List
		int bstInsert = 0, heapInsert = 0;
		for (int i = 0; i < animalAL.size(); i++) {
			bstInsert += animalBST.insert(animalAL.get(i)); //transferring over from arrayList
			heapInsert += animalHeap.insert(animalAL.get(i)); // # of iterations added to variables 
		}
		System.out.println("Average number of iterations for BST and Heap (Unsorted list)");
		System.out.println("BST: " + bstInsert / animalAL.size() + "\tHeap: " + heapInsert / animalAL.size());

		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int index = random.nextInt(animalAL.size());
			String name = animalAL.get(index); //random index
			int bsti = animalBST.search(name);  //testing iterations for the search methods for each data structure
			int heapi = animalHeap.search(name);
			System.out.printf("%-40s\t%-10d\t%-10d\n", name, bsti, heapi);
		}
		animalBST.clear();
		animalHeap.clear(); //clearing the BST and heap 
		//sorting the arrayList of animals
		java.util.Collections.sort(animalAL);
		//repeating same process with sorted list
		for (int i = 0; i < animalAL.size(); i++) {
			bstInsert += animalBST.insert(animalAL.get(i)); //transferring over from arrayList
			heapInsert += animalHeap.insert(animalAL.get(i)); //# of iterations added to variables
		}
		System.out.println("Average number of iterations for BST and Heap (Sorted list)");
		System.out.println("BST: " + bstInsert / animalAL.size() + "\tHeap: " + heapInsert / animalAL.size());

		for (int i = 0; i < 20; i++) {
			int index = random.nextInt(animalAL.size());
			String name = animalAL.get(index); //random index
			int bsti = animalBST.search(name); //testing iterations for the search methods for each data structure
			int heapi = animalHeap.search(name);
			System.out.printf("%-40s\t%-10d\t%-10d\n", name, bsti, heapi);
		}

	}

	/**
	 * Comparison and discussion: 
	 * 
	 * The results from the program show that the Heap will always demonstrate logarithmic performance for insertion no matter
	 * the order of the list used to insert into the heap. Whereas, the order of the list used to insert into the 
	 * BST will determine the performance of the insert method for the BST. When the BST is derived from an unsorted
	 * list, the insert method demonstrates O(log n) time complexity. Whereas, when it is derived from a sorted list, 
	 * the insert method demonstrates O(n) time complexity. For the search, the BST has better performance than the heap
	 * when the list is unsorted. However, they are roughly equivalent in performance with the list is sorted. When the 
	 * list is unsorted, the heap search is O(n) and the BST search is O(log n). However when the list is sorted,
	 * the heap search is O(n) and the BST search is O(n)
	 * 
	 */

}
