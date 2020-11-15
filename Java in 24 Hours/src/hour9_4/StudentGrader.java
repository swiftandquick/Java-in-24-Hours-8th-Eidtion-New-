package hour9_4;

public class StudentGrader {

	public static void main(String[] args) {
		int[][] grades = {
			{ 90, 85, 85, 75, 70, 95}, 
			{ 95, 85, 85, 70, 75, 90 },
            { 85, 80, 85, 95, 100, 100 },
            { 80, 90, 90, 80, 85, 95 },
            { 75, 45, 80, 95, 90, 90 },
            { 90, 90, 90, 95, 70, 65 } 
		};
	
		int sum;
		
		System.out.println("Student\t\tTest 1\tTest 2\tTest 3\tTest 4\tTest 5\tTest 6\tAverage");
		
		/* For each student...  */
		for (int i = 0; i < grades.length; i++) {
			System.out.print("Student #" + i + "\t");
			/* sum is used to calculate average.  Reset sum to 0 
			 * for each new student.  */
			sum = 0;
			/* Display each test result of each student.  */
			for (int j = 0; j < grades[i].length; j++) {
				System.out.print(grades[i][j] + "\t");
				sum = sum + grades[i][j];
			}
			/* Display the average tests for each student.  */
			System.out.print(sum / grades[i].length + "\n");
		}
		
	}
	
}
