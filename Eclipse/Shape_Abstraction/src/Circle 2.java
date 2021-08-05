/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 * Class circle to model a circle derived from class Shape
 */
public class Circle extends Shape {
//private data member
	private double radius;
//default constructor 
	public Circle() {
		radius = 0.0;
	}
//constructor with 2 parameters
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	/**
	 * Accessor method for the radius of a Circle
	 * 
	 * @param no parameters 
	 * @return the value of the data member radius 
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * Mutator method for the radius of a Circle
	 * 
	 * @param radius to set the data member radius
	 * @return no return value
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * Method to get information from a Circle
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-20s\t%-10s\t%-10.2f\t\t\t\t\t%-10.2f\t%-10.2f", "Circle", super.toString(), radius, getArea(), getPerimeter());
	}
	/**
	 * Accessor method for the area of a Circle
	 * 
	 * @param no parameters 
	 * @return the value of the calculated area
	 */
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	/**
	 * Accessor method for the perimeter of a Circle
	 * 
	 * @param no parameters 
	 * @return the value of the calculated perimeter 
	 */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	/**
	 * Mutator method for the radius of a Circle
	 * 
	 * @param factor to scale the radius by the given factor 
	 * @return no return value
	 */
	public void scale(double factor) {
		radius *= factor;
	}
	/**
	 * Method to make a deep copy of a Circle 
	 * 
	 * @param no parameters 
	 * @return a new Circle 
	 */
	public Object clone() {
		return new Circle(getColor(), radius);
	}
}
