import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		double salario;
		double imposto;

		salario = sc.nextDouble();
		imposto = 0;
		
		sc.close();

		if (salario <= 2000.0) {
			imposto = (0.0);
			System.out.println("Isento");
		} else if (salario <= 3000.0 ) {
			imposto = (0.0) + ((salario - 2000) * 0.08);
			System.out.printf("R$ %.2f", imposto);
		} else if (salario <= 4500.0 ) {
			imposto = (0.0) + (80.0) + ((salario - 3000) * 0.18);
			System.out.printf("R$ %.2f", imposto);
		} else {
			imposto = (0.0) + (80.0) + (270.0) + ((salario - 4500) * 0.28);
			System.out.printf("R$ %.2f", imposto);
		}
		
	}
}
