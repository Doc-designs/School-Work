import java.util.ArrayList;
/*
 * 
 * This program rearranges an array list of words (i.e. alphabetic strings) so that 
 * any word beginning with an uppercase letter is shifted up in the arraylist  such that 
 * they are in front of any word beginning with a lowercase letter. The order of the uppercase words 
 * and lowercase words should not change
 * 
 * Example:  "Every" "dog" "named" "Rover" "in" "the" "city" "of" "Toronto" "always" "seems" "to" "be" "friendly"
 * 
 * would rearranged to:
 * 
 *           "Every" "Rover" "Toronto" "dog" "named" "in" "the" "city" "always" "seems" "to" "be" "friendly"  
 * 
 * 
 */
public class ShiftStrings
{
   /**
		Shifts all strings starting with an uppercase letter to the
		beginning, without otherwise changing the order of the elements
		@param list ArrayList of strings to be shifted
   */
   public static void shiftUppercase(ArrayList<String> list)
   {
  	 //-----------Start below here. To do: approximate lines of code = 9
  	 // Hints: You will need a variable to keep track of the index of the last uppercase word shifted to the front,
  	 // You will need to use the method Character.isUpperCase() and the String method charAt(),
  	 // You will need to use the ArrayList methods size(), get(), remove(), and the add() method that takes two parameters
    int indexUpp = 0;
  	 for (int i = 0; i < list.size(); i++){
         if(Character.isUpperCase(((list.get(i)).charAt(0)))){
            list.add(indexUpp, list.get(i));
            list.remove(i+1);
            indexUpp++;
         }
      }
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   public static void main(String[] args)
   {
  	 ArrayList <String> words = new ArrayList<>();
     words.add("So");
     words.add("much");
     words.add("has");
     words.add("been");
     words.add("written");
     words.add("about");
     words.add("The");
     words.add("Beatles");
   
     System.out.println("Before shifting words:\n" + words);
     shiftUppercase(words);
     System.out.println("After shifting words:\n" + words);
     System.out.println("Expected:\n[So, The, Beatles, much, has, been, written, about]");
     
     words.clear();
     words.add("Every");
     words.add("dog");
     words.add("named");
     words.add("Rover");
     words.add("in");
     words.add("the");
     words.add("city");
     words.add("of");
     words.add("Toronto");
     words.add("always");
     words.add("seems");
     words.add("to");
     words.add("be");
     words.add("friendly");
   
     System.out.println("Before shifting words:\n" + words);
     shiftUppercase(words);
     System.out.println("After shifting words:\n" + words);
     System.out.println("Expected:\n[Every, Rover, Toronto, dog, named, in, the, city, of, always, seems, to, be, friendly]");
   }
}
