package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Calculator calculator = new Calculator();
		double radius;
		
		System.out.print("Enter radius: ");
		radius = sc.nextDouble();

		System.out.printf("Circumference: %.2f%n", calculator.circumference(radius));
		System.out.printf("Volume: %.2f%n", calculator.volume(radius));
		System.out.printf("PI value: %.2f", calculator.PI);
		
		sc.close();
		
	}
}
