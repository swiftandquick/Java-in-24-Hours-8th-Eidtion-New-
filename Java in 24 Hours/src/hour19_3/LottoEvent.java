package hour19_3;

import javax.swing.*;
import java.awt.event.*;


public class LottoEvent implements ActionListener, ItemListener, Runnable {
	
	LottoMadness gui;
	Thread playing;
	

	LottoEvent(LottoMadness in) {
		gui = in;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equalsIgnoreCase("Play")) {
			startPlaying();
		}
		if (command.equalsIgnoreCase("Stop")) {
			stopPlaying();
		}
		if (command.equalsIgnoreCase("Reset")) {
			clearAllFields();
		}
	}
	
	
	public void startPlaying() {
		playing = new Thread(this);
		playing.start();
		
		gui.play.setEnabled(false);
		gui.stop.setEnabled(true);
		gui.reset.setEnabled(false);
		gui.quickpick.setEnabled(false);
		gui.personal.setEnabled(false);	
		gui.speed.setEnabled(false);

		/* Only 5 numbers are drawn.  */	
		for (int i = 0; i < 5; i++) {
			gui.numbers[i].setEnabled(false);
		}
		
	}
	
	
	public void stopPlaying() {
		gui.stop.setEnabled(false);
		gui.play.setEnabled(true);
		gui.reset.setEnabled(true);
		gui.quickpick.setEnabled(true);
		gui.personal.setEnabled(true);
		gui.speed.setEnabled(true);
		
		/* Only 5 numbers are drawn.  */		
		for (int i = 0; i < 5; i++) {
			gui.numbers[i].setEnabled(true);
		}
		playing = null;
	}
	
	
	public void clearAllFields() {
		/* Only 5 numbers are drawn.  */
		for (int i = 0; i < 5; i++) {
			gui.numbers[i].setText(null); 
			gui.winners[i].setText(null); 
		}
		gui.got3.setText("0");
		gui.got4.setText("0");
		gui.got5.setText("0");
		gui.drawings.setText("0");
		gui.years.setText("0");
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		Object item = event.getItem();
		if (item == gui.quickpick) {
			/* Only 5 numbers are drawn.  */
			for (int i = 0; i < 5; i++) {
				int pick;
				do {
					/* Picks a random integer from 1 to 90.  */
					pick = (int) Math.floor(Math.random() * 90 + 1);
				} while (numberGone(pick, gui.numbers, i));
				gui.numbers[i].setText(Integer.toString(pick));
			}
		}
		else {
			/* Only 5 numbers are drawn.  */
			for (int i = 0; i < 5; i++) {
				gui.numbers[i].setText(null);;
			}
		}
	}
	

	public void addOneToField(JTextField field) {
		int number = Integer.parseInt("0" + field.getText());
		number++;
		field.setText(Integer.toString(number));
	}
	
	
	boolean numberGone(int number, JTextField[] pastNumbers, int count) {
		for (int i = 0; i < count; i++) {
			if (Integer.parseInt(pastNumbers[i].getText()) == number) {
				return true; 
			}
		}
		return false;
	}
	
	
	public boolean matchedOne(JTextField win, JTextField[] allPicks) {
		/* Only 5 numbers are drawn.  */
		for (int i = 0; i < 5; i++) {
			String winText = win.getText();
			if (winText.equals(allPicks[i].getText())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		
		while (playing == thisThread) {
			addOneToField(gui.drawings);
			
			int drawingsNumber = Integer.parseInt(gui.drawings.getText());
			float yearsNumber = (float) drawingsNumber / 104;
			gui.years.setText(Float.toString(yearsNumber));
			
			int matches = 0;
			
			/* Only 5 numbers are drawn.  */
			for (int i = 0; i < 5; i++) {
				int ball;
				do {
					/* Picks a random integer from 1 to 90.  */
					ball = (int) Math.floor(Math.random() * 90 + 1);
				} while (numberGone(ball, gui.winners, i));
				gui.winners[i].setText(Integer.toString(ball));
				if (matchedOne(gui.winners[i], gui.numbers)) {
					matches++;
				}
			}
			
			switch(matches) {
				case 3:
					addOneToField(gui.got3);
					break;
				case 4:
					addOneToField(gui.got4);
					break;
				case 5:
					addOneToField(gui.got5);
					gui.stop.setEnabled(false);
					gui.play.setEnabled(true);
					gui.reset.setEnabled(true);
					gui.quickpick.setEnabled(true);
					gui.personal.setEnabled(true);
					playing = null;
			}
			
			try {
				try {
					int drawSpeed = Integer.parseInt(gui.speed.getText());
					if (drawSpeed > 10000 || drawSpeed <= 0) {
						throw new Exception();
					}
					Thread.sleep(drawSpeed);
				}
				catch (Exception e) {
					gui.speed.setText("100"); 
					Thread.sleep(100);
				}
			}
			catch (InterruptedException e) {
				// Do nothing.  
			}
			
		}
	}
	
}
