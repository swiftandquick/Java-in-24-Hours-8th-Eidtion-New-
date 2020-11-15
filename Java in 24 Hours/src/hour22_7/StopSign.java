package hour22_7;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class StopSign extends JPanel {

	Font font = new Font("Overpass", Font.BOLD, 100);
	
	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setColor(Color.red);
		
		/** Since I am drawing an octagon, it will have 8 coordinates.  */
		int[] xPoints = {150, 250, 350, 350, 250, 150, 50, 50};
		int[] yPoints = {50, 50, 150, 250, 350, 350, 250, 150};
		
		Polygon octagon = new Polygon(xPoints, yPoints, 8);
		
		comp2D.drawPolygon(octagon);
		comp2D.fillPolygon(octagon);
		
		comp2D.setColor(Color.white);
		
		String stopMessage = "STOP";
		comp2D.setFont(font);
		comp2D.drawString(stopMessage, 60, 225);
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		StopSign stopSign = new StopSign();
		frame.add(stopSign);
	}
	
}
