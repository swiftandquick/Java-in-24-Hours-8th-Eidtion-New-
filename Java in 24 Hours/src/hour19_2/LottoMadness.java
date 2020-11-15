package hour19_2;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LottoMadness extends JFrame {

	/* Creates an instance variable, which is also an LottoEvent object 
	 * named lotto.  Passes in this object as argument.  */
	LottoEvent lotto = new LottoEvent(this);
	
	/* Set up row 1.  */
	JPanel row1 = new JPanel();
	ButtonGroup option = new ButtonGroup();
	JCheckBox quickpick = new JCheckBox("Quick Pick", false);
	/* The personal check box is checked by default.  */
	JCheckBox personal = new JCheckBox("Personal", true);
	/* These components can display and determine the speed of drawing.  */
	JLabel speedLabel = new JLabel("    Drawing Speed", JLabel.RIGHT);
	JTextField speed = new JTextField("100", 6);
	JLabel msLabel = new JLabel("Milliseconds / Draw ", JLabel.LEFT);
	
	/* Set up row 2.  It will be displayed as two rows.  */
	JPanel row2 = new JPanel();
	/* All the text labels will be right leaning.  */
	JLabel numbersLabel = new JLabel("Your picks: ", JLabel.RIGHT);
	JTextField[] numbers = new JTextField[6];
	JLabel winnersLabel = new JLabel("Winners:  ", JLabel.RIGHT);
	JTextField[] winners = new JTextField[6];
	
	/* Set up for row 3.  */
	JPanel row3 = new JPanel();
	JButton stop = new JButton("Stop");
	JButton play = new JButton("Play");
	JButton reset = new JButton("Reset");
	
	/* Set up row 4.  It will be displayed as two rows.  */
	JPanel row4 = new JPanel();
	JLabel got3Label = new JLabel("3 of 6:  ", JLabel.RIGHT);
	JTextField got3 = new JTextField("0");
	JLabel got4Label = new JLabel("4 of 6:  ", JLabel.RIGHT);
	JTextField got4 = new JTextField("0");
	JLabel got5Label = new JLabel("5 of 6:  ", JLabel.RIGHT);
	JTextField got5 = new JTextField("0");
	/* got6 text field is declared to be 10 characters long and others don't have
	 * to, I am not sure why.  */
	JLabel got6Label = new JLabel("6 of 6:  ", JLabel.RIGHT);
	JTextField got6 = new JTextField("0", 10);
	JLabel drawingsLabel = new JLabel("Drawings:  ", JLabel.RIGHT);
	JTextField drawings = new JTextField("0");
	JLabel yearsLabel = new JLabel("Years:  ", JLabel.RIGHT);
	JTextField years = new JTextField();
	
	
	/* Default constructor, most of the codes related to the frame are here.  */
	LottoMadness() {
				
		/* Set the title, size, and default close operation.  */
		super("Lotto Madness");
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Set the default layout as GridLayout. 5 rows and 1 column, basically a
		 * vertical layout for the 4 rows that I put in later.  */
		GridLayout layout = new GridLayout(5, 1, 10, 10);
		setLayout(layout);
	
		/* Add the check boxes to ItemListener. Notice how I put "lotto" in parenthesis
		 * rather than "this", that's because the ItemListener interface is implemented
		 * in the LottoEvent class, and lotto is an object that can be used to refer to
		 * the LottoEvent class.  */
		quickpick.addItemListener(lotto);
		personal.addItemListener(lotto);
		
		/* Add the buttons to ActionListener.  */
		stop.addActionListener(lotto);
		play.addActionListener(lotto);
		reset.addActionListener(lotto);
		
		/* These text fields should not be editable.  */
		got3.setEditable(false);
		got4.setEditable(false);
		got5.setEditable(false);
		got6.setEditable(false);
		drawings.setEditable(false);
		years.setEditable(false);
		
		/* The first row is a FlowLayout, with components align to center. Components
		 * have 10 pixels horizontal distance and 10 pixels vertical distance from each
		 * other.  The last two integer arguments are distance in-between components.  */
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		/* Give row1 (JPanel) a flow layout.  */
		row1.setLayout(layout1);
		/* I need to add these check boxes to row1 (JPanel) as well as the ButtonGroup.  */
		row1.add(quickpick);
		row1.add(personal);
		/* While I can't add ButtonGroup, I can add CheckBoxes to them as exclusive
		 * options, so I can only choose one of the CheckBoxes inside the ButtonGroup.  */
		option.add(quickpick);
		option.add(personal);
		/* These components can display and determine the speed of drawing.  */
		/* Add the new components to row1.  */
		row1.add(speedLabel);
		row1.add(speed);
		row1.add(msLabel);
		/* Don't forget to add the entire row (JPanel with name of row1) at the end.  */	
		add(row1);
	
		/* The second row is a 2 rows by 7 columns GridLayout. */
		GridLayout layout2 = new GridLayout(2, 7, 10, 10);
		row2.setLayout(layout2);
		row2.add(numbersLabel);
		/* Use for loop to add the array of JTextFields.  */
		for (int i = 0; i < numbers.length; i++) {
			/* I need to set the index of the array element (an object type of JTextField)
			 * to new JTextField, because these objects weren't declared properly while 
			 * an empty array of JTextField is created.  If I don't do this, I will get a
			 * NullPointerException because object isn't declared properly.  */
			numbers[i] = new JTextField();
			row2.add(numbers[i]);
		}
		row2.add(winnersLabel);
		/* Use for loop to add the array of JTextFields again.  */
		for (int i = 0; i < winners.length; i++) {
			/* Declaring each element in the JTextField array properly to prevent
			 * NullPointerException error. The same why is already stated above.  */
			winners[i] = new JTextField();
			/* For a JTextField object, which is a text field, it is editable by default, I
			 * can use setEditable(false) to make it non-editable.  */
			winners[i].setEditable(false);
			row2.add(winners[i]);
		}
		add(row2);
		
		/* The third row is just a FlowLayout with 3 JButtons.  */
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row3.setLayout(layout3);
		stop.setEnabled(false);
		row3.add(stop);
		row3.add(play);
		row3.add(reset);
		add(row3);
		
		/* The fourth row is a GridLayout that has 2 rows and 6 columns.  */
		GridLayout layout4 = new GridLayout(2, 6, 10, 10);
		row4.setLayout(layout4);
		row4.add(got3Label);
		row4.add(got3);
		row4.add(got4Label);
		row4.add(got4);
		row4.add(got5Label);
		row4.add(got5);
		row4.add(got6Label);
		row4.add(got6);
		row4.add(drawingsLabel);
		row4.add(drawings);
		row4.add(yearsLabel);
		row4.add(years);
		add(row4);
		
	}
	
	
	/* Method that sets outlook of the frame.  */
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			// Do nothing.  
		}
	}
	
	
	/* Main method.  */
	public static void main(String args[]) {
		/* Create a named LottoMadness object called frame. This line is mainly to
		 * invoke the constructor, where most important frame-related codes are hold.  */
		LottoMadness frame = new LottoMadness();
		/* Set look and feel for the frame, I can also invoke by using
		 * LottoMadness.setLookAndFeel(), but then I have to set the method static as I
		 * am calling from a static method.  */
		frame.setLookAndFeel();
		/* Set the LottoMadness object visible, means the JFrame will be visible.  */
		frame.setVisible(true);
		
	}
		
}