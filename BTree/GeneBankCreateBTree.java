
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
/**
 * This class reads in the input file into the right length of binary strings and inserts it into the binary tree that is created.
 * 
 * @author Jeong-Hyun Boo, Cole Gilmore, Edward Kourbanov, John Martin,
 *
 */

public class GeneBankCreateBTree {
	/**
	 *  This is the main method for the class 
	 * 
	 * @param args - String[]
	 */

	public static void main(String[] args) {
		int  cacheOption, cacheSize; // variables for cache values and cache size
		int debugLevel = 0; // sets the debug level to 0
		int degree = 0; // sets the degree to 0
		int seqLength = 0; // sets the sequence length to 
		String fileName = " "; // variable for the file name
		Scanner fileScan; // variable for the file scan
		BTree tree; //  this is the variable for the btree tree

		try {
			if (args.length == 6) {
				cacheOption = Integer.parseInt(args[0]);
				if (cacheOption == 0) {// this chacks the cache option

				} else if (cacheOption == 1) { // Throws the no unsupported operation exception because it is not implemented 
					throw new UnsupportedOperationException();
				} else {
					System.out.println("Please put in either 0 or 1 for the cache option.");
					System.exit(0);
				}

				degree = Integer.parseInt(args[1]);// This is the degree of the tree that will be built
				fileName = args[2]; // This is gets the file name.
				seqLength = Integer.parseInt(args[3]); // This will provide the sequence length that will be used
				if (seqLength > 31 ||seqLength<1) {
					System.out.println("Please put in a value between 1 and 31.");
					System.exit(0);
				}
		
				debugLevel = Integer.parseInt(args[4]);// This will provide the debug level.
				if (debugLevel == 0) { 

				} else if (debugLevel == 1) {
					
				}else {
					System.out.println(" Please put in either one or two");
					System.exit(0);
				}
				cacheSize = Integer.parseInt(args[5]); // this grabs the cache size

			}else if (args.length == 5) {
				cacheOption = Integer.parseInt(args[0]); // this gets the cache option
				if (cacheOption == 0) {
					
				} else if (cacheOption == 1) {
					throw new UnsupportedOperationException();
				} else {
					System.out.println("Please put in either 0 or 1 for the cache option.");
					System.exit(0);
				}

				degree = Integer.parseInt(args[1]);// This is the degree of the tree that will be built
				fileName = args[2]; // This is gets the file name.
				seqLength = Integer.parseInt(args[3]); // This will provide the sequence length that will be used
				if (seqLength > 31 ||seqLength<1) {
					System.out.println("Please put in a value between 1 and 31.");
					System.exit(0);
				}
				if(cacheOption == 0) {
				debugLevel = Integer.parseInt(args[4]);// This will provide the debug level.
				if (debugLevel == 0) { 

				} else if (debugLevel == 1) {// 
					
				}else {
					System.out.println(" Please put in either one or two for debug level");
					System.exit(0);
				}
				}
				
				

			}else if(args.length == 4 ) {
				cacheOption = Integer.parseInt(args[0]); // this gets the cache option
				if (cacheOption == 0) {

				} else if (cacheOption == 1) {
					throw new UnsupportedOperationException();
				} else {
					System.out.println("Please put in either 0 or 1.");
					System.exit(0);
				}

				degree = Integer.parseInt(args[1]);// This is the degree of the tree that will be built
				if(degree==0) {
					tree = new BTree(fileName, degree, seqLength, debugLevel);
				}
				fileName = args[2]; // This is gets the file name.
				seqLength = Integer.parseInt(args[3]); // This will provide the sequence length that will be used
				if (seqLength > 31 ||seqLength<1) {
					System.out.println("Please put in a value between 1 and 31.");
					System.exit(0);
				}
			}
			else // this prints the usage message
			{
				System.out.println("Usage: [0 | 1(no/with Cache)] [btree file] [query file] [0 | 1 debug level]");
				System.exit(0);
			}

		} catch (NumberFormatException e) {

			System.exit(0);
		}

		try {
			 tree = new BTree(fileName, degree, seqLength, 1); //  this creates a new btree object
			 tree.create(); // sets up the file for the btree
			File numbersFile;// create the file
		
			boolean afterOrigin = false; // Make sure read is after origin 
			boolean done = true; // see if the process is done
			boolean isN= true; // to see if it is after n
			numbersFile = new File(fileName); // creates the file to be parsed
			fileScan = new Scanner(numbersFile); // this gets the file scanner to look at things
			String check = " "; // this is what is read from the file scan
			long number = 0L; // this is the number that will be used for the key value
			while (fileScan.hasNextLine()) { // this will run while file scan has another line to follow it
				check = fileScan.nextLine();
				check = check.replaceAll("\\s+", ""); // removes the spaces
				if (check.equals("ORIGIN")) { // checks if it is after origin 
					afterOrigin = true;
				
					continue;
				}

				if (check.equals("//")) { // if this has run into the double back slashs
					afterOrigin = false;
				}
				done = true; // set done to true
				int i = 0;
				int j = 0;
				
				while (done && afterOrigin) { // will run while after origin and not done
					for (i = 0; i < check.length(); i++) { // reads through string from scanner call to next 
						if (check.charAt(i) == 0 || check.charAt(i) == 1 || check.charAt(i) == 2 || check.charAt(i) == 3 // checks for numbers at the start of each line 
								|| check.charAt(i) == 4 || check.charAt(i) == 5 || check.charAt(i) == 6
								|| check.charAt(i) == 7 || check.charAt(i) == 8 || check.charAt(i) == 9) {
						} else {
							char inputer = check.charAt(i); // grabs a char for the switch statement
							switch (inputer) { // check what the value is in the sequence
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
							case 'N':
							case 'n':
								isN = false;
								break;
							}
							if(!isN) {
								break;
							}
							if (j == seqLength) { // this restarts the grabbing of the sequence
								
								
								TreeObject insert= new TreeObject(number); // creates a btree object with the key
							
								tree.insert(insert); // inserts the value into the  btree 
								number=0L;

								i = i - (seqLength - 1);
								j = 0;
							}
							
							j++;
						}

					}

					done = false; // so that the while loop will end
				}

			}
			long rootOffset = tree.getRootOffset(); // gets the offset of the root of the tree 
			RandomAccessFile RAF = tree.getRAF(); // gets the random access file
			try {
				RAF.seek(16L); // goes to the correct offset to write the root offset
				RAF.writeLong(rootOffset); // writes the root offset
			} catch (IOException e) {
				System.out.println("There was an issue with RandomAccessFile.");
			}
			if(debugLevel == 1) // give the tree the debug level
				tree.debug();
		}
		catch (FileNotFoundException e) {
			System.out.print("The file was not found.");
		}
		catch (UnsupportedOperationException e) // catches the unsupported operation exception 
		{
			System.out.println("Caches are currently unsupported.");
		}
	}


}
