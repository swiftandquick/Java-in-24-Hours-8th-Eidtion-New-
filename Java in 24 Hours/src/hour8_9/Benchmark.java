package hour8_9;

public class Benchmark {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		/* endTime is 60 seconds (1 minute) after startTime.  */
		long endTime = startTime + 60000;
		long index = 0;
		
		while (true) {
			// Not sure what this is for.  
			double x = 15 * 15;
			long now = System.currentTimeMillis();
			// If now > endTime, it signifies that the loop has been running for more than a minute.  
			if (now > endTime) {
				// Exits ouf the loop if now > endTime.  
				break;
			}
			// Increment index by 1 as long as now is not greater than endTime.  
			index++;
		}
		System.out.println(index + " loops in one minute.  ");
	}
	
}
