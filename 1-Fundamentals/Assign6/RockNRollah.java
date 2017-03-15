package Assign6;
/**(Dice Rolling) Write an application to simulate the rolling of two dice. The application
should use an object of class Random once to roll the first die and again to roll the second die. The
sum of the two values should then be calculated. Each die can show an integer value from 1 to 6, so
the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the
least frequent. Figure 7.28 shows the 36 possible combinations of the two dice. Your application
should roll the dice 36,000,000 times. Use a one-dimensional array to tally the number of times
each possible sum appears. Display the results in tabular format.
*/

import java.util.Random;

public class RockNRollah 
{   
    public static void main(String[] args) 
    {
    	Random random = new Random();
    	int dice1, dice2, sum;
    	int rolls = 36000000;
    	int[] tally = new int[11];

    	for(int i = 1; i <= rolls; i++)
    	{
    		dice1 = random.nextInt(6) + 1;
    		dice2 = random.nextInt(6) + 1;
    		sum = dice1 + dice2;
    		
    		for(int j = 0; j < tally.length; j++)
    		{
    			if(sum == (j+2))
    			{
    				tally[j]++;
    				break;
    			}
    		}
    	}
        System.out.println("Results after " + rolls + " rolls");
        System.out.println("-------------------------");
        System.out.println("Value\tFrequency");

        for(int j = 0; j < tally.length; j++)
        {
        	System.out.println((j + 2) + "\t" + tally[j]);
        }
    }   
}