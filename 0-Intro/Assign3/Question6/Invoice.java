/**
 * Create a class called Invoice that a hardware store might use to represent an invoice for an 
 * item sold at the store. An Invoice should include four pieces of information as instance 
 * variables – a part number (type String), a part description (type String), a quantity of the 
 * item being purchased (type int) and a price per item (double). Your class should have a constructor 
 * that initializes the four instance variables. Provide a method named getInvoiceAmount that calculates 
 * the invoiced amount (i.e. multiplies the quantity by the price per item), then returns the amount as a 
 * double value. If the quantity is not positive, it should be set to 0. If the price per item is not positive, 
 * it should be set to 0.0. Write a test application named InvoiceTest that demonstrates the Invoice’s capabilities. 
 * Make sure to create this Java file in the same directory as Invoice. You can then refer to Invoice like you 
 * would in Invoice.java, e.g. Invoice invoice = new Invoice()
 */

package Assign3.Question6;

public class Invoice 
{
	String partNumber;
	String partDescription;
	int quantity;
	double price;
	
	public Invoice()
	{
		partNumber = "";
		partDescription = "";
		quantity = 0;
		price = 0.0;
	}

	double getInvoiceAmount()
	{
		if(quantity < 0)
		{
			System.out.println("\nThe quantity entered was a negative number, setting quantity to 0");
			quantity = 0;
		}
		
		if(price < 0.0)
		{
			System.out.println("\nThe price entered was a negative number, setting price to 0.0");
			price = 0.0;
		}
		
		double invoicdAmount = quantity * price;
		
		return invoicdAmount;
	}
}