import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * @version 0.1 
 * Date of creation: May 3, 2021 
 * Last Date Modified: May 9, 2021
 * @author alexclevenger
 *
 *Class HashMaps to test the instantiation of different hashmaps 
 *
 */
public class HashMaps {

	public static int scIterations = 0;
	public static int lpIterations = 0;
	public static int qpIterations = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read the file
		File file = new File("dictionary.txt");
		Scanner readFile = null;
		HashMapSC<String, String> hashMapSC = new HashMapSC<>(50000); //separate chaining
		HashMapLP<String, String> hashMapLP = new HashMapLP<>(50000); //linear probing 
		HashMapQP<String, String> hashMapQP = new HashMapQP<>(50000); //quadratic probing
		ArrayList<MapEntry<String, String>> words = new ArrayList<>();

		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		while (readFile.hasNextLine()) {
			String line = readFile.nextLine();
			String[] tokens = line.split("\\|");

			hashMapSC.put(tokens[0], tokens[1]); //adding the information into the hashmaps
			hashMapLP.put(tokens[0], tokens[1]);
			hashMapQP.put(tokens[0], tokens[1]);
			words.add(new MapEntry<String, String>(tokens[0], tokens[1]));

		} // file has been read
		readFile.close();
		Random random = new Random(); // random object

		double scTotal = 0;
		double lpTotal = 0;
		double qpTotal = 0;
		
		System.out.printf("%-40s%-30s%-30s%-30s\n", "Word", "Seperate Chaining", "Linear Probing",
				"Quadratic Probing");

		for (int i = 0; i < 100; i++) {
			int index = random.nextInt(words.size());
			
			
			hashMapSC.containsKey(words.get(index).getKey());
			scTotal += scIterations;
			hashMapLP.containsKey(words.get(index).getKey());
			lpTotal += lpIterations;
			hashMapQP.containsKey(words.get(index).getKey());
			qpTotal += qpIterations;
			System.out.printf("%-40s%-30d%-30d%-30d\n",words.get(index).getKey(), scIterations, lpIterations, qpIterations);
		}

		scTotal /= 100.0; //dividing by total to obtain average 
		lpTotal /= 100.0;
		qpTotal /= 100.0;
		System.out.printf("%-40s%-30.2f%-30.2f%-30.2f\n","Average", scTotal, lpTotal, qpTotal);

	}
	/**
	 * Discussion: 
	 * 
	 * Collisions in a hashmap can be treated in different ways. The method of separate chaining handles 
	 * collisions by adding elements that repeat on the same index into a linked list that exists at that index. 
	 * Therefore, the hashmap is made up of linked lists. We could also make the hashmap an array of mapentries 
	 * rather than an array of linked lists of mapentries. This means that when a collision occurs, there must be some 
	 * increment to the index until the element finds an empty space. The method of linear probing increments one index 
	 * while the method of quadratic probing increments by some square of a number. After observing the average iterations from 
	 * each method after calling the containsKey method (subsequently calling the get method) I found that the 
	 * average number of iterations for all three varies slightly each time I run the program because of the random component in the 
	 * main method. However, the average iterations for all three are always somewhere between 1 and two- usually less that 1.5. 
	 */

}
