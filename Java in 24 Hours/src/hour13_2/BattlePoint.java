package hour13_2;

import java.util.*;
import java.awt.*;

public class BattlePoint {

	ArrayList<Point> targets = new ArrayList<Point>();
	
	public BattlePoint() {
		// Create targets to shoot at.  
		createTargets();
		
		// Display the game map.  
		showMap();
		
		// Shoot at three points.  
		shoot(7, 4);
		shoot(3, 3);
		shoot(9, 2);
		
		// Dsiplay the map again.  
		showMap();
	}
	
	
	private void showMap() {
		System.out.println("\n   1  2  3  4  5  6  7  8  9");
		for (int column = 1; column < 10; column++) {
			for (int row = 1; row < 10; row++) {
				/* Prints out the column number when row = 1.  */
				if (row == 1) {
					System.out.print(column + " ");
				}
				System.out.print(" ");
				/* Set cell equals current row and column.  */
				Point cell = new Point(row, column);
				/* targets.indexOf(cell) only returns -1 if target doesn't contain cell.  
				 * If target contains cell, which means it returns more than -1, print 
				 * out "X" rather than ".".  For example, if current cell value is (5, 9), 
				 * then targets.indexOf(cell) will return more than -1.  */
				/* if (target.contains(cell)) also works.  */
				// if (targets.contains(cell)) {
				if (targets.indexOf(cell) > -1) {
					// A target is at this position.  
					System.out.print("X");
				}
				/* If target does not contain the cell, print out ".".  */
				else {
					// No target is here.  
					System.out.print(".");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	
	/* Create an array list of 3 Point objects:  
	 * (5, 9), (4, 5), and (9, 2).  */
	private void createTargets() {
		Point p1 = new Point(5, 9);
		targets.add(p1);
		Point p2 = new Point(4, 5);
		targets.add(p2);
		Point p3 = new Point(9, 2);
		targets.add(p3);
	}
	
	
	private void shoot(int x, int y) {
		/* Create a new Point object shot.  */
		Point shot = new Point(x, y);
		System.out.print("Firing at (" + x + ", " + y + ")...  ");
		/* If target contains the shot...  For example, target contains 
		 * (9, 2) and constructor invokes shoot(9, 2).  */
		if (targets.indexOf(shot) > -1) {
			System.out.println("You sank my battlepoint!  ");
			// Delete the destroyed target.  
			/* Remove the array list Point object shot if targets contains it.  */
			targets.remove(shot);
		}
		else {
			System.out.println("Miss.  ");
		}
	}
	
	
	/* Call the constructor.  */
	public static void main(String[] args) {
		new BattlePoint();
	}
	
}