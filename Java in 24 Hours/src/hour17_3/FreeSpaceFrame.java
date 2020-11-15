package hour17_3;

import java.awt.*;
import javax.swing.*;

public class FreeSpaceFrame extends JFrame {

	public FreeSpaceFrame() {
		super("Disk Free Space");
		setLookAndFeel();
		setSize(500, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		/* Add the component I created, which is FreeSpacePanel to the frame.  */
		FreeSpacePanel freePanel = new FreeSpacePanel();
		add(freePanel);
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
		FreeSpaceFrame frame = new FreeSpaceFrame();
	}
	
}
