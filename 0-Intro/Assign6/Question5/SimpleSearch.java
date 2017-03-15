/**
 * Implement the simple search and search for the first
 * letter a in the text “This class is awesome”. 
 * Utilize charAt() to obtain a character to test.
 */

package Assign6.Question5;

public class SimpleSearch 
{
	public static void main(String[] args)
	{
		String sentence = "This class is awesome";
		int stringSize = sentence.length();
		char letter = 'a';
		
		for(int i = 0; i < stringSize; i++)
		{
			char position = sentence.charAt(i);
			if(letter == position)
			{
				System.out.println("The sentence is " + stringSize + " characters long.");
				System.out.println("You have found the character '" + letter + "' at position " + i);
				return;
			}
		}
		System.out.println("The character '" + letter + "' was never found in the sentence.");
	}
}