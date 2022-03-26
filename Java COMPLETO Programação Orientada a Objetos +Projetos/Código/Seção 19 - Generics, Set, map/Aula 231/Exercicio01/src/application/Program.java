package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.entities.LogEntry;

public class Program {
	public static void main(String[] args) {
		
		Set<LogEntry> set = new HashSet<>();
		String path = "C:\\Temp\\in.txt";
		File file = new File(path);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(" ");
				set.add(new LogEntry(
						fields[0], 
						Date.from(Instant.parse(fields[1]))));
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (LogEntry l : set) {
			System.out.println(l);
		}
		
		System.out.println("Total users: " + set.size());
		
	}
}
