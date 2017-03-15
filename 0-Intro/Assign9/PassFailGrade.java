package Assign9;

public class PassFailGrade implements Grade 
{
	private String grade;
	
	PassFailGrade(String grade)
	{
		this.grade = grade;
	}

	public int toPercent() 
	{
		int percent = 0;
		
		return percent;
	}

	public boolean isPass() 
	{
		if(grade.equalsIgnoreCase("pass"))
		{
			return true;
		}
		return false;
	}

	public boolean includeInAverage() 
	{
		return false;
	}
	
	public String nativeFormat() 
	{
		return grade;
	}
}