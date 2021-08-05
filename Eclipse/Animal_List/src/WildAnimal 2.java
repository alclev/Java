/**
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 8, 2021
 * Last Date Modified: February 12, 2021
 *
 *class to model entity WildAnimal derived from Animal
 */
public class WildAnimal extends Animal {
	//private data fields
	private String origin;
/**
 * default constructor that assigns value of "none" to origin and calls the default constructor of parent class
 */
	public WildAnimal() {
		super();
		origin = "none";
	}
/**
 * constructor with 3 parameters
 * @param name
 * @param weight
 * @param origin
 */
	public WildAnimal(String name, double weight, String origin) {
		super(name, weight);
		this.origin = origin;
	}
/**
 * @param no parameters
 * @return the origin of a WildAnimal
 */
	public String getOrigin() {
		return origin;
	}
/**
 * Mutator for the origin of a WildAnimal
 * @param origin to set the data member origin
 * @return no return value
 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
/**
 * Method to get information from a WildAnimal
 * @param no parameters 
 * @return displays the data stored in private instance variables as a formatted string
 */
	@Override
	public String toString() {
		return String.format("%-10s\t%s\t%-10s\n", "Wild", super.toString(), origin);
	}
}
