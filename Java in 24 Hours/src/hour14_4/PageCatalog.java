package hour14_4;

import java.net.*;

public class PageCatalog {

	public static void main(String[] args) {
		/* Creates a catalog array to store 5 objects of HomePage type.  */
		HomePage[] catalog = new HomePage[5];
		try {
			/* First 4 elements calls the second constructor.  */
			catalog[0] = new HomePage("Mike Glyer", 
					"http://www.file770.com", "science fiction");
			catalog[1] = new HomePage("Shelley Powers", 
					"http://burningbird.net", "environment");
			catalog[2] = new HomePage("Rogers Cadenhead", 
					"http://workbench.cadenhead.org", "programming");
			catalog[3] = new HomePage("Taegan Goddard", 
					"https://politicalwire.com", "politics");
			/* Last elements calls first constructor.  */
			catalog[4] = new HomePage("Manton Reese", 
					"http://www.manton.org");
			/* Print out the owner, address, and category of each website.  */
			for (int i = 0;  i < catalog.length; i++) {
				System.out.println(catalog[i].owner + ":  " + 
						catalog[i].address + " -- " + 
						catalog[i].category);
			}
		}
		/* Catches the MalformedURLException that is thrown in the constructors.  */
		catch (MalformedURLException e) {
			System.out.println("Error:  " + e.getMessage());
		}
	}
	
}
