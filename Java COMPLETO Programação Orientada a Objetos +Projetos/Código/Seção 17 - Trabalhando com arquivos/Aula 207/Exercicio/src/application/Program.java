package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Item;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		List<Item> list = new ArrayList<>();
		
		/*
		 * Entrada do path do arquivo
		 */
		
		System.out.print("Enter source file path: ");
		String sourceFileText = sc.nextLine();

		/*
		 * Leitura dos dados do arquivo
		 */
		
		File sourceFile = new File(sourceFileText);		
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				Integer quantity = Integer.parseInt(fields[2]);
				list.add(new Item(name, price, quantity));
							
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		/*
		 * Gravação dos dados do arquivo
		 */
		
		String summaryFileText = sourceFile.getParent() + "\\out\\summary.csv";
		File summaryFile = new File(summaryFileText);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryFile))) {
			
			for (Item item : list) {
				String line = item.getName() + "," + String.format("%.2f", item.total());
				bw.write(line);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
