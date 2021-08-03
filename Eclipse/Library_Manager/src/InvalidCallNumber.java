import java.util.InputMismatchException;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 16, 2021
 * Last Date Modified: February 19, 2021
 *
 *Exception class for an invalid call number
 */
public class InvalidCallNumber extends InputMismatchException {
//default constructor
	public InvalidCallNumber() {
		super("Invalid Call Number. ");
	}
//construcotr with string paramter
	public InvalidCallNumber(String message) {
		super(message);
	}
}
