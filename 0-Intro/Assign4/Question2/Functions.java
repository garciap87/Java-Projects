/**
Write a program with several functions as shown in the example videos and call them from a main method for testing:
f(x) = 2x +3
f(x) = x2 + 3x + 9
f(x) = x3 + 4x + 7
 */
package Assign4.Question2;

public class Functions 
{
	double twoX(double x)
	{
		return (2*x)+3;
	}
	
	double xSquared(double x)
	{
		return Math.pow(x, 2) + (3*x) + 9;
	}
	
	double xCubed(double x)
	{
		return Math.pow(x, 3) + (4*x) + 7;
	}
}