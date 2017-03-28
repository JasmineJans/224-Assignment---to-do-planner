import java.util.ArrayList;

/**
 * This program implements an ArrayList of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class actually implements the ArrayList of Todo objects. It creates the list
 * and provides methods for adding to it, getting items at certain indices, deleting from the
 * list and printing out the list and all its items. It also provides a special method that will
 * check to see if a given string already exists as a title in the list o help prevent duplication
 * during time of implementation.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/30/2016
 * class CPSC 224 02
 * professor Worobec
 * 
 */

public class TodoPlanner {
	//private Todo[] todoList;
	private ArrayList<Todo> todoList;
	
	/**
	 * the default constructor for the TodoPlanner() that
	 * creates the new arraylist of Todos
	 */
	public TodoPlanner() {
		// TODO Auto-generated constructor stub
		todoList = new ArrayList<Todo>();
	}
	
	/**
	 * adds a new Todo object to the list
	 * @param todo the new Todo object being added to the list
	 */
	public void addToList(Todo todo){
		todoList.add(todo);
	}
	
	/**
	 * gets the arraylist of todos
	 * @return the arraylist of todos
	 */
	public ArrayList<Todo> getList(){
		return todoList;
	}
	
	/**
	 * clears the planner
	 */
	public void clearList(){
		todoList.clear();
	}
	
	/**
	 * gets the todo at a certain index in the list
	 * @param Index an int value that represents a place in the list
	 * @return the Todo object that is in the given index of the list
	 * 		   or null if there is an ArrayIndexOutOfBoundsException.
	 */
	public Todo getTodo(int Index){
		try{
			return todoList.get(Index);
		}
		catch(ArrayIndexOutOfBoundsException e){
			return null;
		}
	}
	
	/**
	 * deletes the given todo object from the list
	 * @param todo the object you want deleted from the list
	 */
	public void deleteTodo(Todo todo){
		todoList.remove(todo);
	}
	
	/**
	 * prints the list using the print() methods of each specific subtype
	 * of todo
	 */
	public void printList(){
		for(int i = 0; i<todoList.size(); i++){
			System.out.print(i+1 + ". ");
			todoList.get(i).print();
		}
	}
	
	/**
	 * checks to see if a title exists as the title
	 * of a todo object in the list already
	 * @param title the title you are checking for as a duplicate
	 * @return true if the title already exists, false otherwise
	 */
	public boolean titleExists(String title){
		for(int i = 0; i<=todoList.size(); i++){
			if(title.equals(todoList.get(i).getTitle())){
				return true;
			}
		}
		return false;
	}

}
