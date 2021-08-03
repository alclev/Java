
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Gatherer<T> implements List<T> {

    private T[] data;  //these "slots" will contain the list elements
    private int used;  //the number of USED slots--not the number

    Gatherer() {
        data = (T[]) new Object[100];  //initialized length of data
    }

    Gatherer(int length) {
        data = (T[]) new Object[length]; //insert length of data
    }

    @Override
    public int size() {
        return used;  //amount of "slots" filled
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;  //says that list is empty
        }
        return false;// list is not empty
    }

    @Override
    /**
     * returns true if the element o is found in the list, otherwise the method
     * returns false
     */
    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    @Override
    /**
     * adds e to the list and returns true if the element e is not already in
     * the list; otherwise, false is returned.
     */
    public boolean add(T e) {
        if (!contains(e)) {
            //since contains failed, the element is to be added...
            add(size(), e);
            return true;
        }
        return false;
    }
//the list already contained e, so it won't be added again.  

    @Override
    /**
     *
     */
    public boolean remove(Object o) {
        if ((contains(o) == true)) {  //remove it at index i
            remove(indexOf(o));
            return true;
        }
        return false;  //false if object o is not in the arrayList
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            remove(data[i]); //goes through the array and removes each object 
        }
        used=0;
    }

    @Override
    public T get(int i) {
        if (i < size()) {
            return data[i]; //returns the object at index i
        }
        return null;
    }

    /**
     *
     *
     */
    @Override
    public T set(int i, T e) {
        if (i < size()) {  //makes sure there are no gaps and it is in bounds of array
            T removed = data[i];
            data[i]=e;
            return removed;  //returns object that was replaced
        }
        throw new IndexOutOfBoundsException("set " + i);
    }

    /**
     *
     *
     */
    @Override
    public void add(int i, T e) {
        if (i > size() || i < 0) {
            throw new IndexOutOfBoundsException("add " + i);
        }
        
            if (size() == data.length) {  //if the array is full
                T[] newdata = (T[]) new Object[size() * 2 + 1]; //make it bigger
                for (int k = 0; k < size(); k++) {  //transfer objects to the bigger array
                    newdata[k] = data[k];
                }
                data = newdata;
            }
            for (int j = used; j > i; j--) {
                data[j] = data[j - 1];  //pulls all objects one slot to the right
            }

            data[i] = e; //adds inputted element in slot i
            used++;  //used is now increased
        
    }

    /**
     *
     *
     */
    @Override
    public T remove(int i) {
        T removed = data[i];  //reference to original
        if (i<size()) {  //within used
            for(int k=i+1; k<size(); k++){
            data[k-1]=data[k];  //slide one slot towards 0
            }
            used--;
            return removed;
        }
        throw new IndexOutOfBoundsException("remove "+ i);
    }

    /**
     *
     *
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) { //runs through arrayList
            if (data[i] == o) { //if it finds object o
                return i;
            }
        }
        return -1;

    }

    /**
     *
     *
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size(); i > 0; i--) {  //starts from last of used and goes down array
            if (data[i] == o) { //checks if in inputted object matches with any in the array
                return i;
            }
        }
        return -1;  //object o was not in the array
    }

    public String toString() {
        String result = String.valueOf(size());
        for (int i = 0; i < size(); i++) {
            result += "\t" + data[i];
        }
        return result;  //returns how number of used slots and what is in them
    }

public static boolean testGC (Gatherer g, String[] testing) {if (g.used != testing.length || g.data.length < testing.length)return false;for (int i = 0; i < testing.length; i++)if (((Object[])g.data)[i] == null || !((Object[])g.data)[i].equals(testing[i]))return false;return true;}public static void main(String[] args) {System.err.println("An Exhaustive/Exhausting Test...");System.err.print("Testing Constructors...");Gatherer<String> g = new Gatherer();if (g.used != 0)throw new AssertionError("new Gatherer() failed");g = new Gatherer(4);if (g.used != 0 || ((Object[])g.data).length != 4)throw new AssertionError("new Gatherer(4) failed");if (g.size() != 0 || !g.isEmpty())throw new AssertionError("size() or isEmpty() failed");System.err.println("passed");System.err.print("Testing indexOf and contains...");g.data = new String[]{"one","two","three","four"};g.used = 4;if (g.indexOf("one") != 0 || g.indexOf("four") != 3 || g.indexOf("five") != -1)throw new AssertionError("indexOf() failed");if (!g.contains("three") || g.contains("seven"))throw new AssertionError("contains() failed");System.err.println("passed");System.err.print("Testing add(i,e)...");g = new Gatherer(4);g.add(0, "one");if (!testGC(g, new String[]{"one"}))throw new AssertionError ("add(0,e) to empty List failed");g.add(1, "two");if (!testGC(g, new String[]{"one","two"}))throw new AssertionError ("add(i,e) to nonfull List failed");g.add(2, "three");g.add(3, "four");if (!testGC(g, new String[]{"one","two","three","four"}))throw new AssertionError ("add(i,e) to fill List failed");g.add(4, "five");if (!testGC(g, new String[]{"one","two","three","four","five"}))throw new AssertionError ("add(i,e) to previously full List failed");g.add(0, "zero");if (!testGC(g, new String[]{"zero","one","two","three","four","five"}))
throw new AssertionError ("add(0,e) to exisitng list failed");g.add(1, "half");if (!testGC(g, new String[]{"zero","half","one","two","three","four","five"}))throw new AssertionError ("add(1,e) to exisitng list failed");System.err.println("passed");System.err.print("Testing add(e)...");g = new Gatherer(4);if (!g.add("one") || !testGC(g, new String[]{"one"}))throw new AssertionError ("add(e) to empty list failed");if (!g.add("two") || !testGC(g, new String[]{"one", "two"}))throw new AssertionError ("add(e) to nonempty list failed");if (g.add("two") || g.used > 2)throw new AssertionError ("add(duplicate) to list was allowed");System.err.println("passed");System.err.print("Testing remove(i)...");g.add("three");if (!g.remove (0).equals("one") || !testGC(g, new String[]{"two","three"}))throw new AssertionError ("remove(0) failed");if (!g.remove (1).equals("three") || !testGC(g, new String[]{"two"}))throw new AssertionError ("remove(size()) failed");g.add("three");g.add("four");if (!g.remove(1).equals("three") || !testGC(g, new String[]{"two","four"}))throw new AssertionError ("remove(mid) failed");System.err.println("passed");System.err.print("Testing get(i), set(i, e)...");g.add("five");if (!g.get(1).equals("four"))throw new AssertionError ("get(i) failed");if (!g.set(1, "six").equals("four") || !testGC(g, new String[]{"two","six","five"}))throw new AssertionError ("set(i, e) failed");System.err.println("passed");System.err.print("Testing remove(e)...");if (!g.remove("six") || !testGC(g, new String[]{"two","five"}))throw new AssertionError ("remove(e) failed to remove or returned false");if (g.remove("six") || !testGC(g, new String[]{"two","five"}))throw new AssertionError ("remove(e) removed nonexistent value or returned true");System.err.println("passed");System.err.println ("All tests passed.");}
     /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
