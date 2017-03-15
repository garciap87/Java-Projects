/**Write a program which counts from your birthday the years until today. 
 * For example if you are born in 2015 it would output:
2015
2016
*/

package Assign6.Question3;
import java.util.Scanner;

public class BirthdayCounter
{
	public static void main(String[] args) 
	{	
		System.out.println("Please enter the year you were born");
		Scanner scanner = new Scanner(System.in);
		
		int birthdayYear = scanner.nextInt();
		int yearCount = 0;
	
		while(birthdayYear > 2016)
		{	
			System.out.println("You have entered a birth year greater than the current year. " 
								+ "Please try again, enter the year you were born");
			birthdayYear = scanner.nextInt();
		}

		System.out.println("\nEvery year that has passed since you were born is below: ");
		
		for(int i = birthdayYear; i <= 2016; i++)
		{
			System.out.println(i);
			yearCount++;
		}
		
		System.out.println("You have been alive for " + (yearCount - 1) + " years!!");

		scanner.close();
	}
}