package hour20_9;

import java.io.*;
import java.util.*; // Imports Properties object.  

public class PropertiesDemo {

	File configFile = new File("src/hour20_9/config.dat");

	PropertiesDemo() {
		try {
			FileInputStream readFile =  new FileInputStream(configFile);

			/* The Properties class is able to separate properties with 
			 * their value.  Properties are username, lastCommand, and windowSize, 
			 * values are lepton, open database, and 32.  */
			Properties config = new Properties();

			/* Properties object loads the readFile object.  */
			config.load(readFile);
			
			/* Properties and values are separated by the equal sign '=', so 
			 * the property of "username" should be "lepton".  */
			String username = config.getProperty("username");
			
			/* String value should be "open database".  */
			String lastCommand = config.getProperty("lastCommand");
			
			/* All properties are stored as String, I must convert the string to 
			 * integer in order to use store it as one.  */
			String windowProp = config.getProperty("windowSize");
			int windowSize = 24;
			try {
				windowSize = Integer.parseInt(windowProp);
				if (windowSize <= 0) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				/* Do nothing, but if windowProp cannot be converted to integer, 
				 * or if it's a negative number, then it will be remain as 24.  */
			}
			
			System.out.println("Username:  " + username);
			System.out.println("Last Command:  " + lastCommand);
			System.out.println("Window Size:  " + windowSize);

			/* Now, I reset the username's value to "max 2.0" */
			config.setProperty("username", "max 2.0");
			
			/* I will now add the new property set.  */
			config.setProperty("firstCommand", "close database");
			
			/* However, if I go back to the file, nothing changed.  That's because 
			 * I'm missing an output stream.  */
			FileOutputStream writeFile = new FileOutputStream(configFile);
			
			/* Stores the newly updated information to the console, I need to have 
			 * an output stream for this to work.  The new green text of that file 
			 * displays "Properties settings" on first line, and the second line 
			 * has shows the old lines that I replaced.  */
			config.store(writeFile, "Properties settings");
			
			/* The file's last line is printed first, because it's added last 
			 * as a property set.  Also, notice how username changed.  Also, 
			 * my newly created property firstCommand is on the list.  Use 
			 * list method to print out all properties.  */
			config.list(System.out);
			
			/* Close the I/O streams as I no longer use them.  */
			readFile.close();
			writeFile.close();
		}
		catch (FileNotFoundException e) {
			// Do nothing.  
		} 
		catch (IOException e) {
			// Do nothing.  
		}
	}
	
	
	public static void main(String args[]) {	
		new PropertiesDemo();		
	}
	
}