/**
 * Simple search: Search for the number 7 in an array of 10 
 * random numbers. You will need to declare an array, use a loop 
 * to assign a random number and then use another loop to search 
 * for the number 7 in the array by investigating each array element.
 */

package Assign7.Question6;
import java.util.Random;

public class ArraySearch 
{
	public static void main(String[] args) 
	{
		int search = 7;
		int[] numbers = new int[11];
		Random randomNumber = new Random();
		
		for(int i = 0; i < 11; i++)
		{
			int random = randomNumber.nextInt(11);
			numbers[i] = random;
		}
		
		for(int i = 0; i < 11; i++)
		{
			if(search == numbers[i])
			{
				System.out.println("You have found the number '" + search + "' at position " + i);
				return;
			}
		}
		System.out.println("The number '" + search + "' was never found in the array.");
	}
}