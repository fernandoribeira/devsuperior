import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		int codigo;
		int quantidade;
		double preco;
		
		codigo = sc.nextInt();
		quantidade = sc.nextInt();
		preco = 0;
		
		sc.close();

		if (codigo == 1) {
			preco = 4.0;
			System.out.printf("Total: R$ %.2f", (preco * quantidade));
		} else if (codigo == 2) {
			preco = 4.5;
			System.out.printf("Total: R$ %.2f", (preco * quantidade));
		} else if (codigo == 3) {
			preco = 5.0;
			System.out.printf("Total: R$ %.2f", (preco * quantidade));
		} else if (codigo == 4) {
			preco = 2.0;
			System.out.printf("Total: R$ %.2f", (preco * quantidade));
		} else if (codigo == 5) {
			preco = 1.5;
			System.out.printf("Total: R$ %.2f", (preco * quantidade));
		} else {
			System.out.println("Código invalido!");
		}
	
	}
}
