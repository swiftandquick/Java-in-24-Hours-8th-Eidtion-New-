package hour20_11;

/* Run -> Run Configurations.  
 * Type in "src/hour20_11/file1.txt src/hour20_11/file2.txt" in arguments.  */

import java.io.*;

public class Copier {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: Copier filename1 filename2");
		}
		else {
			try {
				File inFile = new File(args[0]);
				FileInputStream in = new FileInputStream(inFile);
				File outFile = new File(args[1]);
				FileOutputStream out = new FileOutputStream(outFile);
				boolean eof = false;
				while (!eof) {
					int input = in.read();
					if (input == -1) {
						eof = true;
					}
					else {
						out.write(input);
					}
				}
				in.close();
				out.close();
			}
			catch (IOException e) {
				System.out.println("Error -- " + e.toString());
			}
		}
	}
	
}
