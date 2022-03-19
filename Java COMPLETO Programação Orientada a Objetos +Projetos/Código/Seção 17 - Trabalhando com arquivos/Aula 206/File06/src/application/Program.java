package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Enter file path: ");
		String filePath = sc.nextLine();
		File file = new File(filePath);
		
		System.out.println();
		System.out.println("Methods for file");
		System.out.println();
		System.out.println("getName: " + file.getName());
		System.out.println("getParent: " + file.getParent());
		System.out.println("getPath: " + file.getPath());
		
	}
}
