package hour12_2;

/* Point4D inherits all attributes from Point3D, on top of that, 
 * Point4D has the t variable to represent time.  */
public class Point4D extends Point3D {

	public int t;
	
	public Point4D (int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}
	
	
	public void move(int x, int y, int z, int t) {
		this.t = t;
		super.move(x, y, z);
	}
	
	
	public void translate(int x, int y, int z, int t) {
		this.t += t;
		super.translate(x, y, z);
	}
	
}
