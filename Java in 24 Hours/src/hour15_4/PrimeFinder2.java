package hour15_4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* Displays in JFrame instead of console.  
 * Some issue with display and stop buttons.  */
public class PrimeFinder2 extends JFrame implements Runnable, ActionListener {
	
	/* Thread.  */
    Thread go;
    
    /* Components for front end.  */
    JLabel howManyLabel = new JLabel("Quantity: ");
    JTextField howMany = new JTextField("", 10);
    JButton display = new JButton("Find Numbers");
    JButton stop = new JButton("Stop");
    JTextArea primes = new JTextArea(24, 120);
    JTextArea multiples = new JTextArea(24, 120);

    /* boolean value done checks to see if it's done.  */
    boolean done;
    
    /* PrimeHelper type object help.  */
    PrimeHelper helper;
    
    
    PrimeFinder2() {
    	
    	/* Title.  */
        super("Find Numbers");
        setLookAndFeel();
        // Windows size when first shrink to windows mode. 
        setSize(1600, 900);
        // Initially full screen.  
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        /* This object (PrimeFinder2)'s done value is initially false.  So it's 
         * not initially finish finding all numbers.  */
        this.done = false;

        /* Main layout.  */
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        display.addActionListener(this);
        stop.addActionListener(this);
        stop.setEnabled(false);
        
        JPanel topPanel = new JPanel();        
        topPanel.add(howManyLabel);
        topPanel.add(howMany);
        topPanel.add(display);
        topPanel.add(stop);
        // Add the panel.  
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        // Add a text area to hold the prime numbers.  
        primes.setLineWrap(true);
        // Add scroll because much more space is needed.  
        JScrollPane textPane = new JScrollPane(primes);
        bottomPanel.add(textPane);
        // Add a text area to hold the non-multiples.  
        multiples.setLineWrap(true);
        // Add scroll because much more space is needed.  
        JScrollPane textPane2 = new JScrollPane(multiples);
        bottomPanel.add(textPane2);
        // Add the panel.  
        add(bottomPanel, BorderLayout.CENTER);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
    	/* If the display button (Find Numbers) is clicked, do these:  */
        if (evt.getSource() == display) {
        	/* Disable the display button (Find Numbers).  Enable the stop (Stop) button.  */
            display.setEnabled(false);
            stop.setEnabled(true);
            /* If thread go is null.  */
            if (go == null) {
            	/* Create a new thread for go then start it, start() invokes run().  */
                go = new Thread(this);
                go.start();
                /* Changes String in the howMany JTextField to int.  */
                int quantity = Integer.parseInt(howMany.getText());
                /* Passes variables current PrimeFinder2 object (this), 3, and the int 
                 * value of quantity to constructor PrimeHelper.  */
                helper = new PrimeHelper(this, 3, quantity);
                /* Create a helper thread with the object helper (PrimeHelper type) and start it.  */
                helper.go = new Thread(helper);
                helper.go.start();
            }
        } 
        else {
            stop.setEnabled(false);
            if (go != null) {
                go = null;
            }
        }
    }

    
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        int quantity = Integer.parseInt(howMany.getText());
        int numPrimes = 0;
        // Candidate:  The number that might be prime.  
        int candidate = 2;
        primes.append("First " + quantity + " prime numbers:  \n");
        while ((numPrimes < quantity) & (go == thisThread)) {
            if (isPrime(candidate)) {
                primes.append(candidate + " ");
                numPrimes++;
            }
            /* Skips a line every 20th number.  */
            if (numPrimes % 20 == 0) {
            	primes.append("\n");
            }
            candidate++;
        }
        done = true;
        /* After all the prime numbers are found, done become true.  
         * If the done value from helper object of PrimeHelper class is 
         * also true, the stop (Stop) button disables.  Because both the 
         * main thread and helper thread are done.  Additionally, the 
         * display (Find Numbers) button became enabled.  */
        if (helper.done) {
            stop.setEnabled(false);
            display.setEnabled(true);
        }
    }

    
    /* Find prime numbers.  */
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

    
    /* Calls the constructor PrimeFinder2() to create a general layout of the frame.  */
    public static void main(String[] arguments) {
        new PrimeFinder2();
    }
}