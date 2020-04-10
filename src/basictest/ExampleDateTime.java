package basictest;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ExampleDateTime {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println("current date : " + sdf.format(cal.getTime()));
		
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		System.out.println("Yesterday date : " + sdf.format(cal.getTime()));

		cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, -2);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		System.out.println("next week date : " + sdf.format(cal.getTime()));
		
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		cal.add(Calendar.YEAR, -2);
		System.out.println("next year date : " + sdf.format(cal.getTime()));

		
	}

}
