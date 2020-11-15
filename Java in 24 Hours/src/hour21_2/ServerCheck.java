package hour21_2;

import java.io.*;
import java.net.*;
import java.util.*;
/* Incubator APIs are removed in Java 11.  So I should import this.  */
import java.net.http.*;


public class ServerCheck {

	ServerCheck() {
		/* Create an String array of websites.  "http://www.compaq.com" can no longer 
		 * be reached, I put it last because the server will be display as "null", 
		 * and the for loop will break because of invalid websites will cause 
		 * an exception.  In the book, compaq.com was the third index (index 2).  */
		String[] sites = {
				"http://www.apple.com", 
				"http://www.microsoft.com", 
				"http://www.hp.com", 
				"https://oracle.com", 
				"http://www.informit.com", 
				"http://www.stackoverflow.com",
				"http://www.gizmodo.com", 
				"http://www.cnet.com", 
				"http://www.digitaltrends.com", 
				"http://www.makeuseof.com",
				"http://www.compaq.com"
		};
		
		/* While I try to load the websites, I may encounter various errors.  
		 * So I have a try-catch block to catch those errors.  */
		try {
			/* Call the load method.  */
			load(sites);
		}
		catch (URISyntaxException oops) {
			System.out.println("Bad URI:  " + oops.getMessage());
		}
		catch (IOException | InterruptedException e) {
			System.out.println("Error:  " + e.getMessage());
		}
		
	}
	
	
	/* Pass the String array that contains websites to load method.  */
	public void load(String[] rSites) throws URISyntaxException, IOException, InterruptedException {
		
		/* Use for each loop to iterate through each String element in rSites array.  */
		for (String site : rSites) {
			
			System.out.println("\nSite:  " + site);
			
			/* Creates the web client.  */
			HttpClient browser = HttpClient.newHttpClient();
			
			/* Cast the String site as URI.  */
			URI uri = new URI(site);
			
			/* These 2 lines below works for Java 9, I will try a new method.  */
			// HttpRequest.Builder bob = HttpRequest.newBuilder(uri);
			// HttpRequest request = bob.build();
			
			/* Use this method to build a create a build a HTTP request.  */
			HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
			
			/* Longer version, but I don't need to create a URI with site string because 
			 * I already equalize uri variable as site by casting the site variable.  */
			// HttpRequest request = HttpRequest.newBuilder().uri(uri.create(site)).GET().build();
			
			/* Execute the request.  After Java 11, asString() retired, so I use ofString().  */
			HttpResponse<String> response = browser.send(request, HttpResponse.BodyHandlers.ofString());  

			/* Look for a server header.  */
			// HttpHeaders headers = response.headers();
			// Optional<String> server = headers.firstValue("Server");
			
			/* Shorter iteration.  Gets the server of the requested URL in String.  */
			Optional<String> server = response.headers().firstValue("Server");
			
			/* If server is available, print out the server.  */
			if (server.isPresent()) {
				System.out.println("Server:  " + server.get());
			}
			/* Some servers have unidentifiable server, like Oracle.  */
			else {
				System.out.println("Server unidentified");
			}
		}
		
	}
	
	
	/* Main method calls the constructor.  */
	public static void main(String[] args) {
		new ServerCheck();
	}
	
}