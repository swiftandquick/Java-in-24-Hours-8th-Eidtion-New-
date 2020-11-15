package hour6_2;

public class Favorite {

	public static void main(String[] args) {
		System.out.println("What is Fin's favorite shark-killing weapon?  ");
		String favorite = "chainsaw";
		String guess = "pool cue";
		
		System.out.print("Is Fin's favorite weapon " + guess + "?  ");
		/* Prints false because favorite != guess.  */
		System.out.println(favorite.equals(guess));
		
		/* Set guess equals to favorite.  */
		guess = favorite;
		System.out.println("Fin's favorite weapon is " + guess + "");
	}
	
}