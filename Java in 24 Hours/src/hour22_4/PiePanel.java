package hour22_4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class PiePanel extends JPanel {

	/* PieSlice is a helper (inner) class.  I initialize up an empty array 
	 * of PieSlice objects called slice.  */
	private PieSlice[] slice;
	
	/* PieSlice[] will hold 10 PieSlice objects, so it will start at index 0.  
	 * Variable current represents the current index of the slice array.  */
	private int current = 0;
	
	/* Initialized as 0, later will be used to get the sum of sizes.  The sizes 
	 * are integer arguments passed from the PieFrame class to PiePanel's addSlice() 
	 * method. */
	private float totalSize = 0;

	private Color background; 
	
	/* PieSlice is an inner class of the PiePanel class, that means 
	 * PiePanel gains access to methods and instance variables of the 
	 * inner class PieSlice.  I can also set PieSlice as an object.  */
	class PieSlice {
		
		/* Instance variables of the inner class.  */
		Color color;
		float size;
		
		/* Default constructor sets color to lightGray and size to 0.  */
		PieSlice() {
			color = Color.lightGray;
			size = 0;
		}
		
		/* If I pass in Color and float as argument, I set color and size 
		 * as those variables instead.  */
		PieSlice(Color rColor, float rSize) {
			color = rColor;
			size = rSize;
		}
	}
	
	
	/* In this constructor, piePanel takes in an integer as an argument, 
	 * and the argument is 10.  */
	PiePanel(int sliceCount) {
		/* Since sliceCount is 10.  I successfully initialize slice to hold 
		 * 10 empty PieSlice objects.  */
		slice = new PieSlice[sliceCount];
		/** Set the Color background the same as background color.  */
		background = getBackground();
	}
	
	
	/* addSlice adds a PieSlice object to the PieSlice[] array.  */
	public void addSlice(Color rColor, float rSize) {
		/* slice.length is 10, as long as current is not greater than or 
		 * equal to 10, I can add another PieSlice object into PieSlice[].  
		 * Which will shouldn't be happening.  */
		if (current <= slice.length) {
			
			/* Create a PieSlice object by passing the color and size variables to 
			 * PieSlice's constructor, then add the newly created object to PieSlice[] 
			 * array called slice.  */
			slice[current] = new PieSlice(rColor, rSize);
			
			/* Increment the totalSize by adding rSize to it.  */
			totalSize = totalSize + rSize;
			
			/* Increment the current variable by 1, so I don't replace the  
			 * index with existing PieSlice object with a new PieSlice object. */
			current++;
		}
		
	}
	
	
	/* Method used to paint everything inside a JPanel.  */
	public void paintComponent(Graphics comp) {
		
		/* Invokes the super class method with the same signature, 
		 * which is paintComponent(), pass in comp as argument.  
		 * I am not sure if I really need this.  */
		// super.paintComponent(comp);
		
		/* Casting Graphics object as a Graphics2D object.  */
		Graphics2D comp2D = (Graphics2D) comp;
		
		/* Gets the width and height of the panel, but then reduce them 
		 * by a bit before storing them int int variables width and height.  
		 * These variables are for creating the pie, the pie size will 
		 * be almost as big as the container (JPanel).  */
		int width = getSize().width - 10;
		int height = getSize().height - 15;
		
		/* xInset and yInset means the initial coordinate of the pie.  
		 * So the pie will initially located 5 pixels to the right and 
		 * 5 pixels downward from top left corner.  */
		int xInset = 5;
		int yInset = 5;

		/* Not sure what these are for, they are contradictory.  Since xInset 
		 * and yInset are already declared as 5, and it doesn't look like they 
		 * will be changed anywhere in the code.  */
		/* if (width < 5) {
			xInset = width;
		}
		if (height < 5) {
			yInset = height;
		} */
		
		/* Set color equal to back color, which is equal to getBackground().  Next action 
		 * will draw components that has the same color the Color variable "background".  */
		comp2D.setColor(background);
		
		/* Creates a filled rectangle with background color.  */
		comp2D.fillRect(0,  0, getSize().width, getSize().height);
		
		/* From now on, the drawn components will be light gray instead.  */
		comp2D.setColor(Color.lightGray);
		
		/* Creates an arc with Ellipse2D.Float object, then set the coordinate and size.  */
		Ellipse2D.Float pie = new Ellipse2D.Float(xInset, yInset, width, height);
		
		/* Color the pie.  */
		comp2D.fill(pie);

		/* Variable "start" represents the degree the arc / pie slice starts at.  */
		float start = 0;
		
		/* Loop through every slice array elements (PieSlice objects) from index 0 to 9.  */
		for (int i = 0; i < slice.length; i++) {
			/* Variable extent represents how many degrees the arc will move after its starting 
			 * point.  It's retrieved by dividing the current slice's size by the totalSize.  */
			float extent = slice[i].size * 360F / totalSize;
			/* Set the color to slice[i] equal to current slice's (current PieSlice object) color. */
			comp2D.setColor(slice[i].color);
			/* Draw the pie slice (arc), make sure to I set the last argument as Arc2.Float.PIE, 
			 * because I want to make a pie slice shaped arc not a regular arc.  */
			Arc2D.Float drawSlice = new Arc2D.Float
					(xInset, yInset, width, height, start, extent, Arc2D.Float.PIE);
			comp2D.fill(drawSlice);
			/* Increment start by extent, so the next arc / pie slice will start at that degree.  */
			start = start + extent;
		}
		
	}
	
}
