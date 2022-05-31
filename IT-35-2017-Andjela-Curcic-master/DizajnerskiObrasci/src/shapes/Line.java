package shapes;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Line;
import shapes.Point;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	

	public double lenght() {
		double lenght = startPoint.distance(endPoint.getX(), endPoint.getY());
		return lenght;
	}

	public Line() {
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected()) {
			g.setColor(Color.BLUE);
		g.drawRect(startPoint.getX()-3, startPoint.getY()-3, 6, 6);
		g.drawRect(endPoint.getX()-3, endPoint.getY()-3, 6, 6);
		}
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this (startPoint,endPoint);
		setSelected(selected);
	}
	public Line(Point startPoint, Point endPoint, Color edgeColor) {
		this.startPoint = startPoint;
		setEndPoint( endPoint);
		setEdgeColor(edgeColor);
	}

	public String toString() {
		 return "Line(X1" + startPoint.getX() + "|Y1" + startPoint.getY() +
				"|X2" + endPoint.getX() + "|Y2" + endPoint.getY() + ")|EdgeColor("
				+ getEdgeColor().getRGB()+")";
		}
	
	public boolean equals(Object obj) {
		Line temp;
		if(obj instanceof Line) {
			temp=(Line)obj;
			if(this.lenght()==temp.lenght())
			return true;
			else
				return false;
		} else
			return false;
			
		
	}
	
	public boolean contains(int x, int y) {
		double temp = startPoint.distance(x, y) + endPoint.distance(x, y);
		return temp - this.lenght() <= 3;
	}
	@Override
	public void moveBy(int x, int y) {
		/*startPoint.setX(startPoint.getX()+x);
		startPoint.setY(startPoint.getY()+y);
		endPoint.setX(endPoint.getX()+x);
		endPoint.setY(endPoint.getY()+y);*/
		
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.lenght() - ((Line) o).lenght());
		}
		return 0;
	}
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public Shape clone() {
		Line line=new Line();
		line.setStartPoint(new Point(getStartPoint().getX(),getStartPoint().getY()));
		line.setEndPoint(new Point(getEndPoint().getX(),getEndPoint().getY()));
		line.setEdgeColor(getEdgeColor());
		line.setInnerColor(getInnerColor());
		line.setSelected(isSelected());
		return line;
	}
	

	

}
