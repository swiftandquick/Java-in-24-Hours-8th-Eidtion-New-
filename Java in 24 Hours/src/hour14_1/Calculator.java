package hour14_1;

/* Run -> Run Configurations...  
 * Type "7 4 8 1 4 1 4" as argument.  */

public class Calculator {

	public static void main(String[] args) {
		float sum = 0;for (String arg : args) {
			/* Convert String variable arg to float before adding it to sum.  */
			sum = sum + Float.parseFloat(arg);
		}
		System.out.println("Those numbers add up to " + sum);
	}
	
}
