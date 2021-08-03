/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 * Class meeting to model a meeting derived from event
 */
public class Meeting extends Event {
//private data members
	private String host;
//default constructor
	public Meeting() {
		super();
		host = "none";
	}
//constructor with 5 parameters
	public Meeting(String description, Date date, Time time, String location, String host) {
		super(description, date, time, location);
		this.host = host;
	}
	/**
	 * Accessor method for the data member host
	 * @param no parameters 
	 * @return String
	 */
	public String getHost() {
		return host;
	}
	/**
	 * Setter for the data member host
	 * @param host
	 * @return no return value
	 */
	public void setHost(String host) {
		this.host = host;
	}
/**
 * Method to return the information of a meeting as a formatted string 
 */
	@Override
	public String toString() {
		return String.format("%s%-20s", super.toString(), host);
	}
}
