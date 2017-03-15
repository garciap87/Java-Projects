package Assign3.Question6;
import java.util.Scanner;

public class InvoiceTest 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Invoice invoice = new Invoice();
		
		System.out.println("...........Please enter the information for the item sold below...........");
		System.out.print("What is the part number?: ");
		invoice.partNumber = scanner.nextLine();
		
		
		System.out.print("What is the part description?: ");
		invoice.partDescription = scanner.nextLine();
		
		System.out.print("What was the quantity?: ");
		invoice.quantity = scanner.nextInt();
		
		System.out.print("What was the price?: ");
		invoice.price = scanner.nextDouble();
		
		double invoicdAmount = invoice.getInvoiceAmount();
		
		System.out.println("\nThe part number is: " + invoice.partNumber );
		System.out.println("The part description is: " + invoice.partDescription );
		System.out.println("The invoiced amount is: $" + invoicdAmount);
		
		scanner.close();
	}
}
