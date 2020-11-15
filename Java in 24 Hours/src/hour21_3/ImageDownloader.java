package hour21_3;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.nio.file.*; // This should be for using I/O stream on the net.  


/** This program downloads an image from the Internet to the same package as ImageDownlaoder.java, the image downloaded is in 
 * C:\Users\Yong Chen\Desktop\Eclipse Work Space\Java in 24 Hours\Java in 24 Hours\src\com\java24hours\hour21\p3  */
public class ImageDownloader {

	ImageDownloader() {
		/* The web page no longer exists, I will find another one.  */
		// String urlString = "http://workbench.cadenhead.org/media/lighthouse.jpg/ ";
		/* If the link no longer works, I will have to find another one.  */
		String urlString = "https://upload.wikimedia.org/wikipedia/commons/e/ef/Basco_Lighthouse%2C_Day_Photo.jpg";
		try {
			/* Call the load method and pass in one argument, the String that represents image's URL.  */
			load(urlString);
		}
		catch (URISyntaxException e) {
			System.out.println("Bad URI:  " + e.getMessage());
		}
		catch (IOException | InterruptedException e) {
			System.out.println("Error:  " + e.getMessage());
		}
	}
	
	
	/* Throws possible exceptions, which will be caught in the constructor.  */
	public void load(String rUrlString) throws URISyntaxException, IOException, InterruptedException {
		
		/* Converts String to URI.  */
		URI url = new URI(rUrlString);
		HttpClient browser = HttpClient.newHttpClient();
		
		/* Creates a jpg file in the same package as this java file.  Path object 
		 * temp can be used to create a file in the same package as this java file.  
		 * I don't need to specify the path for reasons state above, so I only need 
		 * to put down what the file name is.  Inside the argument of the createTempFile() 
		 * method, the first argument is file name, the second argument is file type.  
		 * The reason why Path is used to create temporary file rather than File is 
		 * because HttpResponse and nio.file don't support File type.  */
		Path temp = Files.createTempFile("lighthouse", ".jpg");
		
		HttpRequest request = HttpRequest.newBuilder(url).build();
		
		/* Since I am getting the path rather than the String, format is a bit different.  */
		@SuppressWarnings("unused")
		HttpResponse<Path> response = browser.send(request, HttpResponse.BodyHandlers.ofFile(temp));
		
		/* Creates a new File object perm, it has the same name, path, and attribute as temp.  
		 * The purpose is to replace the temp via rename() method.  */
		File perm = new File("src/hour21_3/lighthouse.jpg");
		
		/* Note:  This may not be the case.  
		 * Convert temp from Path to File, then let it be replaced by perm.  I don't have to 
		 * create the perm file using createNewFile(), I can just rename the Object name temp 
		 * to perm, since temp is already created using the createTempFile() method.  Doing this 
		 * will make the temporary file permanent.  */
		temp.toFile().renameTo(perm);
		
		System.out.println("Image moved to " + perm.getAbsolutePath());
		
	}
	
	
	public static void main(String[] args) {
		new ImageDownloader();
	}
	
}
