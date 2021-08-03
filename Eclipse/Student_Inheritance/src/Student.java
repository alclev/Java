/**
 * 
 * @author alexclevenger
 * @version 0.1 Date of creation: February 11, 2021 Last Date Modified: February
 *          19, 2021
 */
public class Student {
//private data members
	private String name;
	private int id;
	private double gpa;

//default constructor 
	public Student() {
		name = "none";
		id = 0;
		gpa = 0.0;
	}

	/**
	 * 
	 * @param name
	 * @param id
	 * @param gpa  constructor that takes 3 parameters String, int, and a double
	 */
	public Student(String name, int id, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	/**
	 * Accessor method for the name of Student
	 * 
	 * @param no parameters
	 * @return the value of the data member name
	 **/
	public String getName() {
		return name;
	}

	/**
	 * Accessor method for the ID of Student
	 * 
	 * @param no parameters
	 * @return the value of the data member ID
	 **/
	public int getID() {
		return id;
	}

	/**
	 * Accessor method for the gpa of Student
	 * 
	 * @param no parameters
	 * @return the value of the data member gpa
	 **/
	public double getGPA() {
		return gpa;
	}

	/**
	 * Mutator method for the name of a student
	 * 
	 * @param name to set the data member name
	 * @return no return value
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Mutator method for the id of a student
	 * 
	 * @param id to set the data member id
	 * @return no return value
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Mutator method for the gpa of a student
	 * 
	 * @param gpa to set the data member dpa
	 * @return no return value
	 */
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Method to get information from Student
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-20s\t%-10d\t%-10.2f", name, id, gpa);
	}
}
