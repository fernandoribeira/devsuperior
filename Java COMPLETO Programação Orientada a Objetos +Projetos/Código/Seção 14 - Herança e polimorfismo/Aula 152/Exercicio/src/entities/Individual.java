package entities;

public class Individual extends TaxPayer {

	protected Double healthExpenditure;

	public Individual(String name, Double anualIncome, Double healthExpenditure) {
		super(name, anualIncome);
		this.healthExpenditure = healthExpenditure;
	}

	public Double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(Double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}
	
	@Override
	public String toString() {
		return name
				+ ": $ "
				+String.format("%.2f", tax());
	}

	@Override
	public Double tax() {
		Double tax;
		if (anualIncome < 20000.0) {
			if (healthExpenditure > 0.0) {
				tax = (anualIncome * 0.15) - (healthExpenditure * 0.50);
			} else {
				tax = (anualIncome * 0.15);
			}
		} else {
			if (healthExpenditure > 0.0) {
				tax = (anualIncome * 0.25) - (healthExpenditure * 0.50);
			} else {
				tax = (anualIncome * 0.25);
			}
		}
		return tax;
	}
	
}
