import java.util.InputMismatchException;

public class InvalidNumberException extends InputMismatchException {

	public InvalidNumberException() {
		super("Invalid Number.");
	}

	public InvalidNumberException(String message) {
		super(message);
	}
}
