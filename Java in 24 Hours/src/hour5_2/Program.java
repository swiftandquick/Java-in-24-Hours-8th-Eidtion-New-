package hour5_2;

public class Program {

	public static void main(String[] args) {
		/* x is increment b y 1 after the operation is done, 
		 * so answer is 30.  x is only set to 4 after answer 
		 * is set to 30.  */
		int x = 3;
		int answer = x++ * 10;
		System.out.println(answer);
		
		/* y is increment by 1 before the operation is done, 
		 * so answer is 40.  */
		int y = 3;
		int answer2 = ++y * 10;
		System.out.println(answer2);
	}
	
}
