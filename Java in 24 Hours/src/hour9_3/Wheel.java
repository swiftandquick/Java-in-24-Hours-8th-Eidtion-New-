package hour9_3;

public class Wheel {

	public static void main(String[] args) {
		String phrase[] = {
				"A STITCH IN TIME SAVES NINE", 
				"DON'T EAT YELLOW SNOW", 
				"TASTE THE RAINBOW", 
				"EVERY GOOD BOY DOES FINE", 
				"I WANT MY MTV", 
				"I LIKE IKE", 
				"PLAY IT AGAIN, SAM", 
				"FROSTY THE SNOWMAN", 
				"ONE MORE FOR THE ROAD", 
				"HOME FIELD ADVANTAGE", 
				"SHEFFIELD WEDNESDAY", 
				"GROVER CLEVELAND OHIO", 
				"SPAGHETTI WESTERN", 
				"TEEN TITANS GO", 
				"IT'S A WONDERFUL LIFE"
		};
		
		/* letterCount contains 26 elements, each element store 
		 * the number of times its respective letter appears.  All 
		 * elements in letterCount array starts as 0.  */
		int[] letterCount = new int[26];

		for (int count = 0; count < phrase.length; count++) {
			/* Set current equal to element of current index */
			String current = phrase[count];
			/* Convert current (element of current index) to a char array, 
			 * the char array is called letters.  */
			char[] letters = current.toCharArray();
			/* Iterate through each letter of the letters char array.  */
			for (int count2 = 0; count2 < letters.length; count2++) {
				char letter = letters[count2];
				/* For each time the character between 'A' and 'Z' (capital letters) appears, 
				 * add one to the corresponding letterCount index's value.  */
				/* Note that index [letter - 'A'] represents the number of times the letter 
				 * appears.  Index 0 represents the number of times A appears, index 1 represent 
				 * the number of times B appears, and so on.   If letter is 'B' first appears, 
				 * then letterCount['B' - 'A'], or letterCount[1] increased from 0 to 1.  */
				if ( (letter >= 'A') && (letter <= 'Z') ) {
					letterCount[letter - 'A']++;
				}
			}
		}
		
		for (char count = 'A'; count <= 'Z'; count++) {
			/* Prints out the letter and how its frequency.  */
			System.out.print(count + ": " + 
					letterCount[count - 'A'] + " ");
			/* When gets to 'M', skips a line.  */
			if (count == 'M') {
				System.out.println();
			}
		}
		System.out.println();
	}
	
}