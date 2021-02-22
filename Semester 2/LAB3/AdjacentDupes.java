/*
 * 
 * This program checks an array of integers to see if there is duplicate integers adjacent to 
 * one another in the array
 * For example, if the array contains:
 * 1, 2, 3, 4, 4, 6, 7, 8, 9, 42
 * 
 * then the number 4 occurs at index 3 and index 4 in the array therefore adjacent duplicate is true
 * 
 * If the array contains:
 * 2, 1, 3, 4, 5, 4, 7, 4, 9, 4
 * 
 * then even though the number 4 occurs multiple times, no occurrence of 4 is adjacent to another occurrence
 */
public class AdjacentDupes
{
	
	/*
	 * 
   */
	public static boolean adjacentDupes(int[] arr)
	{
		//-----------Start below here. To do: approximate lines of code = 5
		// Loop through the array arr, checking for duplicates
		// adjacent to each other. if duplicates occur, return true, else return false
		//Hint: in the for loop, make sure you use a loop condition something like
		// i < arr.length - 1 rather than i < arr.length  Why??
		//Hint 2: as soon as you find a duplicate you can immediately return true
		
		
		// Loop through array, checking for duplicates 
		// next to each other.
		for (int i = 0; i < arr.length-1; i++){
         if (arr[i] == arr[i + 1]){
            return true;
         }
      }
      return false;
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String[] args)
	{
   int[] arr1 = {1, 2, 3, 4, 4, 6, 7, 8, 9, 42};
   int[] arr2 = {2, 1, 3, 4, 5, 4, 7, 4, 9, 4};

   // Check if array 1 has adjacent dupes.
   if (adjacentDupes(arr1))
   {
      System.out.println("Array contains adjacent duplicates.");
   }
   else
   {
      System.out.println("Array does NOT contain adjacent duplicates."); 
   }
   System.out.println("Expected:\nArray contains adjacent duplicates.");

   // Check if array 2 has adjacent dupes.
   if (adjacentDupes(arr2))
   {
      System.out.println("Array contains adjacent duplicates.");
   }
   else
   {
      System.out.println("Array does NOT contain adjacent duplicates." );
   }
   System.out.println("Expected:\nArray does NOT contain adjacent duplicates.");
	}
}
