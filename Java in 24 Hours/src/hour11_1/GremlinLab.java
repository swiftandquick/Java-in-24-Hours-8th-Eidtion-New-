package hour11_1;

/* Run -> Run Configuration...  
 * Set argument as 76000000.  */

public class GremlinLab {

	public static void main(String[] args) {
		int numGremlins = Integer.parseInt(args[0]);
		if (numGremlins > 0) {
			/* Create an array of Gremlin objects called gremlins.  */
			Gremlin[] gremlins = new Gremlin[numGremlins];
			/* Loops 76000000 times, call the constructor each iteration.  */
			for (int i = 0; i < numGremlins; i++) {
				/* For each iteration, create a new object and call the constructor.  */
				gremlins[i] = new Gremlin();
			}
			/* Use class name Gremlin to invoke the getGremlinCount() method.  */
			System.out.println("There are " + Gremlin.getGremlinCount() + " gremlins.  ");
		}
	}
	
}
