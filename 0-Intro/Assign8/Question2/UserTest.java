/**Write a program to simulate a login. Create a class user 
which has a user name, a password, and a role. Initialize 
it with 3 users: Bob, role user; Jim role user; Liz role 
super user. Select appropriate passwords. Now, ask the 
user to input his username and password. If they are correct 
print “Welcome <username>!” otherwise “Access Denied!”. A dialog might look like:

Login: Bob
Password: <password>
Welcome Bob!

Alternatively:
Login: Bob
Password: <wrong password>
Access Denied!

Use a Map to solve this task.
 */


package Assign8.Question2;
import java.util.HashMap;
import java.util.Scanner;

public class UserTest 
{
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		HashMap<String, User> map = new HashMap<String, User>();
		int choice = 0;
		
		do
		{
			System.out.println("\n       MENU");
			System.out.println("1) Log In");
			System.out.println("2) Create User");
			System.out.println("3) End Program");
			System.out.print("Enter your choice: ");
			
			choice = getChoice();
			
			switch(choice)
			{
				case 1:
					if(map.isEmpty())
					{
						System.out.println("\nYou have not created any users!\n");
						break;
					}
					
					System.out.print("\nPlease enter your username: ");
					scanner.nextLine();
					String userName = scanner.nextLine();
					
					if(map.containsKey(userName))
					{
						System.out.print("Please enter your password: ");
						String password = scanner.nextLine();
						
						User u = map.get(userName);
						try
						{
							if(password.contains(u.getPassword()))
							{
								System.out.println("Welcome: Access Granted!!");
								System.out.println("Your role is: " + u.getRole());
							}
							else
							{
								throw new Exception();
							}
						}
						catch(Exception e)
						{
							System.out.println("Access Denied! You have entered an incorrect password");
						}
					}
					else
					{
						System.out.println("You have entered a username that doesn't exist");
					}
					break;
					
				case 2:
					User user = new User();
					user.createUserAccount();
					user.createPassword();
					user.createRole();
					map.put(user.getUserName(), user);
					break;
			}
			
		}while(choice != 3);
		
		System.out.println("Thank You! Good Bye!");
		scanner.close();
	}
	
	static int getChoice()
	{
		int userInput = scanner.nextInt();
		
		while(userInput < 1  || userInput > 3)
		{
			System.out.print("\nChoice must be between 1 and 3\n" 
								+ "Please re-enter your choice: ");
			userInput = scanner.nextInt();
		}
		return userInput;
	}	
}