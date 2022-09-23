/**
   A class to test the UniversityStudent class.
*/
public class QO1
{
   /**
      Tests the methods of the Student class.
      @param args not used
   */
   public static void main(String[] args)
   {
      UniversityStudent student = new UniversityStudent("Jane Doe");
      student.addCourse(new Course("CPS209","Computer Science II", 91));
      student.addCourse(new Course("CPS109","Computer Science I", 87));
      student.addCourse(new Course("CPS511","Computer Graphics", 74));
      student.addCourse(new Course("CPS643","Virtual Reality", 98));
      
      System.out.println("Average mark for " + student.getName() 
			 + " = " + student.getAverageScore());
      
      System.out.println("Expected:\nAverage mark for Jane Doe = 87.5");      
      
      student.printTranscript();
      System.out.println("Expected:\nName: Jane Doe Courses:\nCPS209 Computer Science II 91\nCPS109 Computer Science I 87");
      System.out.println("CPS511 Computer Graphics 74\nCPS643 Virtual Reality 98");
   }
}

