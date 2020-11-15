package hour15_3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;


@SuppressWarnings("serial")
public class LinkRotator extends JFrame 
	implements Runnable, ActionListener {
	
	String[] pageTitle = new String[4];
	URI[] pageLink = new URI[4];
	int current = 0;
	Thread runner;
	JLabel siteLabel = new JLabel();
	
	
	public LinkRotator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		add(siteLabel);
		 
		pageTitle = new String[] {
			"Google", 
			"Yahoo", 
			"eBay",
			"Amazon", 
		};
		
		pageLink[0] = getURI("http://www.google.com");
		pageLink[1] = getURI("http://www.yahoo.com");
		pageLink[2] = getURI("http://www.ebay.com");
		pageLink[3] = getURI("http://www.amazon.com");
		
		Button visitButton = new Button("Visit Site");
		visitButton.addActionListener(this);
		add(visitButton);
		
		setVisible(true);
		 
		start();
	}
	
	
	private URI getURI(String urlText) {
		URI pageURI = null;
		try {
			pageURI = new URI(urlText);
		} 
		catch (URISyntaxException ex) {
			// Do nothing; 
		}
		return pageURI; 
	}
	
	
	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}
	
	
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			current++;
			if (current > 3) {
				current = 0;
			}
			
			siteLabel.setText(pageTitle[current]);
			repaint();
			
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException exc) {
				// Do nothing.  
			}
		}
	}
	
	
	public void actionPerformed(ActionEvent event) {

		Desktop desktop = Desktop.getDesktop();
		if (pageLink[current] != null) {
			try {
				desktop.browse(pageLink[current]);
				runner = null;
				System.exit(0); 
			}
			catch (IOException exc) {
				// Do nothing.  
			}
		}
	}

	 
	public static void main(String[] arguments) {
		new LinkRotator();
	}

}