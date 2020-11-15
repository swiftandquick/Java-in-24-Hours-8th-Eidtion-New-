package hour10_2;

public class Commodore64Modem extends Modem {

	String method = "Commodore 64 modem.  ";
	
	public void connect() {
		System.out.println("Connecting to the Internet...  ");
		System.out.println("Using a " + method);
	}
	
	public void disconnect() {
		System.out.println("Disconnecting from the Internet...  ");
	}
	
}
