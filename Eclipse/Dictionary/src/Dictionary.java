import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 3, 2021 
 * Last Date Modified: May 3, 2021
 *
 * @param <E>
 * Class Dictionary to model a Dictionary
 */
public class Dictionary {
//static variables to track iterations in other classes
	public static int hashIterations = 0;
	public static int LLIterations = 0;

	public static void main(String[] args) {
//read the file
		File file = new File("dictionary.txt");
		ArrayList<Pair<String, String>> words = new ArrayList<>();
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		while (readFile.hasNextLine()) {
			String line = readFile.nextLine();
			String[] tokens = line.split("\\|");
			Pair<String, String> p = new Pair<>(tokens[0], tokens[1]);
			words.add(p);

		}//file has been read
		readFile.close();

		//shuffle list 
		java.util.Collections.shuffle(words);
		//instantiate HashMap, BST, and, LL
		HashMap<String, String> dictionary = new HashMap<>(50000);
		BST<Pair<String, String>> BSTDictionary = new BST<>();
		LinkedList<Pair<String, String>> LLDictionary = new LinkedList<>();

		for (int i = 0; i < words.size(); i++) { //adding information from list to various data structures
			Pair<String, String> p = words.get(i);
			dictionary.put(p.getFirst(), p.getSecond());

			BSTDictionary.insert(new Pair<String, String>(p.getFirst(), p.getSecond()));
			LLDictionary.addLast(new Pair<String, String>(p.getFirst(), p.getSecond()));
		}
		
		Random random = new Random(); //random object
		double hashTotal = 0;
		double bstTotal = 0;
		double LLtotal = 0;
		for (int i = 0; i < 100; i++) {
			int index = random.nextInt(words.size()); //generating random index
			Pair<String, String> p = words.get(index); //getting random pair
			dictionary.containsKey(p.getFirst());
			hashTotal += hashIterations; //tracking hash iterations
			bstTotal += BSTDictionary.search(p); //tracking BST iterations (already returns int)
			LLDictionary.search(p); 
			LLtotal += LLIterations; //tracking LL iterations

		}
		hashTotal /= 100.0; //obtain averages
		bstTotal /= 100.0;
		LLtotal /= 100.0;
		System.out.println("Average number of iterations to find words in the dictionary:");
		System.out.printf("%-10s%-10s%-10s\n", "LL", "BST", "HashMap");
		System.out.printf("%-10.2f%-10.2f%-10.2f\n\n", LLtotal, bstTotal, hashTotal);
		//call collisions method in HashMap
		System.out.println("Maximum number of collisions: " + dictionary.collisions());

	}

}
