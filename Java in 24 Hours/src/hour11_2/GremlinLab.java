package hour11_2;

/* Run -> Run Configuration...  
 * Set argument as 76000000.  */

public class GremlinLab {

	public static void main(String[] args) {
		int numGremlins = Integer.parseInt(args[0]);
		if (numGremlins > 0) {
			Gremlin2[] gremlins = new Gremlin2[numGremlins];
			for (int i = 0; i < numGremlins; i++) {
				gremlins[i] = new Gremlin2();
			}
			System.out.println("There are " + Gremlin2.getGremlinCount() + " gremlins.  ");
		}
		
		Gremlin2 newGrem = new Gremlin2();
		
		/* 1000001 is between 1000000 and 9999999, so I set instance variable guid to 10000001.  */
		newGrem.setGuid(1000001);
		
		/* Retrieves the instance variable guid.  */
		int guid = newGrem.getGuid();
		System.out.println("newGrem's guid value is:  " + guid);
		
		/* Print gremlinCount again, because another object, newGrem is created, so getGremlinCount() 
		 * should return 76000001.  */
		System.out.println("There are " + Gremlin2.getGremlinCount() + " gremlins.  ");
		
	}
	
}
