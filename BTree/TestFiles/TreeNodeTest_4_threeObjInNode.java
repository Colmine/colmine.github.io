import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for instances of TreeNode<B> class
 * 
 * @author Cole Gilmore
 *
 */

public class TreeNodeTest_4_threeObjInNode {
	//TreeNode objects running tests with
	TreeNode<String> treeNode;
	TreeNode<String> testNode;
	
	//*********** Constants used in tests ***********//
	//TreeObjects to check with
	private static final TreeObject<String> TREEOBJECT = TestCase.AG;
	private static final TreeObject<String> TOBJ2 = TestCase.AT;
	private static final TreeObject<String> TOBJ3 = TestCase.AA;
	private static final TreeObject<String> TOBJ4 = TestCase.CG;
	//TreeObject arrays to check with
	private static final TreeObject<String>[] A_1 = TestCase.K_AGATCG;
	private static final TreeObject<String>[] A_2 = TestCase.K_NAAN;
	//Long value array to check testNode
	private static final long[] E_CHILDREN = new long[4];	
	//Long value array to check treeNode
	private static final long[] CHILDREN = new long[] {11L, 0L, 0L, 0L};
	//Long value to set testNode as child
	private static final long CHILD = 11L;
	//Int value to check /index with
	private static final int COUNT = 1;
	//Int value to set count with
	private static final int S_COUNT = 2;
	private static final int SS_COUNT = 3;
	private static final int COUNT4 = 4;
	//Int value to check 0 values
	private static final int VAL = 0;
	//Int value to set degree
	private static final int DEGREE = 2;
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
		treeNode = TestCase.newTreeNode(DEGREE);
		testNode = TestCase.newTreeNode(DEGREE);
		treeNode.setLeaf(S_LEAF);
		testNode.setLeaf(LEAF);
		testNode.setOffSet(CHILD);
		treeNode.setKeys(VAL, TREEOBJECT);
		treeNode.setKeys(COUNT, TOBJ2);
		treeNode.setKeys(S_COUNT, TOBJ4);
		treeNode.setChildren(VAL, CHILD);
		testNode.setKeys(COUNT, TOBJ3);
		treeNode.setCount(3);
		testNode.setCount(1);
	}
	
	//********************************* Tests ******************************//
	
	/**
	 * Test: getLeaf - returns reference to value in treeNode and testNode
	 * Expected Result: returns reference to LEAF and S_LEAF
	 */
	@Test()
	public void testGetLeaf()
	{
		TestCase.testGetLeaf(treeNode, S_LEAF);
		TestCase.testGetLeaf(testNode, LEAF);
	}
	
	/**
	 * Test: getCount - returns reference to value in treeNode and testNode
	 * Expected Result: returns 2 and 1
	 */
	@Test()
	public void testGetCount()
	{
		TestCase.testGetCount(treeNode, SS_COUNT);
		TestCase.testGetCount(testNode, COUNT);
	}
	
	/**
	 * Test: getChildren - returns reference array to children of treeNode and testNode
	 * Expected Result: array of TreeObjects
	 */
	@Test()
	public void testGetChildren()
	{
		TestCase.testGetChildren(treeNode, CHILDREN);
		TestCase.testGetChildren(testNode, E_CHILDREN);
	}
	
	/**
	 * Test: getKeys - returns reference array to keys in treeNode and testNode
	 * Expected Result: TreeObject arrays with keys in it
	 */
	@Test()
	public void testGetKeys()
	{
		TestCase.testGetKeys(treeNode, A_1);
		TestCase.testGetKeys(testNode, A_2);
	}
	
	/**
	 * Test: getOffSet - returns reference to value in treeNode and testNode
	 * Expected Result: returns -1L and 11L
	 */
	@Test()
	public void testGetOffSet()
	{
		TestCase.testGetOffSet(treeNode, OFFSET);
		TestCase.testGetOffSet(testNode, CHILD);
	}
	
	/**
	 * Test: setLeaf - changes reference leaf value in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetLeaf()
	{
		TestCase.testSetLeaf(treeNode, LEAF);
		TestCase.testSetLeaf(testNode, S_LEAF);
	}
	
	/**
	 * Test: incCount - changes reference count value in treeNode and testNode
	 * ExpectedResult: no exceptions
	 */
	@Test()
	public void testIncCount()
	{
		TestCase.testIncCount(treeNode, COUNT4);
		TestCase.testIncCount(testNode, S_COUNT);
	}
	
	/**
	 * Test: setCount - changes reference count value in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetCount()
	{
		TestCase.testSetCount(treeNode, COUNT4, COUNT4);
		TestCase.testSetCount(testNode, S_COUNT, S_COUNT);
	}
	
	/**
	 * Test: setChildren - adds pointers to children nodes in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetChildren()
	{
		TestCase.testSetChildren(treeNode, TestCase.L_2, VAL);
		TestCase.testSetChildren(testNode, OFFSET, VAL);
	}
	
	/**
	 * Test: setKeys - adds TreeObject objects to array within treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetKeys()
	{
		TestCase.testSetKeys(treeNode, TOBJ3, VAL);
		TestCase.testSetKeys(testNode, TREEOBJECT, VAL);
	}
	
	/**
	 * Test: setOffSet - changes reference offSet value in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetOffSet()
	{
		TestCase.testSetOffSet(treeNode, S_OFFSET);
		TestCase.testSetOffSet(testNode, OFFSET);
	}

}

