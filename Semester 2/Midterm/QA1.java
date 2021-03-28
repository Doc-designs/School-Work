import java.util.ArrayList;

/*
 * Given an array list of words (strings), count the number of words that occur only once
 * For example, in the list: "we" "have" "a" "meeting" "at" "four" "and" "we" "have" "another" "meeting" "at" "five"
 * the words occurring once are: "a" "four" "and" "another" "five" for a total of 5 
 */
public class QA1
{
	/**
			counts the number of words (strings) in a list that occur only once
			@param list ArrayList of strings to be examined
			@return number of strings occurring once in the list
	 */
	public static int countSingleOccurrence(ArrayList<String> list)
	{
		//-----------Start below here. To do: approximate lines of code = 9
		// Hint: create boolean flag variable singleOccurrence and set it to true;
		// Use a nested loop, loop through each word in the list in the outer, check this word against
		// all words in the inner loop. If you find a duplicate word in the inner loop, set singleOccurrence to false 
		int total = 0;
		boolean singleOccurrence = true;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(list.get(i).equals(list.get(j)) && j != i){
					singleOccurrence = false;
					break;
				}
			}
			if(singleOccurrence){
				total++;
				singleOccurrence = true;
			}
			else{
				singleOccurrence = true;
			}
		}
		return total;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String[] args)
	{
		ArrayList <String> words = new ArrayList<>();
		words.add("blow");
		words.add("wind");
		words.add("blow");
		words.add("and");
		words.add("go");
		words.add("mill");
		words.add("go");

		int unique = countSingleOccurrence(words);
		System.out.println(words + " has " + unique + " words that occur only once");
		System.out.println("Expected:\n[blow, wind, blow, and, go, mill, go] has 3 words that occur only once");
		
		words.clear();
		words.add("we");
		words.add("have");
		words.add("a");
		words.add("meeting");
		words.add("at");
		words.add("four");
		words.add("and");
		words.add("we");
		words.add("have");
		words.add("another");
		words.add("meeting");
		words.add("at");
		words.add("five");
		unique = countSingleOccurrence(words);
		System.out.println(words + " has " + unique + " words that occur only once");
		System.out.println("Expected:\n[we, have, a, meeting, at, four, and, we, have, another, meeting, at, five] has 5 words that occur only once");
	}
}


