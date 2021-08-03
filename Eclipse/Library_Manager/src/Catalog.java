
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 * Class to model a Catalog that has an array of Titles
 */
public class Catalog {
//private data members
	private Title[] titles;
	private int count;
//default constructor 
	public Catalog() {
		titles = new Title[1000];
		count = 0;
	}
/**
 * Method to save the contents of the given file into an array of type Title
 * @param filename is the name of the file
 */
	public void loadFromFile(String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		while (readFile.hasNext()) {
			String cn = readFile.nextLine();

			if (cn.matches("B-\\d{3}-\\d{3}-\\d{3}")) { // for a book

				String t = readFile.nextLine();

				String p = readFile.nextLine();

				String y = readFile.nextLine(); //made all inputs strings and then I convert them back if needed

				String c = readFile.nextLine();

				String a = readFile.nextLine();

				String i = readFile.nextLine();

				Title b = new Book(cn, t, p, Integer.parseInt(y), Integer.parseInt(c), a, i);
				titles[count++] = b; //create instance of Book with given input and add it to array

			} else {  //for a periodical
				String t = readFile.nextLine();

				String p = readFile.nextLine();

				String y = readFile.nextLine();

				String c = readFile.nextLine();

				String iss = readFile.nextLine();

				String mon = readFile.nextLine();

				Title b = new Periodical(cn, t, p, Integer.parseInt(y), Integer.parseInt(c), Integer.parseInt(iss),
						Integer.parseInt(mon));
				titles[count++] = b; //create instance of Periodical with given input and add it to array
			}
			

		}
		System.out.println("File titles.txt opened successfully.\n" + "Reading Data from file titles.txt ...\n");
		System.out.println(); //reading finished
		readFile.close();

	}
	/**
	 * Accessor method for the publisher of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member publisher
	 **/
	public void saveToFile(String filename) {
		PrintWriter write = null;
		try {
			write = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); //ensures the file can be found or else program terminates
			System.exit(0);
		} //saves data line by line so it can be read again when the program runs for a second time
		for (int k = 0; k < count; k++) {  //instance is a book 
			if (titles[k] instanceof Book) {
				write.print(titles[k].getCallNumber() + "\n");
				write.print(titles[k].getTitle() + "\n");
				write.print(titles[k].getPublisher() + "\n");
				write.print(titles[k].getYear() + "\n");
				write.print(titles[k].getCopies() + "\n");
				write.print(((Book) (titles[k])).getAuthor() + "\n");
				write.print(((Book) (titles[k])).getISBN() + "\n");
			} else { //instance is a periodical
				write.print(titles[k].getCallNumber() + "\n");
				write.print(titles[k].getTitle() + "\n");
				write.print(titles[k].getPublisher() + "\n");
				write.print(titles[k].getYear() + "\n");
				write.print(titles[k].getCopies() + "\n");
				write.print(((Periodical) (titles[k])).getIssue() + "\n");
				write.print(((Periodical) (titles[k])).getMonth() + "\n");
			}
		}
		//file is saved
		System.out.println("File titles.txt opened for writing successfully.");
		System.out.println("Writing Data to file titles.txt ...");
		write.close();
		
	}
/**
 * Method that adds the given item into the array
 * @param t
 * @return no return value
 */
	public void addItem(Title t) {
		titles[count++] = t;
	}
/**
 * Method that removes element of array based on callNumber
 * @param callNumber
 * @return no return value
 */
	public void removeItem(String callNumber) {
		int index = searchCall(callNumber);
		for (int i = index; i < count; i++) {
			titles[i] = titles[i + 1];
		}
		count--;
	}
/**
 * Method that finds elements of array with matching title
 * @param title
 * @return array of Titles that have the same given name
 */
	public Title[] searchTitle(String title) {
		int num = 0;
		Title[] temp = new Title[1000];
		for (int i = 0; i < count; i++) {
			if (titles[i].getTitle().equals(title)) {
				temp[num++] = titles[i];
			}
		}
		Title[] result = new Title[num];
		for (int j = 0; j < num; j++) {
			result[j] = temp[j];
		}
		return result;
	}
/**
 * Method that finds Title with the given callNumber
 * @param cn
 * @return Title with given callNumber
 */
	public Title searchCallNumber(String cn) {
		for (int i = 0; i < count; i++) {
			if (titles[i].getCallNumber().equals(cn)) {
				return titles[i];
			}
		}
		return null;
	}
/**
 * Method that finds the index of Title with given call number
 * @param call
 * @return the index of Title with given callNumber
 */
	public int searchCall(String call) {
		for (int i = 0; i < count; i++) {
			if (titles[i].getCallNumber().equals(call)) {
				return i;
			}
		}
		return -1;
	}
/**
 * Method that finds the Titles that have the same given year
 * @param year
 * @return an array of the Titles whose year value is equal to the year value given
 */
	public Title[] searchYear(int year) {
		int num = 0;
		Title[] temp = new Title[1000];
		for (int i = 0; i < count; i++) {
			if (titles[i].getYear() == year) {
				temp[num++] = titles[i];
			}
		}
		Title[] result = new Title[num];
		for (int j = 0; j < num; j++) {
			result[j] = temp[j];
		}
		return result;
	}
/**
 * Method that displays the CallNumber, title, publisher, and year of each title
 * @param no parameters
 * @return no return value
 */
	public void viewAll() {
		System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "Call Number", "Title", "Publisher", "Year"));
		System.out.print(String.format("%-10s\t%-40s\t%-20s\t%-20s\n", "-----------",
				"--------------------------------------", "---------", "----"));

		for (int i = 0; i < count; i++) {
			System.out.println(titles[i].toString());
		}
	}
}
