package application;

import java.util.Scanner;

import entities.Rent;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Rent[] vect = new Rent[10];
		int n;
		
		System.out.print("How many rooms will be rented? ");
		n = sc.nextInt();
		
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			
			String name;
			String email;
			int room;
			
			System.out.println("Rent #" + i + ":");
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Email: ");
			email = sc.nextLine();
			System.out.print("Room: ");
			room = sc.nextInt();
			
			vect[room] = new Rent(name, email);
			
			System.out.println();
			
		}
		
		System.out.println("Busy rooms:");
		
		for (int i = 0; i < vect.length; i++) {
			
			if (vect[i] != null) {
				System.out.println(i + ": " + vect[i]);
			}
			
		}
		
		sc.close();

	}
}
