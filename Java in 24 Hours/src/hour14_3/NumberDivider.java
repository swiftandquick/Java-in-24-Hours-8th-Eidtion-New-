package hour14_3;

/* Run -> Run Configurations.  
 * Try three different scenarios in arguments:  
 * Scenario 1:  "79 13".  
 * Scenario 2:  "79 13x"
 * Scenario 3:  "79 0" */

public class NumberDivider {

	public static void main(String[] args) {
		if (args.length == 2) {
			int result = 0;
			try {
				result = Integer.parseInt(args[0]) / Integer.parseInt(args[1]);
				System.out.println(args[0] + " divided by " + args[1] + " equals " + result);
			}
			/* In case if String cannot be converted to float.  */
			catch (NumberFormatException e) {
				System.out.println("Both arguments must be integers.  ");
			}
			/* In case if divisor is 0.  */
			catch (ArithmeticException e) {
				System.out.println("You cannot divide by zero.  ");
			}
		}
	}
	
}
