package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		Integer number;
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Double contractValue;
		Integer installments;
		Contract contract;
		ContractService contractService;
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		contractValue = sc.nextDouble();
		
		contract = new Contract(number, date, contractValue);
		
		System.out.print("Enter number of installments: ");
		installments = sc.nextInt();
		
		contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, installments);
		
		System.out.println("Installments:");
		contract.showInstallments();
		
		sc.close();
		
	}
}
