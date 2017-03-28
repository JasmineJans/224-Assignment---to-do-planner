
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This program implements an ArrayList of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class implements creation of a file from a current planner 
 * being used into a new text file with a given number
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 *
 */

public class FileCreator {
	
	//number of the file with planner info
	private int plannerNumber = 0;
	//a print writer to write to the file
	private PrintWriter writer;

	/**
	 * default constructor for a file creator
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public FileCreator() throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter("planner_" + plannerNumber + ".txt");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor that takes a number for the file
	 * @param plannerNumber the number for the file being created
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public FileCreator(int plannerNumber) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter("planner_" + plannerNumber + ".txt");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * makes a file and fills it with strings of planner todo info
	 * @param planner the planner to get the file info from
	 */
	public void createFile(TodoPlanner planner){
		for(int i = 0; i<planner.getList().size(); i++){
			Todo item = planner.getTodo(i);
			writer.println(item.toString());
		}
		writer.close();
	}

}
