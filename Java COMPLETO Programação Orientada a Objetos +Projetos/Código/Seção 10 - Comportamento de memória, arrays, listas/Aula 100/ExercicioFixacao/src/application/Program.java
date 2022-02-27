package application;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m;
		int n;
		int[][] mat;
		int v;
		
		m = sc.nextInt();
		n = sc.nextInt();
		mat = new int[m][n];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		v = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				
				if (mat[i][j] == v) {
					System.out.println("Position " + i + "," + j + ":");
					
					// Left test
					if (j > 0) {
						System.out.println("\tLeft: " + mat[i][j-1]);
					}

					// Up test
					if (i > 0) {
						System.out.println("\tUp: " + mat[i-1][j]);
					}
					
					// Right test
					
					if (j < (mat[i].length - 1)) {
						System.out.println("\tRight: " + mat[i][j+1]);
					}

					// Down test
					if (i < (mat.length - 1)) {
						System.out.println("\tDown: " + mat[i+1][j]);
					}
				}
				
				System.out.println();

			}
		}
		 
		sc.close();
		
	}
}
