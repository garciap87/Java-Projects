package Assign4;
/*(Find the Smallest Value) Write an application that finds the smallest of several integers.
Assume that the first value read specifies the number of values to input from the user.*/

import java.util.Scanner;

public class SmallestInt 
{
    public static void main(String[] args) 
    {
                
        Scanner scanner = new Scanner(System.in);
        int smallest = 0;
        
        System.out.print("How many integers shall we compare? (Enter a positive integer): ");
        int count = scanner.nextInt();
        
        while(count <= 0)
        {
        	System.out.println("Invalid input!");
        	System.out.print("How many integers shall we compare? (Enter a positive integer): ");
        	count = scanner.nextInt();
        }

        for(int ii = 1; ii <= count ; ii++ ) 
        {  
        	System.out.print("Enter value " + ii + ": ");
        	int input = scanner.nextInt();
        	
        	if(ii == 1)
        	{
        		smallest = input;
        	}
        	else if (input < smallest)
        	{
        		smallest = input;
        	}
        }
        System.out.println("The smallest number entered was: " + smallest);
        scanner.close();
    }   
}