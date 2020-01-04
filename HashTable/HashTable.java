import java.util.NoSuchElementException;
import java.util.Objects;

/* Project #3: HashTables
 * Class: CS321 Fall-2019
 * Date: 10/26/2019
 * 
 * Class that implements a hash table that stores HashObjects and generates hash values for the
 * objects that will be stored in the hash table. Keeps track of the number of probes into the table
 * everytime a new object needs to be inserted. Also keeps track of the number of duplicates of an 
 * object in the table as well as some other basic methods for managing the hash table and how many
 * times a given object is accessed.
 * 
 * @author Cole Gilmore
 * 
 * @param <V> - generic type for objects stored in the hash table
 */
@SuppressWarnings("unchecked")
public class HashTable<V> {
	
	private OpenAddressType type;
	private HashObject<V>[] hashTable;
	private int[] frequency;
	private int capacity;
	private float loadFactor;
	private int size;
	private int numProbes;
	private int maxSize;
	private final int DEFAULT_CAPACITY = 13;
	private final float DEFAULT_LOAD_FACTOR = 0.75f;
	private final OpenAddressType DEFAULT_TYPE = OpenAddressType.linear;
	
	//Default Constructor
	public HashTable() {
		capacity = DEFAULT_CAPACITY;
		loadFactor = DEFAULT_LOAD_FACTOR;
		type = DEFAULT_TYPE;
		hashTable = (HashObject<V>[]) new HashObject[capacity];
		size = 0;
		numProbes = 0;
		maxSize = (int) (loadFactor*capacity);
		frequency = new int[capacity];
	}
	
	/*
	 * Constructor that takes in an integer value for a desired capacity size.
	 * 
	 * @param int - capacity size
	 */
	public HashTable(int i) {
		capacity = i;
		loadFactor = DEFAULT_LOAD_FACTOR;
		type = DEFAULT_TYPE;
		hashTable = (HashObject<V>[]) new HashObject[capacity];
		size = 0;
		numProbes = 0;
		maxSize = (int) (loadFactor*capacity);
		frequency = new int[capacity];
	}
	
	/*
	 * Constructor that takes in an integer and float value to set a desired capacity and load factor
	 * 
	 * @param int, float - capacity and load factor values respectively
	 */
	public HashTable(int i, float f) {
		capacity = i;
		loadFactor = f;
		type = DEFAULT_TYPE;
		hashTable = (HashObject<V>[]) new HashObject[capacity];
		size = 0;
		numProbes = 0;
		maxSize = (int) (loadFactor*capacity);
		frequency = new int[capacity];
	}
	
	/*
	 * Constructor that takes in an integer, float, and OpenAddressType to set the capacity, load factor, and probe type
	 * 
	 * @param int, float, OpenAddressType - capacity, load factor, and probe type respectively
	 */
	public HashTable(int i, float f, OpenAddressType t) {
		capacity = i;
		loadFactor = f;
		type = t;
		hashTable = (HashObject<V>[]) new HashObject[capacity];
		size = 0;
		numProbes = 0;
		maxSize = (int) (loadFactor*capacity);
		frequency = new int[capacity];
	}
	
	/*
	 * Inserts given value with a given key into the hash table,
	 * if the value and key are already in the table it increments the frequency
	 * of that value.
	 * 
	 * @param V, int - Value of object, generic object type, and the key, integer value, respectively
	 * @throws IllegalStateException - if the table is full
	 */
	public void put(V val, int i) {
		//Checking to make sure that load factor is maintained
		if(size() == getMaxSize()) {
			throw new IllegalStateException("HashTable, put");
		}
		//Creating hash object instance for comparison
		HashObject<V> newObject = new HashObject<V>(val, i);
		//Generating initial index point to search the table from
		int hashInt = 0;
		int index = getHash(i, hashInt);
		boolean found = false;
		//Searching the table to find where to put the object if it's not already in the table
		while(!found && hashTable[index] != null) {
			//Found the object, increase it's frequency
			if(Objects.equals(newObject, hashTable[index])) {
				frequency[index]++;
				found = true;
			} else {
			//Didn't find the object yet, increment index value and keep searching
				hashInt++;
				index = getHash(i, hashInt); 
			}
		}
		//Object and key pair are not in the table at all, insert them and increment size
		if(!found) {
			hashTable[index] = newObject;
			size++;
		}
		//Keeping track of the number of probes into the hash table it took before the object was found/added
		numProbes += hashInt+1;
	}
	
	/*
	 * Removes given value and its key from the table
	 * 
	 * @param V, int - value of object, generic object type, and the key, integer value, respectively
	 * @throws NoSuchElementException - if key and value not found
	 */
	public V remove(V val, int i) {
		V retVal = null;
		//Creating hash object instance for comparison
		HashObject<V> removeVal = new HashObject<V>(val, i);
		//Generating initial index to search from
		int hashInt = 0;
		int index = getHash(i, hashInt);
		boolean found = false;
		//Checking hash able to see if the object and key pair are there
		while(!found && hashTable[index] != null) {
			//Found object
			if(Objects.equals(removeVal, hashTable[index])) {
				found = true;
			} else {
			//Didn't find object yet and incrementing index to keep searching
				hashInt++;
				index = getHash(i, hashInt);
			}
		}
		//Object and key pair are not in the hash table at all
		if(!found) {
			throw new NoSuchElementException("HashTable, remove");
		}
		//Setting the found object's point in the hash table and it's duplicates to null or 0
		retVal = hashTable[index].getValue();
		hashTable[index] = null;
		frequency[index] = 0;
		size--;
		
		return retVal;
	}
	
	/*
	 * Determines whether the hash table contains a given value with a specific key/integer value
	 * 
	 * @param V, int - value, which is a generic object of any type, and key, integer value, respectively
	 * @return boolean - true or false if the table contains the object and key
	 */
	public boolean contains(V val, int i) {
		//Creating hash object instance for comparison
		HashObject<V> newObject = new HashObject<V>(val, i);
		//Generating initial index to search from
		int hashInt = 0;
		int index = getHash(i, hashInt);
		boolean retVal = false;
		//Checking hash table to see if the object and key are there
		while(!retVal && hashTable[index] != null) {
			//Found object
			if(Objects.equals(newObject, hashTable[index])) {
				retVal = true;
			} else {
			//Didn't find object and incrementing index to keep searching
				hashInt++;
				index = getHash(i, hashInt);
			}
		}
		return retVal;
	}
	
	/*
	 * Clears the contents of the hash table
	 * Capacity, maxSize, and load factor unchanged
	 */
	public void clear() {
		//Setting all values to null or 0
		for(int i = 0; i < capacity; i++) {
			hashTable[i] = null;
			frequency[i] = 0;
		}
		size = 0;
		numProbes = 0;
	}
	
	/*
	 * Returns a hash value for given integers, one being a key value and the other an offset for the hashes
	 * 
	 * @param int, int - key value and offset
	 * @return int - hash value
	 */
	public int getHash(int i, int i2) {
		int index = -1;
		//It should be noted that negative values were somehow getting passed through when using these hash functions, 
		//specifically doubleHashing and quadratic, when load factor was 1 and capacity was equal to, or almost equal to, size.
			//To fix that issue I added Math.abs() around the calls to ensure that the values were positive
		if(type == OpenAddressType.linear) {
			index = Math.abs(hash1(hash1(i, capacity) + i2, capacity));
		} else if(type == OpenAddressType.doubleHashing) {
			index = Math.abs(hash1(hash1(i, capacity) + i2*hash2(i,capacity), capacity));
		} else if(type == OpenAddressType.quadratic) {
			index = Math.abs(hash1((int) (hash1(i, capacity) + (0.5)*i2 + (0.5)*(i2*i2)), capacity));
		}
		return index;
	}
	
	/*
	 * Generates a simple hash value for two given integer values
	 * 
	 * @param int, int - key value and capacity respectively
	 * @return int - hash value
	 */
	private int hash1(int i, int i2) {
		return (i % i2);
	}
	
	/*
	 * Generates a more complex hash value for two given integer values
	 * 
	 * @param int, int - key value and capacity respectively
	 * @return int - hash value
	 */
	private int hash2(int i, int i2) {
		return (1 + hash1(i, i2-2));
	}
	
	/*
	 * @return type - OpenAddressType enum
	 */
	public OpenAddressType getType() {
		return type;
	}
	
	/*
	 * @return capacity - integer value for maximum spots in the hash table
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/*
	 * @return float - determined by size/capacity, I.E. load factor
	 */
	public float getLoadFactor() {
		return (((float) size())/getCapacity());
	}
	
	/*
	 * @return size - integer value for number of objects in the hash table
	 */
	public int size() {
		return size;
	}
	
	/*
	 * @return boolean - true if there is nothing in the hash table, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * @return numProbes - integer value of the number of probes for inserting something into the hash table
	 */
	public int getNumProbes() {
		return numProbes;
	}
	
	/*
	 * @return maxSize - integer value, determined by (load factor * capacity)
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/*
	 * Returns the frequency of a given value and key pair
	 * 
	 * @param V, int - value of object, generic object type, and key, integer value, respectively
	 * @return int - frequency of value/key pair
	 */
	public int getFrequency(V val, int i) {
		//Hash object instance for what is being searched for
		HashObject<V> newObject = new HashObject<V>(val, i);
		
		//Getting the initial index/hash point to start checking the table from
		int hashInt = 0;
		int index = getHash(i, hashInt);
		boolean found = false;
		int retVal = -1;
		
		//Going through the contents of the hash table to find the given value and key pair
		while(!found && hashTable[index] != null) {
			//Found the object
			if(Objects.equals(newObject, hashTable[index])) {
				found = true;
				retVal = frequency[index];
			} else {
			//Didn't find the object and continuing the search by incrementing the index
				hashInt++;
				index = getHash(i, hashInt);
			}
		}
		return retVal;
	}
	
	/*
	 * Returns total number of duplicates within the hash table
	 * 
	 * @return retVal - integer value
	 */
	public int getNumDuplicates() {
		int retVal = 0;
		//going through everything in the frequency/duplicate array and counting it all up
		for(int i = 0; i < capacity; i++) {
			retVal += frequency[i];
		}
		
		return retVal;
	}
	
	@Override
	public String toString() {
		String retVal = "";
		//Going through everything in the hash table and formating it into an easily readable string 
			//Skips any empty spots in the table
		for(int i = 0; i < capacity; i++) {
			if(hashTable[i] != null) {
				retVal += "table" + "[" + i + "]: " + hashTable[i].getValue() + " " + frequency[i] + "\n";
			}
		}
		return retVal;
	}
}
