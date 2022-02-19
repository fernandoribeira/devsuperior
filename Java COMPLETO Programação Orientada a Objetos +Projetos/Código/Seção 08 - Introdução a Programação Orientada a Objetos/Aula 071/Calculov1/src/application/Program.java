package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	
	public static final double PI = 3.14159;
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double radius;
		
		System.out.print("Enter radius: ");
		radius = sc.nextDouble();

		System.out.printf("Circumference: %.2f%n", circumference(radius));
		System.out.printf("Volume: %.2f%n", volume(radius));
		System.out.printf("PI value: %.2f", PI);
		
		sc.close();
		
	}

	public static double volume(double radius) {
		return (4.0 * PI * Math.pow(radius, 3)) / 3;
	}

	public static double circumference(double radius) {
		return 2.0 * PI * radius;
	}
}
