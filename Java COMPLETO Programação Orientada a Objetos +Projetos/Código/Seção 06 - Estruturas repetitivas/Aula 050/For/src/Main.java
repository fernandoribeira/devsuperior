import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int soma;
		int n;
		
		soma = 0;
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int valor = sc.nextInt();
			soma += valor;
		}
		
		sc.close();
		
		System.out.println(soma);
		
	}
}