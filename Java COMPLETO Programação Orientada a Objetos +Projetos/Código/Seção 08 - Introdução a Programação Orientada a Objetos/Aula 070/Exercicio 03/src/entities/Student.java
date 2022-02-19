package entities;

public class Student {

	public String name;
	public double grade1;
	public double grade2;
	public double grade3;
	
	public double finalGrade() {
		return grade1 + grade2 + grade3;
	}
	
	public double missingPoint() {
		return 60.0 - finalGrade();
	}
	
	public String status() {
		if (finalGrade() > 60.0) {
			return "PASS";
		} else {
			return String.format("FAILED%nMISSING %.2f POINTS", missingPoint());
		}
	}
	
}
