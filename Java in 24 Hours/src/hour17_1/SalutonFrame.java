package hour17_1;

import javax.swing.*;

public class SalutonFrame extends JFrame {

	public SalutonFrame() {
		super("Saluton mondo!"); // Title. 
		setLookAndFeel(); // Call setLookAndFeel(). 
		setSize(450, 200); // Set size. 
		
		/* Program is terminated when I close it.  */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Saluton mondo!");
		add(label);
		
		setVisible(true);
	}
	
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception exc) {
			// Ignore error.  
		}
	}
	
	
	public static void main(String[] args) {
		SalutonFrame frame = new SalutonFrame();
	}
	
}
