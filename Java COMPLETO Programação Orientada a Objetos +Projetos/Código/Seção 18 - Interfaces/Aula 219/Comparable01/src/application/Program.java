package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		File file = new File("C:\\Temp\\in.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Fora de ordem:");
		for (String line : list) {
			System.out.println(line);
		}
		
		System.out.println();
		Collections.sort(list);
		
		System.out.println("Ordenado:");
		for (String line : list) {
			System.out.println(line);
		}
		
	}
}
