package mvc;

import java.util.ArrayList;

import shapes.Point;
import shapes.Shape;

public class AppModel {
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	private int i;
	private Point startPoint;
	
	
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void remove(Shape s) {
		shapes.remove(s);
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}
	
	public int getIndex(Shape shape) {
		return shapes.indexOf(shape);
	}
	
	public void setShape( int index, Shape shape) {
		shapes.set(index, shape);
	}
	
	public void addShapeAtIndex(Shape shape, int index) {
		shapes.add(index,shape);
	}
	
	public void removeSelected() {
		shapes.removeIf(shape -> shape.isSelected());
	}
	
	
	
	public void deselect() {
		shapes.forEach(shape -> shape.setSelected(false));
	}
	
	public void select(Point point) {

		for(i = shapes.size()-1;i>=0;i--) {
			if(shapes.get(i).contains(point.getX(),point.getY())) {
				if(shapes.get(i).isSelected()) shapes.get(i).setSelected(false);
				shapes.get(i).setSelected(true);				
					return;
			}
		}
	}
	
	public ArrayList<Shape> getSelectedShapes(){
		ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
		
		shapes.forEach(shape->{
			if(shape.isSelected())
				selectedShapes.add(shape);
		});
		
		return selectedShapes;
	}
	
	public int getSelected() {
		for(i = shapes.size()-1;i >= 0; i--) {
			if(shapes.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return shapes.isEmpty();
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	

}
