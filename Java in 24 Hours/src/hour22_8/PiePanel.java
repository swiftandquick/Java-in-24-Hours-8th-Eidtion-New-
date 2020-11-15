package hour22_8;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/** Remember to extend to JPanel or a lot of JPanel methods cannot 
 * be used in paintComponent.  */
@SuppressWarnings("serial")
public class PiePanel extends JPanel {

	private PieSlice[] slices; // Each represents a pie slice in the pie chart.  
	private int current = 0; // Current index
	float totalSize = 0; // Used to calculate sum of slices' sizes.  

	/* Background color, I am not sure if its useful, if it is, I will uncomment.  */
	// private Color background;  
	
	/* Helper class, can exchange variables and methods with PiePanel.  */
	class PieSlice {
		
		Color color;
		float size;
		
		PieSlice() {
			color = Color.lightGray;
			size = 0;
		}
		
		PieSlice(Color rColor, float rSize) {
			color = rColor;
			size = rSize;
		}
		
	}
	
	
	/* PiePanel's only constructor.  */
	PiePanel(int rNumberOfSlices) {
		/** Set the size of slice to 4, which is the integer that's passed 
		 * to the PiePanel constructor.  */
		slices = new PieSlice[rNumberOfSlices];
	}
	

	/* I can't use for loop here because only 1 slice is added at a time.  */
	public void addSlice(Color rColor, float rSize) { 
		slices[current] = new PieSlice(rColor, rSize);
		totalSize = totalSize + slices[current].size;
		current++;
	}
	
	
	public void paintComponent(Graphics comp) {
		Graphics2D comp2d = (Graphics2D) comp;
	
		/** Set the insets and size of the entire pie.  */
		int xInset = 5;
		int yInset = 5;		
		int width = getSize().width - 10;
		int height = getSize().height - 10;
		
		float start = 0; // First index starts at 0 degrees.  
		
		for(int i = 0; i < slices.length; i++) {
			/* Gets how many degrees I want to extend my arc.  slice[i].size / totalSize 
			 * gets me the percentage, I have to multiply it by 360 to get the degrees that 
			 * I want to extend, we want to find the arc's degrees in a circle (360 degrees).  */
			float extent = slices[i].size / totalSize * 360;
			/* Create an Arc2D object.  */
			Arc2D.Float currentSlice = new Arc2D.Float(xInset, yInset, width, height, start, extent, Arc2D.PIE);
			/* Add extent to start so next pie slice (arc) will starts 
			 * where the previous pie slice (arc) ends.  */
			start = start + extent;
			
			comp2d.setColor(slices[i].color);
			comp2d.draw(currentSlice);
			comp2d.fill(currentSlice);
		}
		
	}
	
}
