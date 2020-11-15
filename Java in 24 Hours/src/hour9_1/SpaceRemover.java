package hour9_1;

public class SpaceRemover {

	public static void main(String[] args) {
		String mostFamous = "Rudolph the Red-Nosed Reindeer";
		
		/* Converts mostFamous String to an array of characters.  */
		char[] mfl = mostFamous.toCharArray();
		
		for (int dex = 0; dex < mfl.length; dex++) {
			char current = mfl[dex];
			/* If current is not empty space, print current.  */
			if (current != ' ') {
				System.out.print(current);
			}
			/* Otherwise prints out '.' instead of ' '.  */
			else {
				System.out.print('.');
			}
		}
	}
	
}
