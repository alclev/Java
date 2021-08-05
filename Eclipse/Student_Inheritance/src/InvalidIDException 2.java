import java.util.InputMismatchException;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 11, 2021
 * Last Date Modified: February 19, 2021
 * 
 * Exception class for an invalid ID
 */
public class InvalidIDException extends InputMismatchException {
//default constructor
	public InvalidIDException() {
		super("Invalid Id.");
	}

//constructor with one string parameter 
	public InvalidIDException(String message) {
		super(message);
	}

	
}
