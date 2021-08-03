
/**
 * Program to review Java fundamental concepts
 * @author Houria Oudghiri
 * @version 1.0
 * Date: August 24, 2020
 */
import java.util.Scanner;
public class Review {
	// Main method
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int students = keyboard.nextInt();
		String[] studentNames = new String[students];
		double[] studentGPAs = new double[students];
		int[] studentIDs = new int[students];
		int operation = 0;
		keyboard.nextLine();
		inputData(keyboard, studentNames, studentIDs, studentGPAs);
		do {
			operation = getOperation(keyboard);
			switch(operation) {
				case 1: // search id
					System.out.printf("Enter student ID: ");
					int id = keyboard.nextInt();
					int i = findStudentID(studentIDs, id);
					if (i == -1)
						System.out.println("Student with id " + id + " not found.");
					else
						System.out.println("Student found. Name: " + studentNames[i] + ", ID: " + studentIDs[i] + ", GPA: " + studentGPAs[i]);
					break;
				case 2: // display all students
					displayData(studentNames, studentIDs, studentGPAs);
					break;
				case 3: // find average GPA
					double avg = averageGPA(studentGPAs);
					System.out.printf("Average GPA: %5.2f\n", avg);
					break;
				case 4: // sort student names and display updated lists
					sortNames(studentNames, studentIDs, studentGPAs);
					displayData(studentNames, studentIDs, studentGPAs);
					break;
				case 5: // quit the program
					System.out.println("Thank you for using my program.");
			}
		} while (operation != 5);
	}

	/** fills in the input arrays with data entered by the user
	* @param input: Scanner object to read the input data
	* @param names: array of student names
	* @param ids: array of student ids
	* @param gpas: array of student GPAs
	* no return value
	*/
	public static void inputData(Scanner input, String[] names, int [] ids, double[] gpas) {

		for(int i = 0; i < names.length; i++) {

			System.out.println("Enter name of student " + (i+1) + ": ");
			names[i] = input.nextLine();

			do {
				System.out.println("Enter id of student " + (i+1) + " (must be integer): ");
				if (input.hasNextInt()) break;
				else {
					System.out.println("ID must be an integer.");
					input.nextLine();
				}
			} while (true);
			ids[i] = input.nextInt();

			do {
				System.out.println("Enter gpa of student " + (i+1) + " (must be double): ");
				if (input.hasNextDouble()) break;
				else {
					input.nextLine();
					System.out.println("GPA must be a double.");
				}
			} while (true);
			gpas[i] = input.nextDouble();

			input.nextLine();
		}
	}

	/** displays the menu and return the selected operation
	* @param input: Scanner object to read the selected operation
	* @return value entered by the user
	*/
	public static int getOperation(Scanner input) {
		int op = 0;
		do {
			System.out.println("\nSelect an operation: ");
			System.out.println(" 1: Find student (id)");
			System.out.println(" 2: View all students");
			System.out.println(" 3: View average GPA");
			System.out.println(" 4: Sort students by name");
			System.out.println(" 5: Exit program");
			if (input.hasNextInt()) {
				op = input.nextInt();
				if (op >= 1 && op <= 9)
					break;
				else
					System.out.println("Invalid operation. Must be an integer from 1 to 9.");
			}
			else {
				input.nextLine();
				System.out.println("Invalid operation. Must be an integer.");
			}
		} while (true);
		return op;
	}

	/** displays the content of the input arrays in tabular format
	* @param names: array of student names
	* @param ids: array of student ids
	* @param gpas: array of student GPAs
	*/
	public static void displayData(String[] names, int[] ids, double[] gpas) {
		System.out.printf("%-20s\t%-15s\t%-15s\n", "Student name", "Student ID", "Student GPA");
		for (int i = 0; i< names.length; i++) {
			System.out.printf("%-20s\t%-15d\t%-15.2f\n", names[i], ids[i], gpas[i]);
		}
	}

	/** calculates the average value of the GPAs in the array gpas
	* @param gpas: array of student GPAs
	* @return calculated average
	*/
	public static double averageGPA(double[] gpas) {
		double average = 0;
		for (int i = 0; i< gpas.length; i++) {
			average += gpas[i];
		}
		return average/gpas.length;
	}

	/** linear search of the input id in the array ids
	* @param ids: array of student IDs
	* @param id: ID to find in the array
	* @return index of the element with ID equal to id, or -1 if id not found
	*/
	public static int findStudentID(int[] ids, int id) {
		for (int i = 0; i< ids.length; i++) {
			if(ids[i] == id)
				return i;
		}
		return -1;
	}

	/** orders the array names in alphabetical order
	* @param names: array of names
	* @param ids: array of IDs
	* @param gpas: array of GPAs
	*/
	public static void sortNames(String[] names, int[] ids, double[] gpas) {
		for (int i=0; i<names.length; i++) {
			int minIndex = i;
			String minName = names[i];
			for(int j=i+1; j<names.length; j++) {
				if(names[j].compareTo(minName) < 0 )
				{
					minName = names[j];
					minIndex = j;
				}
			}
			swap(names, i, minIndex);
			swap(ids, i, minIndex);
			swap(gpas, i, minIndex);

		}
	}
	/** swaps names at indices i and j
	* @param names: array of student names
	* @param i: index in the array names
	* @param j: index in the array names
	*/
	public static void swap(String[] names, int i, int j) {
		String temp = names[i];
		names[i] = names[j];
		names[j] = temp;
	}
	/** swaps ids at indices i and j
	* @param ids: array of student IDs
	* @param i: index in the array ids
	* @param j: index in the array ids
	*/
	public static void swap(int[] ids, int i, int j) {
		int temp = ids[i];
		ids[i] = ids[j];
		ids[j] = temp;
	}
	/** swaps GPAs at indices i and j
	* @param gpas: array of student GPAs
	* @param i: index in the array gpas
	* @param j: index in the array gpas
	*/
	public static void swap(double[] gpas, int i, int j) {
		double temp = gpas[i];
		gpas[i] = gpas[j];
		gpas[j] = temp;
	}
}