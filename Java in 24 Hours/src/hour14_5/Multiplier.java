package hour14_5;

/* Run -> Run Configurations...  
 * 1st test:  4 5 2; 
 * 2nd test:  4 5 2s*/

public class Multiplier {

	public static void main(String[] args) {
		if (args.length == 3) {
			try {
				float product = Float.parseFloat(args[0]) 
						* Float.parseFloat(args[1])
						* Float.parseFloat(args[2]);
				System.out.println(product);
			}
			catch (NumberFormatException e) {
				System.out.println("All inputs must be numbers.  ");
			}
		}
	}
	
}
