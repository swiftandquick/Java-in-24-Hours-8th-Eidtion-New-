package hour9_5;

public class ThirteenCounter {

	public static void main(String[] args) {
		int[] multiples = new int[400];
		for (int i = 0; i < multiples.length; i++) {
			multiples[i] = (i + 1) * 13;
		}
		
		/* Check to see if the values are stored in an array.  */
		for (int element : multiples) {
			System.out.println(element);
		}
	}
	
}
