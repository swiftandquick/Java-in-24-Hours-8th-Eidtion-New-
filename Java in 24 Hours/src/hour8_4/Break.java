package hour8_4;

public class Break {

	public static void main(String[] args) {
		int index = 0;
		while (index <= 1000) {
			index = index + 5;
			/* When index is 400, exit out of the loop.  */
			if (index == 400) {
				break;
			}
			System.out.println(index);
		}
	}
	
}
