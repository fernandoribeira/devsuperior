package model.entities;

import model.enums.Color;
import model.interfaces.Shape;

public abstract class AbstractShape implements Shape {

	private Color color;

	public AbstractShape() {
	}
	
	public AbstractShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract Double area();
	
}
