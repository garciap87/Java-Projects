package Assign4.Question3;
import java.util.Scanner;

public class GiraffeTest 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Giraffe giraffe = new Giraffe();
		
		System.out.print("Please enter the name of the giraffe: ");
		String name = scanner.nextLine();
		giraffe.setName(name);
		
		System.out.print("Please enter the age of the giraffe: ");
		int age = scanner.nextInt();
		giraffe.setAge(age);
		
		System.out.print("Please enter the height of the giraffe: ");
		double height = scanner.nextDouble();
		giraffe.setHeight(height);

		System.out.print("Please enter the number of steps the giraffe has taken: ");
		int steps = scanner.nextInt();
		
		System.out.println("\nThe giraffe's name is: " + giraffe.getName());
		System.out.println("The giraffe's age is: " + giraffe.getAge());
		System.out.println("The giraffe's height is: " + giraffe.getHeight());
		giraffe.walk(steps);
		
		scanner.close();
	}
}