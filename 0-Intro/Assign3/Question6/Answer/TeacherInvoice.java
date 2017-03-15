package Assign3.Question6.Answer;

public class TeacherInvoice 
{
	//An Invoice should include four pieces of 
	//information as instance variables – 
	//a part number (type String), 
	String partNumber;
	//a part description (type String),
	String partDescription;
	//a quantity of the item being purchased (type int) 
	int quantity;
	//and a price per item (double). 
	double price;
	
	//Your class should have a constructor that
	//initializes the four instance variables.	
	public TeacherInvoice(String partNumber, String partDescription, int quantity, double price) 
	{
		// Granted this could also mean to just set them to 0 but I like this better
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.price = price;
	}
	
	//Provide a method named getInvoiceAmount that 
	//calculates the invoiced amount 
	//then returns the amount as a double value.
	void getInvoiceAmount() 
	{
		//let's ignore the returning
		
		//If the quantity is not positive, it should be set to 0 
		this.quantity = Math.max(this.quantity, 0);
		
		//If the price per item is not positive, it should be set to 0.0
		this.price = Math.max(this.price, 0);
		
		//(i.e. multiplies the quantity by the price per item), 
		double amount = this.price * this.quantity;
		
		//instead of returning print the amount
		System.out.println("Amount: " + amount);
	}

}
