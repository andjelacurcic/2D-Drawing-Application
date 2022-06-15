package commands;

import mvc.AppModel;
import shapes.Shape;

public class ToBackCmd implements Command{

	private Shape shape;
	private AppModel model;
	private int index;
	private String cmdLog;
	
	
	public void setCmdLog(String cmdLog) {
		this.cmdLog = cmdLog;
	}

	public String getCmdLog() {
		return cmdLog;
	}
	
	
	
	public ToBackCmd(Shape shape, AppModel model) {
		this.shape = shape;
		this.model = model;
	}

	
	
	@Override
	public void execute() {
		index = model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, index-1);
		cmdLog = "EXECUTE_TO-BACK_" + shape;
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		model.addShapeAtIndex(shape, index);
		cmdLog = "UNEXECUTE_TO-BACK_" + shape;
		
	}
	
	

}
