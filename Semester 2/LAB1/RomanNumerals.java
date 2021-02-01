/**
   Converts Roman numerals to decimal value. For example, if the Roman numeral is X then the valueOf method returns 10
   The valueOf method assumes the parameter is one of either: I X L C D M
*/
import java.util.Scanner;

public class RomanNumerals
{
	public static void main(String[] args)
	{
	   Scanner in = new Scanner("I C X D M L");

	   char romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 100") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 10") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 500") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1000") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 50") ;

	   in.close();
	}
	
   /**
      Returns the integer value of the given Roman numeral (one of I X L C D M)
      @param numeral a single Roman numeral (char)
      @return the integer value of numeral
   */
   //-----------Start below here. To do: approximate lines of code = 14
   // write a static method valueOf with the appropriate parameters and return type. 	
   static int valueOf(char numeral){
	   int ret = 0;
	   switch(numeral){
			case 'I':
				ret = 1;
				break;
			case 'C':
				ret = 100;
				break;
			case 'X':
				ret = 10;
				break;
			case 'D':
				ret = 500;
				break;
			case 'M':
				ret = 1000;
				break;
			case 'L':
				ret = 50;
				break;
	   }
	   return ret;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
      // must be an M
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
