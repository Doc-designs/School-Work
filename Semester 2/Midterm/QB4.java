import java.util.Scanner;
/*
 * Method validate() takes a password string and determines if it is a valid password
 * Valid passwords are at least 8 characters in length and contain at least: one upper case letter,
 * one lower case character, one digit and one of 3 special characters from the set '!' '$' '#' 
 */
public class QB4
{
	 /*
	  * Validate a password string. Returns true if the string is at least 8 characters in length and
	  * contains at least: one upper case character, one lower case character, one digit and contains one special 
	  * character from the set of 3 special characters '!' '$' '#' 
	  * returns false otherwise
	  * 
	  */
   public static boolean validate(String password)
   {
  	 	//-----------Start below here. To do: approximate lines of code = 17
  	 	// Fill in the method. Hint: make use of String method charAt(), class Character static methods:
  	  // isLowerCase(), isUpperCase(), isDigit()
		boolean containsLower = false;
		boolean containsUpper = false;
		boolean containsDigit = false;
		boolean containsSpecial = false;
  	 	if(password.length() >= 7){
			for(int i = 0; i < password.length(); i++){
				if(Character.isLowerCase(password.charAt(i))){
					containsLower = true;
				}
				else if(Character.isUpperCase(password.charAt(i))){
					containsUpper = true;
				}
				else if(Character.isDigit(password.charAt(i))){
					containsDigit = true;
				}
				else{
					containsSpecial = true;
				}
			}
		}
		if(containsLower && containsUpper && containsDigit && containsSpecial){
			return true;
		}
		else{
			return false;
		}
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	
  	 	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   public static void main(String[] args)
   {
     String password = "aBc123xyz!";
     
  	 Scanner in = new Scanner(password);
  	 if (validate(in.next()))
  		 System.out.println("ok");
  	 else
  		 System.out.println("Invalid Password");
  	 System.out.println("Expected:\nok");
  	 
  	 password = "aBcxyz";
  	 in = new Scanner(password);
  	 if (validate(in.next()))
  		 System.out.println("ok");
  	 else
  		 System.out.println("Invalid Password");
  	 System.out.println("Expected:\nInvalid Password");
  	 
  	 password = "hello$";
  	 in = new Scanner(password);
  	 if (validate(in.next()))
  		 System.out.println("ok");
  	 else
  		 System.out.println("Invalid Password");
  	 System.out.println("Expected:\nInvalid Password");
  	 
  	 password = "Hello123#";
  	 in = new Scanner(password);
  	 if (validate(in.next()))
  		 System.out.println("ok");
  	 else
  		 System.out.println("Invalid Password");
  	 System.out.println("Expected:\nok");
      
   }
}
