import java.util.Arrays;
/*
 * 
 * This program takes an array of integers, reverses the elements and stores them in a new array
 * 
 */
public class ReverseElements
{
   /**
      Reverses an array.
      @param data - the input array
      @return an array with the elements of data in reverse order
   */
   public static int[] reverse(int[] data)
   {
  	  //-----------Start below here. To do: approximate lines of code = 6
  	  //
       int[] newData = new int[data.length];
  	  for(int i = 0; i < data.length; i++){
         newData[i] = data[data.length - (i+1)]; 
          
       }
  	  return newData;
  	  
  	  
  	  
  	  
  	  
  	  
  	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }
   
   
   public static void main(String[] args)
   {
      int[] data = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
      int[] reversed = reverse(data);
      for (int i = 0; i < reversed.length; i++) 
      {
         System.out.print(reversed[i] + " ");
      }
      System.out.println();
      System.out.println("Expected:\n11 9 4 7 9 16 9 4 1");
   }
}
