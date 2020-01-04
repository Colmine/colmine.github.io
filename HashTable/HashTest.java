import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


/* Project #3: HashTables
 * Class: CS321 Fall-2019
 * Date: 10/26/2019
 * 
 * Class that uses hash tables and command line arguments to read contents
 * from a given file and then store the contents of the file in a hash table.
 * After the file has been scanned through or the hash table has reached maximum
 * capacity the stats of the file and the hash table will be printed out to
 * the user. Uses three different kinds of hash tables, linear, double hashing,
 * and quadratic. Also allows for an optional command that will print out
 * all of the contents in the hash tables after showing the results.
 * 
 * @author Cole Gilmore
 * 
 */

public class HashTest {
	public static void main(String[] args) {
		//Creating format variable for printing out the average probe counts
		DecimalFormat df = new DecimalFormat("#.00");
		boolean valid = false;
		
		//Checks to make sure that command line arguments are the types and lengths they should be
		if(args.length == 4) {
			valid = true;
			float factor = Float.parseFloat(args[0]);
			//Check to maintain load factor
			if(factor > 1) {
				valid = false;
				System.out.println("Your loadfactor value should be less than or equal to 1!");
			} 
			
			int capacity = Integer.parseInt(args[1]);
			//Checking capacity argument, which can really be any value but would preferably be a prime number
			if(capacity % 2 == 0) {
				System.out.println("Your capacity for the hash table should be a prime number! I.E. 7, 13, 19, etc.");
			}
			//Check to make sure the file name passed in is valid
			File file = new File(args[2]);
			if(!file.exists()) {
				valid = false;
				System.out.println("It seems like I can't find the file you specified! Check to make sure your spelling is correct!");
			} 
			//Checks to make sure which kind of variables are being passed into the hash table,
				//I.E. Integers, Long numbers, Strings, or Characters
			int type = Integer.parseInt(args[3]);
			//Variables being passed into the hash tables are of the type Integer
			if(type == 0 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Integer> linear = new HashTable<Integer>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Integer> doubleHash = new HashTable<Integer>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Integer> quadratic = new HashTable<Integer>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Variables being passed into the hash tables are of the type Long
			} else if(type == 1 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Long> linear = new HashTable<Long>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Long> doubleHash = new HashTable<Long>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Long> quadratic = new HashTable<Long>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Variables being passed to the hash tables are of the type String
			} else if(type == 2 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<String> linear = new HashTable<String>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<String> doubleHash = new HashTable<String>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<String> quadratic = new HashTable<String>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Variables being passed into the hash tables are of the type Character
			} else if(type == 3 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Character> linear = new HashTable<Character>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Character> doubleHash = new HashTable<Character>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Character> quadratic = new HashTable<Character>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Check to see if the user input an integer value that wasn't in the allowed range
			} else {
				System.out.println("Incorrect type value for the hash table!");
			}
			//Check to see if the user input a debug level into the command line
		} else if(args.length == 5) {
			float factor = Float.parseFloat(args[0]);
			valid = true;
			//Check to make sure the load factor is maintained
			if(factor > 1) {
				valid = false;
				System.out.println("Your loadfactor value should be less than or equal to 1!");
			} 
			//Check to see if capacity is prime/odd or not, it doesn't really matter but it does impact performance
			int capacity = Integer.parseInt(args[1]);
			if(capacity % 2 == 0) {
				System.out.println("Your capacity for the hash table should be a prime number! I.E. 7, 13, 19, etc.");
			}
			//Check to see if the filename passed in is valid or not
			File file = new File(args[2]);
			if(!file.exists()) {
				valid = false;
				System.out.println("It seems like I can't find the file you specified! Check to make sure your spelling is correct!");
			} 
			//Check to see if the user wanted to see the entire contents of the table or not
			int debug = Integer.parseInt(args[4]);
			
			int type = Integer.parseInt(args[3]);
			//Checks to see what kind of variables are being passed into the hash tables
				//Variables being passed into the hash tables are integers
			if(type == 0 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Integer> linear = new HashTable<Integer>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(linear.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Integer> doubleHash = new HashTable<Integer>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(doubleHash.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Integer> quadratic = new HashTable<Integer>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Integer> newObject = new HashObject<Integer>
							(Integer.parseInt(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(quadratic.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Variables being passed into the hash tables are of the type Long
			} else if(type == 1 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Long> linear = new HashTable<Long>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(linear.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Long> doubleHash = new HashTable<Long>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(doubleHash.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Long> quadratic = new HashTable<Long>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Long> newObject = new HashObject<Long>
							(Long.parseLong(inFile.next()), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(quadratic.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} else if(type == 2 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<String> linear = new HashTable<String>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(linear.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<String> doubleHash = new HashTable<String>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(doubleHash.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<String> quadratic = new HashTable<String>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<String> newObject = new HashObject<String>
							(inFile.next(), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(quadratic.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} else if(type == 3 && valid) {
				//Creating a linear probe type hash table to store objects
				HashTable<Character> linear = new HashTable<Character>(capacity, factor, OpenAddressType.linear);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && linear.size() != linear.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						linear.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) linear.getNumProbes())/linear.size();
					System.out.println("Using Linear Probing...");
					System.out.println("Inserted " + linear.size() + " values with " + linear.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(linear.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a double-hashing probe type hash table to store objects
				HashTable<Character> doubleHash = new HashTable<Character>(capacity, factor, OpenAddressType.doubleHashing);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && doubleHash.size() != doubleHash.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						doubleHash.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) doubleHash.getNumProbes())/doubleHash.size();
					System.out.println("Using Double Hash Probing...");
					System.out.println("Inserted " + doubleHash.size() + " values with " + doubleHash.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(doubleHash.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//Creating a quadratic probe type hash table to store objects
				HashTable<Character> quadratic = new HashTable<Character>(capacity, factor, OpenAddressType.quadratic);
				try {
					//Reading in info from the file passed in
					Scanner inFile = new Scanner(file);
					//delimiter to ignore any unnecessary whitespace between values
					inFile.useDelimiter("\\s+");
					while(inFile.hasNext() && quadratic.size() != quadratic.getMaxSize()) {
						//Creating a hash object instance to store the values from the file and then putting it into the hash table
						HashObject<Character> newObject = new HashObject<Character>
							(inFile.next().charAt(0), Integer.parseInt(inFile.next())); //For whatever reason using Objects.hashCode() here messes up the results
						quadratic.put(newObject.getValue(), newObject.getKey());
					}
					inFile.close();
					//Printing out stats about the hash table and file that got passed in
					double avgProbe = ((double) quadratic.getNumProbes())/quadratic.size();
					System.out.println("Using Quadratic Probing...");
					System.out.println("Inserted " + quadratic.size() + " values with " + quadratic.getNumDuplicates() + " duplicates.");
					System.out.println("Average number of probes: " + df.format(avgProbe) + "\n");
					//Check to see if the user wanted to see all of the contents of the hash table
					if(debug == 1) {
						System.out.println(quadratic.toString());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} else {
				System.out.println("Incorrect type value for the hash table!");
			}
			//Default message if someone needs to know how to use the program over the command line and what values go where
		} else {
			System.out.println("It looks like you entered either not enough arguments or too many for the program!");
			System.out.println("The general format for executing the program should be as follows, do NOT include the [] brackets around your inputs: ");
			System.out.println("java HashTest [load factor] [hash table capacity] [input file] [input type] [ | debug level] ");
			System.out.println("The load factor should be a number between 0 and 1.");
			System.out.println("The hash table capacity should be a positive whole number/integer.");
			System.out.println("The input file should be the exact name of the file you wish to use," + "\n" + 
					"and it should be in the same directory that the program is running from.");
			System.out.println("The input type should be a number from 0 to 3, I.E. 0, 1, 2, or 3." + "\n" +
					"It should be noted that the value 0 is for integers, 1 is for long numbers, 2 is for strings, and 3 is for characters.");
			System.out.println("For debug level the options are 0 or 1, 0 is the default to simply show the results of the program, " + "\n" + 
					"you can leave this input blank if you just want to see the results, " + "\n" +
					"while 1 shows the entire contents of the hash table, as well as the results at the start before the table is printed out.");
		}
	}
}
