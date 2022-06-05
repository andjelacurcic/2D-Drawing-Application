package commands;

import mvc.AppModel;
import shapes.Shape;

public class AddShapeCmd implements Command {
	
	private Shape shape; 
	private AppModel model;
	
	public AddShapeCmd(Shape shape, AppModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		this.model.addShape(shape);
	}

	@Override
	public void unexecute() {
		this.model.remove(shape);
	}

}
