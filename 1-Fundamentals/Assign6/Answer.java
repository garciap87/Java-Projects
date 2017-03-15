package Assign6;


import java.util.Random;

/**
 *
 * @author Godfrey
 */
public class Answer 
{
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Random rand = new Random();
        // The values of the two dice
        int die1, die2;
        final int rolls = 36000000;
        // Arrays are automatically initialized with the default value for
        // their type
        int frequency[] = new int[11];
        
        // "Roll" the dice 36,000,000 times, incrementing the frequency count
        // for each result as it is encountered
        for(int i=0; i < rolls; i++) 
        {
            die1 = rand.nextInt(6) + 1;
            die2 = rand.nextInt(6) + 1;
            frequency[die1 + die2 - 2]++;
        }
        
        // Display the frequencies
        System.out.println("Results after " + rolls + " rolls");
        System.out.println("-------------------------");
        System.out.println("Value\tFrequency");
        for(int i=0; i<frequency.length; i++)
            System.out.println((i+2) + "\t" + frequency[i]);
    }
    
}