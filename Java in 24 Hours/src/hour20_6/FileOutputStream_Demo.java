package hour20_6;

import java.io.*;

public class FileOutputStream_Demo {
	
	public static void main(String args[]) {
		
		File dataFile = new File("src/hour20_6/data.dat");
		
		try {
			
			FileOutputStream writeFile = new FileOutputStream(dataFile);
			
			/* Creates a byte array, inside the byte array, I can later 
			 * use the write the bytes as their corresponding ASCII 
			 * characters in the data.dat file.  Index 3 has the value of 
			 * 13, which means carriage return in ASCII table.  */
			byte[] data = new byte[] { 5, 12, 4, 13, 3, 15, 2, 17, 1, 18 };
			
			/* Write all characters equivalent to their byte value from the 
			 * data byte array into the data.dat file.  So index 0 to last 
			 * index of the array will be written.  */
			writeFile.write(data, 0, data.length);
			
			/* Right now, the file should output rectangles containing 
			 * question marks.  That's supposed to happen, because byte 
			 * numbers 0-31 are control characters, they have no character 
			 * to represent them.  Notices how the 4th character is skips 
			 * a line?  That's because 13 is '\n' or Enter key.  */
			
			/* I convert the String name into an array of bytes, then add 
			 * the byte[] array elements to the file.  */
			String name = "Pudding N. Tane";
			byte[] nameBytes = name.getBytes();
			writeFile.write(nameBytes);
			
			/* After the question mark block characters, I should be able to 
			 * see Pudding N. Tane in data.dat.  */
			
			/* Close the I/O stream when I don't it.  */
			writeFile.close();
		}
		catch (IOException e){
			System.out.println("I/O error.  ");
		}
		
	}
	
}
