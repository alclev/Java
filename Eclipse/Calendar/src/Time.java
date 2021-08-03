/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 *  Class time to model a time
 */
public class Time implements Comparable<Time> {
//private data members
	private int hours;
	private int minutes;
//default constructor
	public Time() {
		hours = 0;
		minutes = 0;
	}
//constructor with 2 parameters
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	/**
	 * Accessor method for the data member hours
	 * @param no parameters 
	 * @return int
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * Accessor method for the data member minutes
	 * @param no parameters 
	 * @return int
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * Setter for the data member hours
	 * @param hours
	 * @return no return value
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	/**
	 * Setter for the data member minutes
	 * @param minutes
	 * @return no return value
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
/**
 * Overridden method to return the information of a time object as a formatted string
 */
	@Override
	public String toString() {
		return String.format("%02d:%02d", hours, minutes);
	}
/**
 * Overridden method to define how to compare two times
 */
	@Override
	public int compareTo(Time o) {
		if (hours > o.getHours()) {
			return 1;
		}
		if (hours < o.getHours()) {
			return -1;
		} else {
			if (minutes > o.getMinutes()) {
				return 1;
			}
			if (minutes < o.getMinutes()) {
				return -1;
			}
		}
		return 0;
	}

}
