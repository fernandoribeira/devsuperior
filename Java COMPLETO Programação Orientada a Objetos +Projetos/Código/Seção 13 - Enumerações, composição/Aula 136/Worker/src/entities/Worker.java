package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts;
	
	public Worker(String name, WorkerLevel workerLevel, Double baseSalary,
			Department department) {
		
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;
		this.contracts = new ArrayList<HourContract>();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", workerLevel=" + workerLevel + ", baseSalary=" + baseSalary + ", department="
				+ department + ", contracts=" + contracts + "]";
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		
		Double income = baseSalary;
		
		for (HourContract contract : contracts) {
		
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(contract.getDate());
			int contractYear = calendar.get(Calendar.YEAR);
			int contractMonth = 1 + calendar.get(Calendar.MONTH);
			
			if (year == contractYear && month == contractMonth) {
				income += contract.totalValue();
			}
			
		}
		
		return income;
	}
	
}
