package hour19_1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyViewer extends JFrame implements KeyListener {

	JTextField keyText = new JTextField(80);
	JLabel keyLabel = new JLabel("Press any key in the text field.  ");
	
	
	public KeyViewer() {
		super("KeyViewer");
		setLookAndFeel();
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Add event listener to keyText (JTextField).  So an event is 
		 * triggered when I perform action on that component.  */
		keyText.addKeyListener(this);
		BorderLayout bord = new BorderLayout();
		setLayout(bord);
		add(keyLabel, BorderLayout.NORTH);
		add(keyText, BorderLayout.CENTER);
		setVisible(true);
	}
	
	
	/* If a key is typed in keyText...  */
	@Override
	public void keyTyped(KeyEvent input) {
		/* key is the most recently pressed key.  */
		char key = input.getKeyChar();
		/* Change keyLabel's content based on the key I most recently pressed.  */
		keyLabel.setText("You pressed " + key);
	}
	
	
	@Override
	public void keyPressed(KeyEvent txt) {
		// Do nothing.  
	}
	
	
	@Override
	public void keyReleased(KeyEvent txt) {
		// Do nothing.  
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
		KeyViewer frame = new KeyViewer();
	}
	
}
