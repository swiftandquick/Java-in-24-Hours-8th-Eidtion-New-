package hour20_5;

import java.io.*;

public class Console {

	public static String readLine() {
		/* Creates an empty StringBuilder.  */
		StringBuilder response = new StringBuilder();
		try {
			/* BufferedInputStream is not reading the file, but rather, reading the input.  
			 * System.in lets me type things in Eclipse's console.  I use BufferedInputStream 
			 * to read what I typed inside the Eclipse console.  */
			BufferedInputStream bin = new BufferedInputStream(System.in);
			/* The int variable in is different than in from System.in.  Variable in will be 
			 * later used to refer to the current character that is being read.  I don't need 
			 * to initialize the "in" variable because I use a do while loop, not a while loop.  */
			int in;
			char inChar;
			/* While the in variable is not -1 (no more character to read) or \n (enter key).  
			 * The do while loop will continue.  */
			do {
				/* Reads the next character, returns an integer equal to character's value.  */
				in = bin.read();
				/* Converts the integer to its representative character.  */
				inChar = (char) in;
				/* Appends the current character to the StringBuilder.  */
				response.append(inChar);

			} while ((in != -1) & (inChar != '\n'));
			/* Close the buffer reader when I no longer need it.  */
			bin.close();
			/* Returns the StringBuilder as a String.  */
			return response.toString();
		}
		/* Buffer reader may not be able to read the input.  */
		catch (IOException e) {
			System.out.println("I/O error!  ");
			/* Returns a null String if there's I/O error.  */
			return null;
		}
	}
	
	public static void main(String[] args) {
		/* I don't know what these codes are for.  */
		System.out.print("You are standing at the end of the road ");
		System.out.print("before a small brick building.  Around you ");
		System.out.print("is a forest.  A small stream flows out of ");
		System.out.println("the building and down a gully.  \n");
		System.out.print("> ");
		
		/* Since readLine() is a static method, I can invoke the  method by calling 
		 * the class name Console.  Store the return value in String variable input.  */
		String input = Console.readLine();
		
		/* Print out input, it should contain exactly the same characters that I typed 
		 * into Eclipse's console.  */
		System.out.println(input);

		/* It will be printed after the readLine() method is invoked.  
		 * I don't know what this line is for also.  */
		System.out.println("That's not a verb I recognize.  ");
	}
	
}
