public class Course
{
   private int grade;
   private String code;
   private String name;
   
   public Course(String code, String name, int grade)
   {
  	 this.code = code;
  	 this.name = name;
  	 this.grade = grade;
   }
  	
	public int getGrade()
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return code + " " + name + " " + grade;
	}
}