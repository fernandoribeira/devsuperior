import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		double preco;
		double desconto = 0;
		
		System.out.print("Insira o preço: ");
		preco = sc.nextDouble();
		
		desconto = (preco > 20.0) ? (preco * 0.1) : (preco * 0.2);
		
		System.out.printf("O desconto é de %.2f", desconto);
		
		sc.close();
	}
}