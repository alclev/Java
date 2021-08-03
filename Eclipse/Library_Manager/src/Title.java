/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 *Class to model a Title 
 */
public class Title {
//private data members
	private String callNumber;
	private String title;
	private String publisher;
	private int year;
	private int copies;
//default constructor
	public Title() {
		callNumber = "none";
		title = "none";
		publisher = "none";
		year = 0;
		copies = 0;
	}
//constructor with 5 parameters
	public Title(String callNumber, String title, String publisher, int year, int copies) {
		this.callNumber = callNumber;
		this.title = title;
		this.publisher = publisher;
		this.year = year;
		this.copies = copies;
	}
	/**
	 * Accessor method for the callNumber of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member callNumber
	 **/
	public String getCallNumber() {
		return callNumber;
	}
	/**
	 * Accessor method for the title of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member title
	 **/
	public String getTitle() {
		return title;
	}
	
	/**
	 * Accessor method for the publisher of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member publisher
	 **/
	public String getPublisher() {
		return publisher;
	}
	/**
	 * Accessor method for the year of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member year
	 **/
	public int getYear() {
		return year;
	}
	/**
	 * Accessor method for the copies of a Title
	 * 
	 * @param no parameters
	 * @return the value of the data member copies
	 **/
	public int getCopies() {
		return copies;
	}
	/**
	 * Mutator method for the callNumber of a Title
	 * 
	 * @param callNumber to set the data member callNumber
	 * @return no return value
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	/**
	 * Mutator method for the title of a Title
	 * 
	 * @param title to set the data member title
	 * @return no return value
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Mutator method for the publisher of a Title
	 * 
	 * @param publisher to set the data member publisher
	 * @return no return value
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * Mutator method for the year of a Title
	 * 
	 * @param year to set the data member year
	 * @return no return value
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Mutator method for the copies of a Title
	 * 
	 * @param copies to set the data member copies
	 * @return no return value
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}
	/**
	 * Method to get information from a Title
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {

		return String.format("%-10s\t%-40s\t%-20s\t%-20d", callNumber, title, publisher, year);
	}
}
