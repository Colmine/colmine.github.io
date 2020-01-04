/**
 * This class represents a tree node for the Btree data structure. 
 * 
 * @author Jeong-Hyun Boo Cole Gilmore Edward Kourbanov John Martin
 *
 */

public class TreeNode<B> {

	private TreeObject<B> keys[];//array to hold keys
	private long children[];//array to hold offsets to children
	private int leaf;//0 is false, 1 is true
	private int m; // the m value of the node
	private int count; // the count of the node 
	private long offSet; // the offset of this node
	
	@SuppressWarnings("unchecked")
	/**
	 * Default constructor 
	 */	
	public TreeNode(int degree) 
	{
		m = 2 * degree;
		keys = (TreeObject<B>[]) new TreeObject[m-1];
		children =  new long[m];
		leaf = 0;
		count = 0;
		offSet = -1L;
	}
	/**
	 * Updates the leaf value
	 * 
	 * @param leaf - value
	 */
	public void setLeaf(int value)
	{
		leaf = value;
	}
	/**
	 * Returns the leaf of the tree node
	 * 
	 * @return - int
	 */
	public int getLeaf()
	{
		return leaf;
	}
	/**
	 * increments the count
	 * 
	 * 
	 */
	public void incCount()
	{
		count++;
	}
	
	/**
	 * Updates the count value
	 * 
	 * @param newCount - int
	 */
	public void setCount(int newCount)
	{
		count = newCount;
	}
	
	/**
	 * Returns the count of the tree node
	 * 
	 * @return - int
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * Returns the children of the tree nodes 
	 * 
	 * @return - long[]
	 */
	public long[] getChildren()
	{
		return children;
	}
	
	/**
	 * Updates the children values
	 * 
	 * @param index - int
	 * @param child - long
	 */
	public void setChildren(int index, long child)
	{
		children[index] = child;
	}
	/**
	 * Returns the tree object of the tree node 
	 * 
	 * @return - TreeObject[]
	 */
	public TreeObject<B>[] getKeys()
	{
		return keys;
	}
	/**
	 * Updates the keys 
	 * 
	 * @param index - long
	 * @param key - TreeObject
	 */
	public void setKeys(int index, TreeObject<B> key)
	{
		keys[index] = key;
	}
	/**
	 * Returns the offset 
	 * 
	 * @return - long
	 */
	public long getOffSet()
	{
		return offSet;
	}
	
	/**
	 * Updates the key of the tree object 
	 * 
	 * @param value - long
	 */
	public void setOffSet(long value)
	{
		offSet = value;
	}

}