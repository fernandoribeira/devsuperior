package model.entities;

import model.interfaces.Printer;
import model.interfaces.Scanner;

public class ComboDevice extends Device implements Scanner, Printer {
	
	public ComboDevice() {
		super();
	}
	
	public ComboDevice(String serialNumber) {
		super(serialNumber);
	}

	@Override
	public void print(String doc) {
		System.out.println("Combo printing: " + doc);
	}

	@Override
	public void scan(String doc) {
		System.out.println("Combo scanning: " + doc);
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Combo processing: " + doc);
	}

}
