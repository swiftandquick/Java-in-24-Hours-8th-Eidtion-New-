package hour13_4;

import java.awt.*;
import java.util.*;

public class FontMapper {

	public FontMapper() {
		Font courier = new Font("Courier New", Font.PLAIN, 6);
		Font times = new Font("Times New Roman", Font.BOLD, 12);
		Font verdana = new Font("Verdana", Font.ITALIC, 25);
		
		/* Create a HashMap with String as key and font as value.  */
		HashMap<String, Font> fonts = new HashMap<String, Font>();
		
		/* Store 3 entry sets with fonts HashMap.  */
		fonts.put("smallprint", courier);
		fonts.put("body", times);
		fonts.put("headline", verdana);
		
		/* Use entrySet() to iterate through each entry.  */
		for (Map.Entry<String, Font> entry : fonts.entrySet()) {
			String key = entry.getKey();
			Font value = entry.getValue();
			System.out.println(key + ":  " + value.getSize() + "-pt " + value.getFontName());
		}
	}
	
	
	public static void main(String[] args) {
		new FontMapper();
	}
	
}
