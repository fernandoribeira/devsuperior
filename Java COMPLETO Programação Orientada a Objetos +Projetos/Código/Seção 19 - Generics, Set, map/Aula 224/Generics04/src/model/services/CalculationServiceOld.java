package model.services;

import java.util.List;

import model.entities.Product;

public class CalculationServiceOld {

	public Double max(List<Product> list) {
		Double max = list.get(0).getPrice();
		for (Product p : list) {
			if (p.getPrice() > max) {
				max  = p.getPrice();
			}
		}
		return max;
	}
	
}
