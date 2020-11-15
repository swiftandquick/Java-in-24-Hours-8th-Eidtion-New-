package hour12_4;

public class Lineman extends Defensive {

	public Lineman(int number) {
		super(number);
	}

	public void block() {
		super.block();
		System.out.println("This is a lineman.  ");
	}
	
}
