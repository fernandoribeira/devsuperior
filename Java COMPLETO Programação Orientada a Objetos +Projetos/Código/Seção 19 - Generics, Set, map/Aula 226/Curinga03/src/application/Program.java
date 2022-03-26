package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Circle;
import model.entities.Rectangle;
import model.interfaces.Shape;

public class Program {
	
	public static void main(String[] args) {
		
		List<Shape> myList = new ArrayList<>();
		myList.add(new Circle(2.0));
		myList.add(new Rectangle(3.0, 2.0));
		
		List<Circle> myCircle = new ArrayList<>();
		myCircle.add(new Circle(2.0));
		myCircle.add(new Circle(3.0));
		
		System.out.println("Total area: " + totalArea(myCircle));
		
	}
	
	public static Double totalArea(List<? extends Shape> list) {
		
		Double total = 0.0;
		
		for (Shape s : list) {
			total += s.area();
		}
		
		return total;
		
	}
}
