package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double xP, xArea, yP, yArea;
		
		Triangle x = new Triangle();
		Triangle y = new Triangle();
		
		System.out.println("Enter the measures of triangule X:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("Enter the measures of triangule X:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		sc.close();
		
		xP = (x.a + x.b + x.c) / 2.0;
		xArea = Math.sqrt(xP * (xP - x.a) * (xP - x.b) * (xP - x.c));
		yP = (y.a + y.b + y.c) / 2.0;
		yArea = Math.sqrt(yP * (yP - y.a) * (yP - y.b) * (yP - y.c));
		
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