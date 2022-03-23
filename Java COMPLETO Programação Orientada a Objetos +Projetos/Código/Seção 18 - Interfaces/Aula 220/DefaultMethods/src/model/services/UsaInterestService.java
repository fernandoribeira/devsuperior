package model.services;

import model.interfaces.InterestService;

public class UsaInterestService implements InterestService {

	private Double interestRate;

	public UsaInterestService() {
	}
	
	public UsaInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
}
