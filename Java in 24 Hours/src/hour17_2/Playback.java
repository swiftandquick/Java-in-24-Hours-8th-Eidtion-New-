package hour17_2;

import javax.swing.*;
import java.awt.*;

public class Playback extends JFrame {

	public Playback() {
		super("Playback");
		setLookAndFeel();
		setSize(450, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Set layout to FlowLayout.  */
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		/* Create and add buttons to the frame.  */
		JButton play = new JButton("Play");
		JButton stop = new JButton("Stop");
		JButton pause = new JButton("Pause");
		add(play);
		add(stop);
		add(pause);
		
		/* Set the frame visible.  */
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
		Playback frame = new Playback();
	}
	
}
