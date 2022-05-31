package shapes;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Circle;
import shapes.Point;

public class Circle extends Shape {
	
	protected Point center;
	protected int r;

	
	public double area() {
		return r * r * Math.PI;
	}
	
	
	public Circle() {
	}


	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}


	public Circle(Point center, int r, boolean selected) {
		this(center,r);
		setSelected(selected);
	}
	
	public Circle(Point center, int r, Color edgeColor,Color innerColor) {
		this.center=center;
		this.r=r;
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawOval(this.getCenter().getX() - getR(),this.getCenter().getY() - this.getR(),getR() *2,this.getR()*2);
		g.setColor(getInnerColor());
		g.fillOval(this.getCenter().getX() - getR(),this.getCenter().getY() - this.getR(),getR() *2,this.getR()*2);
		
		if(isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(center.getX()-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3-r, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-3-r, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-3+r, 6, 6);
			g.drawRect(center.getX()-3+r, center.getY()-3, 6, 6);
		}
		
	}
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= r;

	}
	
	public boolean contains(Point p) {
		return p.distance(getCenter().getX(), getCenter().getY()) <= r;
	}

	public String toString() {
		return "Circle Center(" + center.getX()+"|"+center.getY() + ")|Radius(" + r + ")|EdgeColor("+getEdgeColor().getRGB()+")|InnerColor("+getInnerColor().getRGB() + ")";
	}
	
	public boolean equals(Object obj) {
		Circle temp;
		if(obj instanceof Circle) {
			temp = (Circle)obj;
			if(r==temp.r && center==temp.center )
				return true;
			else
				return false;}
		else 
			return false;
		}
	
	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle)
			return (int)(this.area() - ((Circle)o).area());
		return 0;
	}

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) 
	{
			this.r=r;
	
	}


	@Override
	public Shape clone() {
		Circle circle = new Circle();
		circle.setCenter(new Point(center.getX(),center.getY()));
		circle.setR(getR());
		circle.setEdgeColor(getEdgeColor());
		circle.setInnerColor(getInnerColor());
		circle.setSelected(isSelected());
		return circle;
	}

	




}
