import java.util.InputMismatchException;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 *Exception class for an invalid date
 */
public class InvalidDate extends InputMismatchException{
//default constructor 
	public InvalidDate() {
		super("Invalid Date. ");
	}
//constructor with one string parameter
	public InvalidDate(String message) {
		super(message);
	}
}
