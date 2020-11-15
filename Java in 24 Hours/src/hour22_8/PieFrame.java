package hour22_8;

import javax.swing.*;
import java.awt.*;

/* The file names might sound similar, but this package is about 
 * student loans in billions of dollars.  
 * Green:  $101 billions is the amount repaid by students.  
 * Yellow:  $68 billions is the amount loaned to students still in school.  
 * Blue:  $91 billions is the amount loaned to students making payments.  
 * Red:  $25 billions is the amount loaned to students who defaulted (defaulters).  
 * */
@SuppressWarnings("serial")
public class PieFrame extends JFrame {

	PieFrame() {
		super("Student Loans");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		/** Creates a PiePanel object called loans, since PiePanel is 
		 * a subclass of JPanel, I can add it to layout.  */
		PiePanel loans = new PiePanel(4);
		loans.addSlice(Color.green, 101F);
		loans.addSlice(Color.yellow, 68F);
		loans.addSlice(Color.blue, 91F);
		loans.addSlice(Color.red, 25F);
		add(loans);
		
	}
	
	
	public static void main(String[] args) {
		PieFrame frame = new PieFrame();
		frame.setVisible(true);
	}
	
}
