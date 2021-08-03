import java.io.File;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 * Main class CalendarManager to manage calendars
 */
public class CalendarManager {
//main method
	public static void main(String[] args) {
		Calendar myCalendar = new Calendar("events.txt"); //reads file
		Scanner input = new Scanner(System.in);
		int operation = 0;

		do {
			try {
				printMenu(); //repeatedly prints the menu for the user
				operation = input.nextInt();

				switch (operation) {
				case 1:
					System.out.println("Enter the description of the event:\n");
					String des = input.next();

					des += input.nextLine(); //formatting

					Event ev = myCalendar.findEvent(des); 
					if (ev != null) { //if the given event exists
						System.out.println("Event found: ");
						if (ev instanceof Meeting) { //is a meeting
							printLine();
							System.out.println(String.format("%-20s%s", "Meeting", ev.toString()));
						} else { //is an appointment
							printLine();
							System.out.println(String.format("%-20s%s", "Appointment", ev.toString()));
						}
					} else {
						System.out.println("Event not found.");
					}
					break;

				case 2: //adding a new event
					System.out.println("Enter the type of the event(meeting/appointment):");
					String type = input.nextLine();
					type += input.nextLine(); //formatting
					System.out.println("Enter the date of the event(mm/dd/yyyy):");
					String date = input.nextLine();
					if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) { //must be properly formatted date
						throw new InvalidDateException("Invalid Date Format."); 
					}
					int month = Integer.parseInt(date.substring(0, 2));
					if (month < 1 || month > 12) { //month range must be 1-12
						throw new InvalidDateException("Invalid month number –must be from 1 to 12.");
					}
					int day = Integer.parseInt(date.substring(3, 5));
					if(day < 1 || day > 31) { //day range must be 1-31
						throw new InvalidDateException("Invalid day number –must be from 1 to 31.");
					}
					int year = Integer.parseInt(date.substring(6));
					if(year < 1972 || year > 2030) { //range of years allowed
						throw new InvalidDateException("Invalid year –must be between 1972 to 2030.");
					}
					Date d = new Date(day, month, year);

					System.out.println("Enter the time of the event(hh:mm):"); 
					String time = input.nextLine();
					if(!time.matches("\\d{2}:\\d{2}")){ //must be proper format for a time
						throw new InvalidTimeException("Invalid time format —must be hh:mm.");
					}
					int hours = Integer.parseInt(time.substring(0, 2));
					if(hours > 23 || hours < 1) { //hours must be in range 1-23
						throw new InvalidTimeException("Invalid hours – must be from 0 to 23.");
					}
					int min = Integer.parseInt(time.substring(3));
					if(min > 59 || min < 1) { //minutes must be in range 1-59
						throw new InvalidTimeException("“Invalid minutes – must be from 0 to 59.");
					}
					Time t = new Time(hours, min);

					System.out.println("Enter the location of the event:");
					String loc = input.nextLine();

					System.out.println("Enter the description of the event:");
					String desc = input.nextLine();

					if (type.equals("meeting") || type.equals("Meeting")) {
						System.out.println("Enter the host of the event:");
						String host = input.nextLine();
						myCalendar.addEvent(new Meeting(desc, d, t, loc, host)); //adds new meeting object to eventList
					} else {
						System.out.println("Enter the contact of the event:");
						String con = input.nextLine();
						myCalendar.addEvent(new Appointment(desc, d, t, loc, con)); //adds new Appointment object to eventList
					}

					break;
				case 3: //removes event if it matches the description 
					System.out.println("Enter the description of the event: ");
					String descr = input.nextLine(); 
					descr += input.nextLine(); //formatting
					Event eve = myCalendar.findEvent(descr);
					if (eve != null) { //if the event exists
						myCalendar.removeEvent(eve); //remove it
					} else {
						System.out.println("Event not found.");
					}
					break;
				case 4: //displays all the events as formatted strings
					myCalendar.viewAllEvent();
					break;
				case 5:
					myCalendar.sortEvent(); //sorts the events by date and time
					break;
				case 6:
					myCalendar.saveToFile("events.txt"); //saves information
					break;

				}

			} catch (InvalidDateException e) {
				System.out.println(e.getMessage()); //handles InvalidDateException
			} catch (InvalidTimeException e) {
				System.out.println(e.getMessage()); //handles InvalidTimeException
			}

		} while (operation != 6);
	}
//displays menu for the user
	public static void printMenu() {
		String out = "Select and Operation: \n";
		out += "---------------------\n";
		out += "1: Find an event with a given description\n";
		out += "2: Add a new event\n";
		out += "3: Remove an existing event\n";
		out += "4: View all events\n";
		out += "5: Sort Events\n";
		out += "6: Quit the program\n";
		System.out.println(out);
	}
//formatting to organize information
	public static void printLine() {
		System.out.println(String.format("%-20s%-15s%-10s%-25s%-25s%-20s", "Type", "Date", "Time", "Location",
				"Description", "Host/Contact"));
		System.out.println(String.format("%-20s%-15s%-10s%-25s%-25s%-20s", "----", "----------", "----", "--------",
				"-----------", "------------"));

	}
}
