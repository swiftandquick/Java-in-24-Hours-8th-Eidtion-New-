package hour13_1;

import java.util.*;

public class ArrayList_Demo {

	public static void main(String[] args) {
		/* Initialize an array list of String type.  */
		ArrayList<String> servants = new ArrayList<String>();
		
		/* Adds String objects to servants.  */
		servants.add("Bates");
		servants.add("Anna");
		servants.add("Thomas");
		servants.add("Mrs. O'Brien");
		servants.add("Daisy");
		
		/* Remove "Mrs. O'Brien" from the list.  */
		servants.remove("Mrs. O'Brien");
		
		/* Gets the size of the array list.  */
		int servantCount = servants.size();		
		System.out.println(servantCount);
		
		/* Prints out current objects of the array list.  */
		for (String servant : servants) {
			System.out.println(servant);
		}
		
		ArrayList<String> aristocrats = new ArrayList<String>();
		aristocrats.add(0, "Lord Robert");
		aristocrats.add(1, "Lady Mary");
		aristocrats.add(2, "Lord Edith");
		aristocrats.add(3, "Lord Sybil");
		/* Lady Grantham is created at index 0, Lord Robert moves to index 1.  */
		aristocrats.add(0, "Lady Grantham"); 
		
		/* Remove object that is currently in index 4, which is "Lady Sybil".  */
		aristocrats.remove(4);
		
		for (String aristocrat : aristocrats) {
			System.out.println(aristocrat);
		}
	}
	
}
