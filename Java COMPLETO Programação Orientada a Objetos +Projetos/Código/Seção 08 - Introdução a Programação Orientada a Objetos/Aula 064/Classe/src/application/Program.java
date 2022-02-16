package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double xA, xB, xC, xP, xArea, yA, yB, yC, yP, yArea;
		
		System.out.println("Enter the measures of triangule X:");
		xA = sc.nextDouble();
		xB = sc.nextDouble();
		xC = sc.nextDouble();
		System.out.println("Enter the measures of triangule X:");
		yA = sc.nextDouble();
		yB = sc.nextDouble();
		yC = sc.nextDouble();
		
		sc.close();
		
		xP = (xA + xB + xC) / 2.0;
		xArea = Math.sqrt(xP * (xP - xA) * (xP - xB) * (xP - xC));
		yP = (yA + yB + yC) / 2.0;
		yArea = Math.sqrt(yP * (yP - yA) * (yP - yB) * (yP - yC));
		
		System.out.printf("Triangle X area: %.4f%n", xArea);
		System.out.printf("Triangle Y area: %.4f%n", yArea);
		
		if (xArea > yArea) {
			System.out.println("Larger area: X");
		} else if (xArea < yArea) {
			System.out.println("Larger area: Y");
		} else {
			System.out.println("Same area");
		}
		
	}
}