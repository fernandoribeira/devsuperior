import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter three numbers:");
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		sc.close();
		
		int maxNumber = max(n1, n2, n3);
		
		showResult(maxNumber);
		
	}
	
	public static int max(int x, int y, int z) {
		
		int maxValue;

		if (x > y && x > z) {
			maxValue = x;
		} else if (y > x && y > z) {
			maxValue = y;
		} else {
			maxValue = z;
		}
		
		return maxValue;
	}
	
	public static void showResult(int value) {
		
		System.out.println("Higher = " + value);
		
	}
}

















