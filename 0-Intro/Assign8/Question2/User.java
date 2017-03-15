package Assign8.Question2;
import java.util.Scanner;

public class User 
{
	private String userName;
	private String password;
	private String role;
	
	Scanner scanner = new Scanner(System.in);
	
	void createUserAccount()
	{
		System.out.print("\nPlease create a username: ");
		userName = scanner.nextLine();
	}
	
	void createPassword()
	{
		System.out.print("Please create a password: ");
		password = scanner.nextLine();
	}
	
	void createRole()
	{
		System.out.print("Please enter your role: ");
		role = scanner.nextLine();
	}
	
	String getUserName(){return userName;}
	
	String getPassword(){return password;}
	
	String getRole(){return role;}
}