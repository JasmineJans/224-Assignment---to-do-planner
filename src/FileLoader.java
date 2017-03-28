import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

   
/**
 * This program implements an ArrayList of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class implements creation of a planner from a 
 * given text file.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 * 
 */

public class FileLoader {

	//planner to load file info into
	private TodoPlanner planner;
	//array list to hold the parsed strings from the file in
	private ArrayList<String> parseArray = new ArrayList<String>();
	
	/**
	 * default constructor that makes a new planer
	 */
	public FileLoader() {
		planner = new TodoPlanner();
	}
	
	/**
	 * 
	 * @param todoFile a file to get the planner information from
	 * @return a todo planner with all the todo objects form the file
	 * @throws FileNotFoundException
	 */
	public TodoPlanner getText(File todoFile) throws FileNotFoundException{
		Scanner in = new Scanner(todoFile);
		planner.clearList();
		while(in.hasNextLine()){
			String a = in.nextLine();
			for(String word : a.split(" |\\,|\\)")) {
			    parseArray.add(word);
			}
			if(parseArray.contains("Deadline:")){
				addDeadline(parseArray);
				/*Deadline newD = new Deadline();
				int indexTitle = parseArray.indexOf("Deadline:");
				newD.setTitle((String) parseArray.get(indexTitle + 1));
				int indexDate = parseArray.indexOf("(DueDate:");
				newD.setDueDate((String)parseArray.get(indexDate+1));
				planner.addToList(newD);*/
			}
			else if (parseArray.contains("Meeting:")){
				addMeeting(parseArray);
				/*Meeting newM = new Meeting();
				int indexTitle = parseArray.indexOf("Meeting:");
				newM.setTitle((String) parseArray.get(indexTitle + 1));
				int indexLocation = parseArray.indexOf("(Location:");
				newM.setLocation((String)parseArray.get(indexLocation+1));
				int indexTime = parseArray.indexOf("Time:");
				newM.setTime((String)parseArray.get(indexTime+1));
				planner.addToList(newM);*/
			}
			else{
				addTask(parseArray);
				/*Task newT = new Task();
				int indexTitle = parseArray.indexOf("Task:");
				newT.setTitle((String) parseArray.get(indexTitle + 1));
				int indexPriority = parseArray.indexOf("(Priority:");
				int priority;
				if(parseArray.get(indexPriority+1).equals("Urgent")){
					priority = 0;
				}
				else if (parseArray.get(indexPriority+1).equals("Important")){
					priority = 1;
				}
				else{
					priority = 3;
				}
				newT.setPriority(priority);
				planner.addToList(newT);
				*/
			}
		}
		in.close();
		return planner;
			
	}
	
	/**
	 * Helper method that adds a deadline to a list based
     * on the input from the file
	 * @param parseArray the array with parse input from the
	 * 		  test file.
	 */
	private void addDeadline(ArrayList<String> parseArray){
		Deadline newD = new Deadline();
		int indexTitle = parseArray.indexOf("Deadline:");
		newD.setTitle((String) parseArray.get(indexTitle + 1));
		int indexDate = parseArray.indexOf("(DueDate:");
		newD.setDueDate((String)parseArray.get(indexDate+1));
		planner.addToList(newD);
	}
	
	/**
	 * Helper method that adds a task to a list based
     * on the input from the file
	 * @param parseArray the array with parse input from the
	 * 		  test file.
	 */
	private void addTask(ArrayList<String> parseArray){
		Task newT = new Task();
		int indexTitle = parseArray.indexOf("Task:");
		newT.setTitle((String) parseArray.get(indexTitle + 1));
		int indexPriority = parseArray.indexOf("(Priority:");
		int priority;
		if(parseArray.get(indexPriority+1).equals("Urgent")){
			priority = 0;
		}
		else if (parseArray.get(indexPriority+1).equals("Important")){
			priority = 1;
		}
		else{
			priority = 3;
		}
		newT.setPriority(priority);
		planner.addToList(newT);
	}
	
	/**
	 * Helper method that adds a meeting to a list based
     * on the input from the file
	 * @param parseArray the array with parse input from the
	 * 		  test file.
	 */
	private void addMeeting(ArrayList<String> parseArray){
		Meeting newM = new Meeting();
		int indexTitle = parseArray.indexOf("Meeting:");
		newM.setTitle((String) parseArray.get(indexTitle + 1));
		int indexLocation = parseArray.indexOf("(Location:");
		newM.setLocation((String)parseArray.get(indexLocation+1));
		int indexTime = parseArray.indexOf("Time:");
		newM.setTime((String)parseArray.get(indexTime+1));
		planner.addToList(newM);
	}

}
