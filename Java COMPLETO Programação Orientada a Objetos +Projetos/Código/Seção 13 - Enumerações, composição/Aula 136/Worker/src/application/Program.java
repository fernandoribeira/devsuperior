package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		String department;
		String name;
		String level;
		Double baseSalary;
		Integer contracts;
		Worker worker;
		SimpleDateFormat sdf;
		Date date;
		Calendar calendar = Calendar.getInstance();
		Integer month;
		Integer year;
		
		System.out.print("Enter department's name: ");
		department = sc.next();
		
		System.out.println("Enter worker data:");
		
		System.out.print("Name: ");
		name = sc.next();
		
		System.out.print("Level: ");
		level = sc.next();
		
		System.out.print("Base salary: ");
		baseSalary = sc.nextDouble();
		
		worker = new Worker(
				name, 
				WorkerLevel.valueOf(level),
				baseSalary,
				new Department(department)
				);
		
		System.out.print("How many contracts to this worker? ");
		contracts = sc.nextInt();

		for (int i = 0; i < contracts; i++) {

			Double valuePerHour;
			Integer hours;
			
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			date = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			hours = sc.nextInt();
			
			worker.addContract(new HourContract(date, valuePerHour, hours));
			
		}

		System.out.println();

		sdf = new SimpleDateFormat("MM/yyyy");
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		date = sdf.parse(sc.next());
		
		calendar.setTime(date);
		month = 1 + calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.printf("Income for %s: %.2f%n", sdf.format(date), worker.income(year, month));

		sc.close();

	}
}
