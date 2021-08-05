/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 * Class Hexagon to model a hexagon derived from class Shape
 */

public class Hexagon extends Shape {
//private data member
	private double side;
//default constructor 
	public Hexagon() {
		super();
		side = 1.0;
	}
//constructor with 2 parameters
	public Hexagon(String color, double side) {
		super(color);
		this.side = side;
	}
	/**
	 * Accessor method for the side of a Hexagon 
	 * 
	 * @param no parameters 
	 * @return the value of the data member side 
	 */
	public double getSide() {
		return side;
	}
	/**
	 * Mutator method for the side of a Hexagon
	 * 
	 * @param side to set the data member side
	 * @return no return value
	 */
	public void setSide(double side) {
		this.side = side;
	}
	/**
	 * Accessor method for the area of a Hexagon
	 * 
	 * @param no parameters 
	 * @return the value of the calculated area
	 */
	public double getArea() {
		double area;
		area = (3 * Math.sqrt(3) / 2) * side * side;
		return area;
	}
	/**
	 * Accessor method for the perimeter of a Hexagon
	 * 
	 * @param no parameters 
	 * @return the value of the calculated perimeter
	 */
	public double getPerimeter() {
		return side * 6;
	}
	/**
	 * Method to scale the side length by a given factor 
	 * 
	 * @param factor to scale the side of a Hexagon 
	 * @return no return value
	 */
	public void scale(double factor) {
		side *= factor;
	}
	/**
	 * Method to make a deep copy of a Hexagon 
	 * 
	 * @param no parameters 
	 * @return a new Hexagon 
	 */
	public Object clone() {
		return new Hexagon(getColor(), side);
	}
	/**
	 * Method to get information from a Hexagon
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-20s\t%-10s\t%-10.2f\t\t\t\t\t%-10.2f\t%-10.2f", "Hexagon", super.toString(), side, getArea(), getPerimeter());
	}
}
