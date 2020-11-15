package hour8_6;

public class Program {

	public static void main(String[] args) {
		int points = 0;
		int target = 100;
		
		/* Name the while loop "targetLoop".  */
		targetLoop:
		while (target <= 100) {
			for (int i = 0; i < target; i++) {
				/* When points = 55, 55 > 50 become false, then I exit the while loop 
				 * via break the while loop called targetLoop.  */
				if (points > 50) {
					break targetLoop;
				}
				points = points + i;
				System.out.println(points);
			}
		}
	}
	
}
