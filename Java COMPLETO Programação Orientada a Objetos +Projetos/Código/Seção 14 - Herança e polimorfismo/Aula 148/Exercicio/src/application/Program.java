package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		Integer n;
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employee: ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			Character outsourced;
			String name;
			Integer hours;
			Double valuePerHour;
			Double additionalCharge;
			Employee employee;
			
			System.out.println("Employee #" + (i + 1) +" data:");
			System.out.print("Outsourced (y/n)? ");
			outsourced = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Hours: ");
			hours = sc.nextInt();
			System.out.print("Value per hour: ");
			valuePerHour = sc.nextDouble();
			
			if (outsourced.equals('y')) {
				System.out.print("Additional charge: ");
				additionalCharge = sc.nextDouble();
				employee = new OutsourcedEmployee(name, hours, valuePerHour,
						additionalCharge);
				employees.add(employee);
				
			} else {
				employee = new Employee(name, hours, valuePerHour);
				employees.add(employee);
			}

		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		sc.close();
		
	}
}
