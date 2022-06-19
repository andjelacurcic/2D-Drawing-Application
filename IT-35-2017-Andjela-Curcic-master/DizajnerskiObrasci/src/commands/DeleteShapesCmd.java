package commands;

import java.util.List;

import mvc.AppModel;
import shapes.Shape;

public class DeleteShapesCmd implements Command {
	
	private AppModel model;
	private List<Shape> shapesForDelete;
	private String cmdLog;


	public String getCmdLog() {
		return cmdLog;
	}
	
	public void setCmdLog(String cmdLog) {
		this.cmdLog = cmdLog;
	}
	
	public DeleteShapesCmd(List<Shape> shapes, AppModel model) {
		this.model = model;
		shapesForDelete = shapes;
		
	}

	@Override
	public void execute() {
		shapesForDelete.forEach(shape -> {
			model.remove(shape);
		});
		cmdLog = "EXECUTE_DELETE_" + shapesForDelete;
	}

	@Override
	public void unexecute() {
		shapesForDelete.forEach(shape -> {
			model.addShape(shape);
			shape.setSelected(true);
		});
		cmdLog = "UNEXECUTE_DELETE_" + shapesForDelete;
	}

}
