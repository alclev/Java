/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 * Class Triangle to model a triangle derived from class Shape
 */
public class Triangle extends Shape {
//private data members
	private double side1;
	private double side2;
	private double side3;
//default constructor
	public Triangle() {
		side1 = 0.0;
		side2 = 0.0;
		side3 = 0.0;
	}
//constructor with 4 parameters
	public Triangle(String color, double side1, double side2, double side3) {
		super(color);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	/**
	 *  Accessor method to get the side of a triangle
	 * 
	 * @param no parameters 
	 * @return the value of side1
	 */
	public double getSide1() {
		return side1;
	}
	/**
	 *  Accessor method to get the side of a triangle
	 * 
	 * @param no parameters 
	 * @return the value of side2
	 */
	public double getSide2() {
		return side2;
	}
	/**
	 *  Accessor method to get the side of a triangle
	 * 
	 * @param no parameters 
	 * @return the value of side3
	 */
	public double getSide3() {
		return side3;
	}
	/**
	 *  Mutator method to set the side of a triangle
	 * 
	 * @param side1 to set the data member side1
	 * @return no return value
	 */
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	/**
	 *  Mutator method to set the side of a triangle
	 * 
	 * @param side2 to set the data member side2
	 * @return no return value
	 */
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	/**
	 *  Mutator method to set the side of a Triangle
	 * 
	 * @param side3 to set the data member side3
	 * @return no return value
	 */
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	/**
	 * Method to get information from a Triangle 
	 * 
	 * @param no parameters
	 * @return displays the data stored in private instance variables as a formatted string
	 */
	public String toString() {
		return String.format("%-20s\t%-10s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f","Triangle", super.toString(), side1, side2, side3, getArea(), getPerimeter());
	}
	/**
	 * Method to get the area of a Triangle 
	 * 
	 * @param no parameters
	 * @return the value of the calculated area
	 */
	public double getArea() {
		double p = 0.5 * getPerimeter();
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
	/**
	 * Method to get the perimeter of a Triangle 
	 * 
	 * @param no parameters
	 * @return the value of the calculated perimeter
	 */
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	/**
	 * Method to scale the sides of a Triangle by a given factor
	 * 
	 * @param factor to scale each side with 
	 * @return no return value
	 */
	public void scale(double factor) {
		side1 *= factor;
		side2 *= factor;
		side3 *= factor;
	}
	/**
	 * Method to make a deep copy of a Triangle 
	 * 
	 * @param no parameters
	 * @return a new Triangle 
	 */
	public Object clone() {
		return new Triangle(getColor(), side1, side2, side3);
	}

}
