package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.Graphics;

import shapes.Point;

public class Donut extends Circle{
	private int innerRadius;

	
	

	public Donut() {

	}

	public Donut(Point center, int outerRadius, int innerRadius) {
		super(center, outerRadius);
		// this.center = center;
		// this.r = outerRadius;
		// setR(outerRadius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius,Color edgeColor,Color innerColor) {
		super(center,radius,edgeColor,innerColor);
		this.innerRadius=innerRadius;
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	
	
	
	public String toString() {
		return "Donut Center(" + super.getCenter().getX() + "|" + super.getCenter().getY() + ")|Radius(" + super.getR() + ")|InnerRadius("+ innerRadius +")|EdgeColor("+getEdgeColor().getRGB()+")|InnerColor("+getInnerColor().getRGB() +")";


	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) > innerRadius;
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		Path2D path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		
		path.append(new Ellipse2D.Double(getCenter().getX() - getR(), this.getCenter().getY() - getR(), getR()*2, getR()*2), false);
		path.append(new Ellipse2D.Double(getCenter().getX() - getInnerRadius(), this.getCenter().getY() - getInnerRadius(), getInnerRadius()*2, getInnerRadius()*2), false);
		
		g2d.setColor(getInnerColor());
		g2d.fill(path);
		
		g2d.setColor(getEdgeColor());
		g2d.drawOval(getCenter().getX() - getR(), this.getCenter().getY() - getR(), getR()*2, getR()*2);
		g2d.drawOval(getCenter().getX() - getInnerRadius(), this.getCenter().getY() - getInnerRadius(), getInnerRadius()*2, getInnerRadius()*2);
		
		if (isSelected()) {
			g2d.setColor(Color.BLUE);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3 - getR(), getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3 + getR(), getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3 + getR() , 6, 6);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3 - getR(), 6, 6);
		}}
	
	
	public double area() {
		return super.area() - (innerRadius * innerRadius * Math.PI);
	}

	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}


	@Override
	public Shape clone() {
		Donut donut = new Donut(new Point(getCenter().getX(),getCenter().getY()),getR(),getInnerRadius(),getEdgeColor(),getInnerColor());
		donut.setSelected(isSelected());
		return donut;
	}


	

}
