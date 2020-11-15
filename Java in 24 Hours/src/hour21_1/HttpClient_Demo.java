package hour21_1;

import java.net.*;
import java.net.http.*;
import java.util.*;
import java.io.*;

public class HttpClient_Demo {

	public static void main(String args[]) {
		
		try {

			URI url = new URI("http://google.com"); 
			
			System.out.println("Site:  " + url);
			
			HttpClient browser = HttpClient.newHttpClient();
			
			/* Requests and build url.  */
			HttpRequest request = HttpRequest.newBuilder(url).build();
			
			/* Gets response from the url that's sent.  This method may cause IOException 
			 * or InterruptedException error, make sure I catch those errors if present.  */
			HttpResponse<String> response = browser.send(request, HttpResponse.BodyHandlers.ofString());
			
			/* Gets information about the server.  */
			Optional<String> server = response.headers().firstValue("Server");
			
			/* Checks if the server is available.  */
			if (server.isPresent()) {
				System.out.println("Server:  " + server.get());
			}
			else {
				System.out.println("Server unidentifiable");
			}
			
		} 
		catch (URISyntaxException e) {
			System.out.println("Website doesn't exist.  ");
		}
		catch (IOException e) {
			// Do nothing.  
		} 
		catch (InterruptedException e) {
			// Do nothing.  
		}
		
	}
	
}
