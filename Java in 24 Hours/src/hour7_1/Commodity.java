package hour7_1;

public class Commodity {

	public static void main(String[] args) {
		String command = "BUY";
		int balance = 550;
		int quantity = 42;
		
		/* command has value of "BUY" so case "BUY" is executed.  */
		switch (command) {
			case "BUY":
				quantity += 5;
				balance -= 20;
				break;
			case "SELL":
				quantity -= 5;
				balance += 15;
				break;
		}
		System.out.println("Balance  $" + balance + "\n"
				+ "Quantity:  " + quantity);
	}
	
}
