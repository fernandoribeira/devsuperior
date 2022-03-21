package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {
	}

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		Double quota;
		Double quotaMoreInterest;
		Double quotaMoreInterestMoreFee;
		Date dueDate;
		
		quota = contract.getTotalValue() / months;
		
		for (int i = 0; i < months; i++) {
			
			quotaMoreInterest = quota + onlinePaymentService.interest(quota, (i + 1));
			quotaMoreInterestMoreFee = quotaMoreInterest + onlinePaymentService.paymentFee(quotaMoreInterest);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(contract.getDate());
			calendar.add(Calendar.MONTH, (i + 1));
			dueDate = calendar.getTime();
			
			contract.listAdd(new Installment(dueDate, quotaMoreInterestMoreFee));
			
		}
		
	}
	
}
