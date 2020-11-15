package hour18_1;

import java.awt.*;
import javax.swing.*;

public class Crisis extends JFrame {

	JButton panicButton;
	JButton dontPanicButton;
	JButton blameButton;
	JButton mediaButton;
	JButton saveButton;
	
	
	public Crisis() {
		super("Crisis");
		setLookAndFeel();
		setSize(348, 128);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Layout is FlowLayout, which arranges Components from left to right.  */
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		// Give labels to the buttons.  
		panicButton = new JButton("Panic");
		dontPanicButton = new JButton("Don't Panic");
		blameButton = new JButton("Blame Others");
		mediaButton = new JButton("Notify the Media");
		saveButton = new JButton("Save Yourself");
		
		// Add the buttons to the frame.  
		add(panicButton);
		add(dontPanicButton);
		add(blameButton);
		add(mediaButton);
		add(saveButton);
		
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
		Crisis frame = new Crisis();
	}
	
}
