package hour20_3;

import java.io.*;

public class FileInputStream_Demo2 {

	public static void main(String[] args) {

		/* Declares an empty String with 4 spaces.  */
		File findId = new File("src/hour20_3/findNumbers.web");

		/* When trying to read a file, always throw a FileNotFoundException.  */
		try {
			FileInputStream readFile = new FileInputStream(findId);
			System.out.print("Employee ID is:  ");
			/* available() method could result in IOException, so I need a try-catch.  */
			try {
				/* Reads until the file ends.  */
				while (readFile.available() > 0) {

					/* Skips the first characters (bytes) to find the ID.  */
					readFile.skip(4);

					/* Use for loop to print out next 3 bytes.  */
					for (int i = 1; i <= 3; i++) {
						char currentChar = (char) readFile.read();
						System.out.print(currentChar);
					}

				}
				readFile.close();
			} 
			catch (IOException e) {
				System.out.println("I/O error.  ");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!  ");
		}

	}

}