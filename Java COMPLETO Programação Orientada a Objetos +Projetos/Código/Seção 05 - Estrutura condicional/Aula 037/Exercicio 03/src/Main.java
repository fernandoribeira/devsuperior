import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A > B) {
			if (A % B == 0) {
				System.out.println("São múltiplos");
			} else {
				System.out.println("Não são múltiplos");
			}
		} else if (B > A) {
			if (B % A == 0) {
				System.out.println("São múltiplos");
			} else {
				System.out.println("Não são múltiplos");
			}
		} else {
			System.out.println("São múltiplos");
		}
		
		sc.close();
		
	}
}
