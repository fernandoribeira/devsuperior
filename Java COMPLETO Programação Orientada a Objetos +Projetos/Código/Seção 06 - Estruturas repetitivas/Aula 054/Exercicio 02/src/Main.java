import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int in =0;
		int out = 0;
		
		for (int i = 0; i < n; i++) {
			int valor = sc.nextInt();
			if (valor >= 10 && valor <= 20) {
				in++;
			} else {
				out++;
			}
		}
		
		sc.close();
		
		System.out.println(in + " in");
		System.out.println(out + " out");
		
	}
}