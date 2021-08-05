import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
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

	// private methods
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1;
		return capacity;
	}

	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}

	private void rehash() {
		ArrayList<MapEntry> list = toList();
		hashTable = new LinkedList[hashTable.length << 1];
		size = 0;
		for (MapEntry entry : list)
			put(entry.getKey(), entry.getValue());

	}

	// public interface
	public int size() {
		return size;
	}

	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				hashTable[i].clear();
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	// search for key in the hash map, returns true if found
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}

	// returns the value of key if found, otherwise null
	public V get(K key) {
		int LLIndex = hash(key.hashCode());
		if (hashTable[LLIndex] != null) {
			LinkedList<MapEntry> LL = hashTable[LLIndex];
			for (MapEntry entry : LL) {
				if (entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}

	// remove a key if found
	public void remove(K key) {
		int LLIndex = hash(key.hashCode());
		if (hashTable[LLIndex] != null) {
			LinkedList<MapEntry> LL = hashTable[LLIndex];
			for (MapEntry entry : LL) {
				if (entry.getKey().equals(key)) {
					LL.remove(entry);
					size--;
					break;
				}
			}
		}
	}

	// adds a new key or modifies an existing key
	public V put(K key, V value) {
		if (get(key) != null) {
			int LLIndex = hash(key.hashCode());
			LinkedList<MapEntry> LL = hashTable[LLIndex];
			for (MapEntry entry : LL) {
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
		int LLIndex = hash(key.hashCode());
		// create a new bucket if bucket is empty
		if (hashTable[LLIndex] == null) {
			hashTable[LLIndex] = new LinkedList<MapEntry>();
		}
		hashTable[LLIndex].add(new MapEntry(key, value));
		size++;
		return value;
	}

	// returns the elements of the hash map as a list
	public ArrayList<MapEntry> toList() {
		ArrayList<MapEntry> list = new ArrayList<>();
		for (int i = 0; i < hashTable.length; i++) {// O(n)
			if (hashTable[i] != null) {
				LinkedList<MapEntry> LL = hashTable[i];
				for (MapEntry entry : LL)
					list.add(entry);
			}
		}
		return list;
	}

	// returns the elements of the hash map as a string
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

	// returns the list of values in the hash map as a list
	/**
	 * Time complexity: O(n^2)
	 * @return
	 */
	public ArrayList<V> listOfValues() {
		ArrayList<MapEntry> arr = toList();
		ArrayList<V> result = new ArrayList<V>(); //O(1)

		for (int i = 0; i < arr.size(); i++) { //O(n)
			result.add(arr.get(i).getValue()); //O(n)
		}
		return result;
	}

}
