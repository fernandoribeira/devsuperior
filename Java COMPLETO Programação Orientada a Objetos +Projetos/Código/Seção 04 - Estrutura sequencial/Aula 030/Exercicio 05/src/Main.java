import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int codigoPeca1;
		int quantidadePeca1;
		double valorPeca1;
		double totalPeca1;
		
		int codigoPeca2;
		int quantidadePeca2;
		double valorPeca2;
		double totalPeca2;
		
		double totalFinal;
		
		codigoPeca1 = sc.nextInt();
		quantidadePeca1 = sc.nextInt();
		valorPeca1 = sc.nextDouble();
		
		codigoPeca2 = sc.nextInt();
		quantidadePeca2 = sc.nextInt();
		valorPeca2 = sc.nextDouble();
		
		totalPeca1 = quantidadePeca1 * valorPeca1;
		totalPeca2 = quantidadePeca2 * valorPeca2;
		totalFinal = totalPeca1 + totalPeca2;
		
		System.out.printf("VALOR A PAGAR: R$ %.2f%n", totalFinal);
		
		sc.close();
		
	}
}