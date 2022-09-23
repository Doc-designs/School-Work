import java.util.Scanner;

// Use a scanner and read each word from a string containing multiple words. Print each word in reverse order

public class ReverseWord
{
   public static void main(String[] args)
   {
     String words = "A quick brown fox jumps over the lazy alligator"; 
  	 Scanner in = new Scanner(words);
      
     while (in.hasNext())
     {
    	 String word = in.next();
    	 
    	 
    	 //-----------Start below here. To do: approximate lines of code = 2
    	 // You must use a for loop and the charAt() method of class String to print the characters of the word in reverse order
    	 // Hint: count down rather than up
    	for(int i = word.length()-1; i >= 0; i--){
        System.out.print(word.charAt(i));
      }
    	 
    	 
    	 
    	 //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
       System.out.println("\n");
     }
     in.close();
     System.out.println("Expected: \nA\n\nkciuq\n\nnworb\n\nxof\n\nspmuj\n\nrevo\n\neht\n\nyzal\n\nrotagilla");
   }
}
