package Assign3.Question6.Answer;

public class TeacherInvoiceTest 
{
	static public void main(String args[]) 
	{
		// Happy Case
		TeacherInvoice invoice = new TeacherInvoice("123", "widget", 2, 1.95);
		invoice.getInvoiceAmount();
		
		//Sad Case 1
		invoice = new TeacherInvoice("123", "widget", -2, 1.95);
		invoice.getInvoiceAmount();
		
		//Sad Case 2
		invoice = new TeacherInvoice("123", "widget", 2, -1.95);
		invoice.getInvoiceAmount();
	}
}