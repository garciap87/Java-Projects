/**
 * Create a class Giraffe which stores the height, age, and name of the Giraffe. 
 * Add assessor methods which show those values but also let you change them. 
 * Write another method walk which takes a number of steps and prints “Giraffe is walking X steps”.
 */
package Assign4.Question3;

public class Giraffe 
{
	private double height;
	private int age;
	private String name;
	
	double getHeight(){return height;}
	int getAge(){return age;}
	String getName(){return name;}
	
	void setHeight(double height)
	{
		this.height = height;
	}
	
	void setAge(int age)
	{
		this.age = age;
	}

	void setName(String name)
	{
		this.name = name;
	}
	
	void walk(int steps)
	{
		System.out.println("Giraffe is walking " + steps + " steps");
	}
}