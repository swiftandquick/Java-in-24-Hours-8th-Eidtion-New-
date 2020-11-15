package hour8_5;

public class Continue {

	public static void main(String[] args) {
		int index = 0;
		while (index <= 1000) {
			index = index + 5;
			/* When index is 400, skips the iteration and goes back 
			 * to while statement.  */
			if (index == 400) {
				continue;
			}
			/* Only 400 is not printed.  */
			System.out.println(index);
		}
	}
	
}
