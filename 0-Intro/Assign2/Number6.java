/**Write an application that inputs one number consisting of five digits from the user, separate 
the number into its individual digits and prints the digits separated from one another by three 
spaces each. For example, if the user types in the number 42339, the program should print 4   2   3   3   9 – 
You will need to use The modulo operator % which is nothing more than “remainder after division”, 
for instance 12 % 10 would be 2 and Integer division /, for instance 12 / 10 would be 1.
*/

package Assign2;
import java.util.Scanner;

public class Number6
{
	static public void main(String args[]) 
	{
		int input = 0;
		int leftOver = 0;
		
		System.out.print("Please enter a five digit number below:\n");
		
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
		
		System.out.print("Your input with each number separated by three spaces is shown below:\n");
		
		leftOver = input % 10000;
		input /=10000;
		System.out.print(input);
		System.out.print("   ");
		
		input = leftOver / 1000;
		leftOver %= 1000;
		System.out.print(input);
		System.out.print("   ");
		
		input = leftOver / 100;
		leftOver %= 100;
		System.out.print(input);
		System.out.print("   ");
		
		input = leftOver / 10;
		leftOver %= 10;
		System.out.print(input);
		System.out.print("   ");
		
		input = leftOver / 1;
		leftOver %= 1;
		System.out.print(input);
		System.out.print("   ");
		
		scanner.close();
	}
}