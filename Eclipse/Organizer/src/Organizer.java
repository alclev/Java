import java.util.ArrayList;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 1, 2021 
 * Last Date Modified: April 6, 2021
 *
 * Generic organizer class 
 */
public class Organizer<E extends Comparable<E>> {
//private data members
	private ArrayList<E> elementList;
//default constructor
	public Organizer() {
		elementList = new ArrayList<E>(10);
	}
//adds element to the generic arraylist 
	public void addElement(E element) {
		
		elementList.add(element);

		if(element instanceof Note) { //could be either a not or a contact 
			Note[] notes = new Note[elementList.size()] ;
			for(int i = 0; i < elementList.size(); i++) {
				notes[i] = (Note) elementList.get(i);
			}
			java.util.Arrays.sort(notes);
			for(int i = 0; i < elementList.size(); i++) {
				elementList.set(i, (E) notes[i]);
			}
		}
		if(element instanceof Contact) {
			Contact[] contacts = new Contact[elementList.size()];
			for(int i = 0; i < elementList.size(); i++) {
				contacts[i] = (Contact) elementList.get(i);
			}
			java.util.Arrays.sort(contacts);
			for(int i = 0; i < elementList.size(); i++) {
				elementList.set(i, (E) contacts[i]);
			}
		}
	}
//returns the element after found recursively
	public E findElement(E element) {
		int low = 0;
		int high = elementList.size();
		
		
		int mid = (low + high)/2;
		if (element.compareTo(elementList.get(mid)) == 0) {
			return elementList.get(mid);
		}
		if(element.compareTo(elementList.get(mid)) == -1) {
			return findElement(element);
		}
		
		if(element.compareTo(elementList.get(mid)) == 1) {
			return findElement(element);
		}
		return null; //if not found
		
	}
	//removes a given element from the arraylist
	public void removeElement(E element) {
		elementList.remove(element);
	}
	//returns each element's information as a formatted string
	public String toString() {
		String str ="";
		for(int i = 0; i < elementList.size(); i++) {
			str += elementList.get(i).toString() + "\n";
		}
		return str;
	}
}
