/**
 * Create a class ColaVendingMachine. This class is simulating a cola vending machine. 
 * It keeps track of how many cola bottles are in the class and how much one bottle costs. 
 * There should be a method sellBottle which sells one bottle to a customer, decreases the 
 * amount of bottles left. There also is a method restock which sets the number of bottles 
 * to the number it is restocked to. Write a main method to test the functionality of the ColaVendingMachine machine.
 */
package Assign4.Question4;

public class ColaVendingMachine 
{
	private int totalBottles;
	private double cost;
	private double moneySpent;
	
	ColaVendingMachine(int totalBottles, double cost)
	{
		this.totalBottles = totalBottles;
		this.cost = cost;
		moneySpent = 0.0;
		
		System.out.println("There are " + this.totalBottles + " bottles in the Cola Vending Machine.");
		System.out.println("Each bottle costs $" + this.cost);
	}
	
	void sellBottle()
	{
		System.out.println("You have bought one bottle!");
		totalBottles --;
		moneySpent = moneySpent + cost;
		
		System.out.println("There are now " + totalBottles + " bottles in the Cola Vending Machine");
		System.out.println("You have spent a total of $" + moneySpent);
	}
	
	void restock(int stock)
	{
		totalBottles = totalBottles + stock;
		System.out.println("There are now " + totalBottles + " bottles in the Cola Vending Machine!");
		System.out.println("You have spent a total of $" + moneySpent + " so far");
	}
}