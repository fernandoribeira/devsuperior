package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int negative = 0;
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
				if (mat[i][j] < 0) {
					negative++;
				}
			}
		}
		
		System.out.println();
		System.out.println("Matrix:");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Main diagonal:");
		
		for (int i = 0; i < n; i++) {
			System.out.print(mat[i][i] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.print("Negative numbers = " + negative);
		
		sc.close();
		
	}
}
