package model.entities;

import model.interfaces.Scanner;

public class ConcreteScanner extends Device implements Scanner {
	
	public ConcreteScanner() {
		super();
	}

	public ConcreteScanner(String serialNumber) {
		super(serialNumber);
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Scanner processing: " + doc);
	}
	
	public void scan(String doc) {
		System.out.println("Scanning: " + doc);
	}

}
