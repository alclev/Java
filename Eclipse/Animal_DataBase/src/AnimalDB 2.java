import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class AnimalDB {

	public static void main(String[] args) {
		
		ArrayList<String> animalAL = new ArrayList<>();
		LinkedList<String> animalLL = new LinkedList<>();
		
		//reading from the file
		
		File file = new File("animals.txt");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		while(readFile.hasNextLine()) {
			
			String animal = readFile.nextLine();
			
			animalAL.add(animal);
			animalLL.add(animal);
			
		}
		readFile.close();
		Random random = new Random();
		
		int totalIterationsAL = 0;
		int totalIterationsLL = 0;
		System.out.printf("%-20s\t%-25s\t%-15s\n", "Animal Name", "#comparisons(ArrayList)", "#comparisons(LinkedList)");
		System.out.println("-------------------------------------------------------------------------------");
		
		for (int i = 0; i < 100; i ++) {
			int index = random.nextInt(animalAL.size()); //generate a valid index
			//random index that is less than both of the list sizes
			String animal = animalAL.get(index);
			int iterAL = animalAL.searchComparisons(animal);
			int iterLL = animalLL.searchComparisons(animal);
			totalIterationsAL += iterAL;
			totalIterationsLL += iterLL;
			System.out.printf("%-30s\t%-25d\t%-15d\n", animal, iterAL, iterLL);
			
		}
		//total / 100 represents the average number of iterations required to find the given element
		System.out.printf("\n%-30s\t%-25d\t%-15d\n", "Average: ", totalIterationsAL/100, totalIterationsLL/100);
	}
	/**
	 * Explanation: 
	 * 
	 * The number of iterations for the two different lists is different when searching for the same animal because
	 * of how the add(E item) method is defined for each of the data structures. An arraylist's add method adds to the 
	 * end of the list, while the linkedlist's add(E item) calls the addFirst(E item) method (adding to the head of the list), 
	 * consequently adding the animals in a different order. 
	 * 
	 * However, the average numbers of iterations for both data structures are close in value because the time complexity 
	 * for the methods defined in both the ArrayList Iterator and the LinkedList iterator is O(1). Also, both data structures
	 * are essentially just iterating through the list element by element, so the difference in iterations due to adding the 
	 * animals in a different order balances out in the average. Due to the way that the add method is defined in each data 
	 * structure, the position of the same animal in the LL should be on the opposite end of the AL, causing the average to balance out. 
	 * 
	 */

}
