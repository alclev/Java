/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 3, 2021 
 * Last Date Modified: May 9, 2021
 *
 * @param <K>
 * @param <V>
 * 
 * Class MapEntry to model an entry in the hashmap 
 */
public class MapEntry<K, V> {
//data members
    K key;
	V value;
//constructors 
	public MapEntry(K k, V v) {
		key = k;
		value = v;
	}
/**
 * Accessor method for a key
 * @param no parameters
 * @return no return value
 */
	public K getKey() {
		return key;
	}
/**
 * Accessor method for a value
 * @param no parameters
 * @return
 */
	public V getValue() {
		return value;
	}
/**
 * toString method for the class MapEntry to return the its information as a formatted string
 */
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}
