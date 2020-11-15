package hour10_2;

public class DslModem extends Modem {

	String method = "DSL phone connection";
	
	public void connect() {
		System.out.println("Connecting to the Internet...  ");
		System.out.println("Using a " + method);
	}
	
}
