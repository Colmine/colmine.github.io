import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for instance of TreeNode<B> class
 * 
 * @author Cole Gilmore
 *
 */

public class TreeNodeTest_1_emptyNode {
	//TreeNode objects running tests on
	TreeNode<String> treeNode;
	
	//*********** Constants used in tests ***********//
	//TreeObject to check with
	private static final TreeObject<String> TREEOBJECT = TestCase.AA;
	//TreeObject array to check with
	private static final TreeObject<String>[] E_KEYS = TestCase.K_E;
	//Int value to set count with
	private static final int S_COUNT = 1;
	//Int value to check count + other 0 values
	private static final int COUNT = 0;
	//Int value to check degree
	//private static final int DEGREE = 2;
	//Long value to check offset
	private static final long OFFSET = -1L;
	//Long value to change offset
	private static final long S_OFFSET = 0;
	//Int value to set leaf value
	private static final int LEAF = 1;
	//Int value to change leaf value
	private static final int S_LEAF = 0;

	//********************** Before Each Test Method ************************//
	
	/**
	 * Sets up TreeNode for testing
	 */
	@BeforeMethod
	public void initialize()
	{
		//Create TreeNode
		treeNode = TestCase.newTreeNode(1);
		treeNode.setLeaf(LEAF);
	}
	
	//********************************* Tests ******************************//
	
	/**
	 * Test: getLeaf - returns reference to value in treeNode
	 * Expected Result: returns reference to LEAF
	 */
	@Test()
	public void testGetLeaf()
	{
		TestCase.testGetLeaf(treeNode, LEAF);
	}
	
	/**
	 * Test: getCount - returns reference to value in treeNode
	 * Expected Result: returns 0
	 */
	@Test()
	public void testGetCount()
	{
		TestCase.testGetCount(treeNode, COUNT);
	}
	
	/**
	 * Test: getChildren - returns reference array to children of treeNode
	 * Expected Result: empty array
	 */
	@Test()
	public void testGetChildren()
	{
		long[] l = new long[2];
		TestCase.testGetChildren(treeNode, l);
	}
	
	/**
	 * Test: getKeys - returns reference array to keys in treeNode
	 * Expected Result: empty array
	 */
	@Test()
	public void testGetKeys()
	{
		TestCase.testGetKeys(treeNode, E_KEYS);
	}
	
	/**
	 * Test: getOffSet - returns reference to value in treeNode
	 * Expected Result: returns -1L
	 */
	@Test()
	public void testGetOffSet()
	{
		TestCase.testGetOffSet(treeNode, OFFSET);
	}
	
	/**
	 * Test: setLeaf - changes reference leaf value in treeNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetLeaf()
	{
		TestCase.testSetLeaf(treeNode, S_LEAF);
	}
	
	/**
	 * Test: incCount - changes reference count value in treeNode
	 * ExpectedResult: no exceptions
	 */
	@Test()
	public void testIncCount()
	{
		TestCase.testIncCount(treeNode, S_COUNT);
	}
	
	/**
	 * Test: setCount - changes reference count value in treeNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetCount()
	{
		TestCase.testSetCount(treeNode, S_COUNT, S_COUNT);
	}
	
	/**
	 * Test: setChildren - adds pointers to children nodes in treeNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetChildren()
	{
		TestCase.testSetChildren(treeNode, TestCase.L_0, COUNT);
	}
	
	/**
	 * Test: setKeys - adds TreeObject objects to array within treeNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetKeys()
	{
		TestCase.testSetKeys(treeNode, TREEOBJECT, COUNT);
	}
	
	/**
	 * Test: setOffSet - changes reference offSet value in treeNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetOffSet()
	{
		TestCase.testSetOffSet(treeNode, S_OFFSET);
	}
	
}
