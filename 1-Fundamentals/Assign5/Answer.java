package Assign5;
public class Answer 
{  
    public static void main(String[] args) 
    {
        System.out.println("Prime numbers < 10k:");
        /**
         * Loop 10000, checking every number along the way for primeness...
         * Let the isPrime method do the heavy lifting
         */
        for(int i=0; i < 10000; i++) 
        {
            if(isPrime(i))
                System.out.println(i);
        }
    }
    
    public static boolean isPrime(int num) 
    {
        // There are many ways to determine if a number is prime or not...
        // we'll take the "easy way out"
        if(num < 2) 
            return false;
        
        /**
         * I've commented out the less efficient approach...
         * for(int i=2; i <= num/2; i++) {
         * 
         * This exercise shows that you can solve the same problem with 
         * different algorithms... the key takeaway is that, just because one 
         * approach works doesn't mean it is the best.
         *
         * In this case, all of the numbers > the square root must be 
         * multiplied by a number < the square root to equal the target 
         * number... so why not just check the numbers <= the square root?
         */        
        for(int i=2; i <= Math.sqrt(num); i++) 
        {
            if(num % i == 0)    // If num is evenly divisible by i 
                return false;   // then it isn't prime
        }
        
        // If it isn't not-prime then I suppose it is prime...
        return true;
    }
    
}
