package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String file = "C:\\Temp\\in.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<Product> list = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));	
				line = br.readLine();
			}
			
			double average = list.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (x, y) -> x + y) / list.size();
			System.out.println("Average price: " + String.format("%.2f", average));
			
			Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < average)
					.map(p -> p.getName())
					.sorted(comparator.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
