/**
 * This program implements an Arraylist of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class is the Todo class. It is a super class to represent any
 * type of Too object. It includes a title and a print method that simply prints
 * the title. It also provides necessary getters and setter for its attributes.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 *
 */

public class Todo {
	
	//String that represents the title of the todo object
	private String myTitle;

	/**
	 * default constructor that just sets the title to an empty string
	 */
	public Todo(){
		myTitle = "";
	}
	/**
	 * constructor that takes one parameter and sets title to the given parameter
	 * @param title new title of the todo object
	 */
	public Todo(String title) {
		// TODO Auto-generated constructor stub
		myTitle = title;
	}
	
	/**
	 * gets the title of the obect and returns it
	 * @return the title of the todo object
	 */
	public String getTitle(){
		return myTitle;
	}
	
	/**
	 * sets the title of the object to the title given as parameter
	 * @param title the new title of the todo object
	 */
	public void setTitle(String title){
		myTitle = title;
	}
	
	/**
	 * prints out the todo object (just its title)
	 */
	public void print(){
		System.out.println(this.getTitle());
	}
}
