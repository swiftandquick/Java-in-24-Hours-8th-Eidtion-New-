package hour13_3;

import java.util.*;

public class HashMap_Demo {

	public static void main(String[] args) {
		/* Create a HashMap with initial capacity of 30 and load factor of 70%, 
		 * when capacity reaches 70%, capacity automatically increases.  */
		HashMap<String, Long> phonebook = new HashMap<String, Long>(30, 0.7F);
		phonebook.put("Butterball Turkey Line", 8002888372L);
		
		/* Gets the value that has the key "Butterball Turkey Line".  */
		long number = phonebook.get("Butterball Turkey Line");
		System.out.println(number);
		
		/* Gets the value that has the key "Betty Crocker", if such key 
		 * doesn't exist, return -1.  */
		long number2 = phonebook.getOrDefault("Betty Crocker", -1L);
		System.out.println(number2);
	}
	
}
