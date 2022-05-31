package shapes;

import java.awt.Color;
import java.awt.Graphics;



public class Point extends Shape {

	/**
	 * 
	 */
	
	private int x;
	private int y;
	
	
	
	public Point() {
	}
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public Point(int x, int y, boolean selected) {
		this(x,y);
		setSelected(selected);
	}
	
	public Point(int x, int y, Color edgeColor) {
		this.x=x;
		setY(y);
		setEdgeColor(edgeColor);
	}
	
	public Point(Point p, Color edgeColor) {
		this.x=p.getX();
		this.y=p.getY();
		setEdgeColor(edgeColor);
	}


	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX * dX + dY * dY);
		return d;
	}
	
	public boolean equals(Object obj) {
		Point temp;
		if(obj instanceof Point) {
			temp=(Point)obj;
			if (x==temp.getX()&&y==temp.getY())
				return true;
			else
				return false;}
		else
			return false;

	}
	@Override
	public void draw(Graphics g) {
		 g.setColor(getEdgeColor());
		g.drawLine(x-2,y,x+2,y);
		g.drawLine(x,y-2, x,y+2);
		if (isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(x-3,y-3,6,6 );
		}
	}
	
	public boolean contains(int x, int y) {
//		if(this.distance(x, y) <= 3)
//			return true;
//		return false;
		return this.distance(x, y) <= 3;
	}
	@Override
	public void moveBy(int x, int y) {
		this.x=this.x + x;
		this.y=this.y +y;
		//this.y +=y;
		
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point start = new Point(0, 0);
			return (int) (this.distance(start.getX(), start.getY()) - ((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}
	
	public String toString() {
		return "Point(" + x + "|" + y +")|EdgeColor(" + getEdgeColor().getRGB() + ")";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


	@Override
	public Shape clone() {
		Point point = new Point(getX(),getY(),getEdgeColor());
		point.setSelected(isSelected());
		return point;
	}
	


	
}
