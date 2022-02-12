import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int senhaCorreta;
		int senha;
		
		senhaCorreta = 2002;
		senha = sc.nextInt();
		
		while (senha != senhaCorreta) {
				System.out.println("Senha inválida");
				senha = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("Acesso permitido");
		
	}
}