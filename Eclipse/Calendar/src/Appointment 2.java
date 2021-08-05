/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 *Class appointment to model an appointment derived from event
 */
public class Appointment extends Event {
//private data members
	private String contact;
//default constructor
	public Appointment() {
		super();
		contact = "none";
	}
//constructor with 5 parameters
	public Appointment(String description, Date date, Time time, String location, String contact) {
		super(description, date, time, location);
		this.contact = contact;
	}
/** 
 * Accessor method for the data member contact
 * @param no parameters
 * @return String
 */
	public String getContact() {
		return contact;
	}
/**
 * Mutator method for a contact
 * @param contact
 * @return no return value
 */
	public void setContact(String contact) {
		this.contact = contact;
	}
/**
 * Method to return information of appointment as a formatted string
 * @param no parameters
 * @return string
 */
	@Override
	public String toString() {
		return String.format("%s%-20s", super.toString(), contact);
	}

}
