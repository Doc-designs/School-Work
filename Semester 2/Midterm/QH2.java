/*
 * A program to test two subclasses of superclass Document: Letter and ToDoList
 */
public class QH2
{
	public static void main(String[] args)
  {
		Letter letter = new Letter("1934623", "T. McInerney", "2 Forest Hill Road", "Google Boss");
		letter.setHeader("Google Technology Company");
		
		System.out.println("Testing Letter\n");
		Document doc = letter;
		doc.setBody("We regret to inform you that you are too old to work here.");
		doc.print();
		System.out.println("Expected:\nGoogle Technology Company\n\n2 Forest Hill Road\n\nDear T. McInerney\n");
		System.out.println("We regret to inform you that you are too old to work here.\n\nSincerely,\nGoogle Boss");
		
		ToDoList list = new ToDoList("743432");
		list.addTask("Do laundry");
		list.addTask("Pick up dry cleaning");
		list.addTask("Vet appt. 3pm for Rover");
		list.addTask("Phone mom");
    list.delTask("Do laundry");
    
		doc = list;
		System.out.println("\n\nTesting To Do List\n");
		doc.print();
		System.out.println("Expected:\nTo Do:\n\n1. Pick up dry cleaning\n2. Vet appt. 3pm for Rover\n3. Phone mom\n");
  }
}
