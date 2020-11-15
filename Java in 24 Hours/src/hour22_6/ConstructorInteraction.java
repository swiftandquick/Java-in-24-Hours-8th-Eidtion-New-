package hour22_6;

public class ConstructorInteraction {
	
	int instanceNum;
	
	ConstructorInteraction(int rNum) {
		instanceNum = rNum;
	}
	
	public void printNum () {
		System.out.println(instanceNum);
	}
	
	public static void main(String args[]) {
		int num = 5;
		ConstructorInteraction object = new ConstructorInteraction(num);
		object.printNum();
	}
	
}