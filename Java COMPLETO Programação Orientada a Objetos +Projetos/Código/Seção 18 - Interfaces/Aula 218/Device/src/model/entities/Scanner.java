package model.entities;

public class Scanner extends Device {
	
	public Scanner() {
		super();
	}

	public Scanner(String serialNumber) {
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
