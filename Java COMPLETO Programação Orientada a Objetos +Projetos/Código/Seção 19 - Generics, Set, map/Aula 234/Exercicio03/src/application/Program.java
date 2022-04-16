package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Map<String, Integer> map = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);
		String path;
		
		System.out.print("Enter file full path: ");
		path = sc.nextLine();

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			String line = bf.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int counter = Integer.parseInt(fields[1]);
				
				if (map.containsKey(name)) {
					counter = counter + map.get(name);
				}
				
				map.put(name, counter);
						
				line = bf.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (String name : map.keySet()) {
			System.out.println(name + ": " + map.get(name));
		}
		
		sc.close();
		
	}
}
