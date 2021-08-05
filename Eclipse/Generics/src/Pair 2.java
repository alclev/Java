/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 18, 2021 
 * Last Date Modified: March 19,2021
 *
 * Generic class with 2 generic types
 * 
 */
public class Pair<E1, E2> {
//private data members
	private E1 first;
	private E2 second;

//default constructor
	public Pair() {
		first = null; // must be class types
		second = null;
	}

//constructor with 2 parameters
	public Pair(E1 first, E2 second) {
		this.first = first;
		this.second = second;
	}
	/**
	 * Accessor method for the data member first
	 * @param no parameters
	 * @return E1
	 * 
	 */
	public E1 getFirst() {
		return first;
	}
	/**
	 * Accessor method for the data member second
	 * @param no parameters
	 * @return E2
	 */
	public E2 getSecond() {
		return second;
	}
	/**
	 * Mutator method for the data member first
	 * @param first
	 * @return no return value
	 */
	public void setFirst(E1 first) {
		this.first = first;
	}
	/**
	 * Mutator method for the data member second
	 * @param second
	 * @return no return value
	 */
	public void setSecond(E2 second) {
		this.second = second;
	}
	/**
	 * Method that displays the information stored in the private data members
	 * as a string 
	 */
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	/**
	 * Method that defines what sets two instances of Pair as equal
	 */
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair<E1, E2> p = (Pair<E1, E2>) o;
			return this.first.equals(p.first) &&
					this.second.equals(p.second);
		}
		return false;
	}
}
