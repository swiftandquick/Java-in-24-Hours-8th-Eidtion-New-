package hour20_10;

import java.io.*;
import java.util.*;

public class Configurator {

	public Configurator() {
		try {
			File configFile = new File("src/hour20_10/program.properties");
			/* Input stream for the file.  */
			FileInputStream inStream = new FileInputStream(configFile);

			/* Create a Properties object.  Load the properties file.  */
			Properties config = new Properties();
			config.load(inStream);
			
			/* Create a new property.  Property is runtime, property's value 
			 * is the current time in String format.  */
			Date current = new Date();
			config.setProperty("runtime", current.toString());
			
			// Save the properties file
			FileOutputStream outStream = new FileOutputStream(configFile);
			
			/* Stores the newly updated information to the console, I need to have 
			 * an output stream for this to work.  The new green text of that file 
			 * displays "Properties settings" on first line, and the second line 
			 * has shows the old lines that I replaced.  */
			config.store(outStream,  "Properties settings");
			/* Prints out the properties and their values.  */
			config.list(System.out);
			
			/* Close the streams that I no longer used.  */
			inStream.close();
			outStream.close();
		}
		catch (IOException ioe) {
			System.out.println("IO error " + ioe.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		new Configurator();
	}
	
}
