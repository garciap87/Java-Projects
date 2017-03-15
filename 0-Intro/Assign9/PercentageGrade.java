package Assign9;

public class PercentageGrade implements Grade 
{
	private String grade;
	
	PercentageGrade(String grade)
	{
		this.grade = grade;
	}

	public int toPercent() 
	{
		return Integer.parseInt(grade);
	}

	public boolean isPass() 
	{
		boolean pass;
		
		if(grade == "f")
		{
			pass = false; 
		}
		else
		{
			pass = true;
		}
		
		return pass;
	}

	public boolean includeInAverage() 
	{
		return true;
	}
	
	public String nativeFormat() 
	{
		return grade;
	}
}