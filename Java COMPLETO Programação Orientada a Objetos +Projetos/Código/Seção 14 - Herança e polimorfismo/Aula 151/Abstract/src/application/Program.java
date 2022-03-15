package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		Integer n;
		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shape: ");
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			Character type;
			Color color;
			Double width;
			Double height;
			Double radius;

			System.out.println("Shape #" + (i + 1) + " data:");
			System.out.print("Rectangle or Circle (r/c)? ");
			type = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			color = Color.valueOf(sc.next());

			if (type.equals('r')) {
				System.out.print("Width: ");
				width = sc.nextDouble();
				System.out.print("Height: ");
				height = sc.nextDouble();
				list.add(new Rectangle(color, width, height));
			} else {
				System.out.print("Radius: ");
				radius = sc.nextDouble();
				list.add(new Circle(color, radius));
			}

		}

		System.out.println();
		System.out.println("SHAPE AREAS:");
		for (Shape shape : list) {
			System.out.printf("%.2f%n", shape.area());
		}

		sc.close();

	}
}
