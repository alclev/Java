import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 * Main class that interacts with user to manage an array of titles
 * 
 */
public class LibraryManager {

	public static void main(String[] args) {

		Catalog myLibrary = new Catalog();
		myLibrary.loadFromFile("titles.txt");
//loads the information from titles.txt file
		int operation = 0;
		Scanner key = new Scanner(System.in);
		do {
			try {
				printMenu(); //continuously prints menu for the user
				operation = key.nextInt();
				switch (operation) {
				case 1: // Find a title with a given call Number:
					System.out.println("Enter a call number: \n");
					String call = key.next(); 
					checkCallNumber(call);  //makes sure inputted callNumber is valid
					if (myLibrary.searchCallNumber(call) != null) { //searches for call number in list
						System.out.println("Titles Found: "); 
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "Call Number", "Title",
								"Publisher", "Year"));
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "-----------",
								"--------------------------------------", "---------", "----"));
						System.out.println(myLibrary.searchCallNumber(call).toString());
					
						System.out.println(); //add a line
					} else
						System.out.println("No titles found."); //if none were found
					break;

				case 2: // Find titles with a given title
					System.out.println("Enter title: ");
					String title = key.nextLine();
					title += key.nextLine(); //this is to properly format the user input 
					//if the list of found titles matching the input is not empty
					if (myLibrary.searchTitle(title).length != 0) {
						System.out.println("List of titles found: " + myLibrary.searchTitle(title).length);
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "Call Number", "Title",
								"Publisher", "Year"));
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "-----------",
								"--------------------------------------", "---------", "----"));
						for (int i = 0; i < myLibrary.searchTitle(title).length; i++) {
							System.out.println(myLibrary.searchTitle(title)[i].toString());
							//print the information of each element found
						}
						System.out.println(); // add a line for spacing
					} else {
						System.out.println("No titles found.\n");
					}
					break;
				case 3: // Find titles with a given year
					System.out.println("Enter a year: ");
					int year = key.nextInt();
					checkDate(year);  //checks the validity of the inputted year 
					//if the list of titles with same inputted year is not empty
					if (myLibrary.searchYear(year).length != 0) {
						System.out.println("List of titles found: " + myLibrary.searchYear(year).length);
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "Call Number", "Title",
								"Publisher", "Year"));
						System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "-----------",
								"--------------------------------------", "---------", "----"));
						for (int i = 0; i < myLibrary.searchYear(year).length; i++) {
							System.out.println(myLibrary.searchYear(year)[i].toString());
							//lists the information of each element found
						}
						System.out.println();
					} else {
						System.out.println("No titles found.\n");
					}
					break;

				case 4: // Add a new title
					System.out.println("Enter a title: ");
					String ti = key.next();
					ti += key.nextLine();  //I added these lines to fix the issue of inputting a string with a space
					System.out.println("Enter the publisher: ");
					String pu = key.next();
					pu += key.nextLine();  //
					System.out.println("Enter the year: ");
					int ye = Integer.parseInt(key.nextLine()); //made all strings and simply converted make into other type needed
					checkDate(ye);
					System.out.println("Enter the number of copies: ");
					int co = Integer.parseInt(key.nextLine());
					System.out.println("Enter the type of title (book/periodical): ");
					String input = key.nextLine();

					if (input.equals("book")) {  //if the user selected book

						System.out.println("Enter the call number: ");
						String callN = key.nextLine();
						//ensures proper callnumber for a book
						if (!callN.matches("B-\\d{3}-\\d{3}-\\d{3}")) {
							throw new InvalidCallNumber("That is not the call number for a book.\n");
						}
						System.out.println("Enter an author: ");
						String au = key.nextLine();
						System.out.println("Enter the ISBN: ");
						String isb = key.nextLine();
						//create instance and add to the list of titles
						Title b = new Book(callN, ti, pu, ye, co, au, isb);
						myLibrary.addItem(b);

					} else if (input.equals("periodical")) { //if the user selected a periodical
						System.out.println("Enter the call number: ");
						String callN = key.nextLine();
						//ensures proper callnumber for a periodical
						if (!callN.matches("P-\\d{3}-\\d{3}-\\d{3}")) {
							throw new InvalidCallNumber("That is not the call number for a periodical.\n");
						}
						System.out.println("Enter the issue: ");
						int iss = Integer.parseInt(key.nextLine());
						System.out.println("Enter the month: ");
						int mon = Integer.parseInt(key.nextLine());
						checkMonth(mon);
						//create instance and add to the list of titles
						Title p = new Periodical(callN, ti, pu, ye, co, iss, mon);
						myLibrary.addItem(p);

					} else {
						System.out.println("Invalid Input. ");
					}
					break;

				case 5: // Remove a title with a given call number
					System.out.println("Enter the call number: ");
					String cn = key.next();
					
					//checks the validity of callNumber 
					checkCallNumber(cn);
					myLibrary.removeItem(cn); //removes the callNumber given that it exists
					break;

				case 6: // View the list of titles in the library
					myLibrary.viewAll(); 
					break;

				case 7: // Exit the program
					myLibrary.saveToFile("titles.txt"); //saves contents of the array of titles onto the titles.txt file

					break;
				}

			} catch (InvalidCallNumber e) {
				System.out.println(e.getMessage()); //handles an Invalid CallNumber
			} catch (InvalidDate e) {
				System.out.println(e.getMessage()); //handles an Invalid Date
			} catch (InputMismatchException e) {
				key.nextLine();
				System.out.println("Invalid input.\n"); //handles InputMismatch with user input
			}

		} while (operation != 7);
	}
/**
 * Method that makes sure that the call number is in the correct format
 * @param callN
 * @throws InvalidCallNumber
 * @return no return value
 */
	public static void checkCallNumber(String callN) throws InvalidCallNumber {
		if (!(callN.matches("B-\\d{3}-\\d{3}-\\d{3}") || callN.matches("P-\\d{3}-\\d{3}-\\d{3}"))) {
			throw new InvalidCallNumber(
					String.format("Invalid call number: %-20s\n Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd", callN));
		}

	}
/**
 * Method that makes sure the date is in the correct range
 * @param date
 * @throws InvalidDate
 * @return no return value
 */
	public static void checkDate(int date) throws InvalidDate {
		if (!(date >= 1900 && date <= 2021)) {
			throw new InvalidDate("Invalid year – must be from 1900 to 2021");
		}
	}
/**
 * Method that makes sure the month is in the correct range
 * @param month
 * @return no return value
 */
	public static void checkMonth(int month) {
		if (month < 1 || month > 12) {
			throw new InvalidDate("Invalid month – Must be from 1 to 12");
		}
	}
/**
 * Displays menu of options for the user
 * @param no parameters
 * @return no return 
 */
	public static void printMenu() {
		String out = "Select and Operation: \n";
		out += "---------------------\n";
		out += "1: Find Title\n";
		out += "2: Search by Title\n";
		out += "3: Search by Year\n";
		out += "4: Add Title\n";
		out += "5: Remove Title\n";
		out += "6: View All Titles\n";
		out += "7: Exit";
		System.out.println(out);
	}
}
