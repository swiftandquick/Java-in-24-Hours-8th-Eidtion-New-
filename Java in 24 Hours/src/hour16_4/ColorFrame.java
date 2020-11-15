package hour16_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFrame extends JFrame {

	JButton red, green, blue;
	
	
	public ColorFrame() {
		super("ColorFrame");
		setSize(322, 122);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		/* Add the buttons to the layout.  */
		red = new JButton("Red");
		add(red);
		green = new JButton("Green");
		add(green);
		blue = new JButton("Blue");
		add(blue);
		
		// Begins anonymous inner class.  
		/* I don't need to implement ActionListener class because I 
		 * created an anonymous inner class for the same purpose.  */
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				/* If the source is red, if I clicked on the JButton called red, 
				 * set the background red.  */
				if (event.getSource() == red) {
					getContentPane().setBackground(Color.RED);
				}
				if (event.getSource() == green) {
					getContentPane().setBackground(Color.GREEN);
				}
				if (event.getSource() == blue) {
					getContentPane().setBackground(Color.BLUE);
				}
			}
		};
		
		/* Add action listener to all 3 buttons.  */
		red.addActionListener(act);
		green.addActionListener(act);
		blue.addActionListener(act);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ColorFrame();
	}
	
}
