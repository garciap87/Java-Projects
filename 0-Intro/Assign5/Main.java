package Assign5;
import java.util.Scanner; 

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your favorite programming language?");
		String language = scanner.nextLine();
		
		if(language.equalsIgnoreCase("java"))
		{
			System.out.println("Java is in high demand");
		}
		else if(language.equalsIgnoreCase("ruby"))
		{
			System.out.println("Ruby can create lots of things");
		}
		else if(language.equalsIgnoreCase("python"))
		{
			System.out.println("Python is great for scripting");
		}
		else if(language.equalsIgnoreCase("javascript"))
		{
			System.out.println("JavaScript can create awesome web pages");
		}
		else if(language.equalsIgnoreCase("c++"))
		{
			System.out.println("C++ was created in 1979");
		}
		else if(language.equalsIgnoreCase("c#"))
		{
			System.out.println("C# was created by Microsoft");
		}
		else
		{
			System.out.println("You did not enter one of the 6 best programming languages");
		}
		scanner.close();
	}
}
