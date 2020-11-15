package hour18_6;

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
		GridLayout layout = new GridLayout(2, 1, 10, 10);
		setLayout(layout);
		
		
		panicButton = new JButton("Panic");
		dontPanicButton = new JButton("Don't Panic");
		blameButton = new JButton("Blame Others");
		mediaButton = new JButton("Notify the Media");
		saveButton = new JButton("Save Yourself");

		JPanel topRow = new JPanel();
		FlowLayout topLayout = new FlowLayout();
		topRow.setLayout(topLayout);
		topRow.add(panicButton);
		topRow.add(dontPanicButton);
		add(topRow);
		
		JPanel bottomRow = new JPanel();
		BorderLayout bottomLayout = new BorderLayout();
		bottomRow.setLayout(bottomLayout);
		bottomRow.add(blameButton, BorderLayout.WEST);
		bottomRow.add(mediaButton, BorderLayout.CENTER);
		bottomRow.add(saveButton, BorderLayout.EAST);
		add(bottomRow);
		
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
