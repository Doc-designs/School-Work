/*
 * This program determines whether an array of integer elements is in incrrasing order
 * For example: 1, 2, 3, 4, 5, 6, 7, 8, 9, 42 is in increasing order
 * but array: 2, 1, 3, 4, 5, 6, 7, 8, 9, 42 is not
 */

public class InOrder
{
	
/*
 * Takes an input array of integer elements as parameter and determines if the
 * elements are in increasing order. If so, return true else return false
 */
public static boolean inOrder(int[] arr)
{
   //-----------Start below here. To do: approximate lines of code = 5
   // Loop through the given array arr checking for out of order elements
   for(int i = 0; i < arr.length; i++){
      if(i != 0 && arr[i] <= arr[i-1]){
         return false;
      }
   }
   return true;
   
   
   
   
   
   
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}

public static void main(String[] args)
{
   int[] arrOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 42};
   int[] arrNotOrder = {2, 1, 3, 4, 5, 6, 7, 8, 9, 42};

   // Check if array 1 is ordered or not.
   if (inOrder(arrOrder))
   {
      System.out.println("The array is in order.");
   }
   else
   {
      System.out.println("The array is NOT in order.");
   }
   System.out.println("Expected:\nThe array is in order.");


   // Check if array 2 is ordered or not.
   if (inOrder(arrNotOrder))
   {
      System.out.println("The array is in order.");
   }
   else
   {
      System.out.println("The array is NOT in order.");
   }
   System.out.println("Expected:\nThe array is NOT in order.");
}
}