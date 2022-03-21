package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String carModel;
		Date pickupDate;
		Date returnDate;
		Double pricePerHour;
		Double pricePerDay;
		CarRental carRental;
		RentalService rentalService;
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		pickupDate = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		returnDate = sdf.parse(sc.nextLine());
		
		carRental = new CarRental(pickupDate, returnDate, new Vehicle(carModel));
		
		System.out.print("Enter price per hour: ");
		pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		pricePerDay = sc.nextDouble();
		
		rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
		
		sc.close();
		
	}
}
