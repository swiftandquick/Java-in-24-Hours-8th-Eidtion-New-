package hour12_2;

import java.awt.*;

public class Point3D extends Point {

	public int z;
	
	public Point3D(int x, int y, int z) {
		/* Call the Point() constructor, and pass x and y as arguments.  */
		super(x, y);
		this.z = z;
	}
	
	
	public void move(int x, int y, int z) {
		this.z = z;
		/* Invoke the superclass Point's move() method, takes x and y as arguments. */
		super.move(x, y);
	}
	
	
	public void translate(int x, int y, int z) {
		this.z += z;
		/* Invokes the superclass Point's translate() method, takes x and y as arguments.  */
		super.translate(x, y);
	}
	
}
