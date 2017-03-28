import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * This is the class that contains the main to create a new 
 * ToDoPlannerGUI frame that will make  an appealing user interface
 * for our todolist.
 * 
 * @author jasminejans
 * @version HW 5: Todo Planner with added GUI,  other classes from HW4
 * @date 03/30/2016
 *
 */

public class GUIStarter {

	// TODO Auto-generated constructor stub
	/**
	 * Main method that creates the TodoPlannerFrame
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame f = new ToDoPlannerGUI();
				f.setTitle("Todo List");
				f.setSize(600,400);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
		// TODO Auto-generated constructor stub
	}
}

