import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {

		HashMap<Integer, Student> studentList = new HashMap<>(500);

		File file = new File("registration.txt");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		while (readFile.hasNextLine()) {

			String line = readFile.nextLine();

			String[] tokens = line.split(" ");
			String name = tokens[0];
			int id = Integer.parseInt(tokens[1]);
			Student stud = new Student(name, id);

			for (int i = 2; i < tokens.length; i += 2) {
				stud.addCourse(tokens[i], Integer.parseInt(tokens[i + 1]));
			}
			studentList.put(id, stud);

		} // file has been read
		readFile.close();

		int operation = 0;
		int in = 0;
		Scanner input = new Scanner(System.in);
		do {
			try {
				printMenu();
				operation = input.nextInt();
				switch (operation) {
				case 1:
					System.out.println(studentList.listOfValues().toString());
					break;
				case 2:
					System.out.println("Enter a student name: ");
					String n = input.next();
					System.out.println("Enter a student id: ");
					int ident = input.nextInt();
					Student st = new Student(n, ident);

					if (studentList.put(ident, st) != null) {
						System.out.println("Student added successfully");
					} else {
						System.out.println("Student added unsuccessfully");
					}
					break;

				case 3: 
					System.out.println("Enter a student id: ");
					int sID = input.nextInt();
					
					if (studentList.get(sID) != null) {
						System.out.println(studentList.get(sID).toString());
						do {
							printsubMenu();
							in = input.nextInt();
							switch (in) {
							case 1:
								System.out.println("What is the course number: ");
								String cn = input.next();
								if (!cn.matches("[A-Z]{2,4}\\d{3}")) {
									throw new InvalidNumberException("Invalid number");
								} else {
									System.out.println("What is the number of credits? ");
									int c = input.nextInt();
									Course course = new Course(cn, c);
									if (studentList.get(sID).findCourse(cn) != null) {
										break;
									} else {
										studentList.get(sID).addCourse(cn, c);
									}
								}

								break;
							case 2:
								System.out.println("What is the course number: ");
								String couNum = input.next();
								if (!couNum.matches("[A-Z]{2,4}\\d{3}")) {
									throw new InvalidNumberException("Invalid number");
								} else {
									if (studentList.get(sID).dropCourse(couNum)) {
										System.out.println("Course dropped successfully");
									} else {
										System.out.println("Course removed unsuccessfully");
									}

								}
								break;

							case 3:

								break;

							}
						} while (in != 3);

					} else {
						System.out.println("Student not found.");
					}
					break;
				case 4:
					ArrayList<Student> preSort = studentList.listOfValues();
					mergeSort(preSort);
					for (int i = 0; i < preSort.size(); i++) {
						System.out.println(preSort.get(i));
					}
					break;
				case 5:
					System.out.println("Thank you for using my program");
					break;

				}
			} catch (InvalidNumberException e) {
				System.out.println(e.getMessage());
			}

		} while (operation != 5);
	}

	public static void printMenu() {
		String result = "Select an operation: \n";
		result += "1: View all Students\n";
		result += "2: Add a Student\n";
		result += "3: Add/Drop Classes\n";
		result += "4: Sort Student List\n";
		result += "5: Quit";
		System.out.println(result);

	}

	public static void printsubMenu() {
		String result = "Select an operation: \n";
		result += "1: Add a course\n";
		result += "2: Drop a course\n";
		result += "3: Exit Add/Drop menu\n";

		System.out.println(result);

	}

	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		if (list.size() > 1) { // base case
			ArrayList<E> firstHalf = new ArrayList<>();
			ArrayList<E> secondHalf = new ArrayList<>();
			firstHalf = subList(list, 0, list.size() / 2);
			secondHalf = subList(list, list.size() / 2, list.size());
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}

	public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end) {
		ArrayList<E> newList = new ArrayList<>();
		for (int index = start; index < end; index++)
			newList.add(list.get(index));
		return newList;
	}

	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int i1 = 0, i2 = 0, i = 0;
		while (i1 < list1.size() && i2 < list2.size()) {
			if (list1.get(i1).compareTo(list2.get(i2)) < 0) {
				list.set(i++, list1.get(i1++));
			} else {
				list.set(i++, list2.get(i2++));
			}
		}
		while (i1 < list1.size()) {
			list.set(i++, list1.get(i1++));
		}
		while (i2 < list2.size()) {
			list.set(i++, list2.get(i2++));
		}
	}

}
