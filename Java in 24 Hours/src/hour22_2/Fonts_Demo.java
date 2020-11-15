package hour22_2;

import javax.swing.*;
import java.awt.*; // This package includes Graphics object

public class Fonts_Demo extends JPanel {	
	
	/** Selects a color based on red, green, and blue mixture.  */
	Color gold = new Color(159, 121, 44);
	Color teal = new Color(0, 101, 118);
	
	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		
		/* Next action will create something teal, I choose to make a rectangle teal.  */
		comp2D.setColor(teal);
		comp2D.fillRect(0, 0, 200, 100);
		
		/* Set the color to the Color object gold for the next two actions' results.  Because 
		 * the Strings are drawn after the rectangle, they are put on top of the rectangle.  */
		comp2D.setColor(gold);
		/* Sets fonts for all drawn texts contained by the comp2D object.  */
		Font font = new Font("Comic Sans", Font.BOLD, 15);
		comp2D.setFont(font);
		
		/* Writes the String on the panel, place it 5 pixels to the right, and 50 pixels downward.  */
		comp2D.drawString("Go, Jaguars!", 5, 50);
		/* Writes the String on the panel, place it 15 pixels to the right, and 75 pixels downward.  */
		comp2D.drawString("Potrzebie!", 15, 75);
		
		/* Enables anti aliasing, which makes edges of shapes and texts less jagged.  */
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	
	public static void main(String args[]) {
		/* Because I am using JPanel and not JFrame, so I have put the 
		 * JFrame related codes in here.  */
		JFrame frame = new JFrame("Fonts Demo");
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		/* Sets the frame's background color to white.  */
		frame.setBackground(Color.white);
		
		/* Creates a panel to draw.  */
		Fonts_Demo panel = new Fonts_Demo();
		frame.add(panel, BorderLayout.CENTER);
	}
	
}
