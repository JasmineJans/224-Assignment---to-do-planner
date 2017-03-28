/**
 * 
 * This program implements an Arraylist of Todo objects as a planner for
 * 3 types of to do items: meetings, tasks and deadlines. 
 * 
 * This specific class is the meeting class. It extends the Todo super class and inherits 
 * it getTitle and setTitle methods and the title attribute. This class adds a string representing
 * a Location, and a string representing the time of a meeting. This class also
 * provides an overridden print method that prints the title as well as the location and time 
 * of the meeting. It also provides necessary getters and setter for the new attributes.
 * 
 * @author Jasmine Jans
 * @version HW 4: Todo Planner with File Input and Output
 * date 3/04/2016
 * class CPSC 224 02
 * professor Worobec
 */

public class Meeting extends Todo{
	private String myLocation;
	private String myTime;
	
	/**
	 * default constructor that calls the usper class default constructor
	 * and sets the location to an empty string and the time to an empty string.
	 */
	public Meeting(){
		super();
		myLocation = "";
		myTime = "";
	}
	
	/**
	 * consturctor that sets the title, location and time of the meeting 
	 * with the given parameters.
	 * @param title the title of the meeting (super constructor called)
	 * @param loc the locaiton fo the meeting
	 * @param time the time on the meeting
	 */
	public Meeting(String title, String loc, String time){
		super(title);
		myLocation = loc;
		myTime = time;
	}
	
	/**
	 * gets the location of the meeting
	 * @return the location of the meeting
	 */
	public String getLocation(){
		return myLocation;
	}
	
	/**
	 * sets the location of the meeting through the parameter
	 * @param loc the new location for a meeting
	 */
	public void setLocation(String loc){
		myLocation = loc;
	}
	
	/**
	 * gets the time of a meeting
	 * @return the time of the meeting 
	 */
	public String getTime(){
		return myTime;
	}
	
	/**
	 * sets the time of the meeting
	 * @param time the new time of the meeting
	 */
	public void setTime(String time){
		myTime = time;
	}
	
	/**
	 * prints out the meeting with the title location and time of the meeting
	 */
	public void print(){
		System.out.println("Meeting: "+ this.getTitle() + " (Location: " + this.getLocation() + ", Time: " + this.getTime() + ")");
	}
	
	/**
	 * returns a string of what would get printed (all pertinent information)
	 * @return string of pertinent information
	 */
	public String toString(){
		return "Meeting: "+ this.getTitle() + " (Location: " + this.getLocation() + ", Time: " + this.getTime() + ")";
	}
}
