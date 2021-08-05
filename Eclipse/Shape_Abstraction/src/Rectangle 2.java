/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 *Class Rectangle to model a rectangle derived from class shape
 */
public class Rectangle extends Shape {
//private data members
	private double length;
	private double width;
//default constructor 
	public Rectangle() {
		length = 0.0;
		width = 0.0;
	}
//constructor with 3 parameters
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}
	/**
	 * Accessor method for the length of a Rectangle 
	 * 
	 * @param no parameters 
	 * @return the value of the data member length  
	 */
	public double getLength() {
		return length;
	}
	/**
	 * Accessor method for the width of a Rectangle 
	 * 
	 * @param no parameters 
	 * @return the value of the data member width   
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * Mutator method for the length of a Rectangle 
	 * 
	 * @param length to set value of data member length 
	 * @return no return value 
	 */
	public void setLength(double length) {
		this.length = length;
	}
	/**
	 * Mutator method for the width of a Rectangle 
	 * 
	 * @param width to set the value of the data member width 
	 * @return no return value
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * Method to get information from a Rectangle 
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-20s\t%-10s\t%-10.2f\t%-10.2f\t\t\t%-10.2f\t%-10.2f", "Rectangle", super.toString(), length, width, getArea(), getPerimeter());
	}
	/**
	 *  Method to get the area of a Rectangle 
	 * 
	 * @param no parameters 
	 * @return the value of the calculated area
	 */
	public double getArea() {
		return length * width;
	}
	/**
	 *  Method to get the perimeter of a Rectangle 
	 * 
	 * @param no parameters 
	 * @return the value of the calculated perimeter 
	 */
	public double getPerimeter() {
		return (2 * length) + (2 * width);
	}
	/**
	 *  Method to get the scale the length and width of a rectangle 
	 * 
	 * @param factor to scale the length and width by a given factor 
	 * @return no return value
	 */
	public void scale(double factor) {
		length *= factor;
		width *= factor;
	}
	/**
	 *  Method to make a deep copy of a Rectangle
	 * 
	 * @param no parameters 
	 * @return a new Rectangle 
	 */
	public Object clone() {
		return new Rectangle(getColor(), length, width);
	}
}