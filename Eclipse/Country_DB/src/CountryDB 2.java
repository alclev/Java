import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1
 * Date of creation: April 22, 2021 
 * Last Date Modified: April 28, 2021
 * 
 * Main class for testing BST and Heap
 */
public class CountryDB {

	public static void main(String[] args) {

		ArrayList<Country> countryList = new ArrayList<Country>();

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

			String line = readFile.nextLine();
			String code = line.substring(0, 2);
			String name = line.substring(3, line.lastIndexOf("|"));
			double area = Double.parseDouble(line.substring(line.lastIndexOf("|") + 1));

			countryList.add(new Country(code, name, area));
		}
		readFile.close();

		BST<Country> countryBST = new BST<Country>(countryList);
		Heap<Country> countryHeap = new Heap<Country>(countryList);

		// for the BST
		System.out.println("Characteristics of the BST and Heap (sorted list)");
		System.out.println("BST - Number of leaf Nodes: " + countryBST.leafNodes());
		System.out.println("BST - Height of the Tree: " + countryBST.height());
		System.out.println("BST - Is the BST balanced? " + countryBST.isBalanced());

		// for the Heap

		System.out.println("Heap - Number of leaf Nodes: " + countryHeap.leafNodes());
		System.out.println("Heap - Height of the Tree: " + countryHeap.height());
		System.out.println("Heap - Is the Heap balanced? " + countryHeap.isBalanced());

		System.out.println("List of countries from BST (inorder)");
		header();
		countryBST.inorder();

		System.out.println("List of countries from Heap (delete)");
		header();
		while (!countryHeap.isEmpty()) {
			System.out.println(countryHeap.delete().toString());
		}

		// shuffle
		Collections.shuffle(countryList);
		// clear BST
		countryBST.clear();

		for (int i = 0; i < countryList.size(); i++) {
			countryBST.insert(countryList.get(i));
			countryHeap.insert(countryList.get(i));
		}

		System.out.println("Characteristics of the BST and Heap (shuffled list)"); // for the BST
		System.out.println("BST - Number of leaf Nodes: " + countryBST.leafNodes());
		System.out.println("BST - Height of the Tree: " + countryBST.height());
		System.out.println("BST - Is the BST balanced? " + countryBST.isBalanced());

		// for the Heap

		System.out.println("Heap - Number of leaf Nodes: " + countryHeap.leafNodes());
		System.out.println("Heap - Height of the Tree: " + countryHeap.height());
		System.out.println("Heap - Is the Heap balanced? " + countryHeap.isBalanced());

		System.out.println("List of countries from BST (inorder)");
		header();
		countryBST.inorder();

		System.out.println("List of countries from Heap (delete)");
		header();
		while (!countryHeap.isEmpty()) {
			System.out.println(countryHeap.delete().toString());
		}

	}

	/**
	 * Discussion:
	 * 
	 * I noticed that for the shuffled BST, the value for # of leaf nodes and height varied slightly from that of 
	 * the unshuffled list. The isBalanced remained false. 
	 * 
	 * Whereas, the shuffled Heap actually had the same number of leaf nodes and height for the shuffled and 
	 * unshuffled lists. The isBalanced remained true. 
	 * 
	 * Also, the shuffled list should vary the values of leaf nodes and height slightly everytime the 
	 * program is run. However, they should remain constant with the sorted list. 
	 * 
	 * 
	 */

	public static void header() {
		System.out.printf("%-5s%-50s%-10s", "Code", "Name", "Area (sq.Km)");
		System.out.printf("\n%-5s%-50s%-10s\n", "----", "----", "------------");
	}
}
