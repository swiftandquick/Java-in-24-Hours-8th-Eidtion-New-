package hour6_3;

public class Credits {

	public static void main(String[] args) {
		String title = "Sharknado";
		int year = 2013;
		String director = "Anthony Ferrante";
		String role1 = "Fin";
		String actor1 = "Ian Ziering";
		String role2 = "April";
		String actor2 = "Tara Reid";
		String role3 = "George";
		String actor3 = "Joyhn Heard";
		String role4 = "Nova";
		String actor4 = "Cassie Scerbo";
		
		// Display information.  
		System.out.println(title + " (" + year + ")\n" + 
				"An " + director.toUpperCase() + " film.\n\n" + 
				role1 + "\t" + actor1.toUpperCase() + "\n" +  
				role2 + "\t" + actor2.toUpperCase() + "\n" +  
				role3 + "\t" + actor3.toUpperCase() + "\n" + 
				role4 + "\t" + actor4.toUpperCase());
				
	}
	
}
