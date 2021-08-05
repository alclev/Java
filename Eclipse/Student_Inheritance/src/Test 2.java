import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 11, 2021
 * Last Date Modified: February 19, 2021
 * 
 * Test class that creates a list of Students and displays a list of options for the user
 */
public class Test {
	//main method
	public static void main(String[] args) {
		Student[] studentList = new Student[100];
		int studentCount = 0;
		// start reading
		File file = new File("students.txt");
		//initializing Printwriter and Scanner
		PrintWriter write = null;
		Scanner readFile = null;
		try {
			//making sure the file is readable
			readFile = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		//copying over contets of file into the studentList while simultaneously incrementing studentCount
		while (readFile.hasNext()) {
			String name = readFile.next() + " " + readFile.next();
			int id = readFile.nextInt();
			double gpa = readFile.nextDouble();
			Student s = new Student(name, id, gpa);
			studentList[studentCount++] = s;
		}
		System.out.println("File students.txt opened successfully.\n" + "Reading Data from file students.txt ...\n");
		readFile.close();
		// finished reading
		Scanner keyboard = new Scanner(System.in);
		int operation = 0;

		do {
			try {
				//displays a list of options
				printMenu();
				operation = keyboard.nextInt();
				switch (operation) {
				case 1:
					System.out.println("Enter Student ID: ");// find a student
					int id = keyboard.nextInt();
					checkID(id);
					if (findStudent(studentList, studentCount, id) != -1) { //if student is found, display
						System.out.println("Student Found: "
								+ studentList[findStudent(studentList, studentCount, id)].toString() + "\n");
					} else {
						System.out.println("Student ID not found.\n");
					}
					break;
				case 2: // add a student
					System.out.println("Enter first and last name: \n");
					String name = keyboard.next();
					name += keyboard.nextLine();
				//this is to properly format the user input 
					System.out.println("Enter id: \n");
					int iD = Integer.parseInt(keyboard.nextLine());
					checkID(iD);
					System.out.println("Enter gpa: \n");
					double gpa = Double.parseDouble(keyboard.nextLine());
					checkGPA(gpa);

					studentList[studentCount] = new Student(name, iD, gpa);
					studentCount++;
					break;
				case 3: // remove a student
					System.out.println("Enter ID: \n");
					int i = keyboard.nextInt();
					checkID(i);
					int index = findStudent(studentList, studentCount, i);
					if (index == -1) {
						System.out.println("Student ID not Found. \n");
					} else {
						studentList[index] = null;
						for (int j = index; j < studentCount; j++) {
							studentList[j] = studentList[j + 1];
							//shift array elements to the left towards the index given 
						}
						studentCount--;
					}

					break;
				case 4: // view all students
					viewStudents(studentList, studentCount); //views students 
					break;
				case 5: // save to file and exit
					try {
						write = new PrintWriter(file);
					} catch (FileNotFoundException e) {
						System.out.println("File not found");
						System.exit(0);
					}
					System.out.println("File students.txt opened for writing successfully.");
					System.out.println("Writing Data to file students.txt ...");
					for (int k = 0; k < studentCount; k++) {
						write.println(studentList[k].toString()); //saving contests to the .txt file
					}

					write.close();

					break;
				}
			} catch (InvalidIDException e) {
				System.out.println(e.getMessage());

			} catch (InvalidGPAException e) {
				System.out.println(e.getMessage());

			} catch (InputMismatchException e) {
				keyboard.nextLine();
				System.out.println("Invalid Input. \n");

			}

		} while (operation != 5);

	}
/**
 * Method to find a student in the list of students by id 
 * @param list
 * @param size
 * @param id
 * @return id of a student
 */
	public static int findStudent(Student[] list, int size, int id) {
		for (int i = 0; i < size; i++) {
			if (list[i].getID() == id)
				return i;
		}
		return -1;
	}
/**
 * Method that ensures the id is the correct format
 * @param id
 * @throws InvalidIDException
 * @return no return value
 */
	public static void checkID(int id) throws InvalidIDException {
		Integer ID = id;
		if (!ID.toString().matches("\\d{6}")) {
			throw new InvalidIDException(String.format("Invalid ID = %d. Must have 6 digits.\n", id));
		}
	}
/**
 * Method that ensures the gpa is the correct format
 * @param gpa
 * @throws InvalidGPAException
 * @return no return value
 */
	public static void checkGPA(double gpa) throws InvalidGPAException {
		if (!(gpa > 0 && gpa <= 4.0)) {
			throw new InvalidGPAException(String.format("Invalid GPA = %6.2f. Must be between 0.00 and 4.00 \n", gpa));
		}

	}
/**
 * Method that iterates through the list of students prints their information
 * @param list
 * @param size
 * @return no return value
 */
	public static void viewStudents(Student[] list, int size) {
		for (int i = 0; i < size; i++) {
			System.out.println(list[i].toString());
		}
	}
/**
 * Method to display a menu of options for the user
 * @param no parameters
 * @return no return value
 */
	public static void printMenu() {
		String out = "Select and operation: \n";
		out += "------------------------\n";
		out += "1: Find a student ID \n";
		out += "2: Add a new student \n";
		out += "3: Remove a student \n";
		out += "4: View all students \n";
		out += "5: Exit \n";

		System.out.println(out);
	}

}
