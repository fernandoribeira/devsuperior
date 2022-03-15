package entities;

public class Company extends TaxPayer {

	protected Integer numberOfEmployees;

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
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
		if (numberOfEmployees > 10) {
			tax = anualIncome * 0.14;
		} else {
			tax = anualIncome * 0.16;
		}
		return tax;
	}
	
}
