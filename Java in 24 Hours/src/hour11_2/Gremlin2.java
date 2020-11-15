package hour11_2;

public class Gremlin2 {

	static int gremlinCount = 0;
	private int guid;
	
	public Gremlin2() {
		gremlinCount++;
	}
	
	public void setGuid(int guid) {
		if (guid >= 1000000 && guid <= 9999999) {
			this.guid = guid;
		}
	}
	
	public int getGuid() {
		return guid;
	}
	
	static int getGremlinCount() {
		return gremlinCount;
	}
	
}
