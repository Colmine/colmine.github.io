import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for instances of TreeNode<B> class
 * 
 * @author Cole Gilmore
 *
 */

public class TreeNodeTest_6_fiveObjInNode {
	//TreeNode objects running tests with
	TreeNode<String> treeNode;
	TreeNode<String> testNode;
	TreeNode<String> testNode2;
	
	//*********** Constants used in tests ***********//
	//TreeObjects to check with
	private static final TreeObject<String> TREEOBJECT = TestCase.AG;
	private static final TreeObject<String> TOBJ2 = TestCase.AT;
	private static final TreeObject<String> TOBJ3 = TestCase.AA;
	private static final TreeObject<String> TOBJ4 = TestCase.CG;
	private static final TreeObject<String> TOBJ5 = TestCase.TC;
	private static final TreeObject<String> TOBJ6 = TestCase.TG;
	private static final TreeObject<String> TOBJ7 = TestCase.CA;
	private static final TreeObject<String> TOBJ8 = TestCase.TT;
	private static final TreeObject<String> TOBJ9 = TestCase.GG;
	private static final TreeObject<String> TOBJ10 = TestCase.CC;
	//TreeObject arrays to check with
	private static final TreeObject<String>[] A_1 = TestCase.K_5F;
	private static final TreeObject<String>[] A_2 = TestCase.K_5N1;
	private static final TreeObject<String>[] A_3 = TestCase.K_5N2;
	//Long value array to check testNode
	private static final long[] E_CHILDREN = new long[6];	
	//Long value array to check treeNode
	private static final long[] CHILDREN = new long[] {0L, 11L, 10L, 0L, 0L, 0L};
	//Long value to set testNode as child
	private static final long CHILD = 11L;
	private static final long CHILD2 = 10L;
	//Int value to check /index with
	private static final int COUNT = 1;
	//Int value to set count with
	private static final int COUNT2 = 2;
	private static final int COUNT3 = 3;
	private static final int COUNT4 = 4;
	private static final int COUNT5 = 5;
	private static final int COUNT6 = 6;
	//Int value to check 0 values
	private static final int VAL = 0;
	//Int value to set degree
	private static final int DEGREE = 3;
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
		//Create TreeNodes
		treeNode = TestCase.newTreeNode(DEGREE);
		testNode = TestCase.newTreeNode(DEGREE);
		testNode2 = TestCase.newTreeNode(DEGREE);
		treeNode.setLeaf(S_LEAF);
		testNode.setLeaf(LEAF);
		testNode2.setLeaf(LEAF);
		testNode.setOffSet(CHILD);
		testNode2.setOffSet(CHILD2);
		treeNode.setKeys(VAL, TREEOBJECT);
		treeNode.setKeys(COUNT, TOBJ2);
		treeNode.setKeys(COUNT2, TOBJ4);
		treeNode.setKeys(COUNT3, TOBJ3);
		treeNode.setKeys(COUNT4, TOBJ10);
		treeNode.setChildren(COUNT, CHILD);
		treeNode.setChildren(COUNT2, CHILD2);
		testNode.setKeys(COUNT, TOBJ5); 
		testNode.setKeys(COUNT2, TOBJ6);
		testNode2.setKeys(VAL, TOBJ7);
		testNode2.setKeys(COUNT2, TOBJ8);
		testNode2.setKeys(COUNT4, TOBJ9);
		treeNode.setCount(5);
		testNode.setCount(2);
		testNode2.setCount(3);
		
	}
	
	//********************************* Tests ******************************//
	
	/**
	 * Test: getLeaf - returns reference to value in treeNode and testNode
	 * Expected Result: returns reference to LEAF and S_Leaf
	 */
	@Test()
	public void testGetLeaf()
	{
		TestCase.testGetLeaf(treeNode, S_LEAF);
		TestCase.testGetLeaf(testNode, LEAF);
		TestCase.testGetLeaf(testNode2, LEAF);
	}
	
	/**
	 * Test: getCount - returns reference to value in treeNode and testNode
	 * Expected Result: returns 2
	 */
	@Test()
	public void testGetCount()
	{
		TestCase.testGetCount(treeNode, COUNT5);
		TestCase.testGetCount(testNode, COUNT2);
		TestCase.testGetCount(testNode2, COUNT3);
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
		TestCase.testGetChildren(testNode2, E_CHILDREN);
	}
	
	/**
	 * Test: getKeys - returns reference array to keys in treeNode and testNode
	 * Expected Result: TreeObject array with keys in it
	 */
	@Test()
	public void testGetKeys()
	{
		TestCase.testGetKeys(treeNode, A_1);
		TestCase.testGetKeys(testNode, A_2);
		TestCase.testGetKeys(testNode2, A_3);
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
		TestCase.testGetOffSet(testNode2, CHILD2);
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
		TestCase.testSetLeaf(testNode2, S_LEAF);
	}
	
	/**
	 * Test: incCount - changes reference count value in treeNode and testNode
	 * ExpectedResult: no exceptions
	 */
	@Test()
	public void testIncCount()
	{
		TestCase.testIncCount(treeNode, COUNT6);
		TestCase.testIncCount(testNode, COUNT3);
		TestCase.testIncCount(testNode2, COUNT4);
	}
	
	/**
	 * Test: setCount - changes reference count value in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetCount()
	{
		TestCase.testSetCount(treeNode, COUNT6, COUNT6);
		TestCase.testSetCount(testNode, COUNT4, COUNT4);
		TestCase.testSetCount(testNode2, COUNT5, COUNT5);
	}
	
	/**
	 * Test: setChildren - adds pointers to children nodes in treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetChildren()
	{
		TestCase.testSetChildren(treeNode, TestCase.L_2, COUNT2);
		TestCase.testSetChildren(testNode, OFFSET, VAL);
		TestCase.testSetChildren(testNode2, CHILD2, COUNT5);
	}
	
	/**
	 * Test: setKeys - adds TreeObject objects to array within treeNode and testNode
	 * Expected Result: no exceptions
	 */
	@Test()
	public void testSetKeys()
	{
		TestCase.testSetKeys(treeNode, TOBJ3, COUNT);
		TestCase.testSetKeys(testNode, TREEOBJECT, COUNT2);
		TestCase.testSetKeys(testNode2, TOBJ10, VAL);
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
		TestCase.testSetOffSet(testNode2, OFFSET);
	}
}
