package Assign3.Question5;
import java.util.Scanner;

public class DressShoe extends Shoe
{
	int size = 0;
	
	public DressShoe(String color) 
	{
		super(color);
	}

	public static void main(String[] args) 
	{
		DressShoe dressShoe = new DressShoe("Black");
		
		System.out.print("Enter your dress shoe size: ");
		
		Scanner scanner = new Scanner(System.in);
		dressShoe.size = scanner.nextInt();
	
		System.out.println("The size of your dress shoe is: " + dressShoe.size);
		System.out.println("The color of your dress shoe is: " + dressShoe.color);
		
		scanner.close();
	}
}