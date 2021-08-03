import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: March 18, 2021 
 * Last Date Modified: March 19,2021
 *
 * Main class for testing instances of generic classes
 * 
 */

public class Test {
	
	public static void main(String [] args) {
		ArrayList<Pair<String, Double>> listProducts = new ArrayList<>();
		
	//creating a list of Pairs for products

		Pair<String, Double> p = new Pair<>("Pencil", 1.29);
		listProducts.add(p);
		listProducts.add(new Pair<>("Notebook", 2.49));
		listProducts.add(new Pair<>("Pen", 0.99));
		listProducts.add(new Pair<>("Eraser", 1.19));
		listProducts.add(new Pair<>("Glue", 2.99));
		
		ArrayList<Pair<Integer, String>> listStudents = new ArrayList<>();
		
	//creating a list of Pairs for students
		
		listStudents.add(new Pair<>(12345, "CSE"));
		listStudents.add(new Pair<>(54321, "ISE"));
		listStudents.add(new Pair<>(12453, "ME"));
		listStudents.add(new Pair<>(53421, "CSB"));
		listStudents.add(new Pair<>(51234, "ECE"));
		
		
	//user input
		Scanner scan = new Scanner(System.in);
		String con = "y"; //for the do-while loop
		
		do {
			System.out.println("What do you want to look for: products or students (p/s)? ");
			String option = scan.next();
			if(option.matches("[pP]{1}")) { //allows input of p or P
				System.out.println("Enter the product name: ");
				String prod = scan.next();
				prod += scan.nextLine(); //formatting for nextLine()
				prod.toLowerCase();
				prod = prod.substring(0,1).toUpperCase() + prod.substring(1);//makes the correct format for the product name
				int index = search(listProducts, prod);
				if(index ==-1) {
					System.out.println("Item not found."); 
				}
				else {
					System.out.println("Product found: " + "(" + listProducts.get(index).getFirst() + ", $" 
							+ listProducts.get(index).getSecond() + ")"); //adds dollar sign
				}
			}
			else if (option.matches("[sS]{1}")){ //can input s or S
				System.out.println("Enter the student ID: ");
				int id = scan.nextInt();
				int ind = search(listStudents, id);
				if(ind ==-1) {
					System.out.println("Student with id \"" + id + "\" not found.");
				}
				else {
					System.out.println("Student found: " + listStudents.get(ind));
				}
			}
			System.out.println("Do you want to continue (y/n)"); //program simply stops if user inputs anything other than y or Y
			con = scan.next();
		}while(con.matches("[yY]{1}"));
	}
/**
 * Method that searches for the pair in a list of pairs that has a given first element
 * @param list
 * @param key
 * @return int
 */
	public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key) {
		for (int i = 0; i < list.size(); i ++) {
			if(list.get(i).getFirst().equals(key)) { 
				return i;
			}
		}
		return -1;
	}
	
	

}
