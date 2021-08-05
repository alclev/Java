/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 * Abstract class to model the common behavior amongst the shapes
 */
public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable {
	private String color;
//default constructor
	protected Shape() {
		color = "none";
	}
//protected constructor with one parameter
	protected Shape(String color) {
		this.color = color;
	}
	/**
	 * Accessor method for the color of a Shape
	 * 
	 * @param no parameters
	 * @return the value of the data member color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Mutator method for the color of a Shape
	 * 
	 * @param color to set the data member color
	 * @return no return value
	 */
	public void setColor(String color) {
		this.color = color;
	}
//method signature for obtaining the area of a shape
	public abstract double getArea();
//method signature for getting the perimeter of a shape
	public abstract double getPerimeter();
/**
 * 
 * defining the method compareTo from the interface Comparable<Shape>
 * @param s to use to compare to another given shape
 * @return 0,1, of -1 indicating whether the area is equal to, greater than, or less than the area of another shape 
 */
	public int compareTo(Shape s) {
		if (getArea() == s.getArea()) {
			return 0;
		} else if (getArea() > s.getArea()) {
			return 1;
		}
		return -1;
	}
	//method signature for to clone an object
	public abstract Object clone();
	/**
	 * Method to get information from a Shape
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-10s",color);
	}
}
