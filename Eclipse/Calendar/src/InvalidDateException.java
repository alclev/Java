/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 * Exception class for an invalid date
 */
public class InvalidDateException extends Exception {
//default constructor
	public InvalidDateException() {
		super("Invalid Date. ");
	}
//constructor that takes a message
	public InvalidDateException(String message) {
		super(message);
	}

}
