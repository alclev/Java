/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 3, 2021 
 * Last Date Modified: May 3, 2021
 *
 * @param <E>
 * Class Pair to model a Pair
 */
public class Pair<E1 extends Comparable<E1>, E2> implements Comparable<Pair<E1, E2>> {
//private data membners
	private E1 first;
	private E2 second;
//constructors
	public Pair(E1 f, E2 s) {
		first = f;
		second = s;
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
	public void setFirst(E1 f) {
		first = f;
	}
	/**
	 * Mutator method for the data member second
	 * @param second
	 * @return no return value
	 */
	public void setSecond(E2 s) {
		second = s;
	}
	/**
	 * Method that defines what sets two instances of Pair as equal
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			Pair<E1, E2> p = (Pair<E1, E2>) obj;
			return this.first.equals(p.first) && this.second.equals(p.second);
		}
		return false;
	}
	/**
	 * Method that displays the information stored in the private data members
	 * as a string 
	 * @param no parameters
	 * @return no return value
	 */
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	/**
	 * Defining how to compare two pairs
	 * @param p
	 * @return int
	 */
	public int compareTo(Pair<E1, E2> p) {
		return this.first.compareTo(p.first);
		
	}
}
