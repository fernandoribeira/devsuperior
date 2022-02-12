import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fatorial = 1;
		int n = sc.nextInt();
		
		sc.close();
		
		for (int i = 1; i <= n; i++) {
			fatorial *= i;
		}
		
		System.out.println(fatorial);
		
	}
}