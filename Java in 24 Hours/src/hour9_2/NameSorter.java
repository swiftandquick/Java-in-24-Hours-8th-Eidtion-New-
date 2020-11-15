package hour9_2;

import java.util.Arrays;

public class NameSorter {

	public static void main(String[] args) {
		String names[] = { "Glimmer", "Marvel", "Rue", "Clove", 
				"Thresh", "Foxface", "Cato", "Peeta", "Katniss" };
		System.out.println("The original order:  ");
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ":  " + names[i]);
		}		
		System.out.println();
		
		/* Sorts the String array in alphabetical order.  */
		Arrays.parallelSort(names);
		System.out.println("The new order:  ");
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + ":  " + names[i]);
		}
		System.out.println();
	}
	
}
