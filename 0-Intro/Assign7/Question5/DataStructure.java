/**
Write a program to store a positive number a user inputs until he enters 0. 
Print all the numbers entered at the end. The dialog might look like:
Enter Number: 1
Enter Number: 10
Enter Number: 0
You entered numbers 1, 10
Select an appropriate data structure for this program.
 */

package Assign7.Question5;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStructure 
{
	public static void main(String[] args) 
	{
		System.out.println("Please enter any positive number you would like to store.\n"
							+ "Enter the number 0 when you want to quit.");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		System.out.print("\nEnter your number: ");
		int number = scanner.nextInt();
		
		if(number == 0)
		{
			System.out.println("You have entered 0, the program will now quit!");
			scanner.close();
			return;
		}
		
		while(number != 0)
		{
			list.add(number);
			System.out.print("Enter your next number: ");
			number = scanner.nextInt();
		}
		
		System.out.println("\nYou have entered 0, the program will display your stored numbers!");
		System.out.print("You entered numbers: ");
		for(int index = 0; index < list.size(); index++)
		{
			System.out.print(list.get(index) + ", ");
		}
	
		scanner.close();	
	}
}