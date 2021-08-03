/**
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 8, 2021 Last Date Modified: February 12, 2021
 *
 * class to model entity DomesticAnimal derived from Animal
 */
public class DomesticAnimal extends Animal {
	// private data fields
	private String owner;

	/**
	 * default constructor that initializes value owner with "none" that also calls
	 * constructor of parent class
	 */
	public DomesticAnimal() {
		super();
		owner = "none";
	}

	/**
	 * constructor with 3 parameters
	 * 
	 * @param name
	 * @param weight
	 * @param owner
	 */
	public DomesticAnimal(String name, double weight, String owner) {
		super(name, weight);
		this.owner = owner;
	}

	/**
	 * @param no parameters
	 * @return the name of the owner
	 */
	public String getOwner() {
		return owner;
	}
/**
 * Mutator method for the owner of a DomesticAnimal
 * @parameters owner to set the data member owner
 * @return no return value
 * 
 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Method to get information from a DomesticAnimal
     * @param no parameters 
     * @return displays the data stored in private instance variables as a formatted string
	 */

	@Override
	public String toString() {
		return String.format("%-10s\t%s\t%-10s\n", "Domestic", super.toString(), owner);
	}

}
