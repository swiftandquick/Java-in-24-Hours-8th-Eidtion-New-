package hour21_5;


import java.io.*;
import java.net.*;
import java.util.*;
import java.net.http.*;

public class ServerCheck {
    public ServerCheck() {
        String[] sites = {
            "https://www.apple.com/",
            "https://www.microsoft.com/",
            "https://www8.hp.com/",
            "https://www.oracle.com/",
            "https://www.informit.com/",
            "https://www.dell.com/",
            "https://www.lenovo.com",
            "https://www.intel.com/",
            "https://www.logitech.com/",
            "https://www.java.com/"
        };
        try {
            load(sites);
        } catch (URISyntaxException oops) {
            System.out.println("Bad URI: " + oops.getMessage());
        } catch (IOException | InterruptedException oops) {
            System.out.println("Error: " + oops.getMessage());
        }
    }
    
    public final void load(String[] sites) throws URISyntaxException, IOException,
            InterruptedException {
        
        for (String site : sites) {
            System.out.println("\nSite: " + site);
            // Create the web client. 
            HttpClient browser = HttpClient.newHttpClient();

            // Build a request for a website.  
            URI uri = new URI(site);
            HttpRequest.Builder bob = HttpRequest.newBuilder(uri);
            HttpRequest request = bob.build();

            // Execute the request
            HttpResponse<String> response = browser.send(request,
                HttpResponse.BodyHandlers.ofString());
            
            /* Get the Content-Type and Content-Encoding as well.  */
            String[] header = {
                "Server", "Content-Type", "Content-Encoding"
            };
            for (int i = 0; i < header.length; i++) {
                // Look for a server header.  
                HttpHeaders headers = response.headers();
                Optional<String> hdr = headers.firstValue(header[i]);
                if (hdr.isPresent()) {
                    System.out.println(header[i] + ": " + hdr.get());
                } else {
                    System.out.println(header[i] + " not identified");
                }
            }
        }
    }
    
    
    public static void main(String[] arguments) {
        new ServerCheck();
    }
}