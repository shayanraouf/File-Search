/**Description: This is a very basic and simple
 * class MyException with extends RuntimeException 
 * therefore inheriting all the functionalities of 
 * RunTimeException. We will be using this for our
 * FindFile class calling it and throwing new exceptions
 * when needed. 
 * Project: MyException.java
 * Author: Shayan Raouf
 * Due Date: 11/10/2014
 */
public class MyException extends RuntimeException {
	
	/**Constructor that accepts an argument
	 * of type String and passes it in to 
	 * parent class which prints the error message*/
	public MyException(String note){
		super(note);
		
	}
	
	/**Constructor that calls the parent class
	 * with no args, default Constructor*/
	public MyException(){
		super();	
	}

}
