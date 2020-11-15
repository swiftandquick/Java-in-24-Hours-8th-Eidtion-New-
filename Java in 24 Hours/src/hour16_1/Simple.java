package hour16_1;

public class Simple {

	class InnerSimple {
		InnerSimple() {
			System.out.println("I am an inner class!  ");
		}
	}
	
	
	public Simple() {
		// Empty constructor.  
	}
	
	
	public static void main(String[] args) {
		/* Create program object with instance of Simple class.  */
		Simple program = new Simple();
		
		/* Create an inner class object inner using an object of the 
		 * outer class.  The object "program" is used to invoke the 
		 * constructor.  */
		Simple.InnerSimple inner = program.new InnerSimple();
	}
	
}
