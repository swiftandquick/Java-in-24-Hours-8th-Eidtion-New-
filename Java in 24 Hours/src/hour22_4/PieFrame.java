package hour22_4;

import javax.swing.*;
import java.awt.*;

/* I am having JFrame as superclass because I am not physically 
 * drawing things on the frame, so I don't use JPanel.  */
@SuppressWarnings("serial")
public class PieFrame extends JFrame {

	/* I am entering parameter values in hexadecimal format. zooSuit and
	 * shrinkingViolet are the same color, I hope that doesn't cause any issue.  */
	Color uneasyBeingGreen = new Color(0xCC, 0xCC, 0x99);
	Color zuzusPetals = new Color(0xCC, 0x66, 0xFF);
	Color zootSuit = new Color(0x66, 0x66, 0x99);
	Color sweetHomeAvocado = new Color(0x66, 0x99, 0x66);
	Color shrinkingViolet = new Color(0x66, 0x66, 0x99);
	Color miamiNice = new Color(0x33, 0xFF, 0xFF);
	Color inBetweenGreen = new Color(0x00, 0x99, 0x66);
	Color norwegianBlue = new Color(0x33, 0xCC, 0xCC);
	Color purpleRain = new Color(0x66, 0x33, 0x99);
	Color freckle = new Color(0x99, 0x66, 0x33);
	
	PieFrame() {
		setTitle("Pie Graph");
		setLookAndFeel();
		setSize(320, 290);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* I am commenting out the layout because I don't need to add the layout, 
		 * as I already add the JPanel to the frame.  */
		// FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// setLayout(layout);
		
		/* PiePanel the object / class, which I set as a subclass to JPanel in 
		 * the other file.  Since PiePanel is a subclass to JPanel, I can treat it
		 * as a JPanel object, which means I can add it to the JFrame (main frame).  
		 * I pass in the variable 10, which is the slice count.  */
		PiePanel pie = new PiePanel(10);
		
		/* Calls the addSlice() method from the PiePanel class, I just the PiePanel 
		 * object named pie to invoke the method from the other class.  I pass in object 
		 * Color and int as the variable.  */
		pie.addSlice(uneasyBeingGreen, 1350);
		pie.addSlice(zuzusPetals, 1221);
		pie.addSlice(zootSuit, 316);
		pie.addSlice(sweetHomeAvocado, 251);
		pie.addSlice(shrinkingViolet, 201);
		pie.addSlice(miamiNice, 193);
		pie.addSlice(inBetweenGreen, 173);
		pie.addSlice(norwegianBlue, 164);
		pie.addSlice(purpleRain, 143);
		pie.addSlice(freckle, 127);
		
		/* Add the PiePanel object (which is also a JPanel object) pie to the layout.  */
		add(pie);
		
	}
	
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plat.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			// Do nothing, I don't want to interrupt the GUI.  
		}
	}
	
	
	/* Main method invokes constructor and sets JFrame visible.  */
	public static void main(String args[]) {
		PieFrame frame = new PieFrame();
		frame.setVisible(true);
	}
	
}
