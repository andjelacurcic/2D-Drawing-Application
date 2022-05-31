package shapes;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Point;
import shapes.Rectangle;

public class Rectangle extends Shape {
	private Point upperLeftPoint;
	private int width;
	private int height;

	public int area() {
		return width * height;
	}

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height,Color edgeColor,Color innerColor) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}
    
	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawRect(this.getUpperLeftPoint().getX(),this.getUpperLeftPoint().getY(),this.width,this.height);
		g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeftPoint().getX()+1,this.getUpperLeftPoint().getY()+1,this.width-1,this.height-1);
		if(isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX()-3, upperLeftPoint.getY()-3, 6, 6);
			g.drawRect(upperLeftPoint.getX()+width-3, upperLeftPoint.getY()-3, 6, 6);
			g.drawRect(upperLeftPoint.getX()-3, upperLeftPoint.getY()-3+height, 6, 6);
			g.drawRect(upperLeftPoint.getX()+width-3, upperLeftPoint.getY()-3+height, 6, 6);
		}
		
	}
	public boolean equals(Object obj) {
		Rectangle temp;
		if (obj instanceof Rectangle) {
			temp = (Rectangle) obj;
		if (this.area() == temp.area())
			return true;
		else
			return false;
	}
	else
		return false;
	}
	public boolean contains(int x, int y) {
		return (x >= upperLeftPoint.getX() &&
			x <= upperLeftPoint.getX() + width &&
			y >= upperLeftPoint.getY() &&
			y <= upperLeftPoint.getY() + height);
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) 
			return this.area() - ((Rectangle) o).area();
		
		return 0;
	}


	public String toString() {
		return "Rectangle UpperLeftPoint(" + upperLeftPoint.getX()+"|" + upperLeftPoint.getY() + ")|Width(" + width + ")|Height(" + height + ")|EdgeColor(" +getEdgeColor().getRGB()+")|InnerColor("+getInnerColor().getRGB()+")"; 
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public Shape clone() {
		Rectangle rec = new Rectangle(new Point(getUpperLeftPoint().getX(),getUpperLeftPoint().getY()),getHeight(),getWidth());
		rec.setEdgeColor(getEdgeColor());
		rec.setInnerColor(getInnerColor());
		rec.setSelected(isSelected());
		return rec;
	}
	

	

}
