package commands;

import mvc.AppModel;
import shapes.Shape;

public class BringToFrontCmd implements Command{
	
	private Shape shape;
	private AppModel model;
	private int index;
	
	
	public BringToFrontCmd(Shape shape, AppModel model) {
		
		this.shape = shape;
		this.model = model;
	}
	@Override
	public void execute() {
		index = model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, model.getShapes().size());
	}
	@Override
	public void unexecute() {
		if(index>model.getShapes().size()-1) 
			return;
		model.remove(shape);
		model.addShapeAtIndex(shape, index);
		
	}
	
	

}
