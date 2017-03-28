/**
 * This program implements an Arraylist of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class is the task class. It extends the Todo super class and inherits 
 * it getTitle and setTitle methods and the title attribute. This class adds an array 
 * of string representing priorities, and a singular string priority. This class also
 * provides an overridden print method that prints the title as well as the priority of the task.
 * It also provides necessary getters and setter for the new attributes.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 * 
 */

public class Task extends Todo{
	private String[] priorities = {"Urgent", "Important", "Someday"};
	private String priority;
	
	/**
	 * default constructor that calls the default constructor 
	 * of the super class and sets priority to an empty string.
	 */
	public Task(){
		super();
		priority = "";
	}
	
	/**
	 * Constructor with two parameters, one is the title 
	 * of the task the other is the priority
	 * @param title the title of the task
	 * @param priority the priority of the task
	 */
	public Task(String title, int priority) {
		super(title);
		setPriority(priority);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * sets the priority of the the task based on the number
	 * entered's correlation with the priorities array
	 * @param priorityNumber the integer value that represents 
	 * 		  the priority you want in the priority array.
	 */
	public void setPriority(int priorityNumber){
		if(priorityNumber == 1){
			priority = priorities[0];
		}
		else if (priorityNumber == 2){
			priority = priorities[1];
		}
		else if (priorityNumber == 3){
			priority = priorities[2];
		}
		else{
			priority = null;
		}	
	}
	
	/**
	 * gets the priority of the tast
	 * @return the string priority of the task
	 */
	public String getPriority(){
		return priority;
	}
	
	/**
	 * prints out the tast with the title and the priority
	 */
	public void print(){
		System.out.println("Task: " + this.getTitle() + " (Priority: " + this.getPriority() + ")");
	}
	
	/**
	 * returns a string of what would get printed (all pertinent information)
	 * @return string of pertinent information
	 */
	public String toString(){
		return "Task: " + this.getTitle() + " (Priority: " + this.getPriority() + ")";
	}
	

}
