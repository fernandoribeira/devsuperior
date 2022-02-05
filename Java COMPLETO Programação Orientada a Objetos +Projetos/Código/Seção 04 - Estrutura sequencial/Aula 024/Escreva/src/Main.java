import java.util.Locale;

public class Main {
	public static void main(String[] args) {

		byte valorInteiroByte;
		short valorInteiroShort;
		int valorInteiroInt;
		long valorInteiroLong;
		float valorPontoFlutuanteFloat;
		double valorPontoFlutuanteDouble;
		char valorChar;
		boolean valorBoolean;
		
		valorInteiroByte = 1;
		valorInteiroShort = 2;
		valorInteiroInt = 3;
		valorInteiroLong = 4;
		valorPontoFlutuanteFloat = 1.2345f;
		valorPontoFlutuanteDouble = 1.2345678;
		valorChar = 'A';
		valorBoolean = true;
		
		System.out.print("Bom dia!");
		System.out.println("Boa tarde!");
		System.out.println("Boa noite!");
		
		System.out.println("Minha idade � = " + valorInteiroByte);
		
		System.out.printf("Minha idade � %d.%n", valorInteiroInt);
		System.out.printf("Sal�rio $ %f%n", valorPontoFlutuanteFloat);
		Locale.setDefault(Locale.US);
		System.out.printf("Sal�rio $ %f%n", valorPontoFlutuanteFloat);
		System.out.printf("Sal�rio $ %.2f%n", valorPontoFlutuanteFloat);
		
	}
}