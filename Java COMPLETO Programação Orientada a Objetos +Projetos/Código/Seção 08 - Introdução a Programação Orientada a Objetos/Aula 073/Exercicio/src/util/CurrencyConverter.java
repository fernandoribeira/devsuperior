package util;

public class CurrencyConverter {
	
	public static double IOF = 0.06;

	public static double dollarToReal(double dollarPrice, double dollarQuantity) {
		return (dollarPrice * dollarQuantity) * (1.0 + IOF);
	}
	
}
