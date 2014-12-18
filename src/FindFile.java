import java.io.File;
/**Description: Given a directory and a target file name this class
 * searches through that directory and all sub-directories within 
 * that directory to find a target file name. After invoking invoking
 * the constructor and specifying the maximum number of files in main
 * and making an instance of this class a String array is set to the 
 * maximum number of files of the target name to be found. 
 * 
 * Once the method directorySearch() is invoked which takes in two 
 * arguments, a target file name and directory name both of type String,
 * the file requested will be stored in as a String in the String array.
 * directorySearch() recursively searches through the directories in a 
 * for each loop which provides conveinvance because it automatically  
 * knows where to start and stops at the length.
 * The point of this assignment is to get introduced to recursion and 
 * stepping through and searching through a data structure recursively.
 * Project: FindFile.java
 * Author: Shayan Raouf
 * Due Date: 11/10/2014
 */
public class FindFile {

	//Initialization of private fields 
	private int maxFiles;
	private int numElements;
	private File f;
	private String[] fileList;
	private File[] fileListArray;

	/**This constructor accepts the maximum number of files 
	 * to find and sets the max and sets the Stacks.*/
	FindFile(int maxFiles){
		setMaxFiles(maxFiles); //Sets the maxFiles
		fileList = new String[maxFiles]; //sets the capacity of Stack to maxFiles
	}

	/**This method  parameters are the target file name to 
	 * look for and the directory to start in.*/
	public void directorySearch(String target, String dirName){
		
		if(target == null || dirName == null){ //checks for null and throw an exception otherwise 
			throw new MyException("No null values allowed");
		}
		
		f = new File("\\" + dirName + "\\"); //makes a new File object
		fileListArray = f.listFiles();  //file array	
		if(fileListArray != null){ //Checks for null in the file array

			/*for each loop for convenience to walk 
			 * through each directory*/
			for (File fileName: fileListArray){
				if(numElements < maxFiles){ //stops once the count reaches the maxFile limit

					if(fileName.isDirectory()){ //checks first if the file is a directory 

						//recursively recalling the method
						directorySearch(target, "\\" + fileName.getAbsolutePath());
					}

					//checking if the target is equal to the file in the directory 
					if(target.equalsIgnoreCase(fileName.getName())){
						fileList[numElements] = fileName.getAbsolutePath();//placing path into String[]
						numElements++;
					}
				}

			}

		}

		//Throws an exception once we reach the max number of files to find
		if(numElements == maxFiles){
			throw new MyException("MAX_NUMBER_OF_FILES_FOUND");
		}

	}

	/**This getter method @returns count 
	 * the number of matching files found*/
	public int getCount(){
		return numElements; 

	}

	/**This setter methods accepts an argument
	 * of type int and initializes the maximum 
	 * number of files it can find*/
	public void setMaxFiles(int maxFiles){
		this.maxFiles = maxFiles;

	}
	/**This getter method @returns the array of file locations, 
	 * up to maxFiles in size. This method also copies the
	 * fileList Stack into a String array with a max size of the number f files so 
	 * in the case of a maxFile number greater than the actual number of files
	 * pertaining in the array, the null values won't appear*/
	public String[] getFiles(){
		String[] retVal = new String[numElements]; //create a new String array of size count

		for(int i = 0; i < numElements; i++){ //copies the files into new String array
			retVal[i] = fileList[i];		
		}

		return retVal; 
	}

}
