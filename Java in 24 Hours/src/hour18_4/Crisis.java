package hour18_4;

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
		setSize(150, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Layout is Box, which arrange components within pane in vertical alignment.  */
		JPanel pane = new JPanel();
		BoxLayout box = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(box);
		
		// Give labels to the buttons.  
		panicButton = new JButton("Panic");
		dontPanicButton = new JButton("Don't Panic");
		blameButton = new JButton("Blame Others");
		mediaButton = new JButton("Notify the Media");
		saveButton = new JButton("Save Yourself");
		
		// Add the buttons to the JPanel container called pane.  
		pane.add(panicButton, BorderLayout.NORTH);
		pane.add(dontPanicButton, BorderLayout.SOUTH);
		pane.add(blameButton, BorderLayout.EAST);
		pane.add(mediaButton, BorderLayout.WEST);
		pane.add(saveButton, BorderLayout.CENTER);
		
		// Add pane (JPanel) to the frame that contains it.  
		add(pane);
		
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
