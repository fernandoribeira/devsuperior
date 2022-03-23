package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

public class Program {
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		
		File file = new File("C:\\Temp\\data.csv");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				String[] lineCsv = line.split(",");
				list.add(new Employee(lineCsv[0], Double.parseDouble(lineCsv[1])));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Fora de ordem:");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println();
		Collections.sort(list);
		
		System.out.println("Ordenado:");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}
}
