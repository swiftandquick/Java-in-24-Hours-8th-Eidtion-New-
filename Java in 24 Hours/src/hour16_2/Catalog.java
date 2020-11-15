package hour16_2;

import java.net.*;

import hour14_4.HomePage;

public class Catalog {

	class HomePage {
		String owner;
		URL address;
		String category = "none";
		
		
		public HomePage(String inOwner, String inAddress) 
			throws MalformedURLException {
			owner = inOwner;
			address = new URL(inAddress);
		}
		
		
		public HomePage(String inOwner, String inAddress, String inCategory) 
			throws MalformedURLException {
			this(inOwner, inAddress);
			category = inCategory;
		}
	}
	
	
	public Catalog() {
		/* Creates an object called catalog, that stores an array of objects with 
		 * HomePage instance.  Since HomePage is an inner class of Catalog, I 
		 * type in Catalog.HomePage to create a HomePage array.  */
		Catalog.HomePage[] catalog = new Catalog.HomePage[5];
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
	
	
	/* Calls the Catalog constructor.  */
	public static void main(String[] args) {
		new Catalog();
	}
	
}
