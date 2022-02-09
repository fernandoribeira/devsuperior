public class Main {
	public static void main(String[] args) {
		
		int numero;
		int hora;
		
		numero = 10;
		System.out.println("Número = " + numero);
		if (numero > 5 ) {
			System.out.println("Número é maior que 5");
		}
		System.out.println();
		
		numero = 10;
		System.out.println("Número = " + numero);
		if (numero > 15 ) {
			System.out.println("Número é maior que 15");
		} else {
			System.out.println("Número é menor que 15");
		}
		System.out.println();
		
		hora = 20;
		System.out.println("Hora = " + hora);
		if (hora < 12 ) {
			System.out.println("Bom dia!");
		} else if (hora < 18) {
			System.out.println("Boa tarde!");
		} else {
			System.out.println("Boa noite!");
		}
	}
}