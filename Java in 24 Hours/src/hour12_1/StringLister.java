package hour12_1;

/* Run -> Run Configurations.  
 * Write "Scotty Sony Jason Dillon" as argument.  */

import java.util.*;

public class StringLister {

	String[] names = { "Carly", "Sam", "Kiki", "Lulu", 
			"Hayden", "Elizabeth", "Kristina", "Molly", "Laura"};
	
	
	/* Parameter moreNames contains an array of String elements that is entered 
	 * in the argument field:  "Scotty", "Sony", "Jason", and "Dillon".  */
	public StringLister(String[] moreNames) {
		ArrayList<String> list = new ArrayList<String>();
		
		/* Add array elements into the ArrayList list.  */
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		
		/* Add String elements from the moreNames array to the ArrayList list.  */
		for (int i = 0; i < moreNames.length; i++) {
			list.add(moreNames[i]);
		}
		
		/* Sort the list in alphabetical order.  */
		Collections.sort(list);
		
		/* Print out each element of the list.  */
		for (String name : list) {
			System.out.println(name);
		}
	}
	
	
	public static void main(String[] args) {
		/* Create an object called lister, call the constructor and pass 
		 * args (array of String elements) as argument.  */
		StringLister lister = new StringLister(args);
	}
	
}