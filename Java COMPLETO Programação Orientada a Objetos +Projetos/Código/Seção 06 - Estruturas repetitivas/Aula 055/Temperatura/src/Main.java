import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double tempCelsius;
		double tempFahrenheit;
		char repetir;
		
		do {
			
			System.out.print("Digite a temperatura em Celsius: ");
			tempCelsius = sc.nextDouble();
			
			tempFahrenheit = ((9 * tempCelsius) / 5) + 32;
			
			System.out.printf("Equivalente em Fahrenheit: %.1f%n",
					tempFahrenheit);
			
			System.out.print("Deseja repetir (s/n): ");
			repetir = sc.next().charAt(0);
			
		} while (repetir != 'n');

		sc.close();
		
	}
}