

/**
 * This class represents a Tree Object that holds a value and a key, which will be stored in B-Trees 
 * 
 * @author Jeong-Hyun Boo Cole Gilmore Edward Kourbanov John Martin
 *
 */

public class TreeObject<B> implements Comparable<B>{

	private long key; // this is the key value of the tree object
	private int frequency; // this is frequency of the tree object
	 
	/**
	 * Default constructor 
	 */	
	public TreeObject(long key)
	{
		this.key = key;
		frequency=1;
		
	}
	
	/**
	 * Returns the key of the tree object
	 * 
	 * @return - long
	 */
	public long getKey()
	{
		return this.key;
	}
	
	/**
	 * Updates the key of the tree object 
	 * 
	 * @param newKey - long
	 */
	public void setKey(long newKey)
	{
		this.key = newKey;
	}
	/**
	 * Returns the frequency of the tree object
	 * 
	 * @return - int
	 */
	public int getFrequency() {
		return frequency;
	}
	/**
	 * Updates the key of the tree object 
	 * 
	 * @param frquency - int
	 */
	public void setFrequency(int frequency) {
		this.frequency=frequency;
	}
	/**
	 * increments the frequency
	 * 
	 * 
	 */
	public void incrementFreq() {
		frequency++;
	}
	/**
	 * Returns a string that consists of the value and key of the tree object 
	 * 
	 * @return String 
	 */
	public String toString()
	{
		return "Key: " + this.key;
	}
	
	/**
	 * Checks if the tree object contains anything
	 * 
	 * @param value - B
	 */
	public boolean contains(B value)
	{
		return false;
	}
	
	
	

	/**
	 * Compares 2 keys.
	 * Returns 0 if equal, -1 if the first key is lesser
	 * 1 if the first key is greater
	 */
	@Override
	public int compareTo(B key) {
		
		if(key.equals(this.key))
		{
			return 0;
		}
		else if(Long.compare(this.key, (long) key) < 0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
}
