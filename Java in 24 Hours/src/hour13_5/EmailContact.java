package hour13_5;

import java.util.*;

public class EmailContact {

	public static void main(String[] args) {
		HashMap<String, String> contacts = new HashMap<String, String>();
		
		contacts.put("jpham14@hotmail.com", "Jamie Pham");
		contacts.put("xuea1996@gmail.com", "Aizhu Xue");
		contacts.put("huange96@gmail.com", "Eric Huang");
		
		int size = contacts.size();
		System.out.println("# of contacts:  " + size);
		
		String name = contacts.get("jpham14@hotmail.com");
		System.out.println("Owner of jpham14@hotmail.com:  " + name);
		
		/* If there is no such email as ychomework4@gmail.com, return "Yong Chen".  */
		String name2 = contacts.getOrDefault("ychomework4@gmail.com", "Yong Chen");
		System.out.println("Owner of ychomework4@gmail.com:  " + name2);
		
		/* Use entrySet() to iterate through HashMap's entry sets.  */
		for (Map.Entry<String, String> entry : contacts.entrySet()) {
			System.out.print(entry.getKey() + "\t");
			System.out.println(entry.getValue());
		}
		
	}
	
}
