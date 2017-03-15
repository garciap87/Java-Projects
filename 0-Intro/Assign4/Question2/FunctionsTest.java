package Assign4.Question2;
import java.util.Scanner;

public class FunctionsTest 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Functions functions = new Functions();
		
		System.out.print("Please enter a number you want to test your functions with: ");
		double x = scanner.nextDouble();
		
		System.out.println("The answer to your functions are: " + functions.twoX(x) + ", " + functions.xSquared(x) + ", " + functions.xCubed(x));
		
		scanner.close();
	}
}