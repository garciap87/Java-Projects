package Assign9;

public class LetterGrade implements Grade 
{
	private String grade;
	
	LetterGrade(String grade)
	{
		this.grade = grade;
	}
	

	public int toPercent() 
	{
		int percent = 0;
		
		if(grade == "a")
		{
			percent = 90; 
		}
		if(grade == "b")
		{
			percent = 80; 
		}
		if(grade == "c")
		{
			percent = 70; 
		}
		if(grade == "d")
		{
			percent = 60; 
		}
		if(grade == "f")
		{
			percent = 0; 
		}
	
		return percent;
	}

	public boolean isPass() 
	{
		boolean pass = false;
		
		if(grade == "a")
		{
			pass = true; 
		}
		if(grade == "b")
		{
			pass = true;
		}
		if(grade == "c")
		{
			pass = true; 
		}
		if(grade == "d")
		{
			pass = true; 
		}
		if(grade == "f")
		{
			pass = false;
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