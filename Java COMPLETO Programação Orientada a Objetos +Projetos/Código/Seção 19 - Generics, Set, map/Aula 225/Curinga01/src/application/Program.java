package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {

		// Erro
		List<Object> myObjs1 = new ArrayList<Object>();
		List<Integer> myNumbers1 = new ArrayList<Integer>();
		myObjs1 = myNumbers1; // erro de compilação
		
		// Correto
		List<?> myObjs2 = new ArrayList<Object>();
		List<Integer> myNumbers2 = new ArrayList<Integer>();
		myObjs2 = myNumbers2;
		
	}
}
