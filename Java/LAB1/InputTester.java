import java.util.* ;
/**
   Complete the code as indicated. Google the Java Scanner class to see the available methods
 */
public class InputTester
{
    public static void main(String[] args)
    {
	    Scanner scanner = new Scanner("5 3.1415 Hello World 19 more words") ;
	    //-----------Start below here. To do: approximate lines of code = 4
	    //  1. read an integer from the scanner into variable i
	    int i = scanner.nextInt();
	    //2. read a double into variable x 
	    double x = scanner.nextDouble();
	    //3. read a word into variable word
	    String word = scanner.next();
	    //4. read the rest of the words into variable line
		String line = scanner.nextLine();
		scanner.close();
	    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	    System.out.println("Integer read: " + i + "   Expected: 5") ;
	    System.out.println("Double read: " + x + "   Expected: 3.1415") ;
	    System.out.println("Word read: " + word + "   Expected: Hello") ;
	    System.out.println("Line read: " + line + "   Expected: World 19 more words") ;
	    System.out.println("Checking types: i/2 + x/x = " + (i/i + x/x)) ;
    }
}
