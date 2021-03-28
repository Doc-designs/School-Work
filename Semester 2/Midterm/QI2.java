import java.util.Arrays;
/*
 * This program tests the interface Sequence using two classes MultiplesSequence and SquareSequence
 * An integer sequence is an ordered list of integers.
 */
public class QI2
{
	
	public static int[] values(Sequence seq, int n)
	{
		int[] result = new int[n];
		//-----------Start below here. To do: approximate lines of code = 2
		// generate n numbers in a sequence and store them in array result
		for (int i = 0; i < n; i++){
			result[i] = seq.next();
		}
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    return result;
	}
	
	
	public static void main(String[] args)
	{
		Sequence sequence = new SquareSequence();
    System.out.println(Arrays.toString(values(sequence,10)));
    System.out.println("Expected:\n[1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
    
    sequence = new MultiplesSequence(3);
    System.out.println(Arrays.toString(values(sequence,10)));
    System.out.println("Expected:\n[3, 6, 9, 12, 15, 18, 21, 24, 27, 30]");
	}
}
