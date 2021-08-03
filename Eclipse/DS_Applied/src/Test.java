import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Room[] rooms = new Room[100];
		Scanner input = new Scanner(System.in);
		int operation = 0;
		int count = readFromFile(rooms, "rooms.txt");

		do {
			try {

				printMenu();
				operation = input.nextInt();
				switch (operation) {
				case 1:
					System.out.println("Enter the room number: ");
					String rn = input.next();

					checkRoomNumber(rn);
					int ind = findRoom(rooms, count, rn);
					if (ind != -1) {
						System.out.println("Room found: ");
						System.out.println(String.format("%-20s%-15s%-15s%-10s%-10s", "Type", "Number", "Capacity",
								"Area", "Owner/Computers"));
						System.out.println(String.format("%-20s%-15s%-15s%-10s%-10s", "----", "----", "----", "----",
								"----", "-------"));
						if (rooms[ind] instanceof Lab) {
							System.out.println(String.format("%-20s%s", "Lab", rooms[ind].toString()));
						}
						if (rooms[ind] instanceof Office) {
							System.out.println(String.format("%-20s%s", "Office", rooms[ind].toString()));
						}
						if (rooms[ind] instanceof Classroom) {
							System.out.println(String.format("%-20s%s", "Classroom", rooms[ind].toString()));
						}
					} else {
						System.out.println("Room not found.");
					}
					break;

				case 2:
					printRooms(rooms, count);
					break;

				case 3:
					java.util.Arrays.sort(rooms, 0, count);
					break;

				case 4:
					System.out.println("Thank you for using my program");
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}

		} while (operation != 4);

	}

	public static void printRooms(Room[] list, int count) {
		System.out.println(
				String.format("%-20s%-15s%-15s%-10s%-10s", "Type", "Number", "Capacity", "Area", "Owner/Computers"));
		System.out
				.println(String.format("%-20s%-15s%-15s%-10s%-10s", "----", "----", "----", "----", "----", "-------"));
		for (int i = 0; i < count; i++) {

			if (list[i] instanceof Lab) {
				System.out.println(String.format("%-20s%s", "Lab", list[i].toString()));
			}
			if (list[i] instanceof Office) {
				System.out.println(String.format("%-20s%s", "Office", list[i].toString()));
			}
			if (list[i] instanceof Classroom) {
				System.out.println(String.format("%-20s%s", "Classroom", list[i].toString()));
			}
		}
		System.out.println();
	}

	public static int findRoom(Room[] list, int count, String roomNumber) {
		for (int i = 0; i < count; i++) {
			if (list[i].getNumber().equals(roomNumber)) {
				return i;
			}
		}
		return -1;
	}

	public static void checkRoomNumber(String roomNumber) throws Exception {
		if (!(roomNumber.matches("[A-Z]{2}-\\d{3}") || roomNumber.matches("[a-z]{2}-\\d{3}"))) {
			throw new Exception("Invalid room number. (XX-ddd)");
		}
	}

	public static int readFromFile(Room[] list, String filename) {
		File file = new File(filename);
		int count = 0;

		Scanner readFile = null;

		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ");
			System.exit(0);
		}

		while (readFile.hasNext()) {
			String type = readFile.next();
			if (type.equals("lab") || type.equals("Lab")) {
				String num1 = readFile.next();
				int cap1 = readFile.nextInt();
				int area1 = readFile.nextInt();
				int comp = readFile.nextInt();
				list[count++] = new Lab(num1, cap1, area1, comp);
			}
			if (type.equals("office") || type.equals("Office")) {
				String num2 = readFile.next();
				int cap2 = readFile.nextInt();
				int area2 = readFile.nextInt();
				String owner = readFile.next();
				owner += readFile.nextLine();
				list[count++] = new Office(num2, cap2, area2, owner);
			}
			if (type.equals("classroom") || type.equals("Classroom")) {
				String num3 = readFile.next();
				int cap3 = readFile.nextInt();
				int area3 = readFile.nextInt();
				list[count++] = new Classroom(num3, cap3, area3);

			}
		}
		return count;
	}

	public static void printMenu() {
		String out = "Select and Operation: \n";
		out += "---------------------\n";
		out += "1: Find a room\n";
		out += "2: View all rooms\n";
		out += "3: Sort Rooms\n";
		out += "4: Exit\n";
		System.out.println(out);
	}
}
