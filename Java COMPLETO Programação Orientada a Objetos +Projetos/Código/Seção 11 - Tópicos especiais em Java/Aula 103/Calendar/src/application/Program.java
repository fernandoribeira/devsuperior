package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Program {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		Date date = Date.from(Instant.parse("2018-06-15T15:42:07Z"));
		
		System.out.println(sdf.format(date));
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		
		cal.add(Calendar.HOUR_OF_DAY, 4);
		date = cal.getTime();
		System.out.println(sdf.format(date));
		
		cal.add(Calendar.HOUR_OF_DAY, -2);
		date = cal.getTime();
		System.out.println(sdf.format(date));
		
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		int minuts = cal.get(Calendar.MINUTE);
		
		System.out.println(hours);
		System.out.println(minuts);
		
	}
}
