//import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
//import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests instance of BTree<String> object
 * Testing empty BTree object methods
 * 
 * @author Cole Gilmore
 *
 */

public class BTreeTest_0_newTable_default {

	//BTree object running tests on
	BTree<String> bTree;
	BTree<String> bTree2;
	//TreeNode object running tests with
	TreeNode<String> treeNode;
	TreeNode<String> treeNode1;
	TreeNode<String> treeNode2;
	//RandomAccessFile object running tests with
	RandomAccessFile RAF;
	RandomAccessFile RAF2;
	RandomAccessFile RAF5;
	
	//*************** Constants used in tests ****************//
	//TreeObjects to use
	private static final TreeObject<String> TOBJ = TestCase.AAA;
	private static final TreeObject<String> TOBJ2 = TestCase.TAT;
	private static final TreeObject<String> TOBJ3 = TestCase.CAA;
	//Integer values to use in tests
	private static final int COUNT = 0;
	private static final int COUNT2 = 1;
	private static final int DEGREE = 2;
	private static final int DEGREE2 = 3;
	private static final int HEIGHT = 0;
	private static final int S_LENGTH = 3;
	private static final int S_LENGTH2 = 4;
	private static final int CAPACITY = 3;
	private static final int CAPACITY2 = 204;
	//File object to use in tests
//	private static final File DUMP = new File("dump.txt");
	//Frequency??
	//String object used in bTree creation
	private static final String FILE = ("xyz" + ".btree.data" + S_LENGTH + "." + DEGREE);
	//String object to check inOrder method
	private static final String INORDER = "";
	
	
	//********************** Before Each Test Method ************************//
	
	/**
	 * Sets up bTree, treeNode1, and RAF for testing
	 */
	@BeforeMethod
	public void initialize()
	{
		bTree = TestCase.newBTree(DEGREE, S_LENGTH, "xyz");
		bTree2 = TestCase.newBTree2(DEGREE, S_LENGTH, "xyz", COUNT2);
		bTree.create();
		bTree2.create();
		treeNode = bTree.getRoot();
//		treeNode.setKeys(COUNT2, TOBJ3);
		treeNode1 = TestCase.newTreeNode(DEGREE);
		treeNode2 = TestCase.newTreeNode(DEGREE);
		treeNode1.setKeys(COUNT, TOBJ);
		treeNode2.setKeys(COUNT, TOBJ2);
		RAF = bTree.create();
		RAF5 = bTree2.create();
		try {
			RAF2 = new RandomAccessFile(FILE, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//********************************* Tests ******************************//
	
	/**
	 * Test: create - returns a RandomAccessFile containing the keys of all objects
	 * Expected Result: RAF with default bTree values
	 */
	@Test()
	public void testCreate()
	{
		RandomAccessFile RAF3 = bTree.create();
		TestCase.testCreate(bTree, RAF3);
		
		RandomAccessFile RAF4 = bTree2.create();
		TestCase.testCreate(bTree2, RAF4);
	}
	
	/**
	 * Test: diskWrite - writes a TreeNode to the disk/into the bTree
	 * Expected Result: No Exceptions
	 */
	@Test()
	public void testDiskWrite()
	{
		TestCase.testDiskWrite(bTree, treeNode);
		
		TestCase.testDiskWrite(bTree2, treeNode);
	}
	
	/**
	 * Test: diskRead - reads a TreeNode from the disk/bTree
	 * Expected Result: NoSuchElementException
	 */
	@Test()
	public void testDiskRead()
	{
		TestCase.testDiskRead(bTree, treeNode);
		
		TestCase.testDiskRead(bTree2, treeNode);
	}
	
	/**
	 * Test: insert - adds TreeObject to TreeNode within bTree
	 * Expected Result: No Exceptions
	 */
	@Test()
	public void testInsert()
	{
		TestCase.testInsert(bTree, treeNode1, TOBJ);
		
		TestCase.testInsert(bTree2, treeNode1, TOBJ);
	}
	
	/**
	 * Test: splitChild - splits two TreeNode objects into three
	 * Expected Result: NullPointerException
	 */
	@Test(expectedExceptions = NullPointerException.class)
	public void testSplitchild()
	{
		TestCase.testSplitChild(bTree, treeNode, treeNode2, COUNT);
		
		TestCase.testSplitChild(bTree2, treeNode, treeNode2, COUNT);
	}
	
	/**
	 * Test: insertNonFull - inserts TreeObject/key to a TreeNode
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testInsertNonFull()
	{
		TestCase.testInsertNonFull(bTree, bTree.getRoot(), TOBJ3.getKey());
		
		TestCase.testInsertNonFull(bTree2, bTree2.getRoot(), TOBJ3.getKey());
	}
	
	/**
	 * Test: search - finds if a TreeObject is in the BTree
	 * Expected Result: null value
	 */
	@Test()
	public void testSearch()
	{
		TestCase.testSearch(bTree, treeNode, TOBJ2);
		
		TestCase.testSearch(bTree2, treeNode, TOBJ2);
	}
	
	/**
	 * Test: delete - tries to remove invalid TreeObject from the BTree
	 * Expected Result: null value
	 */
	@Test()
	public void testDeleteInv()
	{
		TestCase.testDelete(bTree, treeNode, TOBJ);
		
		TestCase.testSearch(bTree2, treeNode, TOBJ);
	}
	
	/**
	 * Test: delete - removes valid TreeObject from the BTree
	 * Expected Result: reference to key in the TreeNode/root of BTree
	 */
	@Test()
	public void testDeleteVal()
	{
		TestCase.testDelete(bTree, treeNode, TOBJ3);
		
		TestCase.testDelete(bTree2, treeNode, TOBJ3);
	}
	
	/**
	 * Test: getRoot - returns top node from BTree
	 * Expected Result: reference to root TreeNode/treeNode
	 */
	@Test()
	public void testGetRoot()
	{
		TestCase.testGetRoot(bTree, treeNode);
		treeNode = bTree2.getRoot();
		TestCase.testGetRoot(bTree2, treeNode);
	}
	
	/**
	 * Test: setRoot - sets top node in BTree/root node
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSetRoot()
	{
		TestCase.testSetRoot(bTree, treeNode2);
		
		TestCase.testSetRoot(bTree2, treeNode2);
	}
	
	/**
	 * Test: isEmpty - checks to see if there's anything in the BTree
	 * Expected Result: true
	 */
	@Test()
	public void testIsEmpty()
	{
		TestCase.testIsEmpty(bTree, true);
		
		TestCase.testIsEmpty(bTree2, true);
	}
	
	/**
	 * Test: getSize - returns an integer value of how many objects are in the BTree
	 * Expected Result: returns 0
	 */
	@Test()
	public void testGetSize()
	{
		TestCase.testGetSize(bTree, 0);
		
		TestCase.testGetSize(bTree2, 0);
	}
	
	/**
	 * Test: incSize - increments size value by 1
	 * Expected Result: returns 1
	 */
	@Test()
	public void testIncSize()
	{
		TestCase.testIncSize(bTree, 1);
		
		TestCase.testIncSize(bTree2, 1);
	}
	
	/**
	 * Test: debug - prints out entirety of BTree sequences and their frequency into a file
	 * Expected Result: empty file
	 */
	@Test()
	public void testDebug()
	{
//		TestCase.testDebug(bTree, bTree.debug());
		
		TestCase.testDebug(bTree2, bTree2.debug());
	}
	
	/**
	 * Test: getHeight - returns an integer value of how tall/deep the BTree is
	 * Expected Result: returns 0
	 */
	@Test()
	public void testGetHeight()
	{
		TestCase.testGetHeight(bTree, HEIGHT);
		
		TestCase.testGetHeight(bTree2, HEIGHT);
	}
	
	/**
	 * Test: getDegree - returns an integer reference to degree
	 * Expected Result: returns DEGREE
	 */
	@Test()
	public void testGetDegree()
	{
		TestCase.testGetDegree(bTree, DEGREE);
		
		TestCase.testGetDegree(bTree2, DEGREE);
	}
	
	/**
	 * Test: setDegree - changes the integer value stored in the Tree's degree variable
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSetDegree()
	{
		TestCase.testSetDegree(bTree, DEGREE2);
		
		TestCase.testSetDegree(bTree2, DEGREE2);
	}
	
	/**
	 * Test: getCapacity - returns an integer value reference to the maximum objects that can be stored
	 * 							in the tree
	 * Expected Result: returns integer value equal to (16+8m+12m-12)=4096, where m is DEGREE
	 */
	@Test()
	public void testGetCapacity()
	{
		TestCase.testGetCapacity(bTree, CAPACITY);
		
		TestCase.testGetCapacity(bTree2, CAPACITY);
	}
	
	/**
	 * Test: setCapacity - changes the integer value stored in the Tree's capacity variable
	 * Expected Result: returns reference to CAPACITY2
	 */
	@Test()
	public void testSetCapacity()
	{
		TestCase.testSetCapacity(bTree, CAPACITY2);
		
		TestCase.testSetCapacity(bTree2, CAPACITY2);
	}
	
	/**
	 * Test: getSeqLength - returns an integer value reference to the Tree's sequence length variable
	 * Expected Result: returns reference to S_LENGTH
	 */
	@Test()
	public void testGetSeqLength()
	{
		TestCase.testGetSeqLength(bTree, S_LENGTH);
		
		TestCase.testGetSeqLength(bTree2, S_LENGTH);
	}
	
	/**
	 * Test: setSeqLength - changes the integer value stored in the Tree's sequence length variable
	 * Expected Result: returns reference to S_LENGTH2
	 */
	@Test()
	public void testSetSeqLength()
	{
		TestCase.testSetSeqLength(bTree, S_LENGTH2);
		
		TestCase.testSetSeqLength(bTree2, S_LENGTH2);
	}
	
	/**
	 * Test: getRAF - returns a RandomAccessFile that stores the BTree
	 * Expected Result: returns a matching RAF file
	 */
	@Test()
	public void testGetRAF()
	{
		TestCase.testGetRAF(bTree, RAF);
		
		TestCase.testGetRAF(bTree2, RAF5);
	}
	
	/**
	 * Test: getRootOffset - returns a long reference value stored in the root node of the BTree
	 * Expected Result: returns reference value to root node's offset
	 */
	@Test()
	public void testGetRootOffset()
	{
		TestCase.testGetRootOffset(bTree, bTree.getRootOffset());
		
		TestCase.testGetRootOffset(bTree2, bTree.getRootOffset());
	}
	
	/**
	 * Test: inOrder - returns a string of all TreeNodes, their children, and their contents
	 * Expected Result: empty string
	 */
	@Test()
	public void testInOrder()
	{
		TestCase.testInOrder(bTree, treeNode, INORDER);
		
		TestCase.testInOrder(bTree2, treeNode, INORDER);
	}
}
