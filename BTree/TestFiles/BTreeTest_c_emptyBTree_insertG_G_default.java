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

public class BTreeTest_c_emptyBTree_insertG_G_default {

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
	
	//*************** Constants used in tests ****************//
	//TreeObjects to use
	private static final TreeObject<String> TOBJ = TestCase.AAA;
	private static final TreeObject<String> TOBJ2 = TestCase.TAT;
	private static final TreeObject<String> TOBJ3 = TestCase.CAA;
	private static final TreeObject<String> TOBJ4 = TestCase.GAA;
	private static final TreeObject<String> TOBJ5 = TestCase.GAG;
	private static final TreeObject<String> TOBJ6 = TestCase.ATA;
	private static final TreeObject<String> TOBJ7 = TestCase.CAT;
	private static final TreeObject<String> TOBJ8 = TestCase.GGG;
	private static final TreeObject<String> TOBJ9 = TestCase.CCC;
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
	private static final String INORDER = "1 " + "aaa" + "\n" + "1 " + "gca" + "\n" + "1 " + "gaa" + "\n"
			+ "1 " + "gaa" + "\n" + "1 " + "taa" + "\n" + "1 " + "taa" + "\n" + "1 " + "tac" + "\n"
			+ "1 " + "tcc" + "\n";
	
	//********************** Before Each Test Method ************************//
	
	/**
	 * Sets up bTree, TreeNodes, and RAF for testing
	 */
	@BeforeMethod
	public void initialize()
	{
		bTree = TestCase.newBTree(DEGREE, S_LENGTH, "xyz");
		treeNode1 = TestCase.newTreeNode(DEGREE);
		bTree.create();
		bTree.insert(TOBJ);
		bTree.insert(TOBJ2);
		bTree.insert(TOBJ3);
		bTree.insert(TOBJ4);
		bTree.insert(TOBJ5);
		bTree.insert(TOBJ6);
		bTree.insert(TOBJ7);
		bTree.insert(TOBJ8);
		
		treeNode = bTree.getRoot();
		
		bTree2 = TestCase.newBTree2(DEGREE, S_LENGTH, "xyz", 1);
		bTree2.create();
		bTree2.insert(TOBJ);
		bTree2.insert(TOBJ2);
		bTree2.insert(TOBJ3);
		bTree2.insert(TOBJ4);
		bTree2.insert(TOBJ5);
		bTree2.insert(TOBJ6);
		bTree2.insert(TOBJ7);
		bTree2.insert(TOBJ8);
		
		treeNode2 = TestCase.newTreeNode(DEGREE);
		treeNode1.setKeys(COUNT, TOBJ);
		treeNode2.setKeys(COUNT2, TOBJ9);
		RAF = bTree.create();
		bTree.diskWrite(treeNode1);
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
	}
	
	/**
	 * Test: diskWrite - writes a TreeNode to the disk/into the bTree
	 * Expected Result: No Exceptions
	 */
	@Test()
	public void testDiskWrite()
	{
		TestCase.testDiskWrite(bTree, treeNode1);
	}
	
	/**
	 * Test: diskRead - reads a TreeNode from the disk/bTree
	 * Expected Result: NoSuchElementException
	 */
	@Test()
	public void testDiskRead()
	{
		TestCase.testDiskRead(bTree, treeNode1);
	}
	
	/**
	 * Test: insert - adds TreeObject to TreeNode within bTree
	 * Expected Result: No Exceptions
	 */
	@Test()
	public void testInsert()
	{
		TestCase.testInsert(bTree, treeNode1, TOBJ);
	}
	
	/**
	 * Test: splitChild - splits two TreeNode objects into three
	 * Expected Result: NullPointerException
	 */
	@Test(expectedExceptions = NullPointerException.class)
	public void testSplitchild()
	{
		TestCase.testSplitChild(bTree, treeNode, treeNode2, COUNT);
	}
	
	/**
	 * Test: insertNonFull - inserts TreeObject/key to a TreeNode
	 * Expected Result: No exceptions (should insert to root)
	 */
	@Test()
	public void testInsertNonFull()
	{
		TestCase.testInsertNonFull(bTree, treeNode, TOBJ2.getKey());
	}
	
	/**
	 * Test: search - finds if a TreeObject is in the BTree
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSearch()
	{
		TestCase.testSearch(bTree, treeNode, TOBJ2);
	}
	
	/**
	 * Test: delete - tries to remove invalid TreeObject from the BTree
	 * Expected Result: fudge it
	 */
	@Test()
	public void testDeleteInv()
	{
		TestCase.testDelete(bTree, treeNode, TOBJ3);
	}
	
	/**
	 * Test: delete - removes valid TreeObject from the BTree
	 * Expected Result: reference to key in the TreeNode/root of BTree
	 */
	@Test()
	public void testDeleteVal()
	{
		TestCase.testDelete(bTree, treeNode, TOBJ3);
	}
	
	/**
	 * Test: debug - prints out entirety of BTree sequences and their frequency into a file
	 * Expected Result: Null file
	 */
	@Test()
	public void testDebug()
	{
		TestCase.testDebug(bTree2, bTree2.debug());
	}
	
	/**
	 * Test: getRoot - returns top node from BTree
	 * Expected Result: reference to root TreeNode/treeNode
	 */
	@Test()
	public void testGetRoot()
	{
		TestCase.testGetRoot(bTree, treeNode);
	}
	
	/**
	 * Test: setRoot - sets top node in BTree/root node
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSetRoot()
	{
		TestCase.testSetRoot(bTree, treeNode2);
	}
	
	/**
	 * Test: isEmpty - checks to see if there's anything in the BTree
	 * Expected Result: false
	 */
	@Test()
	public void testIsEmpty()
	{
		TestCase.testIsEmpty(bTree, false);
	}
	
	/**
	 * Test: getSize - returns an integer value of how many objects are in the BTree
	 * Expected Result: returns 8
	 */
	@Test()
	public void testGetSize()
	{
		TestCase.testGetSize(bTree, 8);
	}
	
	/**
	 * Test: incSize - increments size value by 1
	 * Expected Result: returns 9
	 */
	@Test()
	public void testIncSize()
	{
		TestCase.testIncSize(bTree, 9);
	}
	
	/**
	 * Test: getHeight - returns an integer value of how tall/deep the BTree is
	 * Expected Result: returns 0
	 */
	@Test()
	public void testGetHeight()
	{
		TestCase.testGetHeight(bTree, HEIGHT);
	}
	
	/**
	 * Test: getDegree - returns an integer reference to degree
	 * Expected Result: returns DEGREE
	 */
	@Test()
	public void testGetDegree()
	{
		TestCase.testGetDegree(bTree, DEGREE);
	}
	
	/**
	 * Test: setDegree - changes the integer value stored in the Tree's degree variable
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSetDegree()
	{
		TestCase.testSetDegree(bTree, DEGREE2);
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
	}
	
	/**
	 * Test: setCapacity - changes the integer value stored in the Tree's capacity variable
	 * Expected Result: returns reference to CAPACITY2
	 */
	@Test()
	public void testSetCapacity()
	{
		TestCase.testSetCapacity(bTree, CAPACITY2);
	}
	
	/**
	 * Test: getSeqLength - returns an integer value reference to the Tree's sequence length variable
	 * Expected Result: returns reference to S_LENGTH
	 */
	@Test()
	public void testGetSeqLength()
	{
		TestCase.testGetSeqLength(bTree, S_LENGTH);
	}
	
	/**
	 * Test: setSeqLength - changes the integer value stored in the Tree's sequence length variable
	 * Expected Result: returns reference to S_LENGTH2
	 */
	@Test()
	public void testSetSeqLength()
	{
		TestCase.testSetSeqLength(bTree, S_LENGTH2);
	}
	
	/**
	 * Test: getRAF - returns a RandomAccessFile that stores the BTree
	 * Expected Result: returns a matching RAF file
	 */
	@Test()
	public void testGetRAF()
	{
		TestCase.testGetRAF(bTree, RAF);
	}
	
	/**
	 * Test: getRootOffset - returns a long reference value stored in the root node of the BTree
	 * Expected Result: returns reference value to root node's offset
	 */
	@Test()
	public void testGetRootOffset()
	{
		TestCase.testGetRootOffset(bTree, bTree.getRootOffset());
	}
	
	/**
	 * Test: inOrder - returns a string of all TreeNodes, their children, and their contents
	 * Expected Result: empty string
	 */
	@Test()
	public void testInOrder()
	{
		TestCase.testInOrder(bTree, treeNode, INORDER);
	}
}
