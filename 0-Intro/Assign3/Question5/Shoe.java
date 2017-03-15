/**
Consider the Shoe example.
A.) Add two new classes DressShoe and WorkingBoot. Write a  main method in each which asks the size from the user.
B.)Add a new attribute/instance variable color of type String to Shoe. Change the constructors so you can initialize each show with its color.
*/

package Assign3.Question5;
import java.util.Scanner;

public class Shoe 
{
	int size = 0;
	String color;
	
	public Shoe(String color) 
	{
		super();
		this.color = color;
	}

	void showSize() 
	{
		System.out.println("Size: " + this.size);
	}
	
	static public void main(String args[]) 
	{
		Shoe shoe = new Shoe("Gray");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter shoe size:");
		shoe.size = scanner.nextInt();
		shoe.showSize();
		
		scanner.close();
	}
}