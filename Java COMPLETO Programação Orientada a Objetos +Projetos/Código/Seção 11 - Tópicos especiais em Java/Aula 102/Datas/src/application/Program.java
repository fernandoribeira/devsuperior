package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date y1 = sdf1.parse("25/06/1980");
		Date y2 = sdf2.parse("25/06/1980 15:42:07");
		
		System.out.println(sdf1.format(y1));
		System.out.println(sdf2.format(y2));
		
		Date d1 = new Date();
		Date d2 = new Date(12346579);
		Date d3 = new Date()
		
	}
}
