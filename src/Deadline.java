/**
 * This program implements an Arraylist of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class is the deadline class. It extends the Todo super class and inherits 
 * it getTitle and setTitle methods and the title attribute. It also adds a dueDate 
 * attribute and an overridden print method that will print the title and due date of the object.
 * It also provides necessary getters and setter for the new attributes.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 * 
 */

public class Deadline extends Todo{
	private String dueDate;
	
	/**
	 * default constructor calls super class defaults and sets dueDate to an empty string
	 */
	public Deadline() {
		super();
		dueDate = "";
	}
	
	/**
	 * constructor that takes two parameters for title and dueDate 
	 * (calls the super class one param constructor)
	 * @param date a new duedate for the deadline
	 * @param title a new title for the deadline
	 */
	public Deadline(String date, String title) {
		super(title);
		this.dueDate = date;
	}
	
	/**
	 * gets the due date of the deadline
	 * @return the dueDate string
	 */
	public String getDueDate(){
		return dueDate;
	}
	
	/**
	 * sets the due date of the deadline with the given parameter
	 * @param date the new due date of the deadline
	 */
	public void setDueDate(String date){
		dueDate = date;
	}
	
	/**
	 * prints the deadline, first the title then the dueDate
	 */
	public void print(){
		System.out.println("Deadline: " + this.getTitle() + " (DueDate: " + this.getDueDate() + ")");
	}
	
	/**
	 * returns a string of what would get printed (all pertinent information)
	 * @return string of pertinent information
	 */
	public String toString(){
		return "Deadline: " + this.getTitle() + " (DueDate: " + this.getDueDate() + ")";
	}
}
