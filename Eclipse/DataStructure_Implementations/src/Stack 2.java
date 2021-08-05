import java.util.ArrayList;
import java.util.EmptyStackException;
/**
 * 
 * @author alexclevenger
 *
 *  all methods O(1) except push() O(1)/O(n) and toString() O(n)
 */
public class Stack<E> {
	private ArrayList<E> elements;

	public Stack() {
		elements = new ArrayList<>();
	}


	public int size() {
		return elements.size();
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public void push(E item) {
		elements.add(item);
	}

	public E peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return elements.get(size() - 1); //top element
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		E value = peek();
		elements.remove(size() - 1);
		return value;
	}

	public String toString() {
		return "Stack: " + elements.toString();
	}
}