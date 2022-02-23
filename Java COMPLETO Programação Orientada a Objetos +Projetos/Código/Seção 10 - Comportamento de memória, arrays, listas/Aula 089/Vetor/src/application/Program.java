package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		double[] vect;
		double sum;
		double averageHeight;
		
		n = sc.nextInt();
		vect = new double[n];
		
		for (int i = 0; i < n; i++) {
			vect[i] = sc.nextDouble();
		}
		
		sum = 0.0;
		
		for (int i = 0; i < n; i++) {
			sum += vect[i];
		}
		
		averageHeight = sum / n;
		
		System.out.printf("AVERAGE HEIGHT = %.2f", averageHeight);
		
		sc.close();
		
	}
}
