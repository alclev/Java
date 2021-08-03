/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: February 22, 2021
 * Last Date Modified: February 26, 2021
 *
 * Class to create instances of shapes, display their information, and sort them
 */
public class TestShapes {
	public static void main(String[] args) {
		
//array of 8 shapes
		Shape[] shapes = new Shape[8];

		shapes[0] = new Circle("Black", 2.5);
		shapes[1] = new Triangle("Green", 6, 6, 6);
		shapes[2] = new Rectangle("Red", 5, 3);
		shapes[3] = new Hexagon("Yellow", 7);
		shapes[4] = (Shape) shapes[0].clone(); //clone of a circle
		shapes[5] = (Shape) shapes[1].clone(); //clone of a Triangle
		shapes[6] = (Shape) shapes[2].clone(); //clone of a Rectangle
		shapes[7] = (Shape) shapes[3].clone(); //clone of a Hexagon

		shapes[4].scale(2); //calls scale method for a circle
		shapes[5].setColor("Orange"); //sets a new color for a triangle
		((Rectangle) shapes[6]).setLength(10); //sets a new length for a rectangle
		shapes[7].scale(1.5); //calls the scale method for a hexagon 
		

		
		System.out.println("Before Sorting:\n---------------\n");
		viewAll(shapes);
		System.out.println(); //add a line of space
		java.util.Arrays.sort(shapes);
		System.out.println("After Sorting:\n---------------\n");
		viewAll(shapes);
		System.out.println(); // give a line of space
		System.out.println(String.format("Average Perimeter: %-10.2f", getAveragePerimeter(shapes)));
		// print shapes after sorting

	}
/**
 * Method to get the average perimeter of a list of shapes
 * 
 * @param list to iterate through the all of the shapes 
 * @return the average perimeter
 */
	public static double getAveragePerimeter(Shape[] list) {
		double sum = 0.0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i].getPerimeter();
		}
		return sum / list.length;
	}
/**
 * Method to print the information of each shape in a list of shapes 
 * 
 * @param shapes to get the information of each element in the list
 * @return no return value
 */
	public static void viewAll(Shape[] shapes) {
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i].toString());

		}
	}
}
