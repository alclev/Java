/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 *Class Periodical to model a periodical derived from class title
 */
public class Periodical extends Title {
	private int issue;
	private int month;
//default constructor
	public Periodical() {
		issue = 0;
		month = 0;
	}
//constructor with 7 parameters
	public Periodical(String callNumber, String title, String publisher, int year, int copies, int issue, int month) {
		super(callNumber, title, publisher, year, copies);
		this.issue = issue;
		this.month = month;
	}
	/**
	 * Accessor method for the issue of a Periodical
	 * 
	 * @param no parameters
	 * @return the value of the data member issue
	 **/
	public int getIssue() {
		return issue;
	}
	/**
	 * Accessor method for the month of a Periodical
	 * 
	 * @param no parameters
	 * @return the value of the data member month
	 **/
	public int getMonth() {
		return month;
	}
	/**
	 * Mutator method for the issue of a Periodical
	 * 
	 * @param issue to set the data member issue
	 * @return no return value
	 */
	public void setIssue(int issue) {
		this.issue = issue;
	}
	/**
	 * Mutator method for the month of a Periodical
	 * 
	 * @param month to set the data member month
	 * @return no return value
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * Method to get information from a Periodical
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return super.toString(); //did not add values of issue and month 
		//this is because we are only supposed to display the CN, title, publisher, and year for the user
	}

}
