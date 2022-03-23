package model.interfaces;

public interface InterestService {

	Double getInterestRate();
	
	default Double payment(Double amount, Integer months) {
		return amount * Math.pow((1 + getInterestRate() / 100), months);
	}
	
}
