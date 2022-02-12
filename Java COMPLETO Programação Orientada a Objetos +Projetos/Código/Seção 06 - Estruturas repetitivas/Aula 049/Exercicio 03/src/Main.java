import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int alcool;
		int gasolina;
		int diesel;
		int codigo;
		
		alcool = 0;
		gasolina = 0;
		diesel = 0;
		
		codigo = sc.nextInt();
		
		while (codigo != 4) {
			switch (codigo) {
				case 1:
					alcool++;
					break;
				case 2:
					gasolina++;
					break;
				case 3:
					diesel++;
					break;
			}
			codigo = sc.nextInt();
		}
			
		sc.close();
		
		System.out.println("MUITO OBRIGADO");
		System.out.println("Alcool : " + alcool);
		System.out.println("Gasolina: " + gasolina);
		System.out.println("Diesel: " + diesel);

	}
}