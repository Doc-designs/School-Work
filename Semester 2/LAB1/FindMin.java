import java.util.Scanner;
/*
 * This program finds the minimum number from a list of double numbers and prints it
 * 
 * For example, if the list is: 22.3 47 3.14 77.8 then the minimum is 3.14
 */
public class FindMin
{
   public static void main(String[] args)
   {
  	   String values = "32.5 217.3 12.98 63.44 77.4 185.2";
      Scanner in = new Scanner(values);
      
      
      //-----------Start below here. To do: approximate lines of code = 1
      // 1. Create a boolean variable called first and set it to true
      boolean first = true;
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      
      //-----------Start below here. To do: approximate lines of code = 1
      // 2. Create a double variable called min and initialize it to 0.0
         double currentValue;
         double min = 0.0; 
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      
      // 3. Write a while loop that reads values from scanner in (see above). 
    	// Assume you do not know how many values there will be, so use the hasNextDouble() method  in the loop condition
    	// Inside the loop, read the next double number (NOTE: never call in.nextDouble() more than once inside the loop so use a temporary variable)
      // If this number is the very first number read (Hint: use the boolean variable "first" above) update the min number and set first to false
      // else if this number is less than min then update min
      //-----------Start below here. To do: approximate lines of code = 7
      //
      while(in.hasNextDouble()){
         currentValue = in.nextDouble();
         if(currentValue < min){
            min = currentValue;
         } 
         else if(first == true){
            min = currentValue;
            first = false;
         } 
      } 
      in.close();
      
      
      
      
      
      
      
      
      
      
      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println("The minimum value was: " + min);
      System.out.print("Expected: ") ;
      System.out.println("The minimum value was: 12.98") ;
   }
}
