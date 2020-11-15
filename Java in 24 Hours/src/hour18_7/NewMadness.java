package hour18_7;

import java.awt.*;
import javax.swing.*;

public class NewMadness extends JFrame {

	// Set up row 1.  
	JPanel row1 = new JPanel();
	JComboBox<String> option = new JComboBox<String>();
	
	// Set up row 2.  
	JPanel row2 = new JPanel();
	JLabel numbersLabel = new JLabel("Your picks:  ", JLabel.RIGHT);
	/* 6 text fields.  */
	JTextField[] numbers = new JTextField[6];
	JLabel winnersLabel = new JLabel("Winners:  ", JLabel.RIGHT);
	/* 6 text fields.  */
	JTextField[] winners = new JTextField[6];
	
	// Set up row 3
	JPanel row3 = new JPanel();
	ButtonGroup btnGroup = new ButtonGroup();
	JCheckBox stop = new JCheckBox("Stop");
	JCheckBox play = new JCheckBox("Play");
	JCheckBox reset = new JCheckBox("Reset");
	
	// Set up row 4
	JPanel row4 = new JPanel();
	JLabel got3Label = new JLabel("3 of 6:  ", JLabel.RIGHT);
	JTextField got3 = new JTextField("0");
	JLabel got4Label = new JLabel("4 of 6:  ", JLabel.RIGHT);
	JTextField got4 = new JTextField("0");
	JLabel got5Label = new JLabel("5 of 6:  ", JLabel.RIGHT);
	JTextField got5 = new JTextField("0");
	JLabel got6Label = new JLabel("6 of 6:  ", JLabel.RIGHT);
	JTextField got6 = new JTextField("0");
	JLabel drawingsLabel = new JLabel("Drawings:  ", JLabel.RIGHT);
	JTextField drawings = new JTextField("0");
	JLabel yearsLabel = new JLabel("Years:  ", JLabel.RIGHT);
	JTextField years = new JTextField();
	
	
	public NewMadness() {
		super("Lotto Madness");
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* GridLayout:  5 rows and 1 column.  */
		GridLayout layout = new GridLayout(5, 1, 10, 10);
		setLayout(layout);
		
		// Row 1.  
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		/* ButtonGroup option includes two check boxes, I can only check one check boxes.  */
		option.addItem("Quick Pick");
		option.addItem("Personal");
		row1.setLayout(layout1);
		row1.add(option);
		add(row1);
		
		// Row 2.  
		/* GridLayout:  2 rows and 7 columns.  */
		GridLayout layout2 = new GridLayout(2, 7, 10, 10);
		row2.setLayout(layout2);
		row2.add(numbersLabel);
		/* Adds an array of 6 text fields (numbers).  */
		for (int i = 0; i < 6; i++) {
			numbers[i] = new JTextField();
			row2.add(numbers[i]);
		}
		row2.add(winnersLabel);
		for (int i = 0; i < 6; i++) {
			winners[i] = new JTextField();
			// I cannot edit any of the winners text field.  
			winners[i].setEditable(false);
			row2.add(winners[i]);
		}
		add(row2);
		
		// Row 3.  
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row3.setLayout(layout3);
		/* The stop button is initially unclickable.  */
		btnGroup.add(stop);
		btnGroup.add(play);
		btnGroup.add(reset);
		stop.setEnabled(false);
		row3.add(stop);
		row3.add(play);
		row3.add(reset);
		add(row3);
		
		// Row 4.  
		/* GridLayout:  2 rows and 3 columns.  */
		GridLayout layout4 = new GridLayout(2, 3, 20, 10);
		row4.setLayout(layout4);
		row4.add(got3Label);
		got3.setEditable(false);
		row4.add(got3);
		row4.add(got4Label);
		got4.setEditable(false);
		row4.add(got4);
		row4.add(got5Label);
		got5.setEditable(false);
		row4.add(got5);
		row4.add(got6Label);
		got6.setEditable(false);
		row4.add(got6);
		row4.add(drawingsLabel);
		drawings.setEditable(false);
		row4.add(drawings);
		row4.add(yearsLabel);
		years.setEditable(false);
		row4.add(years);
		add(row4);
		
		setVisible(true);
	}
	
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception exc) {
			// Ignore error.  
		}
	}
	
	
	public static void main(String[] args) {
		NewMadness frame = new NewMadness();
		frame.setLookAndFeel();
	}
}