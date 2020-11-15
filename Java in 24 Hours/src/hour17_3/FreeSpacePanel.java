package hour17_3;

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
		// Set the label's text.  
		space.setText(freeSpace + " free out of " + totalSpace + " (" + percent + "%)");
	}
	
}
