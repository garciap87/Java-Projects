package Assign4.Question4;
import java.util.Scanner; 

public class ColaVendingMachineTest 
{
	public static void main(String[] args) 
	{
		int choice;
		Scanner scanner = new Scanner(System.in);
		ColaVendingMachine vending = new ColaVendingMachine(45, 3.25);
		
		do
		{
			System.out.println("\nWhat action would you like to take? Please enter a number");
			System.out.println("1 - Buy a Cola");
			System.out.println("2 - Restock the vending machine");
			System.out.println("3 - Quit the program");
			
			choice = scanner.nextInt();
			
			if(choice == 1)
			{
				vending.sellBottle();
			}
			else if(choice == 2)
			{
				System.out.println("How many bottles would you like to restock?");
				int stock = scanner.nextInt();
				vending.restock(stock);
			}
			else
			{
				System.out.println("Program will now exit!");
				scanner.close();
			}
		}while(choice != 3);
	}
}