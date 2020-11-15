package hour8_1;

public class Nines {

	public static void main(String[] args) {
		/* dex is 1, loop continues as long as dex <= 200 remains true, 
		 * increment dex by 1 each iteration.  */
		for (int dex = 1; dex <= 200; dex++) {
			/* Prints ouf 200 multiples of 9.  */
			int multiple = 9 * dex;
			System.out.print(multiple + " ");
		}
		System.out.println();
	}
	
}
