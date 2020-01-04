import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
@SuppressWarnings({ "rawtypes", "unchecked" })
/**
 * This class searches sequences of given length in the user-specified B-Tree.  
 * 
 * @author Jeong-Hyun Boo, Cole Gilmore, Edward Kourbanov, John Martin
 *
 */

public class GeneBankSearch 
{
	
	/**
	 *  This is the main method for the class 
	 * 
	 * @param args - String[]
	 */

	@SuppressWarnings("resource")
	public static void main (String[] args)
	{
		int cacheOption, debugLevel, degree, seqLength; // this will be the values that are used later
		String bTreeFileName, queryFileName; // string for the file names
		Scanner fileScan;  // this is the scanner that will used to scan the file
		BTree tree;	//B-Tree object from user provided B-Tree file
		TreeObject queryTreeObject; //TreeObject for query 
		
		try
		{
			if (args.length == 5) // if debug is specified 
			{
				cacheOption = Integer.parseInt(args[0]); // this grabs the cache option
				if (cacheOption == 0) // cache not implemented
				{
				
				}
				else if (cacheOption == 1) // when cache not implemented
				{
					throw new UnsupportedOperationException();
				}
				else 
				{
					System.out.println("Cache not implemented: put in either 0 or 1 for cache option.");
					System.exit(0);
				}
				
				bTreeFileName = args[1]; // gets the btree file name
				queryFileName = args[2]; // gets the query file name
				debugLevel = Integer.parseInt(args[3]); // holds the debug level
				
				if (debugLevel == 0 || debugLevel == 1) 
				{
				try 
				{
					RandomAccessFile RAF = new RandomAccessFile(bTreeFileName, "r"); //creating RandomAccessFile for btree file provided
					degree = RAF.readInt(); //reading in degree for the b-tree
					seqLength = RAF.readInt(); //reading in sequence length for the b-tree
					tree = new BTree (bTreeFileName, degree, seqLength, true); //creating a b-tree object 
					RAF = tree.getRAF(); // getting the file from  the tree
					RAF.seek(16L); // finding the location of the root offset
					long rootOffSet = RAF.readLong(); // reading the offset for the root
					tree.setRoot(BTree.diskRead(rootOffSet)); // getting the root and setting it up
					try 
					{
						File queryFile = new File(queryFileName); // creating the query file
						fileScan = new Scanner(queryFile); // this creates the scanner for the queryfile
						String queryStr = ""; // this will be the query value
						int i = 0; // this is the int value for the query translator
						long number = 0L; // this is value that will be used in translation
						while(fileScan.hasNextLine()) // runs while it has another file
						{
							number = 0L;
							queryStr = fileScan.nextLine(); // pulls off the next line to be parsed
							for (i = 0; i < queryStr.length(); i ++) //converting query to binary 
							{
								char inputer = queryStr.charAt(i); // gets the char at the specific location
								switch (inputer)
								{
								case 'a':
								case 'A':
									number = number <<2;
									break;
								case 'c':
								case 'C':
									number = number <<2;
									number += 1;
									
									break;
								case 'g':
								case 'G':
									number = number <<2;
									number += 2;
									break;
								case 'T':
								case 't':
									number = number <<2;
									number += 3;
									break;

								
								}
							}
							

								queryTreeObject = new TreeObject(number); // creating a new tree object with the number key value
								queryTreeObject = tree.search(tree.getRoot(), queryTreeObject); // searches from the root to find the value
								if (queryTreeObject != null) //searching query in b-tree
								{ 
									System.out.println(queryStr + " exists in the file, frequency: " + queryTreeObject.getFrequency());
								}
								else
								{
									System.out.println(queryStr + " does not exist in the file");
								}

						}
						

					}
					catch (FileNotFoundException e)
					{
						System.out.println("Query file not found");
					}
					RAF.close(); // closing the RAF file 
				}
				catch (IOException e)  // IF the b-tree file is not able to be opened properly
				{
					System.out.println("B-Tree file not found.");
				}
				}
				else //when argument for debugLevel is not either 0 or 1 
				{
					System.out.println("Please put in either 0 or 1 for debug level.");
					System.exit(0);
				}
							
			}
				
			else if (args.length == 4)
			{
				cacheOption = Integer.parseInt(args[0]); // get the cache value
				if (cacheOption == 0)
				{
				}
				else if (cacheOption == 1) // when cache not implemented
				{
					throw new UnsupportedOperationException();
				}
				else 
				{
					System.out.println("Please put in either 0 or 1 for cache option.");
					System.exit(0);
				}
				
				bTreeFileName = args[1];// gets the btree file name 
				queryFileName = args[2]; // gets the query file name
				
				try 
				{
					RandomAccessFile RAF = new RandomAccessFile(bTreeFileName, "r"); //creating RandomAccessFile for btree file provided
					degree = RAF.readInt(); //reading in degree for the b-tree
					seqLength = RAF.readInt(); //reading in sequence length for the b-tree
					tree = new BTree (bTreeFileName, degree, seqLength, true); //creating a b-tree object 
					RAF = tree.getRAF(); // gets the random access file from the tree
					RAF.seek(16L); // seeks the root offsett location
					long rootOffSet = RAF.readLong(); // this gets the root offset
					tree.setRoot(BTree.diskRead(rootOffSet)); // gets the actual root from the file and sets it as the root
					try 
					{

						File queryFile = new File(queryFileName); // this sets up the quiery file to be parsed
						fileScan = new Scanner(queryFile); // the scanner for the file
						String queryStr = ""; // this is line query for each of these
						int i = 0; // this is the index for the string parsing
						
						while(fileScan.hasNextLine()) // runs while is has next
						{
							long number = 0L; // number that will hold the long value
							queryStr = fileScan.nextLine(); // pulls off the next line to be parsed
							for (i = 0; i < queryStr.length(); i ++) //converting query to binary 
							{
								char inputer = queryStr.charAt(i); // gets the char at the beginning 
								switch (inputer)
								{
								case 'a':
								case 'A':
									number = number <<2;
									break;
								case 'c':
								case 'C':
									number = number <<2;
									number += 1;
									
									break;
								case 'g':
								case 'G':
									number = number <<2;
									number += 2;
									break;
								case 'T':
								case 't':
									number = number <<2;
									number += 3;
									break;

								
								}
							}
							
								queryTreeObject = new TreeObject(number); // creates a tree object from the sequence key
								queryTreeObject = tree.search(tree.getRoot(), queryTreeObject); // searches the tree for the object in made from the sequence
								if (queryTreeObject != null) //searching query in b-tree
								{ 
									System.out.println(queryStr + " exists in the file, frequency: " + queryTreeObject.getFrequency());
								}
								else
								{
									System.out.println(queryStr + " does not exist in the file");
								}
								
							

						}
						

					}
					catch (FileNotFoundException e)
					{
						System.out.println("Query file not found");
					}

				}
				catch (IOException e) 
				{
					System.out.println("B-Tree file not found.");
				}
			}
		}
		catch (NumberFormatException e) //when command-line argument input not valid 
		{
			System.out.println("Usage: [0 | 1(no/with Cache)] [btree file] [query file] [0 | 1 debug level]");
			System.exit(0);
		}
		catch (UnsupportedOperationException e)
		{
			System.out.println("Caches are currently unsupported.");
		}
		
	}

	
}