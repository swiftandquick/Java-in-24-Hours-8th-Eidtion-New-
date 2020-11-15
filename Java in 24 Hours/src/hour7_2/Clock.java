package hour7_2;

import java.time.*;
import java.time.temporal.*;

public class Clock {

	public static void main(String[] args) {
	
		// Get current time and date.  
		LocalDateTime now = LocalDateTime.now();
		int hour = now.get(ChronoField.HOUR_OF_DAY);
		int minute = now.get(ChronoField.MINUTE_OF_HOUR);
		int month = now.get(ChronoField.MONTH_OF_YEAR);
		int day = now.get(ChronoField.DAY_OF_MONTH);
		int year = now.get(ChronoField.YEAR);
	
		// Display greeting.  
		if (hour < 12) {
			System.out.println("Good morning.  \n");
		}
		else if (hour < 17) {
			System.out.println("Good afternoon.  \n");
		}
		else {
			System.out.println("Good evening.  \n");
		}
		
		
		// Begin time message by showing the minutes.  
		System.out.print("It's");
		if (minute != 0) {
			System.out.print(" " + minute + " ");
			/* If minute is not 1, print out minutes (plural), otherwise 
			 * print out minute (singular).  */
			System.out.print( (minute != 1) ? "minutes" : "minute");
			System.out.print(" past");
		}
		
		// Display the hour.  
		System.out.print(" ");
		/* If hour > 12, print (hour - 12), for example if hour is 13, print 
		 * out 1 instead.  Otherwise, print out the hour.  */
		System.out.print( (hour > 12) ? (hour - 12) : hour);
		System.out.print(" o'clock on ");
		
		// Display the name of the month.  
		switch (month) {
			case 1:
				System.out.print("January");
				break;
			case 2:
				System.out.print("Febuary");
				break;
			case 3:
				System.out.print("March");
				break;
			case 4:
				System.out.print("April");
				break;
			case 5:
				System.out.print("May");
				break;
			case 6:
				System.out.print("June");
				break;
			case 7:
				System.out.print("July");
				break;
			case 8:
				System.out.print("August");
				break;
			case 9:
				System.out.print("September");
				break;
			case 10:
				System.out.print("October");
				break;
			case 11:
				System.out.print("November");
				break;
			case 12:
				System.out.print("December");
				break;
		}
		
		// Display the date and year.  
		System.out.println(" " + day + ", " + year + ".");
	}
	
}