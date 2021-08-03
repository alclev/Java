/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 1, 2021 
 * Last Date Modified: April 6, 2021
 *
 * class note to model a note
 */
public class Note implements Comparable<Note>{
	
	//private data members
	private Date date;
	private String title;
	private String description;
	//default constructor
	public Note() {
		date = new Date();
		title = "none";
	}
	//constructor with 3 parameters
	public Note(Date d, String t, String descr) {
		date = d;
		title = t;
		description = descr;
	}
//accessor methods
	public Date getDate() {
		return date;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
//mutator methods
	public void setDate(Date d) {
		date = d;
	}
	public void setTitle(String t) {
		title = t;
	}
	public void setDescription(String d) {
		description = d;
	}
	//returns the information of a note as a formatted string
	public String toString() {
		return String.format("%-20s%-20s%-20s", date.toString(), title, description);
	}
	//defines how to compare two notes based on the date
	public int compareTo(Note n) {
		return date.compareTo(n.getDate());
	}
}
