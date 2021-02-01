import java.util.Scanner;

// Calculates the sum of odd digits of the input integer number
// Example: number = 12345   Sum = 9 (1+3+5)
//          number = 248     Sum = 0
//          number = 65732098 Sum = 24 (5+7+3+9)


public class SumOfOddDigits 
{
   public static void main(String[] args) 
   {
     String digits = "48596732 273457 13579 24680 3";    
  	 Scanner in = new Scanner(digits);

     while (in.hasNextInt())
     {
       int num;
       num = in.nextInt();

       int sum = 0;
       int digit;

       //-----------Start below here. To do: approximate lines of code = 5
       // Use a while loop. While num is greater than 0, use the modulus operator to strip off the next digit.
       // Check if this digit is odd, if so add it to sum variable
       // Finally, divide the num by 10 to throw away the current digit
       
       
       
          // Only add digit if it is odd
      while(num > 0){
          digit = num % 10;
          if (digit % 2 != 0){
            sum += digit;
          }
          num /= 10;
      }
       
       
       
       
       
       //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
       System.out.println("The sum is " + sum);
     }
     System.out.println("Expected:");
     System.out.println("The sum is 24");
     System.out.println("The sum is 22");
     System.out.println("The sum is 25");
     System.out.println("The sum is 0");
     System.out.println("The sum is 3");
   }
}
