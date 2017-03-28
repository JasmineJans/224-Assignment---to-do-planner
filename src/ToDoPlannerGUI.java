import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;



/**
 * This class creates the special frame that we use
 * that has 3 diffeerent panels that provide buttons and text inputs
 * to allow the functionality of adding, deleting and editing different
 * item in the TodoList and then changing the planner's title.
 * @author jasminejans
 * @version HW 5: Todo Planner with added GUI,  other classes from HW4
 * @date 03/30/2016
 */
public class ToDoPlannerGUI extends JFrame
{
	
	TodoPlanner planner = new TodoPlanner();

	private JPanel buttonPanel;
	private JPanel listPanel;
	private JPanel infoPanel;
	
	DefaultListModel<String> array;
	JList<String> todos;
	
/**
 * Constructor for the todoPlannerFrame that creates all contents
 */
	public ToDoPlannerGUI()
	{
		
		JLabel title;
		
		JTextField todotitle;
		JTextField date;
		JTextField location;
		JTextField priority;
		JTextField time;
		JLabel todotitlelabel;
		JLabel datelabel;
		JLabel locationlabel;
		JLabel prioritylabel;
		JLabel timelabel;
		
		Container container;
		
		todotitle = new JTextField(16);
		date = new JTextField(8);
		location = new JTextField(12);
		priority = new JTextField(8);
		time = new JTextField(6);
		
		todotitlelabel = new JLabel("Title: ");
		datelabel = new JLabel("Date: ");
		locationlabel = new JLabel("Location: ");
		prioritylabel = new JLabel("Priority: ");
		timelabel = new JLabel("Time: ");
		
		container = getContentPane();
		
		array = new DefaultListModel<String>();
		todos = new JList<String>(array);
		
		title = new JLabel("", SwingConstants.CENTER);
		title.setLayout(new FlowLayout());
		Font displayFont = new Font("Monospaced", Font.BOLD, 25);
		title.setFont(displayFont);
		title.setText("Todo Planner - New Planner!");
		
		JButton add = new JButton("+");
		JButton delete = new JButton("-");
		JButton properties = new JButton("Properties");
		JButton save = new JButton("Save Changes");

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		//buttonPanel.setLocation(0, 0);

		buttonPanel.add(add);
		buttonPanel.add(delete);
		buttonPanel.add(properties);
		buttonPanel.add(save);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(205,190,247));
		infoPanel.setLayout(new FlowLayout());


		add.addActionListener(new ActionListener() {
			/**
			 * Adds a new value to the JLIst and todo to the planner given the user specified type.
			 */
			public void actionPerformed(ActionEvent event)
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						String type = getTodoType();
						if(type.equals("Task"))
						{
							Task task = new Task("New Task", 0);
							array.addElement(task.getTitle());
							planner.addToList(task);
						}
						else if(type.equals("Deadline")){
							Deadline deadline = new Deadline(null, "New Deadline");
							array.addElement(deadline.getTitle());
							planner.addToList(deadline);
						}
						else if(type.equals("Meeting")){
							Meeting meeting = new Meeting("New Meeting", null, null);
							array.addElement(meeting.getTitle());
							planner.addToList(meeting);
						}
					}
				});
			}
		});


		properties.addActionListener(new ActionListener() {

			/**
			 * changes the title to one entered into a dialog box
			 */
			public void actionPerformed(ActionEvent event)
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						Font displayFont = new Font("Monospaced", Font.BOLD, 25);
						title.setFont(displayFont);
						title.setText("Todo Planner - "+ getNewTitle());
					}
				});
			}
		});


		delete.addActionListener(new ActionListener() {
			/**
			 * deletes the todo that is selected in the list box
			 */
			public void actionPerformed(ActionEvent event)
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						if(areYouSure()){
						Todo currTodo = planner.getTodo(todos.getSelectedIndex());
						
						currTodo = null;
						planner.deleteTodo(currTodo);
						array.removeElementAt(todos.getSelectedIndex());
						}
					}
				});
			}
		});
		
		save.addActionListener(new ActionListener() {
			/**
			 * takes the value from the input boxes and sets the value in the planner and JList accordingly
			 */
			public void actionPerformed(ActionEvent event)
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						Todo currTodo = planner.getTodo(todos.getSelectedIndex());
						
						
						if(currTodo.getClass().equals(Task.class)){
							((Task)currTodo).setTitle(todotitle.getText());
							if(priority.getText().equals("Urgent")){
								((Task)currTodo).setPriority(1);
							}
							else if(priority.getText().equals("Important")){
								((Task)currTodo).setPriority(2);
							}
							else
							{
								((Task)currTodo).setPriority(3);
							}
							array.setElementAt(todotitle.getText(), todos.getSelectedIndex());
						}
						else if (currTodo.getClass().equals(Deadline.class)){
							((Deadline)currTodo).setTitle(todotitle.getText());
							((Deadline)currTodo).setDueDate(date.getText());
							array.setElementAt(todotitle.getText(), todos.getSelectedIndex());
						}
						else{
							((Meeting)currTodo).setTitle(todotitle.getText());
							((Meeting)currTodo).setTime(time.getText());
							((Meeting) currTodo).setLocation(location.getText());
							array.setElementAt(todotitle.getText(), todos.getSelectedIndex());
						}
					}
				});
			}
		});
		
		todos.addListSelectionListener(new ListSelectionListener() {
			/**
			 * given the selected item in the list is displays the info and allows for input
			 */
			public void valueChanged(ListSelectionEvent e)
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						Todo currTodo = null;
						infoPanel.removeAll();
						infoPanel.updateUI();
						
						currTodo = planner.getTodo(todos.getSelectedIndex());
						if( currTodo != null){
						if(currTodo.getClass().equals(Task.class)){
							infoPanel.add(todotitlelabel);
							infoPanel.add(todotitle);
							todotitle.setText(((Task) currTodo).getTitle());
							infoPanel.add(prioritylabel);
							infoPanel.add(priority);
							priority.setText(((Task) currTodo).getPriority());
						}
						else if (currTodo.getClass().equals(Deadline.class)){
							infoPanel.add(todotitlelabel);
							infoPanel.add(todotitle);
							todotitle.setText(((Deadline) currTodo).getTitle());
							infoPanel.add(datelabel);
							infoPanel.add(date);
							date.setText(((Deadline) currTodo).getDueDate());
						}
						else{
							infoPanel.add(todotitlelabel);
							infoPanel.add(todotitle);
							todotitle.setText(((Meeting) currTodo).getTitle());
							infoPanel.add(timelabel);
							infoPanel.add(time);
							date.setText(((Meeting) currTodo).getTime());
							infoPanel.add(locationlabel);
							infoPanel.add(location);
							location.setText(((Meeting) currTodo).getLocation());
							
						}
						}
					}
				});
			}
		});

		//make the list box scroll in the panel
		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		JScrollPane listScroller = new JScrollPane(todos);
		listPanel.add(title, BorderLayout.NORTH);
		listPanel.add(listScroller, BorderLayout.SOUTH);

		//adding the panels
		container.add(buttonPanel, BorderLayout.SOUTH);
		container.add(listPanel, BorderLayout.NORTH);
		//container.add(title, BorderLayout.NORTH);
		container.add(infoPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Gets the type of the todo chosen by the user from a dialog box
	 * @return the string of the name of the type chose by the user
	 */
	public String getTodoType(){
		Object[] possibilities = {"Task", "Meeting", "Deadline"};
		String s = (String)JOptionPane.showInputDialog(
				null,
				"Choose your type of Todo",
				"Todo Type",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"Task"
				);

		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
			return s;
		}
		return "";
	}
	/**
	 * gets the new title the the user entered from a dialog box
	 * @return a string of the new title chosen by the user
	 */
	public String getNewTitle(){
		String title = (String)JOptionPane.showInputDialog(
				null,
				"Change the planner title:",
				"Properties",
				JOptionPane.QUESTION_MESSAGE
				);

		//If a string was returned, say so.
		if ((title != null) && (title.length() > 0)) {
			return title;
		}
		return "";
	}
	
	/**
	 * opens a dialog box to check to make sure the delete was
	 * intended by the user
	 * @return true is yes it clicked, and false otherwise
	 */
	public boolean areYouSure(){
		int n = JOptionPane.showConfirmDialog(
			    null,
			    "Are you sure you want to delete this?",
				"Confirm Delete",
			    JOptionPane.YES_NO_OPTION);

		//If a string was returned, say so.
		if ((n == JOptionPane.YES_OPTION)) {
			return true;
		}
		return false;
	}
	


}
