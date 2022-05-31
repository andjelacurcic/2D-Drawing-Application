package shapes;

import java.awt.Graphics;
import java.io.Serializable;
import java.awt.Color;


public abstract class Shape implements Moveable, Comparable, Serializable{
	/**
	 * 
	 */
	
	protected boolean selected;

	public Shape() {

	}

	public abstract boolean contains(int x, int y); /* apstraktna metoda */

	public abstract void draw(Graphics g);
	public abstract Shape clone();
	
	
	private Color edgeColor;
	private Color innerColor;
	
	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	

}
