package commands;

import mvc.AppModel;
import shapes.Shape;

public class BringToBackCmd implements Command {

	private Shape shape;
	private AppModel model;
	private int index;
	
	
	
	public BringToBackCmd(Shape shape, AppModel model) {
		
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		index = model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, 0);
		
	}

	@Override
	public void unexecute() {
		if(index>model.getShapes().size()-1)
			return;
		model.remove(shape);
		model.addShapeAtIndex(shape, index);
		
	}
	
	

}
