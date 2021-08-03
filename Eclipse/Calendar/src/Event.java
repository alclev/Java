/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 *Abstract Class Event to model an event in general
 */
public abstract class Event implements Comparable<Event> {
//private data members 
	private String description;
	private Date date;
	private Time time;
	private String location;
//protected default constructor
	protected Event() {
		description = "none";
		date = new Date();
		time = new Time();
		location = "none";
	}
//protected constructor with 4 parameters
	protected Event(String description, Date date, Time time, String location) {
		this.description = description;
		this.date = date;
		this.time = time;
		this.location = location;
	}
/**
 * Accessor method for the data member description
 * @param no parameters 
 * @return String
 */
	public String getDescription() {
		return description;
	}
	/**
	 * Accessor method for the data member date
	 * @param no parameters 
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Accessor method for the data member time
	 * @param no parameters 
	 * @return Time
	 */
	public Time getTime() {
		return time;
	}
	/**
	 * Accessor method for the data member location
	 * @param no parameters 
	 * @return String
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Setter for the data member description
	 * @param description
	 * @return no return value
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Setter for the data member date
	 * @param date
	 * @return no return value
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Setter for the data member time
	 * @param time
	 * @return no return value
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	/**
	 * Setter for the data member location
	 * @param location
	 * @return no return value
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Method to return information of Event as a formatted string
	 */
	@Override
	public String toString() {
		return String.format("%-15s%-10s%-25s%-25s", date.toString(), time.toString(), location, description);
	}
/**
 * Method that shows if descriptions of two events are the same
 * @param e
 * @return boolean
 */
	public boolean equals(Event e) {
		return description.equals(e.getDescription());
	}
/**
 * Overridden method that defines how to compare two events
 */
	@Override
	public int compareTo(Event e) {
		if (date.compareTo(e.getDate()) == 1) {
			return 1;
		}
		if (date.compareTo(e.getDate()) == -1) {
			return -1;
		} else {
			if (time.compareTo(e.getTime()) == 1) {
				return 1;
			}
			if (time.compareTo(e.getTime()) == -1) {
				return -1;
			}
		}
		return 0;
	}
}
