import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 3, 2021 
 * Last Date Modified: May 3, 2021
 *
 * @param <E>
 * Class HashMap to model a HashMap
 */
public class HashMap<K, V> {
//private data members
	private int size;
	private double loadFactor;
	private LinkedList<MapEntry>[] hashTable;

// Inner class for hash map entry
	private class MapEntry {
		K key;
		V value;

		MapEntry(K k, V v) {
			key = k;
			value = v;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return value;
		}

		public String toString() {
			return "(" + key + ", " + value + ")";
		}

	}

	// Constructors
	public HashMap() {
		this(100, 0.9);
	}

	public HashMap(int c) {
		this(c, 0.9);
	}

	public HashMap(int c, double lf) {
		hashTable = new LinkedList[trimToPowerOf2(c)];
		loadFactor = lf;
	}

	/**
	 * Private method that converts integer to power of 2 
	 * @param c
	 * @return int
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1; // * 2
		return capacity;
	}
/**
 * Method hash to return integer
 * @param hashCode
 * @return int
 */
	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}
/**
 * Method to modify length of HashMap to fit number of elements
 * @param no parameters
 * @return no return value
 */
	private void rehash() {
		ArrayList<MapEntry> list = toList();
		hashTable = new LinkedList[hashTable.length << 1]; // *2
		size = 0;
		for (MapEntry entry : list)
			put(entry.getKey(), entry.getValue());
	}

	// public interface
	
	/**
	 * Method that returns size of HashMap
	 * @param no parameters 
	 * @return int 
	 */
	public int size() {
		return size;
	}
	/**
	 * Method that clears hashmap
	 * @param no parameters 
	 * @return no return value 
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				hashTable[i].clear();
	}
	/**
	 * Method that checks is hashmap is empty
	 * @param no parameters 
	 * @return boolean 
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Method that searches for key in the hash map, returns true if found
	 * @param key
	 * @return boolean 
	 */
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}

	/**
	 * returns the value of key if found, otherwise null
	 * @param key
	 * @return V
	 */
	public V get(K key) {
		Dictionary.hashIterations = 0;
		int bucketIndex = hash(key.hashCode());
		if (hashTable[bucketIndex] != null) {
			LinkedList<MapEntry> bucket = hashTable[bucketIndex];
			for (MapEntry entry : bucket) {
				Dictionary.hashIterations++;
				if (entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}

	/**
	 * Method that removes a key if found
	 * @param key
	 * @return no return value
	 */
	public void remove(K key) {
		int bucketIndex = hash(key.hashCode());
		if (hashTable[bucketIndex] != null) { // key is in the hash map
			LinkedList<MapEntry> bucket = hashTable[bucketIndex];
			for (MapEntry entry : bucket) {
				if (entry.getKey().equals(key)) {
					bucket.remove(entry);
					size--;
					break;
				}
			}
		}
	}

	/**
	 * Method that adds a new key or modifies an existing key
	 * @param key, value
	 * @return no return value
	 */
	public V put(K key, V value) { // The key is in the hash map
		if (get(key) != null) {
			int bucketIndex = hash(key.hashCode());
			LinkedList<MapEntry> bucket = hashTable[bucketIndex];
			for (MapEntry entry : bucket) {
				if (entry.getKey().equals(key)) {
					V old = entry.getValue();
					entry.value = value;
					return old;
				}
			}
		}
		// key not in the hash map - check load factor
		if (size >= hashTable.length * loadFactor)
			rehash();
		int bucketIndex = hash(key.hashCode());
		// create a new bucket if bucket is empty
		if (hashTable[bucketIndex] == null) {
			hashTable[bucketIndex] = new LinkedList<MapEntry>();
		}
		hashTable[bucketIndex].add(new MapEntry(key, value));
		size++;
		return value;
	}

	/**
	 * returns the elements of the hash map as a list
	 * @param no parameters
	 * @return ArrayList<MapEntry>
	 */
	public ArrayList<MapEntry> toList() {
		ArrayList<MapEntry> list = new ArrayList<>();
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				LinkedList<MapEntry> bucket = hashTable[i];
				for (MapEntry entry : bucket)
					list.add(entry);
			}
		}
		return list;
	}

	/**
	 * returns the elements of the hash map as a string
	 * @param no parameters
	 * @return String
	 */
	public String toString() {
		String out = "[";
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (MapEntry entry : hashTable[i])
					out += entry.toString();
				out += "\n";
			}
		}
		out += "]";
		return out;
	}
/**
 * Method that returns the maximum number of collisions 
 * @param no parameters
 * @return int
 */
	public int collisions() {
		int max = 0;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (MapEntry entry : hashTable[i]) {
					int temp = hashTable[i].size();
					if (temp > max) {
						max = temp;
					}
				}
			}
		}
		return max;
	}

}