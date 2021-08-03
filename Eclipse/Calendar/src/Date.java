/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 *Class Date to model a Date 
 */
public class Date implements Comparable<Date> {
//private data members
	private int day;
	private int month;
	private int year;
//default constructor
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
//constructor with 3 parameters
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
/**
 * Accessor for the data member day
 * @param no parameters
 * @return int
 */
	public int getDay() {
		return day;
	}
/*
 * Accessor for the data member 
 * @param no parameters
 * @return int
 */
	public int getMonth() {
		return month;
	}
/**
 * Accessor for data member year
 * @param no parameters
 * @return int
 */
	public int getYear() {
		return year;
	}
/**
 * Setter for the data member day
 * 
 * @param int
 * @return no return value
 */
	public void setDay(int day) {
		this.day = day;
	}
/**
 * Setter for the data member month
 * 
 * @param month
 * @return no return value
 */
	public void setMonth(int month) {
		this.month = month;
	}
/**
 * Setter for the data member year
 * 
 * @param year
 * @return no return value
 */
	public void setYear(int year) {
		this.year = year;
	}
/**
 * returns the information of a date as a formatted string
 */
	@Override
	public String toString() {
		return String.format("%02d/%02d/%02d", day, month, year);
	}
/**
 * defines how to compare dates 
 */
	@Override
	public int compareTo(Date o) {
		if (year > o.getYear()) {
			return 1;
		}
		if (year < o.getYear()) {
			return -1;
		} else {
			if (month > o.getMonth()) {
				return 1;
			}
			if (month < o.getMonth()) {
				return -1;
			} else {
				if (day > o.getDay()) {
					return 1;
				}
				if (day < o.getDay()) {
					return -1;
				}
			}
		}
		return 0;
	}

}
