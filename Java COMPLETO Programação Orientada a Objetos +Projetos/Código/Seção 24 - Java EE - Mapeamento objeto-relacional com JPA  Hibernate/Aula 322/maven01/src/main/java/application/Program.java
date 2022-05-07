package application;

import model.entities.Pessoa;

public class Program {
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Bob", "bob@gmail.com");
		Pessoa p2 = new Pessoa(2, "Maria", "maria@gmail.com");
		Pessoa p3 = new Pessoa(3, "Fernando", "fernando@gmail.com");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}
}
