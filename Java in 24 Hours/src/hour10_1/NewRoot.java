package hour10_1;

/* Run -> Run Configurations.  
 * Emter "9025" as argument.  */

public class NewRoot {

	public static void main(String[] args) {
		int number = 100;
		if (args.length > 0) {
			/* Convert String to int.  */
			number = Integer.parseInt(args[0]);
		}
		System.out.println("The square root of "
			+ number + " is " + Math.sqrt(number));
	}
}