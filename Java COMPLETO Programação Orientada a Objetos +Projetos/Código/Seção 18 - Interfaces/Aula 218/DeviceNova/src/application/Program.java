package application;

import model.entities.ComboDevice;
import model.entities.ConcretePrinter;
import model.entities.ConcreteScanner;

public class Program {
	public static void main(String[] args) {
		
		ConcretePrinter p = new ConcretePrinter("1080");
		p.processDoc("My letter");
		p.print("My letter");
		
		ConcreteScanner s = new ConcreteScanner("2003");
		s.processDoc("My photo");
		s.scan("My photo");
		
		ComboDevice c = new ComboDevice("5687");
		c.processDoc("My audio");
		c.scan("My audio");
		c.print("My audio");
		
	}
}
