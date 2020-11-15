package hour22_3;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawLinesAndShapes extends JPanel {

	public void paintComponent(Graphics comp) {
		/* Casting Graphics (superclass object) to Graphics2D (subclass object).  */
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.drawString("Draw, pardner!", 15, 40);
		
		/* These two methods gets the size of the frame.  */
		int maxXValue = getSize().width;
		int maxYValue = getSize().height;
		
		/* I divide the width and height by 2 to get the middle coordinate, 
		 * then I put the String "X" in the middle of the frame.  */
		comp2D.drawString("X", maxXValue / 2, maxYValue / 2);
		
		/* I am drawing a line.  From (40, 200) to (70, 130).   
		 * 40F:  Line starts at 40 pixels to the right.  
		 * 200F:  Line starts at 200 pixels downward.  
		 * 70F:  Line ends at 70 pixels to the right.  
		 * 130F:  Line ends at 130 pixels downward.  */
		Line2D.Float line = new Line2D.Float(40F, 200F, 70F, 130F);
		comp2D.draw(line);
		
		/* I created a rectangle with width of 20 pixels and length (height) of 10 pixels 
		 * at the location of:  245 pixels to the right, 65 units downward.  */
		Rectangle2D.Float box = new Rectangle2D.Float(245F, 65F, 20F, 10F);
		comp2D.draw(box);
		/* Fill the Rectangle2D.Float object, the default color filling should 
		 * be black, I can change its color with setColor, but I am not doing that.  */
		comp2D.fill(box);
		
		/* Creates a rectangle with rounded edges.  The first 4 float variables in the 
		 * parenthesis represent the same thing as in the parenthesis of the Rectangle2D's 
		 * parenthesis.  The last 2 float variables in the parenthesis represents how many 
		 * pixels I should round the rectangle horizontally and vertically respectively.  
		 * Which is 15 pixels for both of them.  */
		RoundRectangle2D.Float rr = new RoundRectangle2D.Float(10F, 10F, 100F, 80F, 15F, 15F);
		comp2D.draw(rr);
		
		/* Ellipse is also known as oval.  I can draw ovals and circles using the Object 
		 * Ellipse2D.Float.  (245, 45) is the coordinate.  Third argument (15F) is the how 
		 * width of the circle, fourth argument (15F) is height of it.  If last two arguments 
		 * are equal, then a circle is stored in the Ellipse2D.Float object.  Otherwise, an 
		 * oval is stored.  */
		Ellipse2D.Float circle = new Ellipse2D.Float(245F, 45F, 15F, 15F);
		comp2D.draw(circle);
		
		/* This is an oval.  */
		Ellipse2D.Float oval = new Ellipse2D.Float(145F, 45F, 35F, 25F);
		comp2D.draw(oval);
		
		/* I can also create arcs.  In the arc I created below.  OPEN means that it's a regular 
		 * arc.  The arc starts at coordinate (200, 100), width is 65 pixels, height is 75 pixels.  
		 * It starts at 30-degrees mark, and it is 120 degrees long.  */
		Arc2D.Float arc = new Arc2D.Float(200F, 100F, 65F, 75F, 30F, 120F, Arc2D.Float.OPEN);
		comp2D.draw(arc);

		/* CHORD replaces CLOSED, it draws a straight line at the end of the arc's two points.  
		 * 6th float argument is negative, that means starting at 30 degrees, the arc will be 
		 * drawn at the clockwise direction for 120 degrees.  */
		Arc2D.Float chord = new Arc2D.Float(200F, 200F, 65F, 75F, 30F, -120F, Arc2D.Float.CHORD);
		comp2D.draw(chord);
		
		/* PIE creates a pie piece shape based on the end of the arc's two points.  */
		Arc2D.Float pie = new Arc2D.Float(300F, 200F, 65F, 75F, 30F, 120F, Arc2D.Float.PIE);
		comp2D.draw(pie);
		
	}
	
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Draw Lines and Shapes");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		/* I guess I have to treat the current class as the subclass of JPanel, 
		 * and then we add this class' object to JFrame object called frame.  
		 * It will be the same as adding a JPanel object to JFrame object.  */
		DrawLinesAndShapes panel = new DrawLinesAndShapes();
		/* Not sure if I have to add BorderLayout.CENTER, so I got rid of it.  */
		frame.add(panel);
	}
	
}