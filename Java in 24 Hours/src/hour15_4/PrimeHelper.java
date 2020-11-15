package hour15_4;

public class PrimeHelper implements Runnable {
    Thread go;
    int multiplier;
    int quantity;
    /* PrimeFinder2 object parent.  */
    PrimeFinder2 parent;
    boolean done;
    
    public PrimeHelper(PrimeFinder2 parent, int multiplier, int quantity) {
        this.multiplier = multiplier;
        this.quantity = quantity;
        this.parent = parent;
        this.done = false;
    }
        
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        int numNotMultiOf3 = 0;
        // candidate:  The number that might not be divisible by 3.  
        int candidate = 1;
        /* multiples is a JTextArea component.  */
        parent.multiples.append("First " + quantity + " non-multiples of 3:  \n");
        while ((numNotMultiOf3 < this.quantity) & (this.go == thisThread)) {
            if (isNotMultiple(candidate)) {
                parent.multiples.append(candidate + " ");
                numNotMultiOf3++;
            }
            /* Skips a line for every 20 numbers.  */
            if (numNotMultiOf3 % 20 == 0) {
            	parent.multiples.append("\n");
            }
            candidate++;
        }
        /* Set done to true.  */
        done = true;
        /* If parent's (PrimeHelper) done value is also true.  Which means 
         * both threads are done.  The stop button disables and the display 
         * button enables.  */
        if (parent.done) {
            parent.stop.setEnabled(false);
            parent.display.setEnabled(true);
        }
    }

    public static boolean isNotMultiple(int checkNumber) {
        if (checkNumber % 3 == 0) {
            return false;
        }
        return true;
    }
}