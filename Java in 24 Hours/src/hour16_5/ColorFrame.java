package hour16_5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorFrame extends JFrame {

	JButton red, green, blue, yellow;


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
		yellow = new JButton("Yellow");
		add(yellow);

		// Begins lambda expression.  
		ActionListener act = (event) -> {
			if (event.getSource() == red) {
				getContentPane().setBackground(Color.RED);
			}
			if (event.getSource() == green) {
				getContentPane().setBackground(Color.GREEN);
			}
			if (event.getSource() == blue) {
				getContentPane().setBackground(Color.BLUE);
			}
			if (event.getSource() == yellow) {
				getContentPane().setBackground(Color.YELLOW);
			}
		};
		// End lambda expression.  

		red.addActionListener(act);
		green.addActionListener(act);
		blue.addActionListener(act);
		yellow.addActionListener(act);
		setVisible(true);
	}


	public static void main(String[] args) {
		new ColorFrame();
	}

}
