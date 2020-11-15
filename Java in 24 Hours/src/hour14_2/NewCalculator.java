package hour14_2;

/* Run -> Run Configurations...  
 * Type in "1 3 5x 6 6x 5" as arguments.  */

public class NewCalculator {

	public static void main(String[] args) {
		float sum = 0;
		for (String arg : args) {
			try {
				/* Calculate the sum of the arg that can be converted to float.  */
				sum = sum + Float.parseFloat(arg);
			}
			/* Some String variables cannot convert to float, for example 5x.  The for 
			 * loop continues to iterate even after an exception is caught.  */
			catch (NumberFormatException e) {
				System.out.println(arg + " is not a number.  ");
			}
		}
		System.out.println("Those numbers add up to " + sum);
	}
	
}
