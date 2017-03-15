package Assign3;
import java.util.Scanner;

public class CommissionCalculator 
{
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        double compensation = 200.00;
        int item = 0;
    	
    	do
    	{
    		menu(compensation);
    		item = scanner.nextInt();
    		
			while(item < 0 || item > 4)
			{
				System.out.println("ERROR: Invalid input!");
				menu(compensation);
	    		item = scanner.nextInt();
			}
			
			switch(item)
			{
				case 1:
					compensation += (239.99 *0.09);
					break;
				
				case 2:
					compensation += (129.75 *0.09);
					break;
					
				case 3:
					compensation += (99.95 *0.09);
					break;
					
				case 4:
					compensation += (350.89 *0.09);
					break;	
			}

    	}while(item != 0);
    	
    	System.out.println("Total earnings: " + compensation);
    	scanner.close();
    }
    
    private static void menu(double comp)
    {
    	System.out.println("Item\tValue");
		System.out.println("1\t$239.99");
		System.out.println("2\t$129.75");
		System.out.println("3\t$99.95");
		System.out.println("4\t$350.89");
		System.out.println("Current compensation: $" + comp);
		System.out.print("Please select an item from the list above (or enter 0 to exit):");
    }
}