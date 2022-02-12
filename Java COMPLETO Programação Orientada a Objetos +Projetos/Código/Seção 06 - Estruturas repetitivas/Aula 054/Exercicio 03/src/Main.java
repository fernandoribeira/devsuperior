import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			double valor1 = sc.nextDouble();
			double valor2 = sc.nextDouble();
			double valor3 = sc.nextDouble();
			double peso1 = 2.0;
			double peso2 = 3.0;
			double peso3 = 5.0;
			
			double mediaPonderada = ((valor1 * peso1) + (valor2 * peso2) + (valor3 * peso3)) 
					/ (peso1 + peso2 + peso3);
			
			System.out.printf("%.1f%n", mediaPonderada);
			
		}
		
		sc.close();
	}
}