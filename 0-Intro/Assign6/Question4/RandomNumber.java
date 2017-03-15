/**
Write a simple guessing game:
Generate a random number between 1 and 10 by using java.util.Random:
Random r = new Random()
int i = r.nextInt(10)+1
Ask the user for his guess
Use a while loop to loop until the user has guessed the correct number
 */

package Assign6.Question4;
import java.util.Scanner;
import java.util.Random;

public class RandomNumber 
{
	public static void main(String[] args) 
	{
		Random randomNumber = new Random();
		int random = randomNumber.nextInt(10) + 1;
		
		System.out.println("A random number between 1 and 10 has been generated,"
							+ " try and guess the number!");
		Scanner scanner = new Scanner(System.in);
		int guess = scanner.nextInt();
		
		while(guess != random)
		{
			System.out.println("Sorry your guess was wrong. Please try again.");
			guess = scanner.nextInt();
		}
		
		System.out.println("The number was " + random + ". You have guessed correctly!!");
		scanner.close();
	}
}