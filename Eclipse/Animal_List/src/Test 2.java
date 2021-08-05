import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author alexclevenger
 * @version 0.1 Date of creation: February 8, 2021 Last Date Modified: February
 *          12, 2021
 *
 *          Test class that creates 10 instance of an Animal
 */
public class Test {
	// main class that assigns values of values for 10 different animals and
	// arranges them in an array

	public static void main(String[] args) {

		Animal[] animalList = new Animal[10];
		animalList[0] = new WildAnimal("Lion", 400.0, "Africa");
		animalList[1] = new DomesticAnimal("Dog", 68.5, "Jack Holmer");
		animalList[2] = new WildAnimal("Tiger", 410.0, "Asia");
		animalList[3] = new WildAnimal("Kangaroo", 110.0, "Australia");
		animalList[4] = new DomesticAnimal("Cat", 8.56, "Patricia Bell");
		animalList[5] = new DomesticAnimal("Goldfish", 0.75, "Sebastien Cole");
		animalList[6] = new WildAnimal("Wolf", 120.0, "Europe");
		animalList[7] = new DomesticAnimal("Parrot", 3.7, "Lily Alexander");
		animalList[8] = new WildAnimal("Crocodile", 1000.0, "America");
		animalList[9] = new DomesticAnimal("Hamster", 0.5, "Bella Chen");
//allows user input
		Scanner scan = new Scanner(System.in);
		int input;
//do while loop to repeatedly display menu of options and code to execute methods
		do {
			// list of menu options
			System.out.println("Select an operation: \n");
			System.out.println("1: View all animals \n");
			System.out.println("2: Search by name \n");
			System.out.println("3: Search by weight \n");
			System.out.println("4: Search by type \n");
			System.out.println("5: Sort by name \n");
			System.out.println("6: Sort by weight \n");
			System.out.println("7: Exit \n");

			input = scan.nextInt();
//depending on the user's number inputted, one of the following will execute: 
			switch (input) {
//displays list of animals
			case 1:
				System.out.println("Type \t\t Name \t\t Weight (lbs) \t Origin/Owner");
				printArray(animalList);
				break;
//searches list of animals by name 
			case 2:
				System.out.println("Enter the name of the Animal: ");
				String name = scan.next();
				int i = searchByName(animalList, name);
				if (i != -1)
					System.out.println("Animal Found: " + animalList[i]);
				else
					System.out.println("Animal Not Found \n");
				break;
//searches list of animals by weight 
			case 3:
				System.out.println("Enter the minimum weight of the animal: ");
				double weight = scan.nextDouble();
				System.out.println("List of animals with weight >= " + weight + "\n");
				System.out.println(searchByWeight(animalList, weight) + " animals found. \n");
				break;
//displays certain type of animals in list
			case 4:
				System.out.println("Enter the type of the animal (wild/domestic): ");
				String type = scan.next();
				if (!(type.equals("wild") || type.equals("domestic"))) {
					System.out.println("Invalid Entry");
				} else
					System.out.println(searchByType(animalList, type) + " animals found. \n");
				break;
//sorts list of animals by name and displays it
			case 5:
				sortByName(animalList);
				System.out.println("List of animals sorted by name: ");
				printArray(animalList);
				break;
//sort list of animals by weight and displays it
			case 6:
				sortByWeight(animalList);
				System.out.println("List of animals sorted by weight: ");
				printArray(animalList);
				break;
//exits the program
			case 7:
				System.out.println("Thank you for using my program!");
				scan.close();
				break;
			}
//ends program with int 7 inputted
		} while (input != 7);

	}

	/**
	 * displays the list of animals with their information
	 * 
	 * @param animals list of animals
	 * @return no return value
	 */
	public static void printArray(Animal[] animals) {
		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].toString() + "\n");
		}
	}

	/**
	 * searches through the list of animals and finds the one with the given name
	 * 
	 * @param animals
	 * @param name
	 * @return index of animal found
	 */
	public static int searchByName(Animal[] animals, String name) {
		for (int i = 0; i < animals.length; i++) {
			if (animals[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * searches through the list of animals and finds the one with the given weight
	 * and displays them
	 * 
	 * @param animals
	 * @param weight
	 * @return number of animals greater than the weight given
	 */
	public static int searchByWeight(Animal[] animals, double weight) {
		int total = 0;
		ArrayList<Animal> list = new ArrayList<Animal>();
		for (int i = 0; i < animals.length; i++) {
			if (animals[i].getWeight() >= weight) {
				total++;
				list.add(animals[i]);
			}

		}
		for (Animal an : list) {
			System.out.println(an.toString() + "\n");
		}
		return total;
	}

	/**
	 * Finds the animals in the list with a certain type and displays them
	 * 
	 * @param animals
	 * @param type
	 * @return the number of animals with the given type
	 */
	public static int searchByType(Animal[] animals, String type) {
		int total = 0;
		ArrayList<Animal> list = new ArrayList<Animal>();
		for (int i = 0; i < animals.length; i++) {
			if (type.equals("wild")) {
				if (animals[i] instanceof WildAnimal) {
					total++;
					list.add(animals[i]);
				}
			} else if (animals[i] instanceof DomesticAnimal) {
				total++;
				list.add(animals[i]);
			}

		}
		for (Animal an : list) {
			System.out.println(an + "\n");
		}
		return total;
	}

	/**
	 * Sorts the list of animals by name
	 * 
	 * @param animals
	 * @return no return value
	 */
	public static void sortByName(Animal[] animals) {
		for (int i = 0; i < animals.length; i++) {
			int minInd = i;
			String minName = animals[i].getName(); // minimum index
			for (int k = i + 1; k < animals.length; k++) {
				if (minName.compareTo(animals[k].getName()) > 0) {
					minName = animals[k].getName();
					minInd = k;
				}
			}
			// swap
			Animal temp = animals[i];
			animals[i] = animals[minInd];
			animals[minInd] = temp;
		}
	}

	/**
	 * Sorts the list of animals by weight
	 * 
	 * @param animals
	 * @return no return value
	 */
	public static void sortByWeight(Animal[] animals) {
		for (int i = 1; i < animals.length; i++) {
			Animal currentElement = animals[i];
			int j;
			for (j = i - 1; j >= 0 && animals[j].getWeight() > currentElement.getWeight(); j--) {
				animals[j + 1] = animals[j]; // shift to right
			}
			animals[j + 1] = currentElement; // found the proper placement in the sublist
		}
	}

}
