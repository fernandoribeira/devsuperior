import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String apelido;
		String nomeCompleto;
		char sexo;
		int idade;
		double salario;
		boolean casado;
		
		System.out.print("Insira o apelido: ");
		apelido = sc.next();
		sc.nextLine();
		
		System.out.print("Insira o nome completo: ");
		nomeCompleto = sc.nextLine();
		
		System.out.print("Insira o sexo: ");
		sexo = sc.next().charAt(0);
		
		System.out.print("Insira a idade: ");
		idade = sc.nextInt();
		
		System.out.print("Insira o salario: ");
		salario = sc.nextDouble();
		
		System.out.print("Insira o estado civil (casado = true e solteiro = "
				+ "false): ");
		casado = sc.nextBoolean();
		
		System.out.println();
		
		System.out.println("Mostrando informações");
		System.out.println("Apelido: " + apelido);
		System.out.println("Nome completo: " + nomeCompleto);
		System.out.println("Sexo: " + sexo);
		System.out.println("Idade: " + idade);
		System.out.printf("Salario: %.2f%n", salario);
		System.out.println("Casado: " + casado);
		
		sc.close();
		
	}
}