import java.util.Objects;

/* Project #3: HashTables
 * Class: CS321 Fall-2019
 * Date: 10/26/2019
 * 
 * Class that implements a basic object, HashObject, that stores an integer value and a generic value
 * to later be used in a hash function for storage.
 * 
 * @author Cole Gilmore
 * 
 * @param <V> - generic type for object stored in the HashObject
 */

public class HashObject<V> {
	private int key;
	private V value;
	
	/*
	 * Default Constructor, takes in a given value and key for a hash object
	 * 
	 * @param V, int - Value of object, generic object type, and key, integer value, respectively
	 */
	public HashObject(V val, int i) {
		this.value = val;
		this.key = i;
	}
	
	/*
	 * Returns the object value for the hash object
	 * 
	 * @return V - generic object type/object value
	 */
	public V getValue() {
		return this.value;
	}
	
	/*
	 * Returns key value for the hash object
	 * 
	 * @return int - key value
	 */
	public int getKey() {
		return this.key;
	}
	
	/*
	 * Sets the value/object to a new given value
	 * 
	 * @param V - generic object type/new object value
	 */
	public void setValue(V val) {
		this.value = val;
	}
	
	/*
	 * Sets the key value to a given integer
	 * 
	 * @param int - new key value
	 */
	public void setKey(int i) {
		this.key = i;
	}
	
	@Override
	public String toString() {
		return this.value + " " + this.key;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if(!(o instanceof HashObject)) {
			return false;
		}
		HashObject<V> hashObject = (HashObject<V>) o;
		return (key == hashObject.key) && Objects.equals(value, hashObject.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}
}
