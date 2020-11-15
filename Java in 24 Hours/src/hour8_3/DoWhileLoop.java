package hour8_3;

public class DoWhileLoop {

	public static void main(String[] args) {
		int limit = 5;
		int count = 1;
		/* do-while loops iterate at least once.  Because statements 
		 * inside the loop gets executed before conditional test is done.  */
		do {
			System.out.println("I am not allergic to long division.  ");
			count++;
		} while (count < limit);
	}
	
}
