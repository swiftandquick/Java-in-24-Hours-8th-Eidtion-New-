package hour16_3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyViewer extends JFrame {

	/* A text field that is 80 characters long.  */
	JTextField keyText = new JTextField(80);
	JLabel keyLabel = new JLabel("Press any key in the text field.  ");
	
	
	public KeyViewer() {
		super("KeyViewer"); // title
		setSize(350, 100); // size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Instead of implementing KeyListener interface, I use an anonymous 
		 * inner class.  Add key listener to the keyText (JTextField), so the 
		 * program will handle the events when something is typed into the 
		 * text field.  The listener is created anonymously with the call to 
		 * new KeyAdapter() followed by definition of the class.  */
		keyText.addKeyListener(new KeyAdapter () {
			/* Handle events when a key is typed.  One of the upside of not 
			 * implementing the KeyListener interface is that I only need to 
			 * implement the keyTyped method without implementing keyPressed 
			 * or keyReleased methods.  */
			public void keyTyped(KeyEvent input) {
				/* Gets the key that is being typed.  */
				char key = input.getKeyChar();
				/* Displays the key that is most recently typed.  */
				keyLabel.setText("You pressed " + key);
			}
		});
		
		BorderLayout bord = new BorderLayout();
		setLayout(bord);
		add(keyLabel, BorderLayout.NORTH);
		add(keyText, BorderLayout.CENTER);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new KeyViewer();
	}
	
	
}
