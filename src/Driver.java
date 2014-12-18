/**Description: Given the FindFile.java this main class
 * tests and runs the code making sure it executes correctly. 
 * For clean and precise coding I made a static method
 * that prints the path in the array and static variables
 * for the initialization. In main I solely have a try and catch
 * while invoking different methods from FindFile and within 
 * this class as well. 
 * The purpose of this assignment is not use to test out this
 * program for functionality but also to get familiar with building
 * test drivers to effectively run our code. 
 * Project: Driver.java
 * Author: Shayan Raouf
 * Due Date: 11/10/2014
 */
public class Driver {
	//Public static fields 
	public static String targetFile = "longwords.txt"; //Enter a file
	public static String pathToSearch = "C:"; // Enter a Directory
	public static int maxNum = 7; //Max number of files
	public static FindFile finder = new FindFile(maxNum); //creates an instance of the FindFile
	public static String[] get;
	
	public static void main(String [] args){

		try{ //invokes method to recursively search for the file
		finder.directorySearch(targetFile, pathToSearch); 
		printFileArray(); //method call to display files
		
		}
		catch(Exception e){ //Catch the exception
			System.err.println(e); //Print the exception issue
			printFileArray(); //method call to display files
			System.exit(0); //exit gracefully 
		}
	}
	
	/**static method made to help cleaner test code
	 * and for less repetitive code*/
	public static void printFileArray(){
		get = finder.getFiles(); 
		for(String obj: get){ //displays the file paths in the array
			System.out.println(obj);
		}
		//display the number of files
		System.out.println("Number of files: " + finder.getCount());
		
	}

}
