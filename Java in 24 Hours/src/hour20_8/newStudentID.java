package hour20_8;

import java.io.*;

public class newStudentID {
	
	File studentIDList = new File("src/hour20_8/IDList.dat");
	
	/* Constructor.  */
	newStudentID() {
		try {
			FileOutputStream writeFile = new FileOutputStream(studentIDList);
			/* Calls writeLine method.  However, only the first 5 numbers are 
			 * studentID, rest of it doesn't need to be written.  */
			writeLine(writeFile, "42814mfd");
			writeLine(writeFile, "900143rr");
			writeLine(writeFile, "09913K@9");
			writeFile.close();
		}
		catch (IOException e) {
			// Do nothing.  
		}
	}
	
	
	public void writeLine(FileOutputStream rWriteFile, String untrimmedID) throws IOException {
		/* Changes the String "StudentID:  #" to array of bytes called labelBytes.  */
		byte[] labelBytes = "Student ID:  #".getBytes();
		/* Changes the String untrimmedID to array of bytes called labelBytes.  */
		byte[] uIDBytes = untrimmedID.getBytes();
		/* Writes the bytes in labelBytes to the stream.  */
		rWriteFile.write(labelBytes);
		/* Writes only the first 5 characters in uIDBytes to the stream, 
		 * because rest are not part of the ID.  */
		rWriteFile.write(uIDBytes, 0, 5);
		/* Skips a line.  */
		rWriteFile.write('\n');
	}
	
	
	public static void main(String args[]) {
		new newStudentID();
	}
}
