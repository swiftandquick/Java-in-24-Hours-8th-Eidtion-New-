package hour11_3;

public class Changer {

	public static void main(String[] args) {
		/* Change String to Float.  */
		Float var = Float.parseFloat(args[0]);
		/* Change from Float (Object) to float (primitive type).  */
		float var2 = var;
		/* Change from float to int.  */
		int var3 = (int) var2;
		System.out.println(var3);
	}
	
}
