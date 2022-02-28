package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date y1 = sdf1.parse("25/06/1980");
		Date y2 = sdf2.parse("25/06/1980 15:42:07");
		
		System.out.println(sdf1.format(y1));
		System.out.println(sdf2.format(y2));
		
		System.out.println("---------------------------");
		System.out.println("Timezone BRT");
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");

		Date y3 = new Date();
		Date y4 = new Date(1000L * 60L * 60L * 5L); // Milisegundos * minutos * horas * dias
		Date y5 = new Date(System.currentTimeMillis());
		Date y6 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		Date y7 = new Date(0L); 
		
		System.out.println(sdf3.format(y1));
		System.out.println(sdf3.format(y2));
		System.out.println(sdf3.format(y3));
		System.out.println(sdf3.format(y4));
		System.out.println(sdf3.format(y5));
		System.out.println(sdf3.format(y6));
		System.out.println(sdf3.format(y7));
		
		System.out.println("---------------------------");
		System.out.println("Timezone GMT");
		
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		System.out.println(sdf3.format(y1));
		System.out.println(sdf3.format(y2));
		System.out.println(sdf3.format(y3));
		System.out.println(sdf3.format(y4));
		System.out.println(sdf3.format(y5));
		System.out.println(sdf3.format(y6));
		System.out.println(sdf3.format(y7));

	}
}
