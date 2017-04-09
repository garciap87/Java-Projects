/**Some courses assign letter grades, whereas other courses assign a percentage
between 0 and 100. Still others assign a pass/fail grade.
Write an interface named Grade. The toPercent method returns the grade as
an integer percentage between 0 and 100 percent. The toString method
prints the grade in its “native” format (a percentage, a letter grade, or either
“Pass” or “Fail”). The isPass method returns true for a passing grade,
false otherwise. The includeInAverage returns true for letter and
numeric grades, but false for pass/fail grades.
Write three classes that implement Grade: LetterGrade, PercentageGrade,
and PassFailGrade. Write a main method that fills an array with grades. For
each grade, print on one line the native format, “Pass” or “Fail” (as appropriate),
and the percentage (if it can be included in an average). After the list of
grades, print the average grade as a percentage.
Use your school’s mapping between letter grades and numeric grades, if it has
one. Otherwise, make up something like A+ is 95%, A is 90%, etc.
*/

package Assign9;

public class Main
{
	static int grade = 0;
	
	public static void main(String[] args) 
	{
		Grade[] grades = new Grade[3];
		
		grades[0] = new LetterGrade("a");
		grades[1] = new PercentageGrade("80");
		grades[2] = new PassFailGrade("fail");
		
		for (int i = 0; i < grades.length; i++)
		{
			System.out.println("The native format of the grade is " + grades[i].nativeFormat() + " and the percentage is " + grades[i].toPercent());
			
			if(grades[i].includeInAverage())
			{
				grade += grades[i].toPercent();
			}
		}
		
		System.out.println("The average grade is " + (grade/3));

	}
}