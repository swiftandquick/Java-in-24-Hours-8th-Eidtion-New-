package hour11_1;

public class Gremlin {

	/* gremlinCount is a class variable.  */
	static int gremlinCount = 0;

	/* Every time the constructor is called, increase class variable 
	 * gremlinCount by 1.  */
	public Gremlin() {
		gremlinCount++;
	}
	
	/* Returns the class variable gremlinCount.  */
	static int getGremlinCount() {
		return gremlinCount;
	}

}
