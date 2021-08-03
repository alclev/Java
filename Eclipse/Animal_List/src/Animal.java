/**
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 8, 2021
 * Last Date Modified: February 12, 2021
 * class to model the entity Animal
 */
public class Animal {
//private data members
	private String name;
	private double weight;
/**
 * default constructor 
 * initializes fields name and weight
 */
	public Animal() {
		name = "none";
		weight = 0.0;
	}
/**
 * @param name
 * @param weight
 * constructor with 2 parameters
 */
	public Animal(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
/**
 * @parameters no parameters
 * @return the name of an Animal
 */
	public String getName() {
		return name;
	}
/**
 * @parameters no parameters
 * @return the weight of an Animal
 */
	public double getWeight() {
		return weight;
	}
/**
 * @parameters name to change the data member name
 * @return name of an Animal
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Mutator for the weight of an animal
 * @param weight to set the data member weight
 * no return value
 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
/**
 * Method to get information from an Animal
 * @param no parameters 
 * @return displays the data stored in private instance variables as a formatted string
 */

	public String toString() {
		return String.format("%-10s\t%-10.2f", name, weight);
	}
}
