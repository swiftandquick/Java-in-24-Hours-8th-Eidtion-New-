package hour4_3;

/* Import all classes from java.util package.  */
import java.util.*;

public class Dice {

	public static void main(String[] args) {
		/* Random class is a template used to create an object called generator.  */
		Random generator = new Random();
		/* Integer from Java range from -2,147,473,648 to 2,147,473,647.  The generator 
		 * object choose one of the numbers and assigned to the value variable.  */
		int value = generator.nextInt();
		System.out.println("The random number is " + value);
	}
	
}
