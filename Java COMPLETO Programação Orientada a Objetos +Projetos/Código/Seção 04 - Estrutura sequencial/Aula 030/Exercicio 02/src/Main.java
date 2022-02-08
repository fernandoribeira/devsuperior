import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double raio;
		double area;
		
		raio = sc.nextDouble();
		area = 3.14159 * Math.pow(raio, 2);
		
		System.out.printf("A=%.4f", area);
		
		sc.close();
		
	}
}