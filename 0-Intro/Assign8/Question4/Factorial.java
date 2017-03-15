/**Implement the Factorial as a recursive Java 
 * function. For example factorial(2) should return 2.
 */

package Assign8.Question4;
import java.util.Scanner;

public class Factorial 
{
	public static void main(String[] args) 
	{
		System.out.print("Please enter the number you want to take the factorial of: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("The factorial of " + number + " is " + fact(number));
		scanner.close();
	}
	
	static int fact(int n)
	{
		if(n==1)
		{
			return 1;
		}
		
		return n* (fact(n-1));
	}
}