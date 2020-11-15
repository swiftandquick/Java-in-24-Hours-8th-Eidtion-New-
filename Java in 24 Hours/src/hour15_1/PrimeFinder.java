package hour15_1;

/* The interface is supported by a Runnable class.  
 * Thanks to the implementation, I can use run() 
 * method in the program to make the program run again.  
 */
public class PrimeFinder implements Runnable {
	
    Thread go; // For finding prime #.  
    
    /* Creates a string buffer called primes.  
     * User can append new strings onto the existing string buffer.  */
    StringBuffer primes = new StringBuffer(); 
    
    /* The variable time starts as 0, then increments by 1 every second (1000 milliseconds).  */
    int time = 0; 
 
    
    /* Constructor, but in reality it's just for main method to invoke it once.  */
    PrimeFinder() {
    	/* Call the start method.  */
        start();
        /* Displays how many seconds elapsed while thread is working to find the 
         * prime numbers in the background.  */
        // While primes isn't null...  
        while (primes != null) {
            System.out.println(time);
            try {
            	// Prints out the time every 1000 milliseconds or one second.  
                Thread.sleep(1000);
            } 
            catch (InterruptedException exc) {
                // Do nothing.  
            }
            time++;
        }
    }
 
    
    /* If the go object variable has a value of null, which indicates the thread 
     * hasn't been created yet.  Simply, start the thread if it hasn't already.  */
    public void start() {
        if (go == null) {
        	/* A new Thread object is created and stored in the variable.  */
            go = new Thread(this);
            /* The thread is started by calling the thread's start() method, 
             * which causes the run() method to be called.  */
            go.start();
        }
    }
    
    
	/* run() is not being invoke manually, but when the thread starts via start()
	 * method, the run() method will begin to execute.  */
    public void run() {
        
        // Finding the first one million prime numbers.  
    	int quantity = 1000000;
        
        int numPrimes = 0;
        // Candidate: the number that might be prime.  First prime is 2.  
        int candidate = 2;
        // Append strings into existing string buffer.  
        primes.append("\nFirst ").append(quantity).append(" primes:  \n\n");
        /* Simply put, find one million prime numbers, 
         * and appending each new number onto the existing string.  */
        while (numPrimes <= quantity) {
        	/* If a prime number is found, increment the numPrimes value by 1, 
        	 * while loop will continue until numPrimes reaches 1 million.  */
            if (isPrime(candidate)) {
                primes.append(candidate).append(" ");
                /* Adds a line skip every for every 20 prime numbers append to the string.  
                 * Without line skipping, the console will not print because the String is 
                 * too long and the width limit of the console is too short.  */
                if (numPrimes % 20 == 0) {
                	primes.append("\n");
                }
                numPrimes++;
            }
            /* candidate will also keep increment until numPrimes surpass quantity.  */
            candidate++;
        }
        
        System.out.println(primes);
        primes = null;
        System.out.println("\nTime elapsed: " + time + " seconds.  ");
    }
 
    
    // Check if the "candidate" number is prime.  
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        /* If the candidate is not divisible by the number from 2 to its 
         * square root, the  candidate is a prime number.  */
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
       
    
    /* Call the PrimeFinder() constructor.  */
    public static void main(String[] arguments) {
        new PrimeFinder();
    }
}