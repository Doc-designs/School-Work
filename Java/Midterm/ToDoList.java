import java.util.ArrayList;
/*
 * A To Do List is a Document. It contains a list of tasks to be performed
 */
//-----------Start below here. To do: approximate lines of code = 1
// Make class ToDoList a subclass of Document
class ToDoList extends Document
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
	private ArrayList<String> tasks;
	
	public ToDoList(String name)
	{
		super(name);
		tasks = new ArrayList<String>();
	}
	
	// Overrides the print() method in class Document
	public void print()
	{
		String taskList = "";
		
		//-----------Start below here. To do: approximate lines of code = 5
		// Set the document header to "To Do: "
		// Then append each task in the array list of tasks to the taskList string variable above. 
		// Append each task to taskList by adding the task number (indexed from 1) followed by a ". " followed by
		// the task description itself followed by a "\n". Set the document body variable to the string taskList; Then
		// print the to do list by using the print() method in the superclass Document
		setHeader("To Do: ");
		for( int i=0; i < tasks.size(); i++){
			taskList += Integer.toString(i+1) + ". " + tasks.get(i) + "\n";
		}
		setBody(taskList);
		super.print();
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	//-----------Start below here. To do: approximate lines of code = 2
	// Create a method void addTask(String taskDescription) that adds the task to the array list of tasks
	public void addTask(String taskDescription){
		tasks.add(taskDescription);
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
  //-----------Start below here. To do: approximate lines of code = 2
  // Create a method void delTask(String taskDescription) that removes the task from the array list of tasks
  public void delTask(String taskDescription){
	tasks.remove(taskDescription);
  }
  
  
  
  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
