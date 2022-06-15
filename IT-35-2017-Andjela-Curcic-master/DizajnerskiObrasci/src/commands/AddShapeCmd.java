package commands;

import mvc.AppModel;
import shapes.Shape;

public class AddShapeCmd implements Command {
	
	private Shape shape; 
	private AppModel model;
	private String cmdLog;
	
	
	public String getCmdLog() {
		return cmdLog;
	}
	
	public void setCmdLog(String cmdLog) {
		this.cmdLog = cmdLog;
	}
	
	public AddShapeCmd(Shape shape, AppModel model) {
		this.shape = shape;
		this.model = model;
		
	}

	@Override
	public void execute() {
		this.model.addShape(shape);
		cmdLog = "EXECUTE_ADD_" + shape;
	}

	@Override
	public void unexecute() {
		this.model.remove(shape);
		cmdLog = "UNEXECUTE_ADD_" + shape;
	}

}
