package hour7_4;

import java.util.*;

public class Store {

	public static void main(String[] args) {
		/* Grade is a random number from 1 to 100.  */
		Random random = new Random();
		int grade = random.nextInt(100) + 1;
		char letter;
		
		if (grade <= 100 && grade >= 90) {
			letter = 'A';
		}
		else if (grade <= 89 && grade >= 80) {
			letter = 'B';
		}
		else if (grade <= 79 && grade >= 70) {
			letter = 'C';
		}
		else if (grade <= 69 && grade >= 60) {
			letter = 'D';
		}
		else {
			letter = 'F';
		}
		
		System.out.println("Grade:  " + grade);
		System.out.println("Letter:  " + letter);
	}
	
}
