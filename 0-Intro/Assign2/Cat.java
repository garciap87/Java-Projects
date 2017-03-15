/**Create a new Java project in eclipse
Create a new Java file
Implement a class Cat – the cat has a name.
Write a program where the user can enter the name and assign the name to a cat.
Print the name of the cat*/

package Assign2;
import java.util.Scanner;

public class Cat 
{
	String catName = "";
	
	public static void main(String[] args) 
	{
		System.out.println("Please enter the name of your cat below:");
		
		Cat cat = new Cat();
	
		Scanner scanner= new Scanner(System.in);
		cat.catName = scanner.nextLine();
		
		System.out.println("The name of your cat is:");
		System.out.println(cat.catName);
		
		scanner.close();
	}
}