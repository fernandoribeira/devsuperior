package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		System.out.println("Program init");
		
		method1();
		
		System.out.println("End of program");
		
	}

	public static void method1() {
		System.out.println("method1 init");
		method2();
		System.out.println("method1 end");
	}

	public static void method2() {
		
		System.out.println("method2 init");
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Invalid position!");
			e.printStackTrace();
			sc.next();
			
		}
		catch (InputMismatchException e) {
			
			System.out.println("Input error!");
			e.printStackTrace();
			sc.next();
			
		}
		
		sc.close();
		
		System.out.println("method2 end");
		
	}
}
