package hour21_4;

import java.io.*;
import java.net.*;
import java.net.http.*;

public class SalutonVerkisto {

	/* The website I went to says it has an error, I believe it's intentional.  */
	String site = "http://workbench.cadenhead.org/post-a-comment.php";
	
	SalutonVerkisto() {
		try {
			postMessage(site);
		}
		catch (URISyntaxException e) {
			System.out.println("Bad URI:  " + e.getMessage());
		}
		catch (IOException | InterruptedException e) {
			System.out.println("Error:  " + e.getMessage());
		}
	}
	
	
	public void postMessage(String rSite) throws URISyntaxException, IOException, InterruptedException {
		
		URI url = new URI(rSite);
		HttpClient browser = HttpClient.newHttpClient();
		
		/* Set up the message.  */
		String yourName = "Sam Snett of Indianapolis";
		String yourMessage = "Your book is pretty good, if I do say so myself.  ";
		
		/* Encode the message.  */
		// Outdated method.  
		/* HttpRequest.BodyProcessor proc = HttpRequest.BodyProcessor.fromString(
				"name=" + URLEncoder.encode(yourName, "UTF-8") + 
				"&comment=" + URLEncoder.encode (yourMessage, "UTF-8") + 
				"&mode=" + URLEncoder.encode("demo", "UTF-8")
		); */
		
		/* "ofString" converts everything in UTF-8 format, so I don't need URLEncoder 
		 * method to change anything, I can just add the things in.  The purpose of 
		 * "demo" lets the server script know the purpose of the message.  I heard 
		 * "demo" is to used against spammers by weeding them out.  */
		HttpRequest.BodyPublisher proc = HttpRequest.BodyPublishers.ofString(
				"name=" + yourName + "&comment=" + yourMessage + "&mode=" + "demo");
		
		/* Prepare the request.  I can user Builder to the build the request 
		 * by adding headers and other things first before I actually request it.  
		 * I stored the builder in the Builder object called newBuild.  
		 * 
		 * First header method sets a request header called Content-Type to the value 
		 * "application/x-www-form-urlencoded".  This tells the server that a web form 
		 * is being sent.  
		 * 
		 * Second header() sets Accept to "text/plain", the MIME type of the request.  
		 * 
		 * Post(HttpRequest.BodyProcessor) formats the encoded message as an HTTP POST 
		 * request.  Parameters are passed as the body of the request, not URL.  
		 */ 
		HttpRequest.Builder newBuild = HttpRequest
				.newBuilder(url)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Accept", "text/plain")
				.POST(proc);
		
		/* Finish the request.  */
		HttpRequest request = newBuild.build();
		
		/* Get the response from the server.  */
		HttpResponse<String> response = browser.send(request, HttpResponse.BodyHandlers.ofString());
		
		/* Get the method(), it should be POST.  I appended POST(proc) to the 
		 * newBuild Builder object.  Then, I print out the body of the HttpResponse 
		 * object response using the body() method.  */
		System.out.println("Method:  " + request.method());
		System.out.println(response.body());
		
		/* I get the output from other people, but my output was never published.  
		 * I think I am only supposed to get a response.  I am not sure.  */
		
	}
	
	
	/* Call the constructor.  */
	public static void main(String args[]) {
		new SalutonVerkisto();
	}
	
}
