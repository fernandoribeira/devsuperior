import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int horaInicial;
		int horaFinal;
		int duracao;
		
		horaInicial = sc.nextInt();
		horaFinal = sc.nextInt();
		duracao = 0;
		
		sc.close();
		
		if (horaInicial < horaFinal) {
			duracao = horaFinal - horaInicial;
		} else if (horaInicial > horaFinal) {
			duracao = (24 - horaInicial) + horaFinal;
		} else {
			duracao = 24;
		}
		
		System.out.println("O JOGO DUROU " + duracao + " HORA(S)");
		
	}
}
