package Assign3.Question5;
import java.util.Scanner;

public class WorkingBoot extends Shoe 
{
	int size = 0;
	
	public WorkingBoot(String color) 
	{
		super(color);
	}

	public static void main(String[] args) 
	{
		WorkingBoot workingboot = new WorkingBoot("Brown");
		
		System.out.print("Enter your working boot size: ");
		
		Scanner scanner = new Scanner(System.in);
		workingboot.size = scanner.nextInt();
	
		System.out.println("The size of your working boot is: " + workingboot.size);
		System.out.println("The color of your working boot is: " + workingboot.color);
		
		scanner.close();
	}
}