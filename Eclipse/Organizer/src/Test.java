import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 1, 2021 
 * Last Date Modified: April 6, 2021
 *
 * Testing class for contacts and notes
 */
public class Test {

	public static void main(String[] args) {
		Organizer<Contact> contacts = new Organizer<>();
		Organizer<Note> notes = new Organizer<>();

		// Testing Organizer for type Note
		readNotes(notes, "notes.txt");
		System.out.println("List of notes:\n" + notes);
		Note n = new Note(new Date(2, 22, 2021), "Medicine", "Pick up at the pharmacy");
		notes.addElement(n);
		System.out.println("Note: (" + n + ") added successfully.");
		System.out.println("\nList of notes:\n" + notes);
		n = new Note(new Date(1,26,2021), "", "");
		n = notes.findElement(n);
		if (n == null)
			System.out.println("Note not found.");
		else {
			System.out.println("Note found: " + n);
			notes.removeElement(n);
			System.out.println("Note (" + n + ") removed successfully.");
		}
		System.out.println("\nList of notes:\n" + notes);

		// Testing Organizer for type Contact
		readContacts(contacts, "contacts.txt");
		System.out.println("\nList of contacts:\n" + contacts);
		Contact c = new Contact("Floss Albert", "610-222-2434", "afloss@lehigh.edu");
		contacts.addElement(c);
		System.out.println("Contact (" + c + ") added successfully.");
		System.out.println("\nList of contacts:\n" + contacts);
		c = new Contact("Philip Mensen", "", "");
		c = contacts.findElement(c);
		if (c == null)
			System.out.println("Contact not found.");
		else {
			System.out.println("Contact found: " + c);
			contacts.removeElement(c);
			System.out.println("Contact (" + c + ") removed successfully.");
		}
		c = new Contact("Albares Cammy", "", "");
		c = contacts.findElement(c);
		if (c == null)
			System.out.println("Contact not found.");
		else {
			System.out.println("Contact found: " + c);
			contacts.removeElement(c);
			System.out.println("Contact(" + c + ") removed successfully.");
		}
		System.out.println("\nList of contacts:\n" + contacts);
	}

	/***
	 * readNotes reads the file "filename" and updates notes
	  * with the information read from the filename
		* @param notes Organizer object where the created notes will be added
		* @param filename file where the information of the notes is read from
	*/
	public static void readNotes(Organizer<Note> notes, String filename) {
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ");  //checks to see if file is there
			System.exit(0);
		}
		while(readFile.hasNext()) {
			
			String date = readFile.nextLine();
			
			int month = Integer.parseInt(date.substring(0, 2)); //splits into three chunks
			
			int day = Integer.parseInt(date.substring(3, 5));
			
			int year = Integer.parseInt(date.substring(6));
			
			Date d = new Date(day, month, year);
			
			String title = readFile.nextLine();
			
			String desc = readFile.nextLine();
			
			notes.addElement(new Note(d, title, desc));
			
		}
		
	}
	/***
	 * readContacs reads the file "filename" and updates contacts
	  * with the information read from the filename
		* @param contacts Organizer object where the created contacts will be added
		* @param filename file where the information of the contacts is read from
	*/
	public static void readContacts(Organizer<Contact> contacts, String filename) {

		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ");  //checks to see if file is there
			System.exit(0);
		}
		while(readFile.hasNext()) {
			
			String line = readFile.nextLine();
			String[] tokens = line.split(" ");
			
			String name = tokens[0] + " " + tokens[1];
			String phone = tokens[2];
			String email = tokens[3];
			
			contacts.addElement(new Contact(name, phone, email));
			
		}
	}

}
