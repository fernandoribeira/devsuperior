package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		int n;
		int idSalaryIncrease;
		double percentage;
		boolean result;
		
		System.out.print("How many employees will be registered? ");
		n = sc.nextInt();
		
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			
			Integer id;
			String name;
			Double salary;
			
			System.out.println("Employee #" + i + ":");
			System.out.print("Id: ");
			id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Salary: ");
			salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
			
			System.out.println();
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		idSalaryIncrease = sc.nextInt();
		
		result = false;
		for (Employee e : list) {
			if (e.getId() == idSalaryIncrease) {
				result = true;
				System.out.print("Enter the percentage: ");
				percentage = sc.nextDouble();
				e.increaseSalary(percentage);
			}
		}

		if (result == false) {
			System.out.println("This id does not exist!");
		}

		System.out.println();
		
		System.out.println("List of employees:");
		for (Employee e : list) {
			System.out.println(e);
		}
		
		sc.close();
		
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		
		boolean exist;
		exist = false;
		
		for (Employee e : list) {
			if (e.getId() == id) {
				exist = true;
			}
		}
		
		return exist;
	}
	
}
