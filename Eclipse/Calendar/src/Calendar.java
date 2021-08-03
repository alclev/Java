import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 *Class calendar to model a calendar
 */
public class Calendar {
//private data members
	private Event[] eventList;
	private int count;
//default constructor
	public Calendar() {
		eventList = new Event[100];
		count = 0;
	}
//constructor with 1 parameter
	public Calendar(String filename) {
		File file = new File(filename);
		count =0;
		eventList = new Event[100];
		Scanner readFile = null;

		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. ");  //checks to see if file is there
			System.exit(0);
		}

		while (readFile.hasNext()) { 
			String type = readFile.nextLine();
			
			if (type.equals("appointment") || type.equals("Appointment")) { //makes an appointment object
				
				String date = readFile.nextLine();
				
				int month = Integer.parseInt(date.substring(0, 2)); //splits string into 3 chunks
				
				int day = Integer.parseInt(date.substring(3, 5));
				
				int year = Integer.parseInt(date.substring(6));
				
				Date d = new Date(day, month, year); //new Date object
				
				
				String time = readFile.nextLine();
				int hours = Integer.parseInt(time.substring(0, 2)); //splits into 2 chunks
				int min = Integer.parseInt(time.substring(3));
				Time t = new Time(hours, min); 
				
				String loc = readFile.nextLine();
				
				String des = readFile.nextLine();
				
				String con = readFile.nextLine();
				
				Appointment apmt = new Appointment(des, d, t, loc, con);
				
				eventList[count++] = apmt; //appointment added to the event list
				
				
			} else if (type.equals("meeting") || type.equals("Meeting")) { //makes a meeting object
				String date = readFile.nextLine();
				
				int month = Integer.parseInt(date.substring(0, 2)); //splits into three chunks
				
				int day = Integer.parseInt(date.substring(3, 5));
				
				int year = Integer.parseInt(date.substring(6));
				
				Date d = new Date(day, month, year);
				
				String time = readFile.nextLine(); //splits into 2 chunks
				int hours = Integer.parseInt(time.substring(0, 2));
				int min = Integer.parseInt(time.substring(3));
				Time t = new Time(hours, min);
				
				String loc = readFile.nextLine();
				
				String des = readFile.nextLine();
				
				String host = readFile.nextLine();
				
				Meeting mtg = new Meeting(des, d, t, loc, host);
				 
				eventList[count++] = mtg; //adds meeting object to event list
			}
			
		}
	}
/**
 * Method that returns event with given description
 * @param d
 * @return Event
 */
	public Event findEvent(String d) {
		for (int i = 0; i < count; i++) {
			if (eventList[i].getDescription().equals(d)) {
				return eventList[i];
			}
		}
		return null;
	}
/**
 * Method that returns index of event in eventList
 * @param e
 * @return int
 */
	public int evIndex(Event e) {
		for (int i = 0; i < count; i++) {
			if (eventList[i].getDescription().equals(e.getDescription())) {
				return i;
			}
		}
		return -1;
	}
/**
 * Method that adds event if the event list is not full
 * @param event e
 * @return boolean
 */
	public boolean addEvent(Event e) {
		if (count != eventList.length) {
			eventList[count++] = e;
			return true;
		}
		return false;
	}
/**
 * Method that removes a given event from the event list
 * @param Event e
 * @return boolean
 */
	public boolean removeEvent(Event e) {

		int index = evIndex(e);
		if (index != -1) {

			for (int i = index; i < count; i++) {
				eventList[i] = eventList[i + 1];
			}
			count--;
			return true;
		}
		return false;
	}
/**
 * Method that displays the information of each event in eventList
 * @param no parameters
 * @return no return value
 */
	public void viewAllEvent() {
		System.out.println(String.format("%-20s%-15s%-10s%-25s%-25s%-20s", "Type", "Date", "Time", "Location", "Description", "Host/Contact"));
		System.out.println(String.format("%-20s%-15s%-10s%-25s%-25s%-20s", "----", "----------", "----", "--------", "-----------", "------------"));
		
		for (int i = 0; i < count; i++) {
			
			if(eventList[i] instanceof Meeting) {
				System.out.println(String.format("%-20s%s","Meeting", eventList[i].toString()));
			}
			else {
				System.out.println(String.format("%-20s%s","Appointment", eventList[i].toString()));
			}
			
		}
	}
/**
 * Method that sorts the events by date and time
 * @param no parameters
 * @return no return value
 */
	public void sortEvent() {
		java.util.Arrays.sort(eventList, 0, count);
	}
/**
 * Method that saves the information in eventList in the file
 * 
 * @param filename
 * @return no return value
 */
	public void saveToFile(String filename) {
		PrintWriter write = null;
		try {
			write = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found"); //ensures the file can be found or else program terminates
			System.exit(0);
		} //saves data line by line so it can be read again when the program runs for a second time
		for(int i = 0; i < count; i ++) {
			if (eventList[i] instanceof Meeting) {
				write.println("meeting");
				write.println(eventList[i].getDate().toString());
				write.println(eventList[i].getTime().toString());
				write.println(eventList[i].getLocation());
				write.println(eventList[i].getDescription());
				write.println(((Meeting)eventList[i]).getHost());
			}
			else { //is an appointment
				write.println("appointment");
				write.println(eventList[i].getDate().toString());
				write.println(eventList[i].getTime().toString());
				write.println(eventList[i].getLocation());
				write.println(eventList[i].getDescription());
				write.println(((Appointment)eventList[i]).getContact());
			}
		}
		System.out.println("File events.txt opened for writing successfully.");
		System.out.println("Writing Data to file events.txt ...");
		write.close();
	}

}
