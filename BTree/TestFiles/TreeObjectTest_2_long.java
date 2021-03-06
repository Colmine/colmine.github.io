import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for instances of TreeObject<Long> class
 * 
 * @author Cole Gilmore
 *
 */
public class TreeObjectTest_2_long {
	//TreeObject object running tests on
	TreeObject<Long> treeObject;
	
	//************* Constants used in tests******************//
	//Value in TreeObject
	private static final Long VALUE = TestCase.L_12;
	//Key for value in TreeObject
	private static final long KEY = TestCase.K_1;
	//New key for TreeObject
	private static final long NEW_KEY = TestCase.K_2;
	//String value to test toString from TreeObject
	private static final String LK1 = "Key: " + TestCase.K_1;
	//Integer values to test frequency methods
	private static final int F_0 = 0;
	private static final int F_1 = 1;
	private static final int F_2 = 2;
	
	//************************* Before Each Test Method ***************************//
	
	/**
	 * Sets up TreeObject for testing
	 */
	@BeforeMethod
	public void initialize() {
		//Create TreeObject
		treeObject = new TreeObject<Long>(KEY);
	}
	
	//*********************************** Tests ***********************************//
	
	/**
	 * Test: getKey - returns key for treeObject
	 * Expected Result: Returns KEY
	 */
	@Test()
	public void testGetKey()
	{
		TestCase.getKey(treeObject, VALUE, KEY);
	}


	/**
	 * Test: setKey - sets key to given new key 
	 * Expected Result: No exceptions
	 */
	@Test()
	public void testSetKey()
	{
		TestCase.setKey(treeObject, VALUE, NEW_KEY);
	}
	
	/**
	 * Test: toString - returns string value of treeObject
	 * Expected Result: Returns a string that matches LK1
	 */
	@Test()
	public void testToString() 
	{
		TestCase.toString(treeObject, VALUE, LK1);
	}
	
	/**
	 * Test: getFrequency - returns integer value of treeObject's frequency
	 * Expected Result: matching value
	 */
	@Test()
	public void testGetFrequency()
	{
		TestCase.getFrequency(treeObject, VALUE, F_1);
	}
	
	/**
	 * Test: setFrequency - returns reference to integer value used to set treeObject's frequency
	 * Expected Result: reference to integer value
	 */
	@Test()
	public void testSetFrequency()
	{
		TestCase.setFrequency(treeObject, VALUE, F_0);
	}
	
	/**
	 * Test: incrementFrequency - returns treeObject's frequency + 1
	 * Expected Result: treeObject's frequency + 1
	 */
	@Test()
	public void testIncFrequency()
	{
		TestCase.incFrequency(treeObject, VALUE, F_2);
	}
}

