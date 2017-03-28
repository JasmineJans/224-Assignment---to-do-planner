import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * This program implements an ArrayList of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class implements the user interface needed for a person to
 * use the to do list. It gives them the ability to load an old and saved list 
 * in a text file , add new items, delete items, view the list and exit from the 
 * list, either throwing it away or saving it into a txt. file with a given number
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 */
public class TodoPlannerTextUI {

	/**
	 * Prints out the main menu of the program
	 */
	public void mainMenu(){
		System.out.println("Main Menu:");
		System.out.println("1. Create a Task");
		System.out.println("2. Create a Meeting");
		System.out.println("3. Create a Deadline");
		System.out.println("4. Remove a Todo Item");
		System.out.println("5. Display Todo Items");
		System.out.println("6. Save ToDo List and Exit");
		System.out.println("7. Load a saved planner");
		System.out.println("8. Exit");
		System.out.println("Choice: ");
	}

	/**
	 * adds a meeting to the list
	 * @param in the scanner used for user input
	 * @param planner the list of todo objects
	 * @return the meeting object that you want to add
	 */
	public Meeting addingMeeting(Scanner in, TodoPlanner planner){
		System.out.println("Please enter a meeting title: ");
		String title = in.next();
		int i = 0;
		while(i<planner.getList().size()){
			if(title.equals(planner.getTodo(i).getTitle())){
				System.out.println("This title already exists, please enter a new title: ");
				title = in.next();
				i = 0;
			}
			i++;
		}
		System.out.println("Please enter a meeting location: ");
		String location = in.next();
		System.out.println("Please enter a meeting time: ");
		String time = in.next();
		Meeting newMeeting = new Meeting(title, location, time);
		System.out.println("Added Meeting: ");
		newMeeting.print();
		return newMeeting;
	}

	/**
	 * adds a deadline to the list
	 * @param in the scanner used for user input
	 * @param planner the list of todo objects
	 * @return the deadline object that you want to add
	 */
	public Deadline addingDeadline(Scanner in, TodoPlanner planner){
		System.out.println("Please enter a deadline title: ");
		String title = in.next();
		int i = 0;
		while(i<planner.getList().size()){
			if(title.equals(planner.getTodo(i).getTitle())){
				System.out.println("This title already exists, please enter a new title: ");
				title = in.next();
				i = 0;
			}
			i++;
		}
		System.out.println("Please enter a deadline due date: ");
		String dueDate = in.next();
		Deadline newDeadline = new Deadline(dueDate, title);
		System.out.println("Created Deadline: ");
		newDeadline.print();
		return newDeadline;
	}

	/**
	 * adds a task to the list
	 * @param in the scanner used for user input
	 * @param planner the list of todo objects
	 * @return the task object that you want to add
	 */
	public Task addingTask(Scanner in, TodoPlanner planner){
		System.out.println("Please enter a task title: ");
		String title = in.next();
		int i = 0;
		while(i<planner.getList().size()){
			if(title.equals(planner.getTodo(i).getTitle())){
				System.out.println("This title already exists, please enter a new title: ");
				title = in.next();
				i = 0;
			}
			i++;
		}
		System.out.println("Please enter a task priority (1-Urgent, 2-Important, 3-Someday): ");
		int priority = in.nextInt();
		while(priority < 1 || priority > 3){
			System.out.println("Oops, please try again, must be between 1-3: ");
			priority = in.nextInt();
		}
		Task newTask = new Task(title, priority);
		System.out.println("Created Task: ");
		newTask.print();
		return newTask;	
	}

	/**
	 * deletes the given todo object you no longer want in the list
	 * @param in the scanner used for user input
	 * @param type the value that represents the object in the 
	 * 		  list the user wants to delete.
	 * @param planner the list of all the todo objects
	 */
	public void deletingTodo(Scanner in, int type, TodoPlanner planner){
			planner.deleteTodo(planner.getTodo(type));
	}

	/**
	 * Main method that opens a scanner, create a new planner and runs until the user
	 * exits the program by typing 6
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated constructor stub
		Scanner in = new Scanner(System.in);
		TodoPlanner planner = new TodoPlanner();
		TodoPlannerTextUI text = new TodoPlannerTextUI();
		FileCreator newFile;
		FileLoader newPlanner = new FileLoader();

		System.out.println("Welcome to the Todo Planner!");
		System.out.println("----------------------------");
		text.mainMenu();

		boolean loop = true;
		while(loop){
			int selection = in.nextInt();
			//adding a task
			if(selection == 1){
				planner.addToList(text.addingTask(in, planner));
			}
			//add a meeting
			else if(selection == 2){
				planner.addToList(text.addingMeeting(in, planner));
			}
			//add a deadline
			else if(selection == 3){
				planner.addToList(text.addingDeadline(in, planner));

			}
			//deleting an item
			else if(selection == 4){
				System.out.println("Please enter the number of the todo item you'd like to remove!");
				planner.printList();
				int type = in.nextInt();
				while(type > planner.getList().size() || type < 1){
					System.out.println("Oops, please try again, must be a valid todo number: ");
					type = in.nextInt();
				}
				text.deletingTodo(in, type-1, planner);
			}
			//displaying the planner
			else if(selection == 5){
				planner.printList();
			}
			//saving a planner and exiting
			else if (selection == 6){
				System.out.println("Please provide a number for your planner:");
				int number = in.nextInt();
				newFile = new FileCreator(number);
				newFile.createFile(planner);
				System.out.println("Your file is saved! Goodbye!");
				in.close();
				loop = false;
			}
			// loading a saved planner
			else if (selection == 7){
				System.out.println("Please enter the name of the planner you want!");
				File file = new File(in.next());
				planner = newPlanner.getText(file);
				System.out.println("Your planner is loaded!");
			}
			//exiting
			else if(selection == 8){
				System.out.println("Goodbye!");
				in.close();
				loop = false;
			}
			//failed input
			else{
				System.out.println("Please enter a valid integer between 1 and 6");
			}
			//redisplaying the main menu
			if(selection != 8 && selection != 6){
				text.mainMenu();
			}
		}
	}
}
