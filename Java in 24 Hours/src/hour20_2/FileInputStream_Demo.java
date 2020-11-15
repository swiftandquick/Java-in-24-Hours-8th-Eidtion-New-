package hour20_2;

import java.io.*;

public class FileInputStream_Demo {
	
	public static void main(String args[]) {
		
		File cookie = new File("src/hour20_2/cookie.web");
		
		/* Every I try to create, read, or write a file, I must surround it with
		 * try-catch block, the two most common errors are FileNotFoundException and
		 * IOException.  */	
		try {
			FileInputStream readFile = new FileInputStream(cookie);
			/* Each character is represented by a byte, the length() method returns 
			 * how many bytes the file has, which is also how many characters are in 
			 * the file.  */
			System.out.println("File size:  " + cookie.length() + " bytes.  ");
			System.out.println("File content in integers & characters:  \nint\tchar");
			try {
				/* available() checks if there is next character, if there aren't, then its
				 * integer value be -1.  */
				while (readFile.available() > 0) {
					/* Gets the next character.  */
					int nextCharacterInInt = readFile.read();
					System.out.print(nextCharacterInInt + "\t");
					/* Cast the int type to char type.  */
					char nextCharacterInChar = (char) nextCharacterInInt;
					System.out.print(nextCharacterInChar + "\n");
				}
				readFile.close();
			} 
			catch (IOException e) {
				// Do nothing.  
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("No such file existed.  ");
		}
		
	}
}
