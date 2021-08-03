/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 10, 2021
 * Last Date Modified: March 12, 2021
 *
 * Exception class for an invalid time
 */
public class InvalidTimeException extends Exception {
//default constructor
	public InvalidTimeException() {
		super("Invalid time. ");
	}
//constructor that takes a message
	public InvalidTimeException(String message) {
		super(message);
	}

}
