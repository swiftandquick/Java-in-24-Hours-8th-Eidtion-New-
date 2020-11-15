package hour15_2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;


/* Link rotator class is a subclass of the JFrame class.  
 * JFrame is a simple graphical user interface that contains an empty frame.  
 * Implements Runnable and ActionListener classes.  
 * Runnable class allows the usage of the run() method in this program.  
 * ActionListener interface enables the program to respond to mouse clicks.  
 */
@SuppressWarnings("serial")
public class LinkRotator extends JFrame 
	implements Runnable, ActionListener {
	
	// Creates a six-element array of String objects.  
	String[] pageTitle = new String[6];
	
	/* Creates a six-element array of URI objects. URI is not URL, so not it's not a
	 * misspelled acronym. URI also identifies the website's address.  */
	URI[] pageLink = new URI[6];
	
	/* current keeps track of which site being displayed, so I can cycle through the 
	 * sites.  current starts as 0 means "Oracle's Java Site" will be displayed first.  */
	int current = 0;
	
	/* The Thread object runner represents the thread this program runs.  The runner object 
	 * is called when I start, stop, and pause the operation.  */	
	Thread runner;
	
	// Creates an object called siteLabel.  
	JLabel siteLabel = new JLabel();
	
	
	public LinkRotator() {
		
		// Exit out of the program when it's closed.  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// The size of the pop up is 300 x 100.  
		setSize(300, 100);
		
		// Constructs a default flow layout.  
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		// Add the site label.  
		add(siteLabel);
		
		// Create a String array with six sites.  
		pageTitle = new String[] {
			"Oracle's Java site", 
			"Server Side", 
			"JavaWorld",
			"Java in 24 Hours", 
			"Sams Publishing", 
			"Workbench"
		};
		
		/* Add six websites to URI array.  getURI will convert String 
		 * into URI then returns a URI value.  */
		pageLink[0] = getURI("http://www.oracle.com/technetwork/java");
		pageLink[1] = getURI("http://www.theserverside.com");
		pageLink[2] = getURI("http://www.javaworld.com");
		pageLink[3] = getURI("http://www.java24hours.com");
		pageLink[4] = getURI("http://www.samspublishing.com");
		pageLink[5] = getURI("http://workbench.cadenhead.org");
		
		// Create a clickable button.  
		Button visitButton = new Button("Visit Site");
		
		/* Clicking on the visitButton will trigger an event. The effect of 
		 * clicking the button will be reflected on the actionPerformed class. */
		visitButton.addActionListener(this);
		add(visitButton);
		
		// Set the GUI visible.  
		setVisible(true);
		
		// Call the start() method.  
		start();
	}
	
	
	private URI getURI(String urlText) {
		// Declare URI as null at first.  
		URI pageURI = null;
		/* Get the pageURI by equaling it to the argument (urlText). 
		 * Catch errors in case if the URI format isn't valid.  */
		try {
			// Convert String to URI.  
			pageURI = new URI(urlText);
		}
		// Keep the program running in case of the URI syntax is wrong.  
		catch (URISyntaxException ex) {
			// Do nothing; 
		}
		// Return the the URI variable:  pageURI.  
		return pageURI; 
	}
	
	
	// If the Thread hasn't been started, start it.  
	public void start() {
		if (runner == null) {
			/* Creates a new Thread object with one argument:  the this keyword.  
			 * The this keyword refers to the program itself, designating it as 
			 * the class that runs within the thread.  */
			runner = new Thread(this);
			/* By calling the start() method, the run() method is invoked.  */
			runner.start();
		}
	}
	
	
	/* run() method is not invoked manually, but rather it's invoked when start()
	 * method is called.  As long as the thread doesn't stop, the codes inside 
	 * the run() method will continue to execute.  */
	public void run() {
		// Keeps track of the thread that's currently running.  
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			/* There are six websites, the index goes from 0 to 5.  
			 * When index reaches to 5, it resets to 0 to repeat the cycle.  
			 * 2 seconds after Workbench (index 5) is displayed, Oracle's 
			 * Java Site (index 0) will be displayed next.  */
			current++;
			if (current > 5) {
				current = 0;
			}
			
			// Set label to the current wesbite.  
			siteLabel.setText(pageTitle[current]);
			
			// Replaces old text with new text.  
			repaint();
			
			// Each siteLabel text displays for 2 seconds.  
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException exc) {
				// Do nothing.  
			}
		}
	}
	
	
	/* Handle event if action is performed.  Since I only add action listener to 
	 * visitButton (JButton), the method actionPerformed handles event that occurs 
	 * after clicking on visitButton.  */
	public void actionPerformed(ActionEvent event) {
		/* "Desktop" class is defined in the java.awt package.  
		 * It represents the desktop environment for the running application.  
		 * The "desktop" object is created.  */
		Desktop desktop = Desktop.getDesktop();
		if (pageLink[current] != null) {
			try {
				/* Clicking on the button allows me to browse to the current displayed website.  */
				desktop.browse(pageLink[current]);
				
				/* If I comment out the next two lines, because I don't want the program to stop
				 * after I click on a link. So, I need the thread (runner) to keep running, and
				 * I need the GUI window to continue to pop up instead of exiting.  If I want 
				 * to close it, I can always click on the "x" mark on top-right corner.  */
				
				/* Stops the thread after the link is clicked on.  */
				runner = null;
				
				/* Closes the GUI once the link is clicked on.  */
				System.exit(0); 
			}
			catch (IOException exc) {
				// Do nothing.  
			}
		}
	}
	
	
	// Reads main method, main method calls LinkRotator().  
	public static void main(String[] arguments) {
		new LinkRotator();
	}

}