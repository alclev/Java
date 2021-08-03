import java.util.InputMismatchException;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 11, 2021
 * Last Date Modified: February 19, 2021
 * 
 * Exception class for an invalid gpa
 */
public class InvalidGPAException extends InputMismatchException {
//default constructor
	public InvalidGPAException() {
		super("Invalid ID.");
	}
//constructor with one string parameter
	public InvalidGPAException(String message) {
		super(message);
	}

}
