package hour22_5;

/* Run -> Run Configurations.  
 * Type in the following as argument:  
 * 	" 0xCC 0xCC 0x99 1350 
	0xCC 0x66 0xFF 1221 
	0x66 0x66 0x99 316 
	0x66 0x99 0x66 251 
	0x66 0x66 0x99 201 
	0x33 0xFF 0xFF 193 
	0x00 0x99 0x66 173 
	0x33 0xCC 0xCC 164 
	0x66 0x33 0x99 143 
	0x99 0x66 0x33 127 "
*/

public class ArgumentPractice {

	public static void main(String[] args) {
		
		int colorArgs[] = new int[args.length / 4 * 3];
		int sizeArgs[] = new int[args.length / 4]; 
		
		/** colorIndex and sizeIndex starts at 0.  */
		int colorIndex = 0;
		int sizeIndex = 0;
		
		for(int i = 0; i < args.length; i++) {
			/** For size.  Because every 4th argument is about size.  */
			if ((i + 1) % 4 == 0) {
				sizeArgs[sizeIndex] = Integer.parseInt(args[i]);
				System.out.println(sizeArgs[sizeIndex]);
				sizeIndex++;
			}
			/** Otherwise, the index will be converted to hexadecimal and 
			 * be added to color.  */
			else {
				/** Program can't convert a String to int when there is "0x" 
				 * in front of it, so I must get rid of it first.  */
				args[i] = args[i].replace("0x", "");
				colorArgs[colorIndex] = Integer.parseInt(args[i], 16);
				System.out.print(colorArgs[colorIndex] + " ");
				colorIndex++;
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < sizeArgs.length; i++) {
			System.out.println(colorArgs[i * 3] + ", " + colorArgs[i * 3 + 1] + ", " + colorArgs[i * 3 + 2] + ", " + sizeArgs[i]);
		}
		
	}
	
}
