package hour12_2;

import java.awt.*;

public class PointTester {

	public static void main(String[] args) {
		Point location1 = new Point(11, 22);
		Point3D location2 = new Point3D(7, 6, 64);
		Point4D location3 = new Point4D(17, 61, 6, 4);
		
		System.out.println("The 2D point is at (" + location1.x
				+ ", " + location1.y + ")");
		
		System.out.println("It's being moved to (4, 13");
		location1.move(4, 13);
		System.out.println("The 2D point is now at (" + location1.x
				+ ", " + location1.y + ")");
		
		System.out.println("It's being moved -10 units on both the x " 
				+ "and y axes.  ");
		location1.translate(-10, -10);
		System.out.println("The 2D Point ends up at (" + location1.x
				+ ", " + location1.y + ")");

		System.out.println();
		
		System.out.println("The 3D point is at (" + location2.x
				+ ", " + location2.y + ", " + location2.z + ")");
		
		System.out.println("It's being moved to (10, 22, 71");
		location2.move(10, 22, 71);
		System.out.println("The 3D point is now at (" + location2.x
				+ ", " + location2.y + ", " + location2.z + ")");
		
		System.out.println("It's being moved -20 units on the x, y, " 
				+ "and z axes.  ");
		location2.translate(-20, -20, -20);
		System.out.println("The 3D Point ends up at (" + location3.x
				+ ", " + location3.y + ", " + location3.z + 
				location3.t + ")");
	
		System.out.println();
		
		System.out.println("The 4D point is at (" + location3.x
				+ ", " + location3.y + ", " + location3.z + ", " + 
				location3.t + ")");
		
		System.out.println("It's being moved to (11, 12, 27, 11)");
		location3.move(11, 12, 27, 11);
		System.out.println("The 4D point is now at (" + location3.x
				+ ", " + location3.y + ", " + location3.z + ", " + 
				location3.t + ")");
		
		System.out.println("It's being moved -15 units on the x, y, " 
				+ "z, and t axes.  ");
		location3.translate(-15, -15, -15, -15);
		System.out.println("The 4D Point ends up at (" + location3.x
				+ ", " + location3.y + ", " + location3.z + ", " + 
				location3.t + ")");

	
	}
	
}
