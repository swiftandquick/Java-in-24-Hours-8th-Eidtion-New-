package hour19_3;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LottoMadness extends JFrame {

	LottoEvent lotto = new LottoEvent(this);
	
	JPanel row1 = new JPanel();
	ButtonGroup option = new ButtonGroup();
	JCheckBox quickpick = new JCheckBox("Quick Pick", false);
	JCheckBox personal = new JCheckBox("Personal", true);
	JLabel speedLabel = new JLabel("    Drawing Speed", JLabel.RIGHT);
	JTextField speed = new JTextField("100", 6);
	JLabel msLabel = new JLabel("Milliseconds / Draw ", JLabel.LEFT);
	
	JPanel row2 = new JPanel();
	JLabel numbersLabel = new JLabel("Your picks: ", JLabel.RIGHT);
	/* The new lottery draws only 5 numbers.  */
	JTextField[] numbers = new JTextField[5];
	JLabel winnersLabel = new JLabel("Winners:  ", JLabel.RIGHT);
	JTextField[] winners = new JTextField[5];
	
	JPanel row3 = new JPanel();
	JButton stop = new JButton("Stop");
	JButton play = new JButton("Play");
	JButton reset = new JButton("Reset");
	
	JPanel row4 = new JPanel();
	JLabel got3Label = new JLabel("3 of 5:  ", JLabel.RIGHT);
	JTextField got3 = new JTextField("0");
	JLabel got4Label = new JLabel("4 of 5:  ", JLabel.RIGHT);
	JTextField got4 = new JTextField("0");
	JLabel got5Label = new JLabel("5 of 5:  ", JLabel.RIGHT);
	
	JPanel row5 = new JPanel();
	JTextField got5 = new JTextField("0");
	JLabel drawingsLabel = new JLabel("Drawings:  ", JLabel.RIGHT);
	JTextField drawings = new JTextField("0");
	JLabel yearsLabel = new JLabel("Years:  ", JLabel.RIGHT);
	JTextField years = new JTextField();
	
	
	LottoMadness() {
		super("Lotto Madness");
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(5, 1, 10, 10);
		setLayout(layout);
	
		quickpick.addItemListener(lotto);
		personal.addItemListener(lotto);
		
		stop.addActionListener(lotto);
		play.addActionListener(lotto);
		reset.addActionListener(lotto);
		
		got3.setEditable(false);
		got4.setEditable(false);
		got5.setEditable(false);
		drawings.setEditable(false);
		years.setEditable(false);
		
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row1.setLayout(layout1);
		row1.add(quickpick);
		row1.add(personal);
		option.add(quickpick);
		option.add(personal);
		row1.add(speedLabel);
		row1.add(speed);
		row1.add(msLabel);	
		add(row1);
	
		/* The second row is a 2 rows by 6 columns GridLayout. */
		GridLayout layout2 = new GridLayout(2, 6, 10, 10);
		row2.setLayout(layout2);
		row2.add(numbersLabel);
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new JTextField();
			row2.add(numbers[i]);
		}
		row2.add(winnersLabel);
		for (int i = 0; i < winners.length; i++) {
			winners[i] = new JTextField();
			winners[i].setEditable(false);
			row2.add(winners[i]);
		}
		add(row2);
		
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
		row3.setLayout(layout3);
		stop.setEnabled(false);
		row3.add(stop);
		row3.add(play);
		row3.add(reset);
		add(row3);
		
		GridLayout layout4 = new GridLayout(1, 6, 10, 10);
		row4.setLayout(layout4);
		row4.add(got3Label);
		row4.add(got3);
		row4.add(got4Label);
		row4.add(got4);
		row4.add(got5Label);
		row4.add(got5);
		add(row4);
		
		GridLayout layout5 = new GridLayout(1, 4, 10, 10);	
		row5.setLayout(layout5);
		row5.add(drawingsLabel);
		row5.add(drawings);
		row5.add(yearsLabel);
		row5.add(years);
		add(row5);
		
	}
	
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			// Do nothing.  
		}
	}
	
	
	public static void main(String args[]) {
		LottoMadness frame = new LottoMadness();
		frame.setLookAndFeel();
		frame.setVisible(true);
		
	}
		
}