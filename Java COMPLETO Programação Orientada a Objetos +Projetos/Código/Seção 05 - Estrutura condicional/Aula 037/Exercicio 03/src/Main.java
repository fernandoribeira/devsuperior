import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A > B) {
			if (A % B == 0) {
				System.out.println("S�o m�ltiplos");
			} else {
				System.out.println("N�o s�o m�ltiplos");
			}
		} else if (B > A) {
			if (B % A == 0) {
				System.out.println("S�o m�ltiplos");
			} else {
				System.out.println("N�o s�o m�ltiplos");
			}
		} else {
			System.out.println("S�o m�ltiplos");
		}
		
		sc.close();
		
	}
}
