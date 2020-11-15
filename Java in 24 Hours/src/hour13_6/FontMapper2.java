package hour13_6;

/* Run -> Run Configurations.  
 * Type in arguments:  "Verdana italic 24".  */

import java.awt.*;
import java.util.*;

public class FontMapper2 {
	HashMap<String, Font> fonts = new HashMap<>();

	public FontMapper2() {
		Font courier = new Font("Courier New", Font.PLAIN, 6);
		Font times = new Font("Times New Roman", Font.BOLD, 12);
		Font verdana = new Font("Verdana", Font.ITALIC, 25);
		fonts.put("smallprint", courier);
		fonts.put("body", times);
		fonts.put("headline", verdana);
	}

	
	/* Add a font to the hash map by specifying its name, style, and size. If
    the named font is not present on your computer, the Font class attempts
    to choose a similar substitute. */
	public void addFont(String name, String style, String size) {
		int fontStyle = -1;
		/* Set font style as plain, bold, or italic.  */
		if (style.equalsIgnoreCase("plain")) {
			fontStyle = Font.PLAIN;
		}
		if (style.equalsIgnoreCase("bold")) {
			fontStyle = Font.BOLD;
		}
		if (style.equalsIgnoreCase("italic")) {
			fontStyle = Font.ITALIC;
		}
		
		int fontSize = -1;
		/* Convert size from String to int.  */
		try {
			fontSize = Integer.parseInt(size);
		} 
		catch (NumberFormatException nfe) {
			// do nothing
		}

		/* If fontStyle and fontSize equals -1, print error message.  */
		if ((fontStyle == -1) | (fontSize == -1)) {
			System.out.println("Invalid font style or size");
			return;
		}
		/* Create a new font with name, fontStyle, and fontSize.  */
		Font userFont = new Font(name, fontStyle, fontSize);
		
		/* Adds a new entry set.  */
		fonts.put("user", userFont);
	}

	
	/* Print all 4 entry sets.  */
	public void displayFonts() {
		for (Map.Entry<String, Font> entry : fonts.entrySet()) {
			String key = entry.getKey();
			Font value = entry.getValue();
			System.out.println(key + ": " + value.getSize() + "-pt "
					+ value.getFontName());
		}
	}

	
	public static void main(String[] arguments) {
		FontMapper2 app = new FontMapper2();
		if (arguments.length < 3) {
			System.out.println("Usage: FontMapper2 name style size");
			System.exit(-1);
		}
		app.addFont(arguments[0], arguments[1], arguments[2]);
		app.displayFonts();
	}
}