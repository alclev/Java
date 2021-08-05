/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 *Class Book to model a book derived from class Title
 */
public class Book extends Title {
//private data members
	private String author;
	private String isbn;
//default constructor 
	public Book() {
		author = "none";
		isbn = "none";
	}
//constructor with 7 parameters
	public Book(String callNumber, String title, String publisher, int year, int copies, String author, String isbn) {
		super(callNumber, title, publisher, year, copies);
		this.author = author;
		this.isbn = isbn;
	}
	
	/**
	 * Accessor method for the author of a Book
	 * 
	 * @param no parameters
	 * @return the value of the data member author
	 **/
	
	public String getAuthor() {
		return author;
	}
	/**
	 * Accessor method for the ISBN of a Book
	 * 
	 * @param no parameters
	 * @return the value of the data member ISBN
	 **/
	public String getISBN() {
		return isbn;
	}
	/**
	 * Mutator method for the author of a Book
	 * 
	 * @param author to set the data member author
	 * @return no return value
	 */
	public void setAuthors(String author) {
		this.author = author;
	}
	/**
	 * Mutator method for the isbn of a Book
	 * 
	 * @param isbn to set the data member isbn
	 * @return no return value
	 */
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * Method to get information from a Periodical
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return super.toString(); //I did not add the values of author and isbn onto this intentionally
	} //this is because we are only supposed to display the CN, title, publisher, and year to the user
}
