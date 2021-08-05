/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 1, 2021 
 * Last Date Modified: April 6, 2021
 *
 * Class contact to model a contact
 */
public class Contact implements Comparable<Contact>{
	
	//private data members
	private String name;
	private String phone;
	private String email;
	//default constructor
	public Contact() {
		name = "none";
		phone = "none";
		email = "none";
	}
	//constructor with 3 parameters
	public Contact(String n, String p, String e) {
		name = e;
		phone = p;
		email = e;
	}
//accessors
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
//mutator methods
	public void setName(String n) {
		name = n;
	}
	public void setPhone(String p) {
		phone = p;
	}
	public void setEmail(String e) {
		email = e;
	}
	//return information of a contact as a formatted string
	public String toString() {
		return String.format("%-20s%-20s%-20s", name, phone, email);
	}
	//returns 1, -1, or 0 based on the name 
	public int compareTo(Contact c) {
		return name.compareTo(c.getName());
	}
}
