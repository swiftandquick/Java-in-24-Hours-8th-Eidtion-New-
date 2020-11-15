package hour14_4;

import java.net.*;

public class HomePage {

	String owner;
	URL address;
	/* Default value for category is none.  */
	String category = "none";
	
	/* Since category is not being set, if this constructor is called, 
	 * category will remain as none.  */
	/* Both constructors throw MalformedURLException in case if the 
	 * inAddress cannot be converted to URL.  */
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
