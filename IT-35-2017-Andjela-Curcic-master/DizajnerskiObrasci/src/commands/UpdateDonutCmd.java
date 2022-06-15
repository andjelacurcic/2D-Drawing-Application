package commands;

import shapes.Donut;

public class UpdateDonutCmd implements Command {

	private Donut oldState;
	private Donut newState;
	private Donut original;
	private String cmdLog;
	
	
	public void setCmdLog(String cmdLog) {
		this.cmdLog = cmdLog;
	}

	public String getCmdLog() {
		return cmdLog;
	}
	
	
	
	public UpdateDonutCmd(Donut oldState, Donut newState) {
		this.oldState = oldState;
		this.newState = newState;
		original = (Donut)oldState.clone();
	}

	@Override
	public void execute() {
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setR(newState.getR());
		oldState.setInnerRadius(newState.getInnerRadius());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setInnerColor(newState.getInnerColor());
		oldState.setSelected(newState.isSelected());
		cmdLog= "EXECUTE_UPDATE_" + original + "-->" + newState;
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setR(original.getR());
		oldState.setInnerRadius(original.getInnerRadius());
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setInnerColor(original.getInnerColor());
		oldState.setSelected(original.isSelected());
		cmdLog = "UNEXECUTE_UPDATE_" + newState + "-->" + original;
	}
	
	

}
