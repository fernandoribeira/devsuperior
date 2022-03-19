package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		// Listando pastas e arquivos
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String folderPath = sc.nextLine();
		
		File path = new File(folderPath);
		
		System.out.println();
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		System.out.println();

		File[] files = path.listFiles(File::isFile);
		System.out.println("Files:");
		for (File file : files) {
			System.out.println(file);
		}
		
		System.out.println();
		
		File[] filesAndFolders = path.listFiles();
		System.out.println("Files and folders:");
		for (File item : filesAndFolders) {
			System.out.println(item);
		}
		
		System.out.println();
		
		// Criando arquivo
		
		String fileName = "NovoArquivo.txt";
		File novoArquivo = new File(folderPath + "\\" + fileName);
		try {
			if (novoArquivo.createNewFile()) {
				System.out.println("Arquivo criado com sucesso!");
			} else {
				System.out.println("Erro na criação do arquivo...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String folderName = "NovaPasta";
		File novaPasta = new File(folderPath + "\\" + folderName);
		if (novaPasta.mkdir()) {
			System.out.println("Pasta criada com sucesso!");
		} else {
			System.out.println("Erro na criação da pasta...");
		}
		
		sc.close();
		
	}
}
