package hour17_4;

import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class FreeSpacePanel extends JPanel {

	JLabel spaceLabel = new JLabel("Disk space:  ");
	JLabel space = new JLabel();
	
	
	public FreeSpacePanel() {
		super();
		add(spaceLabel);
		add(space);
		try {
			setValue();
		}
		catch (IOException ioe) {
			space.setText("Error");
		}
	}
	
	
	private final void setValue() throws IOException {
		// Get the current file storage pool.  
		Path current = Paths.get("");
		FileStore store = Files.getFileStore(current);
		// Find the free storage space.  
		long totalSpace = store.getTotalSpace();
		long freeSpace = store.getUsableSpace();
		// Get this as a percentage (with two digits)
		double percent = (double) freeSpace / (double)totalSpace * 100;
		percent = (int) (percent * 100) / (double) 100;
		
		/* Convert long to String.  */
		String freeSpaceStr = freeSpace + "";
		String totalSpaceStr = totalSpace + "";
		
		/* Convert String to char array.  */
		char[] freeSpaceCA = freeSpaceStr.toCharArray();
		char[] totalSpaceCA = totalSpaceStr.toCharArray();
		
		/* These two variables will be printed at the end, both variables 
		 * starts off as empty Strings.  */
		String freeSpaceFinal = "";
		String totalSpaceFinal = "";
		
		/* Start counting from last index, add "," every 3 digits.  */
		for (int i = freeSpaceCA.length - 1; i >= 0; i--) {
			freeSpaceFinal = freeSpaceCA[i] + freeSpaceFinal;
			if (i % 3 == 0 && i != 0) {
				freeSpaceFinal = "," + freeSpaceFinal;
			}
		}

		for (int i = totalSpaceCA.length - 1; i >= 0; i--) {
			totalSpaceFinal = totalSpaceCA[i] + totalSpaceFinal;
			if (i % 3 == 0 && i != 0) {
				totalSpaceFinal = "," + totalSpaceFinal;
			}
		}
		
		// Set the label's text.  
		space.setText(freeSpaceFinal + " free out of " + totalSpaceFinal + " (" + percent + "%)");
	}
	
}
