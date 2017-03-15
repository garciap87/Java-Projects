/**Write an application that inputs free integers from the user and displays the sum, average, product, 
smallest, and largest of the numbers. To determine the largest and smallest number use Math.min(x, y)
and Math.max(x,y) 
*/

package Assign2;
import java.util.Scanner;

public class Number5 
{
	public static void main(String[] args) 
	{
		System.out.println("Please enter three integers, press enter after each number:");
		
		Scanner scanner = new Scanner(System.in);
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		int number3 = scanner.nextInt();
		
		int sum = number1 + number2 + number3;
		int prod = number1 * number2 * number3;
		
		System.out.println("The sum of the integers you entered is: " + sum);
		
		System.out.println("The average of the integers you entered is: " + (sum/3));
		
		System.out.println("The product of the integers you entered is: " + prod);
		
		System.out.println("The largest number is: " + Math.max(Math.max(number1, number2), number3));
		
		System.out.println("The smallest number is: " + Math.min(Math.min(number1, number2), number3));
		
		scanner.close();
	}
}