package hour12_4;

public class FootballPlayer_Demo {

	public static void main(String[] args) {
		
		Lineman player1 = new Lineman(15);
		player1.displayNumber();
		player1.block();

		WideReceiver player2 = new WideReceiver(16);
		player2.displayNumber();
		player2.speed();

		TightEnd player3 = new TightEnd(18);
		player3.displayNumber();
		player3.block();
		
		RunningBack player4 = new RunningBack(24);
		player4.displayNumber();
		player4.speed();
		
		Quarterback player5 = new Quarterback(27);
		player5.displayNumber();
		player5.qb();
	}
	
}
