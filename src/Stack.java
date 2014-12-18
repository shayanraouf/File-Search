/**Description: This class we will be building our
 * own Stack class with the following methods
 * void push(Object)
 * Object pop()
 * int size()
 * String toString()
 * boolean isEmpty()
 * boolean equals(Object);
 * The goal is to understand how Stacks work in Java
 * also understanding that Stacks go in LIFO order
 * Project: Stack.java
 * Author: Shayan Raouf
 * Due Date:    10/23/2014
 */
public class Stack {
	//Private instance variables declared 
	private int numElement;
	private Object[] object;
	
	/**Constructor that initializes the private fields*/
	public Stack(int capacity){
		object = new Object[capacity];	
		numElement = 0;
	}
	
	/**passes in 100 to the above constructor 
	 * to set the initial capacity of our array 
	 * to 100*/
	public Stack(){
		this(100);
	}
	
	/**This method adds to the Stack
	 * it adds to the last element of the array*/
	public void push(Object value){	

		//the object passed in needs not to be null and an instance of an object
		if(value != null){
			
			if(numElement == object.length){
				
				//calls resize if the numElement reaches the array length
				resize();	
			}
			//Adds to the end element and increments the numElement
			object[numElement] = value;
			numElement++;
			
		}
		else{
			  //Throws in an exception otherwise 
			  throw new IllegalArgumentException("Invalid Paramater Type");		
		}
	}
	
	/**This method doubles the value of the 
	 * instance array object and is called
	 * when the elements are reaching the maximum length*/
	private void resize(){
		
		//creates a temporary Object[] array and set the length multiplied by two
		Object[] resized = (Object[]) new Object[object.length * 2];
		for(int i = 0; i < numElement; i++){
			
			//add the current values to the doubled array
			resized[i] = object[i];
		}
		
		//change the instance variable to our resized array
		object = resized;
	}
	
	/**This removes an object from out array elements
	 * but only from the top(the last element)*/
	public Object pop(){
		Object newObject = new Object();
		
		//Checking if there are elements in the array before removing anything
		if(!isEmpty()){
	
		newObject = object[numElement - 1];
		object[numElement - 1] = null;
		numElement--;		
		}
		else{
			
			//throws an out of bounce exception
			throw new ArrayIndexOutOfBoundsException("Accessing an out of bounce element");
		}
	return newObject;	
	}
	
	/**@returns a value type int
	 * of the size of the Queue*/
	public int size(){
		return numElement;	
	}
	
	/**This toString method @returns []
	 * if the number of elements are empty or
	 * @returns the object values in the array
	 * nicely displayed in a string like
	 * [object, object, object] etc.*/
	public String toString(){
		String retVal = "";
		if(isEmpty()){
			return "[]";
			
		}
		else{
			retVal = "[" + object[0];
			for(int i = 1; i < numElement; i++){
				retVal += ", " + object[i];		
				
			}
			 retVal += "]";			
		}
		
		return retVal;
	}
	
	/**This method checks to see if the
	 * any objects in the Stack
	 * and @returns true if there is*/
	public boolean isEmpty(){
		boolean retVal = false;
		if(numElement == 0){
			retVal = true;		
		}
		return retVal;
	}
	
	/**@returns true of the object being passed
	 * in is present in the Stack*/
	@Override
	public boolean equals(Object obj){
		boolean retVal = true;
		
		//validates if null and an instance of the class Stack then casts the object
		if(obj != null && obj instanceof Stack){	
		Stack castedObj = (Stack)obj;
		
		//if the sizes are equal then continues to the next step
		if(size() == castedObj.size()){
			
			for(int i = 0; i < numElement; i++){
				if(!object[i].equals(castedObj.object[i])){
					return false;
				}			
			}
		}
		
		else{
			retVal = false;
			
		}
	}
		else{			  
			  //Throws an illegal argument exception and prints the reasoning 
			  throw new IllegalArgumentException("Invalid Paramater Type");		
		}	
		return retVal;	
	}

}
