package hour10_2;

public class ModemTester {

	public static void main(String[] args) {
		
		/* Create object surfBoard using CableModem class as template.  */
		CableModem surfBoard = new CableModem();
		
		/* Create object gateway using DslModem class as template.  */
		DslModem gateway = new DslModem();
		
		Commodore64Modem c64 = new Commodore64Modem();
		
		/* CableModem is a subclass of Modem, so CableModem inherits the 
		 * speed attribute (instance variable) as well.  */
		surfBoard.speed = 500000;
		gateway.speed = 400000;
		c64.speed = 1000;
		
		System.out.println("Trying the cable modem:  ");
		/* CableModem is a subclass of Modem, so CableModem inherits the 
		 * displaySpeed() method as well.  */
		surfBoard.displaySpeed();
		/* Use object surfBoard to call the connect() method.  */
		surfBoard.connect();
		
		System.out.println("Trying the DSL modem:  ");
		gateway.displaySpeed();
		gateway.connect();
		
		System.out.println("Trying the Commodore 64 modem:  ");
		c64.displaySpeed();
		c64.connect();
		c64.disconnect();
		
	}
	
}
