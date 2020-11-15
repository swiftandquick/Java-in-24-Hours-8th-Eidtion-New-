package hour20_7;

import java.io.*;

public class ConfigWriter {

	/* The String that skips a line, similar to "\n".  */
	String newline = System.getProperty("line.separator");
	
	public ConfigWriter() {
		try {
			File file = new File("src/hour20_7/program.properties");
			/* Creates the file.  */
			FileOutputStream fileStream = new FileOutputStream(file);			
			/* Call the write method, pass fileStream (FileOutputStream) and String as argument.  */
			write(fileStream, "username=max");
			write(fileStream, "score=12550");
			write(fileStream, "level=5");
			/* Close the stream when it's no longer needed.  */
			fileStream.close();
		}
		/* Catches IOException that is thrown at the write() method.  */
		catch (IOException ioe) {
			System.out.println("Could not write file.  ");
		}
	}
	
	
	/* Throws IOException.  */
	void write(FileOutputStream stream, String output) throws IOException {
		/* Output equals output plus a line separator.  So if output is "username=max", the new 
		 * output value should be "username=max\n" */
		output = output + newline;
		/* Converts the String to an array of bytes.  */
		byte[] data = output.getBytes();
		/* Writes the array of bytes to stream (program.properties).  */
		stream.write(data, 0, data.length);
	}
	
	
	/* Call the ConfigWriter() constructor.  */
	public static void main(String[] args) {
		new ConfigWriter();
	}
	
}
