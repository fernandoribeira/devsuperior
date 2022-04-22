package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String file;
		Double salary;
		
		System.out.print("Enter full file path: ");
		file = sc.nextLine();
		System.out.print("Enter salary: ");
		salary = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<Employee> list = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				Employee employee = new Employee(fields[0], fields[1], Double.parseDouble(fields[2]));
				list.add(employee);
				line = br.readLine();
			}
			
			Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			List<String> emailList = list.stream()
					.filter(e -> e.getSalary() > salary)
					.map(e -> e.getEmail())
					.sorted(comparator)
					.collect(Collectors.toList());
			System.out.println("Email of people whose salary is more than "
					+ String.format("%.2f", salary) + ":");
			emailList.forEach(System.out::println);
			
			Double sumSalary = list.stream()
					.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			System.out.println("Sum of salary of people whose name starts with 'M': "
					+ String.format("%.2f", sumSalary));			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
